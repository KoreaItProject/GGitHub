
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.*;

import java.awt.event.*;

class GGitSource extends JFrame implements ActionListener {

    RoundedButton pushBtn, pullBtn;
    String imgPath = "";

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

        JScrollPane scrollPan = new ScrollPan().getScrollPan();
        scrollPan.setBounds(-2, 50, 248, 272);
        scrollPan.setVisible(true);
        mainPanel.add(scrollPan);

        JLabel toptxt = new JLabel("로그인 후 이용해주세요");
        toptxt.setBounds(55, 0, 300, 50);
        toptxt.setFont(new Font("Gothic", Font.BOLD, toptxt.getFont().getSize() + 3));
        toptxt.setForeground(new Color(252, 241, 234));
        mainPanel.add(toptxt);

        ImageIcon topIcon;
        topIcon = imgMk("top.jpg", 300, 50);
        JLabel toplbl = new JLabel();
        toplbl.setBounds(50, 0, 300, 50);
        mainPanel.add(toplbl);
        toplbl.setIcon(topIcon);

        pushBtn = new RoundedButton("push");
        pullBtn = new RoundedButton("pull");
        pushBtn.addActionListener(this);
        pullBtn.addActionListener(this);
        pushBtn.setBounds(55, 8, 85, 35);
        pullBtn.setBounds(150, 8, 85, 35);
        mainPanel.add(pushBtn);
        mainPanel.add(pullBtn);
        ImageIcon logoIcon;
        logoIcon = imgMk("logo.png", 35, 35);
        JLabel logolbl = new JLabel();
        logolbl.setBounds(10, 8, 35, 35);
        mainPanel.add(logolbl);
        logolbl.setIcon(logoIcon);

        ImageIcon whiteIcon;
        whiteIcon = imgMk("white.jpg", 300, 400);
        JLabel whitelbl = new JLabel();
        whitelbl.setBounds(-10, 50, 300, 400);
        mainPanel.add(whitelbl);
        whitelbl.setIcon(whiteIcon);

        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pushBtn) {

        } else if (e.getSource() == pullBtn) {

        }

    }

    public ImageIcon imgMk(String img, int w, int h) {

        return new ImageIcon(new ImageIcon(imgPath + img).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }

    public void setting() {
        Setting setting = new Setting();
        this.imgPath = setting.getImgPath();
    }

}
