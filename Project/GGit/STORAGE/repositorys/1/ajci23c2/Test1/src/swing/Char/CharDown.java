package swing.Char;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import swing.GameStartFrame;
import swing.SingleStartFrame;

public class CharDown extends Thread{
    JLabel charlbl;
    ImageIcon [] charArr,charDown;
    int mode=0;//0 대전인지, 1 싱글인지, 2싱글 컴퓨터인지에 따라 달라진다.
    
    
    public CharDown(JLabel charlbl,ImageIcon [] charDown,ImageIcon [] charArr,int mode){

        this.charArr=charArr;
        this.charDown=charDown;
        this.charlbl=charlbl;
        this.mode=mode;
    }

    @Override
    public void run() {
        if(mode==0){
            GameStartFrame.downed=true;
        }else if(mode==1){
            SingleStartFrame.downed=true;
        }
        
      
        // TODO Auto-generated method stub
        int start=0,end=charDown.length/2;

        if(mode==0){
            if(GameStartFrame.moveX>0){
                start=charDown.length/2;   
                end=charDown.length;
            }
        }else if(mode==1){
            if(SingleStartFrame.moveX>0){
                start=charDown.length/2;   
                end=charDown.length;
            }
        }
            


        for(int i=start;i<end;i++){
            charlbl.setIcon(charDown[i]);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        charlbl.setIcon(charArr[0+start]);

        if(mode==0){
            GameStartFrame.downed=false;
        }else if(mode==1){
            SingleStartFrame.downed=false;
        }


        super.run();
    }
}