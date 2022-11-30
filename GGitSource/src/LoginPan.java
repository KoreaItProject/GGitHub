
import javax.swing.*;
import javax.swing.event.MouseInputListener;

import com.ggit.socket.InfoDTO;
import com.ggit.socket.InfoDTO.Info;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class LoginPan extends KeyAdapter implements MouseInputListener {
    String imgPath;
    ImageIcon topIcon;
    JLabel top1lbl;
    JButton loginbtn;
    JTextField id;
    JPasswordField pw;
    ObjectOutputStream writer;
    InfoDTO infoDTO;

    LoginPan(ObjectOutputStream writer) {
        this.writer = writer;
        infoDTO = new InfoDTO();
        imgPath = new Setting().getImgPath();
    }

    public JPanel getLoginPan() {

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);

        id = new MyField();
        id.setBounds(11, 131, 226, 22);
        id.setFont(new Font("Gothic", Font.BOLD, id.getFont().getSize() + 3));
        loginPanel.add(id);
        id.addKeyListener(this);

        pw = new MyPwField();
        pw.setBounds(11, 187, 226, 22);
        pw.setFont(new Font("Gothic", Font.BOLD, pw.getFont().getSize() + 3));
        loginPanel.add(pw);
        pw.addKeyListener(this);

        loginbtn = new JButton("로그인");
        loginbtn.setBounds(-1, 234, 250, 38);
        loginbtn.setFont(new Font("Gothic", Font.BOLD, loginbtn.getFont().getSize() + 5));
        loginPanel.add(loginbtn);
        loginbtn.setBackground(new Color(45, 164, 78));
        loginbtn.setForeground(new Color(252, 241, 234));
        loginbtn.addMouseListener(this);
        loginbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ImageIcon topIcon1 = imgMk("loginLogo.png", 108, 60);
        top1lbl = new JLabel();
        top1lbl.setBounds(67, 9, 108, 60);
        loginPanel.add(top1lbl);
        top1lbl.setIcon(topIcon1);
        top1lbl.addMouseListener(this);
        top1lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));

        topIcon = imgMk("login.png", 248, 272);
        JLabel toplbl = new JLabel();
        toplbl.setBounds(0, -3, 248, 272);
        loginPanel.add(toplbl);
        toplbl.setIcon(topIcon);

        return loginPanel;
    }

    public ImageIcon imgMk(String img, int w, int h) {

        return new ImageIcon(new ImageIcon(imgPath + img).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource() == top1lbl) {
            try {
                Desktop.getDesktop().browse(new URI("http://localhost/"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (URISyntaxException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } else if (e.getSource() == loginbtn) {
            try {
                infoDTO = new InfoDTO();
                infoDTO.setCommand(Info.LOGIN);
                infoDTO.setId(id.getText());
                infoDTO.setPw(pw.getText());

                writer.writeObject(infoDTO);
                writer.flush();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                infoDTO = new InfoDTO();
                infoDTO.setCommand(Info.LOGIN);
                infoDTO.setId(id.getText());
                infoDTO.setPw(pw.getText());

                writer.writeObject(infoDTO);
                writer.flush();
            } catch (IOException e1) {
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
