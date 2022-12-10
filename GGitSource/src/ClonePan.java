import java.io.ObjectOutputStream;

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

import com.ggit.socket.InfoDTO;

class MyField extends JTextField {

    private Shape shape;

    protected void paintBorder(Graphics g) {

        g.drawRoundRect(0, 0, -1, -1, 15, 15);
        // g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 15, 15);
    }

}

public class ClonePan extends KeyAdapter implements MouseInputListener {
    String imgPath;
    ImageIcon topIcon;
    JLabel top1lbl;
    JButton clonebtn;
    JTextField code;
    ObjectOutputStream writer;
    InfoDTO infoDTO;
    String member;

    ClonePan(ObjectOutputStream writer) {
        this.writer = writer;
        this.member = member;

        infoDTO = new InfoDTO();
        imgPath = new Setting().getImgPath();
    }

    public JPanel getPanel() {
        JPanel clonePanel = new JPanel();
        clonePanel.setLayout(null);

        code = new MyField();
        code.setBounds(11, 161, 226, 22);
        code.setFont(new Font("Gothic", Font.BOLD, code.getFont().getSize() + 3));
        clonePanel.add(code);
        code.addKeyListener(this);

        clonebtn = new JButton("접속");
        clonebtn.setBounds(-1, 232, 250, 40);
        clonebtn.setFont(new Font("Gothic", Font.BOLD, clonebtn.getFont().getSize() + 5));
        clonePanel.add(clonebtn);
        clonebtn.setBackground(new Color(45, 164, 78));
        clonebtn.setForeground(new Color(252, 241, 234));
        clonebtn.addMouseListener(this);
        clonebtn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ImageIcon topIcon1 = imgMk("loginLogo.png", 108, 60);
        top1lbl = new JLabel();
        top1lbl.setBounds(67, 29, 108, 60);
        clonePanel.add(top1lbl);
        top1lbl.setIcon(topIcon1);
        top1lbl.addMouseListener(this);
        top1lbl.setCursor(new Cursor(Cursor.HAND_CURSOR));

        topIcon = imgMk("code.png", 248, 272);
        JLabel toplbl = new JLabel();
        toplbl.setBounds(0, -3, 248, 272);
        clonePanel.add(toplbl);
        toplbl.setIcon(topIcon);

        return clonePanel;
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
        } else if (e.getSource() == clonebtn) {
            try {
                infoDTO = new InfoDTO();
                infoDTO.setCommand(Info.CLONE);
                infoDTO.setMessage(code.getText());
                infoDTO.setId(member);
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
                infoDTO.setCommand(Info.CLONE);
                infoDTO.setMessage(code.getText());
                infoDTO.setId(member);
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

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void setMemberIdx(String member) {
        this.member = member;
    }

}
