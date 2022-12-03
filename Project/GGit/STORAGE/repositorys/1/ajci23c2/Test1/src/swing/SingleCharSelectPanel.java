package swing;

import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



import swing.SoundF.sound;

import java.awt.event.*;

import java.util.Random;

import java.awt.*;


public class SingleCharSelectPanel extends JPanel implements ActionListener {
   
    int FramW = 1000, FramH = 900;
    int charIdx = 0,comCharIdx=0;
    static boolean player1 = false;
    String imgPath;
    int charSizeW = 300;
    int charSizeH = 600;
    int gifSize = 300;

    // 상대 들어왔나 안들어왔나

    JLabel whiteIbl2;
    ImageIcon whiteIcon;

    ImageIcon s[];
    Icon gif[];
    JLabel l,ll;
    JButton readyBtn;
    JButton outbtn;
    JButton leftBtn;
    JButton rightBtn;
    JButton leftBtn1;
    JButton rightBtn1;
    JLabel contentslbl;

    sound sd = new sound();
    int i, l1;
    JFrame frame;
    public int[] result;
    JComboBox lvlCombo;


    String charDetail[] = {
            "<html><body style='font-size:16px;'><p>&ensp스노우맨</p><p>&ensp스킬 : 일정 시간 동안상대방을 얼린다</p><p>&ensp대상은 움직일 수 없다</p></body></html>",
            "<html><body style='font-size:16px;'><p>&ensp고스트맨</p><p>&ensp스킬 : 일정 시간 동안 상대방의 시야를 방해한다 </p><p>&ensp대상은 시야가 축소된다</p></body></html>",
            "<html><body style='font-size:16px;'><p>&ensp미라맨</p><p>&ensp스킬 : 생명력을 회복한다</p><p>&ensp최대 생명력이 높습니다</p></body></html>" };
    
    int lvl;
 

    public SingleCharSelectPanel(JFrame frame,int lvl,int charIdx,int comCharIdx) {
        getSetting();
        this.frame = frame;
        this.lvl=lvl;
        this.charIdx=charIdx;
        this.comCharIdx=comCharIdx;

        // result 배열 만들기
        Random rand = new Random();

        result = new int[new Setting().getBlockCount()];
        result[0] = 0;
        for (int i = 1; i < result.length; i++) {
            result[i] = rand.nextInt(2); // 0 또는 1
        }
        // result 배열 만들기

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

        leftBtn1 = new JButton("<<");
        rightBtn1 = new JButton(">>");
        leftBtn1.setBounds(690, 640, 60, 30);
        rightBtn1.setBounds(820, 640, 60, 30);
        this.add(leftBtn1);
        this.add(rightBtn1);
        leftBtn1.addActionListener(this);
        rightBtn1.addActionListener(this);


        JLabel comlbl=new JLabel("컴퓨터");
        comlbl.setBounds(640, 220, 300, 60);
        comlbl.setFont(new Font("Gothic", Font.BOLD, comlbl.getFont().getSize() + 22));
        this.add(comlbl);
        String [] lvlData={"60세이상","매우쉬움","쉬움","보통","어려움","매우어려움","헬"};
        lvlCombo = new JComboBox<>(lvlData);
        lvlCombo.setBounds(780, 230, 140,35);
        lvlCombo.setFont(new Font("Gothic", Font.BOLD, lvlCombo.getFont().getSize() + 9));
        lvlCombo.addActionListener(this);
        lvlCombo.setSelectedIndex(lvl);
        this.add(lvlCombo);
        JLabel comlbl1=new JLabel("유저");
        comlbl1.setBounds(60, 220, 300, 60);
        comlbl1.setFont(new Font("Gothic", Font.BOLD, comlbl1.getFont().getSize() + 22));
        this.add(comlbl1);


        s = new ImageIcon[3];
        gif = new Icon[3];

        for (int i = 0; i < s.length; i++) {
            s[i] = imgMk("character/char" + i + ".gif", gifSize, gifSize, 0);
        }

        l = new JLabel("", JLabel.CENTER);
        l.setBounds(50, 50, charSizeW, charSizeH + 200);
        l.setIcon(s[charIdx]);
        this.add(l);
        ll = new JLabel("", JLabel.CENTER);
        ll.setBounds(640, 50, charSizeW, charSizeH + 200);
        ll.setIcon(s[comCharIdx]);
        this.add(ll);

        // 레디 버튼
        readyBtn = new JButton("Start");
        readyBtn.setBackground(new Color(131, 210, 105));
        readyBtn.setBounds(800, 725, 155, 120);
        readyBtn.addActionListener(this); // 이벤트 호출 메서드
        readyBtn.setFont(new Font("Gothic", Font.BOLD, readyBtn.getFont().getSize() + 23));
        this.add(readyBtn);

        outbtn = new JButton("나가기");
        outbtn.setBackground(new Color(227, 202, 227));
        outbtn.setBounds(40, 29, 100, 82);
        outbtn.addActionListener(this); // 이벤트 호출 메서드
        outbtn.setFont(new Font("Gothic", Font.BOLD, outbtn.getFont().getSize() + 8));
        this.add(outbtn);


        whiteIcon = imgMk("sub/white.png", 330, 490, Image.SCALE_SMOOTH);


        JLabel whiteIbl1 = new JLabel();// 왼쪽 캐릭터 div
        whiteIbl2 = new JLabel();// 오른쪽 캐릭터 div
        JLabel whiteIbl3 = new JLabel();// 밑에 설명 div
        JLabel roomIdlbl = new JLabel("vs 컴퓨터");
        JLabel whiteIbl4 = new JLabel();// 위에 방코드 div
        contentslbl = new JLabel(charDetail[0]);

        whiteIbl1.setBounds(40, 215, 330, 490);


        whiteIbl2.setBounds(620, 215, 330, 490);
        whiteIbl3.setBounds(40, 725, 910, 120);
        contentslbl.setBounds(40, 725, 910, 120);
        roomIdlbl.setBounds(160, 30, 910, 80);
        roomIdlbl.setFont(new Font("Gothic", Font.BOLD, roomIdlbl.getFont().getSize() + 20));
        whiteIbl4.setBounds(40, 30, 910, 80);
        this.add(whiteIbl1);

        this.add(whiteIbl2);
        this.add(contentslbl);
        this.add(whiteIbl3);
        this.add(roomIdlbl);
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

      
    } // 생성자

    public void getSetting() {
        Setting settings = new Setting();
        imgPath = settings.getImgPath();

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
           
        }
        else if (e.getSource() == rightBtn) {
            if (charIdx == s.length - 1) {
                charIdx -= 2;
            } else {
                charIdx = charIdx + 1;
            }
            l.setIcon(s[charIdx]);
            contentslbl.setText(charDetail[charIdx]);
            
        }
      
        else if (e.getSource() == leftBtn1) {
            if (comCharIdx == 0) {
                comCharIdx += 2;

                System.out.println(comCharIdx);
            } else {
                comCharIdx = comCharIdx - 1;
            }
            ll.setIcon(s[comCharIdx]);
           
           
        }
        else if (e.getSource() == rightBtn1) {
            if (comCharIdx == s.length - 1) {
                comCharIdx -= 2;
            } else {
                comCharIdx = comCharIdx + 1;
            }
            ll.setIcon(s[comCharIdx]);
           
            
        }
      
        else if (e.getSource() == readyBtn) {
            selectSoundStopFunc();

            
            frame.removeAll();
            frame.dispose();
            new SingleStartFrame(result, charIdx, comCharIdx, lvlCombo.getSelectedIndex());

        } else if (e.getSource() == rightBtn) {
            // charLabel
        }else if (e.getSource() == outbtn) {
        
            selectSoundStopFunc();
            ((GameSelectFrame)frame).showRoomPan();
            
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


