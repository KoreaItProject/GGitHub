package swing.Sub;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import swing.GameStartFrame;
import swing.SingleStartFrame;

public class StartCount extends Thread {
    JLabel countjl;
    ImageIcon[] ImgArr3;
    ImageIcon[] ImgArr2;
    ImageIcon[] ImgArr1;
    ImageIcon[] ImgArrGo;

    public StartCount(JLabel countjl, ImageIcon[] ImgArr3, ImageIcon[] ImgArr2,
            ImageIcon[] ImgArr1, ImageIcon[] ImgArrGo) {
        this.countjl = countjl;
        this.ImgArr3 = ImgArr3;
        this.ImgArr2 = ImgArr2;
        this.ImgArr1 = ImgArr1;
        this.ImgArrGo = ImgArrGo;
    }

    @Override
    public void run() {
 
            countjl.setIcon(ImgArr3[0]);
      
        for (int i = 0; i < ImgArr3.length; i++) {
            countjl.setIcon(ImgArr3[i]);
            try {
                Thread.sleep(1000 / ImgArr3.length);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        for (int i = 0; i < ImgArr2.length; i++) {
            countjl.setIcon(ImgArr2[i]);
            try {
                Thread.sleep(1000 / ImgArr2.length);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        for (int i = 0; i < ImgArr1.length; i++) {
            countjl.setIcon(ImgArr1[i]);
            try {
                Thread.sleep(1000 / ImgArr1.length);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        GameStartFrame.stop=0;
        SingleStartFrame.stop=0;
        SingleStartFrame.comStop=false;
        for (int i = 0; i < ImgArrGo.length; i++) {
            countjl.setIcon(ImgArrGo[i]);
            try {
                Thread.sleep(1000 / ImgArrGo.length);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        countjl.setVisible(false);
        

    }
}