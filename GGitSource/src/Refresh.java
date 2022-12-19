import javax.swing.JFrame;

public class Refresh extends Thread {
    JFrame frame;

    public Refresh(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                frame.revalidate();
                frame.repaint();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
