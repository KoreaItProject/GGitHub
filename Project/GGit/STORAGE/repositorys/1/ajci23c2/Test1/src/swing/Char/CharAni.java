package swing.Char;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import swing.GameStartFrame;

public class CharAni extends Thread{
    JLabel charlbl;
    ImageIcon [] charArr;
    int moveX;
    public CharAni(JLabel charlbl,ImageIcon []charArr,int moveX){

        this.charArr=charArr;
        this.charlbl=charlbl;
        this.moveX=moveX;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        int start=0,end=charArr.length/2;
        int move=moveX;
        if(moveX>0){
            start=charArr.length/2;   
            end=charArr.length;
        }
        for(int i=start;i<end;i++){
            if(moveX!=move){
                break;
            }
            if(move==moveX)
            charlbl.setIcon(charArr[i]);
            try {
                if(move!=moveX)
                    Thread.sleep(90);
                Thread.sleep(30);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        
            
        }
        charlbl.setIcon(charArr[0+start]);


        super.run();
    }
}
//틀렸을때 애니메이션