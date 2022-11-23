
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPan {
    String imgPath;

    public JPanel getLoginPan() {
        imgPath = new Setting().getImgPath();
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);

        JTextField id = new MyField();
        id.setBounds(11, 149, 226, 22);
        id.setFont(new Font("Gothic", Font.BOLD, id.getFont().getSize() + 3));
        loginPanel.add(id);

        JPasswordField pw = new MyPwField();
        pw.setBounds(11, 201, 226, 22);
        pw.setFont(new Font("Gothic", Font.BOLD, id.getFont().getSize() + 3));
        loginPanel.add(pw);

        ImageIcon topIcon;
        topIcon = imgMk("login.png", 248, 272);
        JLabel toplbl = new JLabel();
        toplbl.setBounds(0, 0, 248, 272);
        loginPanel.add(toplbl);
        toplbl.setIcon(topIcon);

        return loginPanel;
    }

    public ImageIcon imgMk(String img, int w, int h) {

        return new ImageIcon(new ImageIcon(imgPath + img).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }
}

class MyField extends JTextField {

    private Shape shape;

    protected void paintBorder(Graphics g) {

        g.drawRoundRect(0, 0, -1, -1, 15, 15);
        // g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

}

class MyPwField extends JPasswordField {

    private Shape shape;

    protected void paintBorder(Graphics g) {

        g.drawRoundRect(0, 0, -1, -1, 15, 15);
        // g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

}
