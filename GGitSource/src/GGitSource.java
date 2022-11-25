
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.MouseInputListener;

import com.ggit.socket.InfoDTO;
import com.ggit.socket.InfoDTO.Info;

import java.awt.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;

public class GGitSource extends JFrame implements MouseInputListener, Runnable {

    RoundedButton pushBtn, pullBtn;
    String imgPath;

    String clientPath;
    File info;

    JLabel logolbl;

    boolean hasLogin = true;
    boolean hasClone = false;

    Socket socket;
    ObjectOutputStream writer;
    ObjectInputStream reader;
    InfoDTO infoDTO;
    boolean running = true;

    public GGitSource() {
        String serverIp = "localhost";
        Socket socket = null;
        try {
            socket = new Socket(serverIp, 4445);

            writer = new ObjectOutputStream(socket.getOutputStream());
            reader = new ObjectInputStream(socket.getInputStream());
            System.out.println("서버에 연결되었습니다.");
            infoDTO = new InfoDTO();

            // 파일전송을 서버에 알린다.('file' 구분자 전송)

            infoDTO.setCommand(Info.STATE);
            infoDTO.setMessage("running");
            writer.writeObject(infoDTO);
            writer.flush();

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

        JPanel loginPan = new LoginPan(writer).getLoginPan();
        loginPan.setBounds(-2, 50, 248, 272);
        loginPan.setVisible(!hasLogin);
        mainPanel.add(loginPan);

        JScrollPane scrollPan = new ScrollPan().getScrollPan();// 변경된 파일 패널
        scrollPan.setBounds(-2, 50, 248, 272);
        scrollPan.setVisible(hasLogin);
        mainPanel.add(scrollPan);

        JLabel toptxt = new JLabel("로그인 후 이용해주세요");
        toptxt.setBounds(55, 0, 300, 50);
        toptxt.setFont(new Font("Gothic", Font.BOLD, toptxt.getFont().getSize() + 3));
        toptxt.setForeground(new Color(252, 241, 234));
        mainPanel.add(toptxt);
        toptxt.setVisible(!hasLogin);

        ImageIcon topIcon;
        topIcon = imgMk("top.jpg", 300, 50);
        JLabel toplbl = new JLabel();
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
        }
    }

    @Override
    public void run() {
        int i = 0;
        try {
            while (running) {
                infoDTO = (InfoDTO) reader.readObject();

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
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

}
