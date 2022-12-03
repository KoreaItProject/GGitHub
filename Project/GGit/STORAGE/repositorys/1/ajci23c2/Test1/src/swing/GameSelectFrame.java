package swing;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;

import javax.swing.JPanel;

import swing.SocketServer.Sock;


public class GameSelectFrame extends JFrame {

    int FramW = 1000, FramH = 900;
    public JPanel panel;

    public GameSelectFrame() {

        setSize(FramW, FramH); // 프레임 크기 지정
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // 레이블을 넣기 위한 패널 생성

        // 패널 생성
        // JPanel gameCharSelectPanel = new GameCharSelectPanel(this);
        panel = new GameRoomPan(this);
        add(panel);
        setVisible(true);

    } // 생성자

    public GameSelectFrame(String roomId,  String nick, int seed,int charIdx,int otherCharIdx) {
       
        setSize(FramW, FramH); // 프레임 크기 지정
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // 레이블을 넣기 위한 패널 생성

        // 패널 생성
        // JPanel gameCharSelectPanel = new GameCharSelectPanel(this);
        try {
            Sock.socket = new Socket(new Setting().getHost(), 9500);
            Sock.reader = new ObjectInputStream(Sock.socket.getInputStream()); 
            Sock.writer = new ObjectOutputStream(Sock.socket.getOutputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        panel = new GameCharSelectPanel(this, roomId, nick, seed,charIdx,otherCharIdx);
        add(panel);
        revalidate();
        repaint();
        setVisible(true);

    } // 생성자
    
    public GameSelectFrame(Boolean isSingle,int lvl,int charidx,int comCharIdx) {

   
        if(isSingle){
        setSize(FramW, FramH); // 프레임 크기 지정
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        // 레이블을 넣기 위한 패널 생성

        // 패널 생성
        // JPanel gameCharSelectPanel = new GameCharSelectPanel(this);
        panel = new SingleCharSelectPanel(this,lvl,charidx,comCharIdx);
        add(panel);
        setVisible(true);
        }
    } // 생성자

    public void showCharSelectPan( String roomId,  String nick, int seed) {

        remove(panel);
        revalidate();
        repaint();
        panel = new GameCharSelectPanel(this, roomId, nick, seed,0,0);
        add(panel);
        revalidate();
        repaint();
        setVisible(true);

    }

    public void showRoomPan() {

        remove(panel);
        revalidate();
        repaint();
        panel = new GameRoomPan(this);
        add(panel);
        revalidate();
        repaint();
        setVisible(true);
    }

    public void showSingleSelectPan() {
        System.out.println(123);
        remove(panel);
        revalidate();
        repaint();
        panel = new SingleCharSelectPanel(this,3,0,0);
        add(panel);
        revalidate();
        repaint();


        
        setVisible(true);

    }

} // class
