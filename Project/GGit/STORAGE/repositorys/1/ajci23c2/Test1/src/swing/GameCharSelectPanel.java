package swing;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.datatransfer.*;

import swing.SocketServer.InfoDTO;
import swing.SocketServer.Sock;
import swing.SocketServer.InfoDTO.Info;
import swing.SoundF.sound;

import java.awt.event.*;
import java.io.IOException;

import java.util.Random;

import java.awt.*;
import java.awt.datatransfer.Clipboard;

public class GameCharSelectPanel extends JPanel implements ActionListener, Runnable {
    GameStart gameStart;
    int FramW = 1000, FramH = 900;
    static int charIdx = 0;
    static boolean player1 = false;
    String imgPath;
    int charSizeW = 300;
    int charSizeH = 600;
    int gifSize = 300;

    // 상대 들어왔나 안들어왔나
    ImageIcon someone;
    JLabel whiteIbl2;
    ImageIcon whiteIcon;

    ImageIcon s[];
    Icon gif[];
    JLabel l;
    JButton readyBtn;
    JButton outbtn;
    JButton leftBtn;
    JButton rightBtn;
    JButton clipbtn;
    JLabel contentslbl;

    static int ready = 0, otherReady = 0;

    public static JLabel readylbl1, readylbl2;
    public JLabel someoneNick;
    sound sd = new sound();
    int i, l1;
    JFrame frame;

    public static String roomId, nick;
    public static int seed;

    public static Thread t1;
    public int[] result;
    public static String otherNick;
    static int otherCharIdx;


    String charDetail[] = {
            "<html><body style='font-size:16px;'><p>&ensp스노우맨</p><p>&ensp스킬 : 일정 시간 동안상대방을 얼린다</p><p>&ensp대상은 움직일 수 없다</p></body></html>",
            "<html><body style='font-size:16px;'><p>&ensp고스트맨</p><p>&ensp스킬 : 일정 시간 동안 상대방의 시야를 방해한다 </p><p>&ensp대상은 시야가 축소된다</p></body></html>",
            "<html><body style='font-size:16px;'><p>&ensp미라맨</p><p>&ensp스킬 : 생명력을 회복한다</p><p>&ensp최대 생명력이 높습니다</p></body></html>" };

    public GameCharSelectPanel(JFrame frame, String roomId, String nick, int seed,int charIdx,int otherCharIdx) {
        getSetting();
        this.frame = frame;
        this.roomId = roomId;
        this.nick = nick;
        this.seed = seed;
        this.charIdx=charIdx;
        this.otherCharIdx=otherCharIdx;

        // result 배열 만들기
        Random rand = new Random();
        rand.setSeed(seed);

        result = new int[new Setting().getBlockCount()];
        result[0] = 0;
        for (int i = 1; i < result.length; i++) {
            result[i] = rand.nextInt(2); // 0 또는 1
        }
        // result 배열 만들기

        t1 = new Thread(this);

        // JPanel game2 = new JPanel();
        this.setLayout(null);
        this.setSize(FramW, FramH);

        // 사운드 재생
        selectSoundStartFunc();

        leftBtn = new JButton("<<");
        rightBtn = new JButton(">>");

        leftBtn.setBounds(110, 640, 60, 30);
        rightBtn.setBounds(240, 640, 60, 30);

        this.add(leftBtn);
        this.add(rightBtn);

        // add(game2);

        leftBtn.addActionListener(this);
        rightBtn.addActionListener(this);

        ImageIcon readyIcon = imgMk("sub/ready.png", 200, 80, Image.SCALE_SMOOTH);
        readylbl1 = new JLabel(readyIcon);
        readylbl2 = new JLabel(readyIcon);
        readylbl1.setBounds(65, 100, 300, 120);
        readylbl2.setBounds(645, 100, 300, 120);
        this.add(readylbl1);
        this.add(readylbl2);
        readylbl1.setVisible(false);
        readylbl2.setVisible(false);

        s = new ImageIcon[3];
        gif = new Icon[3];

        for (int i = 0; i < s.length; i++) {
            s[i] = imgMk("character/char" + i + ".gif", gifSize, gifSize, 0);
        }

        l = new JLabel("", JLabel.CENTER);
        l.setBounds(50, 50, charSizeW, charSizeH + 200);
        l.setIcon(s[charIdx]);
        this.add(l);

        // 레디 버튼
        readyBtn = new JButton("Ready");
        readyBtn.setBackground(new Color(100, 214, 245));
        readyBtn.setBounds(800, 725, 155, 120);
        readyBtn.addActionListener(this); // 이벤트 호출 메서드
        readyBtn.setFont(new Font("Gothic", Font.BOLD, readyBtn.getFont().getSize() + 23));
        this.add(readyBtn);
        readyBtn.setEnabled(false);

        outbtn = new JButton("나가기");
        outbtn.setBackground(new Color(227, 202, 227));
        outbtn.setBounds(40, 30, 100, 80);
        outbtn.addActionListener(this); // 이벤트 호출 메서드
        outbtn.setFont(new Font("Gothic", Font.BOLD, outbtn.getFont().getSize() + 8));
        this.add(outbtn);


        whiteIcon = imgMk("sub/white.png", 330, 490, Image.SCALE_SMOOTH);
        someone = imgMk("sub/someone.png", 330, 490, Image.SCALE_SMOOTH);

        JLabel whiteIbl1 = new JLabel();// 왼쪽 캐릭터 div
        someoneNick = new JLabel("닉네임:");
        whiteIbl2 = new JLabel();// 오른쪽 캐릭터 div
        JLabel whiteIbl3 = new JLabel();// 밑에 설명 div
        JLabel roomIdlbl = new JLabel("방 코드 : " + roomId);
        clipbtn = new JButton("복사");
        clipbtn.addActionListener(this);
        JLabel whiteIbl4 = new JLabel();// 위에 방코드 div
        contentslbl = new JLabel(charDetail[0]);

        whiteIbl1.setBounds(40, 215, 330, 490);
        someoneNick.setBounds(640, 650, 300, 60);
        someoneNick.setFont(new Font("Gothic", Font.BOLD, someoneNick.getFont().getSize() + 13));

        someoneNick.setVisible(false);
        whiteIbl2.setBounds(620, 215, 330, 490);
        whiteIbl3.setBounds(40, 725, 910, 120);
        contentslbl.setBounds(40, 725, 910, 120);
        roomIdlbl.setBounds(160, 30, 910, 80);
        roomIdlbl.setFont(new Font("Gothic", Font.BOLD, roomIdlbl.getFont().getSize() + 20));
        clipbtn.setBounds(870, 50, 60, 40);
        whiteIbl4.setBounds(40, 30, 910, 80);
        this.add(whiteIbl1);
        this.add(someoneNick);
        this.add(whiteIbl2);
        this.add(contentslbl);
        this.add(whiteIbl3);
        this.add(roomIdlbl);
        this.add(clipbtn);
        this.add(whiteIbl4);
        whiteIbl1.setIcon(whiteIcon);
        whiteIbl2.setIcon(whiteIcon);
        whiteIbl3.setIcon(imgMk("sub/white.png", 910, 120, Image.SCALE_SMOOTH));
        whiteIbl4.setIcon(imgMk("sub/white.png", 910, 80, Image.SCALE_SMOOTH));

        // 배경
        ImageIcon backImg = imgMk("sub/vs.png", FramW, FramH, Image.SCALE_SMOOTH);
        JLabel backlbl = new JLabel();
        backlbl.setBounds(0, 0, FramW, FramH);
        this.add(backlbl);
        backlbl.setIcon(backImg);

        service("입장");
        t1.start();
        gameStart=new GameStart(this,result);
        gameStart.start();

         // 창닫을 경우
         frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // 
                try {
                    // InfoDTO dto = new InfoDTO(nickName,Info.EXIT);
                    
                    InfoDTO dto = new InfoDTO();
                    dto.setCommand(Info.EXIT);
                    dto.setNickName(GameCharSelectPanel.nick);
                    dto.setRoomId(GameCharSelectPanel.roomId);
                    Sock.writer.writeObject(dto); // 역슬러쉬가 필요가 없음
                    Sock.writer.flush();
                    if(GameCharSelectPanel.t1!=null)
                         GameCharSelectPanel.t1.stop();

                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        });

    } // 생성자

    public void getSetting() {
        Setting settings = new Setting();
        imgPath = settings.getImgPath();

    }

    // 서버 연결부
    public void service(String message) {

        try {
            // 연결시 서버에 보내는 코드

            InfoDTO dto = new InfoDTO();
            dto.setIngame(false);
            dto.setNickName(nick);
            dto.setCharIdx(charIdx);
            dto.setRoomId(roomId);
            dto.setMessage(message);
            dto.setCommand(Info.STATE);
            Sock.writer.writeObject(dto); // 역슬러쉬가 필요가 없음
            Sock.writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        InfoDTO dto = null;
        while (true) {
            System.out.println(123);

            try {
                dto = (InfoDTO) Sock.reader.readObject();
                System.out.println(dto.getRoomId());
                if(dto.isIngame()!=true){

             
                if (dto.getRoomId() != null && dto.getRoomId().equals(roomId)) {

                    if (dto.getNickName() != null && !dto.getNickName().equals(nick)) {
                        if (dto.getCommand() == Info.STATE) {

                            if (dto.getMessage() != null && dto.getMessage().equals("입장")) {// 내가 방주인이고 상대가 입장했음
                                System.out.println(dto.getNickName() + "님 입장하셨습니다.");
                                whiteIbl2.setIcon(someone);
                                someoneNick.setVisible(true);
                                someoneNick.setText("닉네임:" + dto.getNickName());
                                GameCharSelectPanel.otherNick = dto.getNickName();
                                dto.setNickName(nick);
                                dto.setRoomId(roomId);
                                dto.setMessage("입장확인");
                                dto.setCommand(Info.STATE);
                                dto.setIngame(false);
                                Sock.writer.writeObject(dto); // 역슬러쉬가 필요가 없음
                                Sock.writer.flush();
                                readyBtn.setEnabled(true);
                               


                            } else if (dto.getMessage() != null && dto.getMessage().equals("입장확인")) {// 내가 입장했고 상대가 내
                                                                                                     // 입장을 확인했음
                                System.out.println(dto.getNickName() + "님 방에 입장하였습니다");
                                whiteIbl2.setIcon(someone);
                                someoneNick.setVisible(true);
                                someoneNick.setText("닉네임:" + dto.getNickName());
                                GameCharSelectPanel.otherNick = dto.getNickName();
                                readyBtn.setEnabled(true);

                            } else if (dto.getMessage() != null && dto.getMessage().equals("레디1")) {
                                otherCharIdx=dto.getCharIdx();                                                    
                                otherReady = 1;
                                readylbl2.setVisible(true);
                            } else if (dto.getMessage() != null && dto.getMessage().equals("레디0")) {
                                                                                                   
                                otherReady = 0;
                                readylbl2.setVisible(false);
                            }

                        } else if (dto.getCommand() == Info.EXIT) {
                            System.out.println("상대종료");
                            whiteIbl2.setIcon(whiteIcon);
                            someoneNick.setVisible(false);
                            ready = 0;
                            otherReady = 0;
                            readylbl1.setVisible(false);
                            readylbl2.setVisible(false);
                            readyBtn.setEnabled(false);

                        }else if (dto.getCommand() == Info.SEND) {
                            if(dto.getMessage()!=null&&dto.getMessage().equals("charIdx")){
                                otherCharIdx=dto.getCharIdx();
                            }
                           

                        }

                    }

                }
            }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {

                e.printStackTrace();
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leftBtn) {
            if (charIdx == 0) {
                charIdx += 2;

                System.out.println(charIdx);
            } else {
                charIdx = charIdx - 1;
            }
            l.setIcon(s[charIdx]);
            contentslbl.setText(charDetail[charIdx]);
            try {
                InfoDTO dto = new InfoDTO();
                dto.setIngame(false);
                dto.setCommand(Info.SEND);
                dto.setMessage("charIdx");
                dto.setNickName(GameCharSelectPanel.nick);
                dto.setCharIdx(GameCharSelectPanel.charIdx);
                dto.setRoomId(GameCharSelectPanel.roomId);
                Sock.writer.writeObject(dto); // 역슬러쉬가 필요가 없음
                Sock.writer.flush();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if (e.getSource() == rightBtn) {
            if (charIdx == s.length - 1) {
                charIdx -= 2;
            } else {
                charIdx = charIdx + 1;
            }
            l.setIcon(s[charIdx]);
            contentslbl.setText(charDetail[charIdx]);
            try {
                InfoDTO dto = new InfoDTO();
                dto.setCommand(Info.SEND);
                dto.setIngame(false);
                dto.setMessage("charIdx");
                dto.setNickName(GameCharSelectPanel.nick);
                dto.setCharIdx(GameCharSelectPanel.charIdx);
                dto.setRoomId(GameCharSelectPanel.roomId);
                Sock.writer.writeObject(dto); // 역슬러쉬가 필요가 없음
                Sock.writer.flush();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if (e.getSource() == clipbtn) {

            StringSelection contents = new StringSelection(roomId);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(contents, null);
        }
        if (e.getSource() == readyBtn) {
            selectSoundStopFunc();
            if (ready == 0) {
                readylbl1.setVisible(true);
                ready = 1;
                service("레디1");
            } else {
                readylbl1.setVisible(false);
                ready = 0;
                service("레디0");
            }

        } else if (e.getSource() == rightBtn) {
            // charLabel
        }if (e.getSource() == outbtn) {
            try {
            InfoDTO dto = new InfoDTO();
            dto.setCommand(Info.EXIT);
            dto.setIngame(false);
            dto.setNickName(GameCharSelectPanel.nick);
            dto.setRoomId(GameCharSelectPanel.roomId);
            Sock.writer.writeObject(dto); // 역슬러쉬가 필요가 없음
            Sock.writer.flush();
            
            gameStart.stop();
            GameCharSelectPanel.t1.stop();
            selectSoundStopFunc();
            ready=0;
            otherReady=0;
            ((GameSelectFrame)frame).showRoomPan();
            
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

    }

    public void selectSoundStartFunc() {

        sd.selectSoundStart();

    }

    public void selectSoundStopFunc() {
        sd.selectSoundStop();
    }

    // 이미지 생성쓰
    public ImageIcon imgMk(String path, int w, int h, int hint) {
        return new ImageIcon(new ImageIcon(imgPath + path).getImage().getScaledInstance(w, h, hint));
    }

} // class

class GameStart extends Thread {

    GameCharSelectPanel gcp;
    int [] result;
        GameStart(JPanel jp,int [] result){
            this.gcp=(GameCharSelectPanel)jp;
            this.result=result;
        }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                if (GameCharSelectPanel.ready == 1 && GameCharSelectPanel.otherReady == 1) {
                    System.out.println("게임시작");
                    GameCharSelectPanel.ready=0;
                    GameCharSelectPanel.otherReady=0;
                    InfoDTO dto = new InfoDTO();

                    dto.setCommand(Info.EXIT);
                    dto.setIngame(false);
                    dto.setMessage("startGame");
                    dto.setNickName(GameCharSelectPanel.nick);
                    dto.setRoomId(GameCharSelectPanel.roomId);
                    Sock.writer.writeObject(dto); // 역슬러쉬가 필요가 없음
                    Sock.writer.flush();


                    GameCharSelectPanel.t1.stop();
                    gcp.frame.removeAll();
                    gcp.frame.dispose();
                    System.out.println("-----");
                  
                    
                    new GameStartFrame(
                            GameCharSelectPanel.roomId,
                            GameCharSelectPanel.nick,
                            GameCharSelectPanel.charIdx, GameCharSelectPanel.otherCharIdx,
                            result,
                            GameCharSelectPanel.otherNick,
                            GameCharSelectPanel.seed);



                            
                    this.stop();
                 
                    break;
                }
             
                super.run();
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
