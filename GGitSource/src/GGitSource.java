
import javax.swing.ImageIcon;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.zeroturnaround.zip.ZipUtil;

import com.ggit.socket.InfoDTO;
import com.ggit.socket.InfoDTO.Info;

import util.ReadPushData;
import util.WritePushData;

import java.awt.*;

import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URI;

import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GGitSource extends JFrame implements MouseInputListener, Runnable {
    // pull
    // 1.pull 버튼 클릭시 pull()함수 에서 서버에 Pull요청을 함
    // 2.서버에서 pull에 대한 zip파일을 보내줌
    // 3.run 에서 zip파일을 받으면 fileWrite()함수로 파일을 받아서 저장함

    RoundedButton pushBtn, pullBtn;
    String imgPath;

    boolean hasLogin = true;

    Socket socket;
    ObjectOutputStream writer;
    ObjectInputStream reader;
    InfoDTO infoDTO;
    boolean running = true;
    Thread sockThread;
    Thread refThread;
    String projectName;
    FileState fileState;
    // component
    JLabel logolbl;
    JLabel toptxt;
    JPanel loginPan;
    JScrollPane scrollPan;
    JLabel toplbl;
    JPanel clonepan;
    boolean canbtn = true;
    JTextField pushMsg;
    ClonePan cp;

    // info
    String clientPath;
    File info;
    String memberIdx;
    String repo;
    String token;
    String lastToken;

    public GGitSource() {

        String serverIp = "localhost";
        Socket socket = null;
        setting();
        try {

            socket = new Socket(serverIp, 4445);
            socket.setSoTimeout(0);
            writer = new ObjectOutputStream(socket.getOutputStream());
            reader = new ObjectInputStream(socket.getInputStream());
            System.out.println("서버에 연결되었습니다.");
            infoDTO = new InfoDTO();

            // 파일전송을 서버에 알린다.('file' 구분자 전송)

            sockThread = new Thread(this);
            sockThread.start();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        setSize(250, 350); // 컨테이너 크기 지정
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        // 레이블을 넣기 위한 패널 생성

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(36, 41, 47));
        mainPanel.setVisible(true);

        loginPan = new LoginPan(writer).getLoginPan();
        loginPan.setBounds(-2, 50, 248, 272);
        loginPan.setVisible(!hasLogin);
        mainPanel.add(loginPan);

        pushMsg = new HintTextField("전송할 메시지를 입력해주세요");
        pushMsg.setBounds(-2, 50, 248, 26);
        pushMsg.setVisible(hasLogin);
        mainPanel.add(pushMsg);

        ScrollPan sp = new ScrollPan();
        scrollPan = sp.getScrollPan(clientPath);// 변경된 파일 패널
        fileState = sp.getFileState();

        scrollPan.setBounds(-2, 75, 248, 247);
        scrollPan.setVisible(hasLogin);
        mainPanel.add(scrollPan);

        cp = new ClonePan(writer);
        clonepan = cp.getPanel();
        clonepan.setBounds(-2, 50, 248, 272);
        mainPanel.add(clonepan);
        clonepan.setVisible(false);

        toptxt = new JLabel("로그인 후 이용해주세요");
        toptxt.setBounds(55, 0, 300, 50);
        toptxt.setFont(new Font("Gothic", Font.BOLD, toptxt.getFont().getSize() +
                3));
        toptxt.setForeground(new Color(252, 241, 234));
        mainPanel.add(toptxt);
        toptxt.setVisible(!hasLogin);

        ImageIcon topIcon;
        topIcon = imgMk("top.jpg", 300, 50);
        toplbl = new JLabel();
        toplbl.setBounds(50, 0, 300, 50);
        mainPanel.add(toplbl);
        toplbl.setIcon(topIcon);
        toplbl.setVisible(!hasLogin);

        pushBtn = new RoundedButton("push");
        pullBtn = new RoundedButton("pull");
        pushBtn.addMouseListener(this);
        pullBtn.addMouseListener(this);
        pushBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pullBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pushBtn.setBounds(55, 8, 85, 35);
        pullBtn.setBounds(150, 8, 85, 35);
        mainPanel.add(pushBtn);
        mainPanel.add(pullBtn);

        ImageIcon logoIcon;
        logoIcon = imgMk("logo.png", 35, 35);
        logolbl = new JLabel();
        logolbl.setBounds(10, 8, 35, 35);
        mainPanel.add(logolbl);
        logolbl.setIcon(logoIcon);
        logolbl.addMouseListener(this);
        logolbl.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ImageIcon whiteIcon;
        whiteIcon = imgMk("white.jpg", 300, 400);
        JLabel whitelbl = new JLabel();
        whitelbl.setBounds(-10, 50, 300, 400);
        mainPanel.add(whitelbl);
        whitelbl.setIcon(whiteIcon);

        add(mainPanel);

        // 창닫을 경우
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // System.exit(0);
                try {
                    // InfoDTO dto = new InfoDTO(nickName,Info.EXIT);
                    infoDTO.setCommand(Info.EXIT);
                    writer.writeObject(infoDTO);
                    writer.flush();
                    running = false;
                    sockThread.stop();
                    refThread.stop();

                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        });

        refThread = new Refresh(this);
        refThread.start();

    }

    public ImageIcon imgMk(String img, int w, int h) {

        return new ImageIcon(new ImageIcon(imgPath + img).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }

    public void setting() {
        try {

            Setting setting = new Setting();
            this.imgPath = setting.getImgPath();

            JFileChooser jfc = new JFileChooser();
            jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            jfc.showDialog(this, null);

            File dir = jfc.getSelectedFile();
            if (dir == null) {
                System.exit(0);
            }
            this.clientPath = dir.getPath();

            this.info = new File(clientPath + "/.ggit/user/info.gt");

            if (info.isFile()) {
                InfoLeader infoLeader = new InfoLeader(info.getPath());
                this.repo = infoLeader.getRepo();
                this.memberIdx = infoLeader.getMemberIdx();
                this.token = infoLeader.getToken();
                this.lastToken = infoLeader.getLastToken();
                this.hasLogin = true;

            } else {
                System.out.println("파일이 없습니다.");
                this.hasLogin = false;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (canbtn) {
            if (e.getSource() == pushBtn) {
                push();
            } else if (e.getSource() == pullBtn) {
                pull();
            } else if (e.getSource() == logolbl) {
                try {
                    Desktop.getDesktop().browse(new URI("http://localhost/"));
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    System.out.println("안에 내용이 올바르지 않음");
                }
            }
        }
        revalidate();
        repaint();
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public void pull() {// 풀
        canbtn = false;

        try {
            InfoDTO dto = new InfoDTO();
            dto.setCommand(Info.PULL);
            dto.setIdx(repo);
            dto.setId(memberIdx);
            writer.writeObject(dto);
            writer.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void push() {// push
        canbtn = false;
        try {
            fileState.setRunning(false);
            Thread.sleep(600);
            JSONParser parser = new JSONParser();
            InfoDTO dto = new InfoDTO();
            dto.setCommand(Info.PUSH);
            dto.setIdx(repo);// 레포인덱스
            dto.setId(memberIdx + "");// 로그인된 회원 인덱스
            dto.setMessage(pushMsg.getText());// commit시 메시지
            if (pushMsg.getText().equals("전송할 메시지를 입력해주세요")) {
                dto.setMessage("업데이트됨");// commit시 메시지
            }

            dto.setLastToken(lastToken);// 이전토큰 어떤걸 가져와서 push 한건지
            String newToken = new RandStr(15).getResult();
            dto.setToken(newToken);// 새로운 토큰 이 push에 대한 토큰
            token = newToken; // 토큰 바꾸고
            fileW();// info.gt에도 써줌

            List<String> addPush = fileState.getAddPush();
            List<String> changePush = fileState.getChangePush();
            List<String> delPush = fileState.getDelPush();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String nowTime = sdf.format(new Date()).toString();

            String pushDataCon = new ReadPushData(clientPath + "/.ggit/.repo/file/dump/pushData.txt").getCon();
            JSONArray pushData = (JSONArray) parser.parse(pushDataCon);
            String pushChanged2Con = new ReadPushData(clientPath + "/.ggit/.repo/file/dump/pushChanged2.txt").getCon();
            JSONArray pushChanged2 = (JSONArray) parser.parse(pushChanged2Con);

            JSONArray pushChanged = new JSONArray();
            CopyFile copyFile = new CopyFile();

            for (int i = 0; i < delPush.size(); i++) {

                for (int j = 0; j < pushData.size(); j++) {

                    if (((JSONObject) pushData.get(j)).get("path").equals(delPush.get(i))) {
                        pushData.remove(j);
                    }
                }

                for (int j = 0; j < pushChanged2.size(); j++) {
                    if (((JSONObject) pushChanged2.get(j)).get("path").equals(delPush.get(i))) {
                        pushChanged2.remove(j);
                    }
                }
                pushChanged.add((JSONObject) parser.parse("{\"path\":\"" + delPush.get(i) + "\",\"state\":\"del\"}"));
                pushChanged2
                        .add((JSONObject) parser.parse("{\"path\":\"" + delPush.get(i) + "\",\"state\":\"del\"}"));
                File file = new File(clientPath + "/.ggit/.repo/file/data" + delPush.get(i));
                if (file.isDirectory()) {
                    new AllDelete(clientPath + "/.ggit/.repo/file/data" + delPush.get(i) + "/");
                } else if (file.isFile()) {
                    file.delete();
                }

            }
            for (int i = 0; i < changePush.size(); i++) {

                for (int j = 0; j < pushData.size(); j++) {
                    if (((JSONObject) pushData.get(j)).get("path").equals(changePush.get(i))) {
                        ((JSONObject) pushData.get(j)).replace("path", changePush.get(i));
                        ((JSONObject) pushData.get(j)).replace("date", nowTime);
                        ((JSONObject) pushData.get(j)).replace("message", pushMsg.getText());
                    }
                }
                for (int j = 0; j < pushChanged2.size(); j++) {
                    if (((JSONObject) pushChanged2.get(j)).get("path").equals(changePush.get(i))) {
                        pushChanged2.remove(j);
                    }
                }
                pushChanged.add(
                        (JSONObject) parser.parse("{\"path\":\"" + changePush.get(i) + "\",\"state\":\"change\"}"));
                pushChanged2
                        .add((JSONObject) parser
                                .parse("{\"path\":\"" + changePush.get(i) + "\",\"state\":\"change\"}"));
                File file = new File(clientPath + "/.ggit/.repo/file/data" + changePush.get(i));

                copyFile.copy(new File(clientPath + "/project" + changePush.get(i)),
                        file);// 지금 파일을 보낼 파일로 옮김

            }
            for (int i = 0; i < addPush.size(); i++) {

                pushData.add((JSONObject) parser
                        .parse("{\"date\":\"" + nowTime + "\",\"path\":\"" + addPush.get(i) + "\",\"message\": \""
                                + pushMsg
                                        .getText()
                                + "\",}"));
                pushChanged.add((JSONObject) parser.parse("{\"path\":\"" + addPush.get(i) + "\",\"state\":\"add\"}"));
                pushChanged2
                        .add((JSONObject) parser.parse("{\"path\":\"" + addPush.get(i) + "\",\"state\":\"add\"}"));

                File file = new File(clientPath + "/.ggit/.repo/file/data" + addPush.get(i));
                copyFile.copy(new File(clientPath + "/project" + addPush.get(i)),
                        file);// 지금 파일을 보낼 파일로 옮김

            }

            new WritePushData(clientPath + "/.ggit/.repo/file/dump/pushData.txt")
                    .write((pushData + ""));
            new WritePushData(clientPath + "/.ggit/.repo/file/dump/pushChanged1.txt")
                    .write((pushChanged + ""));
            new WritePushData(clientPath + "/.ggit/.repo/file/dump/pushChanged2.txt")
                    .write((pushChanged2 + ""));

            System.out.println("-1--");
            File zip = new File(clientPath + "/.ggit/.repo/file/");// 폴더 압축
            ZipUtil.pack(zip, new File(clientPath + "/.ggit/.repo/file.zip"), 0);// 파일 보내기 위해 압축
            System.out.println("-2--");
            writer.writeObject(dto);
            writer.flush();// 서버한테 나 푸쉬할게 라고 말함

            fileSend();// 서버한테 파일 보냄
            pushMsg.setText("전송할 메시지를 입력해주세요");
            fileState.setRunning(true);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    } // push

    private void fileSend() {

        File path = new File(clientPath + "/.ggit/.repo/file.zip");

        FileInputStream fis;
        BufferedInputStream bis;

        try {

            writer.writeUTF("file");

            // 파일을 읽어서 서버에 전송

            File file = new File(path.getPath());
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);

            int len;
            int size = 100000;
            int i = 0;
            byte[] Object = new byte[size];
            while ((len = bis.read(Object)) > 0) {

                writer.write(Object, 0, len);
            }

            fis.close();
            bis.close();
            System.out.println("전송완료");
            canbtn = true;
            writer.flush();
            InfoDTO infoDTO = new InfoDTO();
            infoDTO.setCommand(Info.FILEEND);
            writer.writeObject(infoDTO);
            writer.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            while (running) {
                infoDTO = (InfoDTO) reader.readObject();

                // if (infoDTO.getUser() != null && infoDTO.getUser().equals(member)) {

                if (infoDTO.getCommand() == Info.LOGINRESULT) {
                    if (infoDTO.getMessage().equals("false")) {
                        toptxt.setText("이메일 패스워드가 다릅니다");
                    } else if (infoDTO.getMessage().equals("true")) {
                        this.memberIdx = infoDTO.getIdx() + "";
                        System.out.println(this.memberIdx);
                        loginPan.setVisible(false);
                        cp.setMemberIdx(memberIdx);
                        toptxt.setText("접속코드를 입력하세요");
                        // toptxt.setVisible(false);
                        // scrollPan.setVisible(true);
                        // toplbl.setVisible(false);
                        clonepan.setVisible(true);
                    }
                } else if (infoDTO.getCommand() == Info.CLONERESULT) {
                    if (infoDTO.getIdx() == null) {
                        toptxt.setText("잘못된 접속코드 입니다.");
                    } else {
                        this.repo = infoDTO.getIdx() + "";
                        pull();
                    }

                } else if (infoDTO.getCommand() == Info.PULLRESULT) {
                    System.out.println("pullresult");

                    this.token = infoDTO.getToken();
                    this.lastToken = infoDTO.getLastToken();
                    fileW();

                    String result = fileWrite();

                } else if (infoDTO.getCommand() == Info.FILEEND) {
                    System.out.println("end");
                    File zip = new File(clientPath + "/.ggit/.repo/file.zip");

                    if (new File(clientPath + "/.ggit/.repo/file").isDirectory()) {
                        new AllDelete(clientPath + "/.ggit/.repo/file");
                    }
                    ZipUtil.unpack(zip,
                            new File(clientPath + "/.ggit/.repo/file"));
                    zip.delete();

                    File projectFolder = new File(clientPath + "/" + projectName + "/");
                    if (projectFolder.isDirectory()) {
                        new AllDelete(clientPath + "/" + projectName + "/");
                    }
                    projectFolder.mkdirs();
                    new CopyFile().copy(new File(clientPath + "/.ggit/.repo/file/data/"),
                            new File(clientPath + "/" + projectName + "/"));

                    canbtn = true;

                }
            }

            // }
        } catch (Exception e) {
            e.printStackTrace();
            running = false;

        }

    }

    private String fileWrite() {
        String result = "";
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            projectName = reader.readUTF();
            System.out.println("파일 수신 작업을 시작합니다.");

            // 파일명을 전송 받고 파일명 수정
            System.out.println("파일명 " + projectName + "을 전송받았습니다.");
            // 파일을 생성하고 파일에 대한 출력 스트림 생성
            File file = new File(clientPath + "/.ggit/.repo/file.zip");
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            System.out.println("file.zip을 생성하였습니다.");

            // 바이트 데이터를 전송받으면서 기록
            int len = 0;
            int size = 100000;
            byte[] Object = new byte[size];
            int i = 0;
            while ((len = reader.read(Object)) > 0) {

                bos.write(Object, 0, len);

            }

            result = "SUCCESS";
            // bos.flush();

            System.out.println("파일 수신 작업을 완료하였습니다.");
            System.out.println("받은 파일의 사이즈 : " + file.length());
            System.out.println(clientPath + "/file.zip");
            // new UnzipFile(clientPath, "file.zip");
            System.out.println(clientPath + "/.ggit/.repo/file.zip");

            try {
                bos.close();
                fos.close();

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        } catch (

        IOException e) {
            e.printStackTrace();

        } finally {

        }
        return result;
    }

    public void fileW() {
        try {

            // 1. 파일 객체 생성
            File dir = new File(clientPath + "/.ggit/user/");
            dir.mkdirs();
            Path p = Paths.get(clientPath + "/.ggit");
            Files.setAttribute(p, "dos:hidden", Boolean.TRUE, LinkOption.NOFOLLOW_LINKS);
            new File(clientPath + "/.ggit/.repo/").mkdirs();
            File file = new File(clientPath + "/.ggit/user/info.gt");
            System.out.println(file.getPath());
            file.createNewFile();

            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);

            // 4. 파일에 쓰기
            String con = "\"memberIdx\" : \"" + memberIdx + "\", \"repo\" : \"" + repo
                    + "\",\"token\" : \"" + token + "\",\"lasttoken\":\"" + lastToken
                    + "\",";
            System.out.println(con);
            String conResult = "";
            for (int i = 0; i < con.length(); i++) {
                conResult += (int) con.charAt(i) + (i * 100 + 11) * con.length() + "\n";
            }

            writer.write(conResult);

            // 5. BufferedWriter close
            writer.close();

            toptxt.setVisible(false);
            pushMsg.setVisible(true);
            scrollPan.setVisible(true);
            toplbl.setVisible(false);
            clonepan.setVisible(false);
            hasLogin = true;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
