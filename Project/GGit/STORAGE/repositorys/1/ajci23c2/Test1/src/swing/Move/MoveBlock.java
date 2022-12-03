package swing.Move;



import javax.swing.JLabel;

import swing.GameStartFrame;
import swing.SingleStartFrame;




public class MoveBlock extends Thread {
    JLabel[] blockArr;
    int moveX, moveY;
    int mode;
    

    public MoveBlock(JLabel[] blockArr, int moveX, int moveY,int mode) {
        this.blockArr = blockArr;
        this.moveX = moveX;
        this.moveY = moveY;
        this.mode=mode;
    }

    @Override
    public void run() {
        try {
        
            for (int k = 0; k < 10; k++) {
                Thread.sleep(3);
                for (int i = 0; i < blockArr.length; i++) {
                    blockArr[i].setLocation(blockArr[i].getLocation().x- moveX / 10,
                    blockArr[i].getLocation().y + moveY / 10);
                    
                }
                
            }
            if(mode==0){
                GameStartFrame.totalMoveX-=moveX;
                GameStartFrame.totalMoveY+=moveY;
            }else{
                SingleStartFrame.totalMoveX-=moveX;
                SingleStartFrame.totalMoveY+=moveY;
            }
            
          

      

        } catch (InterruptedException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
    }
}
