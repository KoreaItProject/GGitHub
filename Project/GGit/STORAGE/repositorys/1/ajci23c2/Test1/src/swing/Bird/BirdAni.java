package swing.Bird;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BirdAni extends Thread {

    JLabel[] birdJLabel;
    ImageIcon[] birdIcon;
    public int birdY = 10;

    public BirdAni(JLabel[] birdJLabel, ImageIcon[] birdIcon) {
        this.birdJLabel = birdJLabel;
        this.birdIcon = birdIcon;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 1000; i++) {
                birdJLabel[0].setLocation(birdJLabel[0].getLocation().x + 4, birdJLabel[0].getLocation().y);
                birdJLabel[1].setLocation(birdJLabel[1].getLocation().x - 3, birdJLabel[1].getLocation().y);
                Thread.sleep(25);
            }
            // for (int i = 1; i <= 1000; i++) {
            // birdJLabel[1].setLocation(birdJLabel[1].getLocation().x + 4,
            // birdJLabel[1].getLocation().y);
            // Thread.sleep(25);
            // }
            birdJLabel[0].setIcon(birdIcon[0]);
            birdJLabel[1].setIcon(birdIcon[1]);
        } catch (Exception e) {

        }
    }
}
