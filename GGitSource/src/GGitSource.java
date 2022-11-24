
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.MouseInputListener;

import java.awt.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

class GGitSource extends JFrame implements MouseInputListener {

    RoundedButton pushBtn, pullBtn;
    String imgPath;

    String clientPath;
    File info;

    JLabel logolbl;

    boolean hasLogin = true;
    boolean hasClone = false;

    GGitSource() {

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

        JPanel loginPan = new LoginPan().getLoginPan();
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

        ImageIcon whiteIcon;
        whiteIcon = imgMk("white.jpg", 300, 400);
        JLabel whitelbl = new JLabel();
        whitelbl.setBounds(-10, 50, 300, 400);
        mainPanel.add(whitelbl);
        whitelbl.setIcon(whiteIcon);

        add(mainPanel);
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

        } else {
            System.out.println("파일이 없습니다.");
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
            } catch (IOException | URISyntaxException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
