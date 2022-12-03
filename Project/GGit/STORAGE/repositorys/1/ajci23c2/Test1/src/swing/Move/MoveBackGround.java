package swing.Move;


import javax.swing.JLabel;

import swing.GameStartFrame;
import swing.SingleStartFrame;



public class MoveBackGround extends Thread {
    JLabel backlbl;
    int mode;

    public MoveBackGround(JLabel backlbl,int mode) {
        this.backlbl = backlbl;
        this.mode=mode;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 16; i++) {
                backlbl.setLocation(0, backlbl.getLocation().y + 1);
                if(mode==0){
                    GameStartFrame.totalBackMove+=1;
                }else{
                    SingleStartFrame.totalBackMove+=1;
                }
                
                
                Thread.sleep(25);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
