package swing;

import java.awt.Image;


import javax.swing.*;

import swing.Bird.BirdAni;
import swing.SocketServer.InfoDTO;
import swing.SocketServer.Sock;
import swing.SocketServer.InfoDTO.Info;

import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.*;



public class GameRoomPan extends JPanel implements ActionListener , Runnable {
    int frameW = 1000, frameH = 900;
    JFrame frame;
    String imgPath;
    JButton roomBtn1lbl,roomBtn2lbl,roomBtn3lbl,roomBtn4lbl,roomBtn5lbl;
    JTextField codeText,nicktxt;
    JLabel  blacklbl,codelbl,blacklbl1;
    String host;

    public static String roomId,nick;
    public static int seed;


    static boolean nickCheck=false,roomCheck=false;



    public static Thread t ;

    JLabel nicklbl;
    
    public GameRoomPan(JFrame frame){
        this.frame=frame; 
        this.setLayout(null);
        this.setSize(frameW, frameH);
        getSetting();
        t= new Thread(this);

        
       
        nicklbl=new JLabel("닉네임을 입력해주세요");
        nicklbl.setFont(new Font("Gothic", Font.BOLD, nicklbl.getFont().getSize() + 20));
        nicklbl.setForeground(Color.white);
        this.add(nicklbl);
        nicklbl.setBounds(330,160,500,30);
        nicktxt= new JTextField();
        this.add(nicktxt);
        nicktxt.setFont(new Font("Gothic", Font.BOLD, nicktxt.getFont().getSize()+10));
        nicktxt.setBounds(370,210,260,35);
            //닉네임 입력창
            ImageIcon black1 = imgMk("room/black.png",360, 130, Image.SCALE_SMOOTH);
            blacklbl1=new JLabel(black1);
            blacklbl1.setBounds(320, 130, 360, 130);
            this.add(blacklbl1);



         //버튼
         ImageIcon roomBtn1 = imgMk("room/roomBtn1.png",300, 80, Image.SCALE_SMOOTH);
         ImageIcon roomBtn2 = imgMk("room/roomBtn2.png",300, 80, Image.SCALE_SMOOTH);
         ImageIcon roomBtn5 = imgMk("room/roomBtn5.png",300, 80, Image.SCALE_SMOOTH);
         roomBtn1lbl=new JButton(roomBtn1);
         roomBtn2lbl=new JButton(roomBtn2);
         roomBtn5lbl=new JButton(roomBtn5);
         roomBtn1lbl.setBounds(350, 430, 296, 80);
         roomBtn2lbl.setBounds(350, 330, 296, 80);
         roomBtn5lbl.setBounds(350, 530, 296, 80);
         this.add(roomBtn1lbl);
         this.add(roomBtn2lbl);
         this.add(roomBtn5lbl);
         roomBtn1lbl.addActionListener(this);
         roomBtn2lbl.addActionListener(this);
         roomBtn5lbl.addActionListener(this);

         //코드 입력
         codeText =new JTextField();
         codeText.setBounds(455, 440, 170, 25);
         this.add(codeText);
         codeText.setVisible(false);
         codeText.setFont(new Font("Gothic", Font.BOLD, codeText.getFont().getSize()+10 ));
         codelbl=new JLabel("코드입력");
         codelbl.setFont(new Font("Gothic", Font.BOLD, codelbl.getFont().getSize()+8 ));
         codelbl.setForeground(Color.white);
         codelbl.setBounds(365, 440, 170, 25);
         this.add(codelbl);


         //코드 입력 버튼
         roomBtn3lbl=new JButton("취소");
         roomBtn4lbl=new JButton("확인");
         roomBtn3lbl.setBounds(400, 470, 100, 30);
         roomBtn4lbl.setBounds(500, 470, 100, 30);
         this.add(roomBtn3lbl);
         this.add(roomBtn4lbl);
         roomBtn3lbl.addActionListener(this);
         roomBtn4lbl.addActionListener(this);
         roomBtn3lbl.setVisible(false);
         roomBtn4lbl.setVisible(false);
         
        //코드입력창
         ImageIcon black = imgMk("room/black.png",300, 80, Image.SCALE_SMOOTH);
         blacklbl=new JLabel(black);
         blacklbl.setBounds(350, 430, 294, 80);
         this.add(blacklbl);
         blacklbl.setVisible(false);
     

         //조작법
         JLabel contents=new JLabel("<html><body style='font-size:22px;'><p>&ensp 조작법! </p><p>&ensp오른쪽 방향키 : 보는 방향으로 이동</p><p>&ensp왼쪽 방향키 : 방향 전환 이동</p><p>&ensp스페이스바 : 게이지 100%시 스킬사용</p></body></html>");
         JLabel whiteIbl3=new JLabel(imgMk("sub/white.png",910, 190, Image.SCALE_SMOOTH));//밑에 설명 div
         whiteIbl3.setBounds(40, 650, 910, 190);
         contents.setBounds(55, 650, 910, 170);
         this.add(contents);
         this.add(whiteIbl3);
       
         //새
        ImageIcon [] birdIcon = new ImageIcon[2];
        birdIcon[0] = imgMk("bird/rbird.gif", 60, 60, 0);
        birdIcon[1] = imgMk("bird/lbird.gif", 70, 70, 0);
        JLabel[] birdJLabel = new JLabel[2];
        birdJLabel[0] = new JLabel(birdIcon[0]);
        birdJLabel[1] = new JLabel(birdIcon[1]);

        birdJLabel[0].setBounds(0, 100, 60, 60);
        birdJLabel[1].setBounds(1000, 250, 70, 70);

        add(birdJLabel[0]);
        add(birdJLabel[1]);

        new BirdAni(birdJLabel, birdIcon).start();
 



         //배경
         ImageIcon backImg = imgMk("room/backRoom.png",frameW, frameH, Image.SCALE_SMOOTH);
         JLabel backlbl=new JLabel(backImg);
         backlbl.setBounds(0, 0, frameW, frameH);
         this.add(backlbl);

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
                    t.stop();
                    if(GameCharSelectPanel.t1!=null)
                         GameCharSelectPanel.t1.stop();

                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        });

        //소켓연결부
            try {
            
            Sock.socket = new Socket(host, 9500);
            Sock.reader = new ObjectInputStream(Sock.socket.getInputStream());
            Sock.writer = new ObjectOutputStream(Sock.socket.getOutputStream());



            } catch (UnknownHostException e) {
                System.out.println("서버를 찾을 수 없습니다.");
                e.printStackTrace();
                System.exit(0);
            } catch (IOException e) {
                System.out.println("서버와 연결이 안되었습니다.");
                e.printStackTrace();
                System.exit(0);
            }


        System.out.println("전송 준비 완료!");
        t.start();
       new GoRoom(frame).start();
    }
    
    public void getSetting() {
        Setting settings = new Setting();
        this.imgPath=settings.getImgPath();
        this.host=settings.getHost();



    }


    // 이미지 생성쓰
    public ImageIcon imgMk(String path, int w, int h,int hint) {
        return new ImageIcon(new ImageIcon(imgPath + path).getImage().getScaledInstance(w, h, hint));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == roomBtn1lbl) {//방만들기 바로 입장됨
            if(nicktxt.getText().equals("")){
                nicklbl.setText("닉네임 입력!");
            }else{
                service(Info.MAKE);
            }
            
            
         }else if(e.getSource() == roomBtn2lbl) {//방입장하기 버튼
            roomBtn1lbl.setVisible(false);
            codeText.setVisible(true);
            blacklbl.setVisible(true);
            codelbl.setVisible(true);
            roomBtn3lbl.setVisible(true);
            roomBtn4lbl.setVisible(true);
         }
         else if(e.getSource() == roomBtn3lbl) {//취소
            roomBtn1lbl.setVisible(true);
            codeText.setVisible(false);
            blacklbl.setVisible(false);
            codelbl.setVisible(false);
            roomBtn3lbl.setVisible(false);
            roomBtn4lbl.setVisible(false);
         }
         else if(e.getSource() == roomBtn4lbl) {//확인 코드값 가지고 입장
            if(nicktxt.getText().equals("")){
                nicklbl.setText("닉네임 입력!");
            }else{
                  service(Info.JOIN);
            }
          
          
         }
         else if(e.getSource() == roomBtn5lbl) {//싱글플레이
            try {
            InfoDTO dto = new InfoDTO();
            dto.setCommand(Info.EXIT);
            dto.setMessage("startGame");
            dto.setNickName(GameCharSelectPanel.nick);
            dto.setRoomId(GameCharSelectPanel.roomId);
            Sock.writer.writeObject(dto);
            Sock.writer.flush();
            t.stop();
            System.out.println("123");
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } 
            ((GameSelectFrame)frame).showSingleSelectPan();
        
         }
        

         
        
    }
     // 서버 연결부
     public void service(Info info) {
       

        try {
            // 연결시 서버에 보내는 코드

                InfoDTO dto = new InfoDTO();
                dto.setNickName(nicktxt.getText());
                dto.setRoomId(codeText.getText());
                dto.setCommand(info);
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
           
            try {
                dto =  (InfoDTO)Sock.reader.readObject();
                System.out.println();
                if(dto.getNickName()!=null&&dto.getNickName().equals(nicktxt.getText())){

                    if (dto.getCommand() == Info.MAKE) {
                    if(dto.getMessage()!=null&&dto.getMessage().equals(nicktxt.getText()+"ERR")||dto.equals("")){
                        System.out.println("사용중인 닉네임");
                        nicklbl.setText("사용중인 닉네임");
                    }else{
                        System.out.println("방코드:"+dto.getRoomId());
                        System.out.println("닉네임:"+dto.getNickName());
                        nick=dto.getNickName();
                        roomId=dto.getRoomId();
                        seed= dto.getSeed();
                        nickCheck=true;
                        roomCheck=true;
                        break;

                    }
                    } else if (dto.getCommand() == Info.JOIN) {
                        System.out.println(dto.getMessage());

                        if(dto.getMessage()!=null&&dto.getMessage().equals(nicktxt.getText()+"ERR")){
                            System.out.println("사용중인 닉네임");
                            nicklbl.setText("사용중인 닉네임");
                        }else if(dto.getMessage()!=null&&dto.getMessage().equals(codeText.getText()+"ERR")){
                            System.out.println("존재하지 않는 방");
                            nicklbl.setText("존재하지 않는 방");
                            nickCheck=true;
                            roomCheck=false;
                        }else{
                            nick=dto.getNickName();
                            roomId=dto.getRoomId();
                            seed= dto.getSeed();
                            nickCheck=true;
                            roomCheck=true;
                            break;
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
    
      
}
class GoRoom extends Thread{
    JFrame frame;

GoRoom(JFrame frame){
    this.frame=frame;
}
 @Override
 public void run() {

    while(true){
        try {
            Thread.sleep(500);
            if(GameRoomPan.nickCheck&&GameRoomPan.roomCheck){
               
                 GameRoomPan.nickCheck=false;
                 GameRoomPan.roomCheck=false;
                    
                ((GameSelectFrame)frame).showCharSelectPan(GameRoomPan.roomId,GameRoomPan.nick,GameRoomPan.seed);
                GameRoomPan.t.stop();
                this.stop();
                break;

            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   

 }
}