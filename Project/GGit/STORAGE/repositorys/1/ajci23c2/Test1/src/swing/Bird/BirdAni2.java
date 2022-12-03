package swing.Bird;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BirdAni2 extends Thread {

    JLabel[] birdJLabel;
    ImageIcon[] birdIcon;
    int moveX;

    public BirdAni2(JLabel[] birdJLabel, ImageIcon[] birdIcon, int moveX) {
        this.birdJLabel = birdJLabel;
        this.birdIcon = birdIcon;
        this.moveX = moveX;
    }

    @Override
    public void run() {
        try {

            if (moveX >= 0) { // 양수(오른쪽)
                for (int i = 1; i <= 20; i++) {
                    birdJLabel[0].setLocation(birdJLabel[0].getLocation().x - 2, birdJLabel[0].getLocation().y + 1);
                    birdJLabel[1].setLocation(birdJLabel[1].getLocation().x - 2, birdJLabel[1].getLocation().y + 1);
                    Thread.sleep(10);
                }
            } else { // 음수(왼쪽)
                for (int i = 1; i <= 20; i++) {
                    birdJLabel[0].setLocation(birdJLabel[0].getLocation().x + 2, birdJLabel[0].getLocation().y + 1);
                    birdJLabel[1].setLocation(birdJLabel[1].getLocation().x + 2, birdJLabel[1].getLocation().y + 1);
                    Thread.sleep(10);
                }
            }
            birdJLabel[0].setIcon(birdIcon[0]);
            birdJLabel[1].setIcon(birdIcon[1]);
        } catch (Exception e) {

        }
    }
}
