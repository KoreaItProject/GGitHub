
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.MouseInputListener;

import org.zeroturnaround.zip.ZipUtil;

import com.ggit.socket.InfoDTO;
import com.ggit.socket.InfoDTO.Info;

import java.awt.*;

import java.awt.event.*;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Random;

public class GGitSource extends JFrame implements MouseInputListener, Runnable {

    RoundedButton pushBtn, pullBtn;
    String imgPath;

    boolean hasLogin = true;

    Socket socket;
    ObjectOutputStream writer;
    ObjectInputStream reader;
    InfoDTO infoDTO;
    boolean running = true;

    // component
    JLabel logolbl;
    JLabel toptxt;
    JPanel loginPan;
    JScrollPane scrollPan;
    JLabel toplbl;
    JPanel clonepan;

    // info
    String clientPath;
    File info;
    String memberIdx;
    String repo;
    String token;

    public GGitSource() {

        String serverIp = "localhost";
        Socket socket = null;
        try {

            socket = new Socket(serverIp, 4445);
            socket.setSoTimeout(0);
            writer = new ObjectOutputStream(socket.getOutputStream());
            reader = new ObjectInputStream(socket.getInputStream());
            System.out.println("서버에 연결되었습니다.");
            infoDTO = new InfoDTO();

            // 파일전송을 서버에 알린다.('file' 구분자 전송)

            Thread sockThread = new Thread(this);
            sockThread.start();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        setting();
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

        scrollPan = new ScrollPan().getScrollPan();// 변경된 파일 패널
        scrollPan.setBounds(-2, 50, 248, 272);
        scrollPan.setVisible(hasLogin);
        mainPanel.add(scrollPan);

        clonepan = new ClonePan(writer).getPanel();
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
                    infoDTO.setUser("a");
                    writer.writeObject(infoDTO);
                    writer.flush();
                    running = false;

                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        });
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
            this.clientPath = dir.getPath();
            this.info = new File(clientPath + "/.ggit/user/info.gt");

            if (info.isFile()) {
                InfoLeader infoLeader = new InfoLeader(info.getPath());
                this.hasLogin = true;

            } else {
                System.out.println("파일이 없습니다.");
                this.hasLogin = false;
                int leftLimit = 97; // letter 'a'
                int rightLimit = 122; // letter 'z'
                int targetStringLength = 40;
                Random random = new Random();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == pushBtn) {

        } else if (e.getSource() == pullBtn) {

        } else if (e.getSource() == logolbl) {
            try {
                Desktop.getDesktop().browse(new URI("http://localhost/"));
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                System.out.println("안에 내용이 올바르지 않음");
            }
        }

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

    public void pull() {

        try {
            InfoDTO dto = new InfoDTO();
            dto.setCommand(Info.PULL);
            dto.setIdx(repo);
            dto.setToken(token);
            writer.writeObject(dto);
            writer.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
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
                        loginPan.setVisible(false);
                        toptxt.setText("접속코드를 입력하세요");
                        // toptxt.setVisible(false);
                        // scrollPan.setVisible(true);
                        // toplbl.setVisible(false);
                        clonepan.setVisible(true);
                    }
                } else if (infoDTO.getCommand() == Info.CLONERESULT) {
                    if (infoDTO.getToken() == null) {
                        toptxt.setText("잘못된 접속코드 입니다.");
                    } else {
                        this.repo = infoDTO.getIdx() + "";
                        this.token = infoDTO.getToken();
                        fileW();
                        pull();
                    }

                } else if (infoDTO.getCommand() == Info.PULLRESULT) {
                    System.out.println("pullresult");
                    String result = fileWrite();

                } else if (infoDTO.getCommand() == Info.FILEEND) {
                    System.out.println("end");

                }
            }

            // }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String fileWrite() {
        String result = "";
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;

        try {
            String fileNm = reader.readUTF();
            System.out.println("파일 수신 작업을 시작합니다.");

            // 파일명을 전송 받고 파일명 수정
            System.out.println("파일명 " + fileNm + "을 전송받았습니다.");

            // 파일을 생성하고 파일에 대한 출력 스트림 생성
            File file = new File(clientPath + "/" + fileNm);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            System.out.println(fileNm + "파일을 생성하였습니다.");

            // 바이트 데이터를 전송받으면서 기록
            int len = 0;
            int size = 100000;
            byte[] Object = new byte[size];
            int i = 0;
            while (true) {
                len = reader.read(Object);
                if (!(len > 0)) {
                    break;
                }
                bos.write(Object, 0, len);

            }
            System.out.println(len);
            result = "SUCCESS";
            // bos.flush();
            System.out.println(1);
            System.out.println("파일 수신 작업을 완료하였습니다.");
            System.out.println("받은 파일의 사이즈 : " + file.length());
            System.out.println(clientPath + "\\" + fileNm);
            new UnzipFile(clientPath, fileNm);

            try {
                fos.close();
                bos.close();

            } catch (Exception e1) {

            }

        } catch (IOException e) {
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
            File file = new File(clientPath + "/.ggit/user/info.gt");
            System.out.println(file.getPath());
            file.createNewFile();

            FileWriter fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);

            // 4. 파일에 쓰기
            String con = "\"memberIdx\" : \"" + memberIdx + "\", \"repo\" : \"" + repo
                    + "\",\"token\" : \"" + token
                    + "\",";
            String conResult = "";
            for (int i = 0; i < con.length(); i++) {
                conResult += (int) con.charAt(i) + (i * 100 + 11) * con.length() + "\n";
            }

            writer.write(conResult);

            // 5. BufferedWriter close
            writer.close();

            toptxt.setVisible(false);
            scrollPan.setVisible(true);
            toplbl.setVisible(false);
            clonepan.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
