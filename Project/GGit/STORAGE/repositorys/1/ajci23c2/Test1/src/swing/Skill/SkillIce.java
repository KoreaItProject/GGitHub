package swing.Skill;


import javax.swing.JLabel;

import swing.GameStartFrame;
import swing.SingleStartFrame;




public class SkillIce extends Thread {
    JLabel iceBackbl;
    int mode;
    

    public SkillIce(JLabel iceBackbl,int mode) {
        this.iceBackbl = iceBackbl;
        this.mode=mode;
        System.out.println(123);
    }

    @Override
    public void run() {
            if(mode==0){
               
                GameStartFrame.stop = 1;
            }else if(mode==1){
               
                SingleStartFrame.stop = 1;
            }
            


        try {
            iceBackbl.setVisible(true);
            Thread.sleep(1400);
            iceBackbl.setVisible(false);

       
            if(mode==0){
                GameStartFrame.stop = 0;
            }else if(mode==1){
                SingleStartFrame.stop = 0;
            }
     

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
} 