package swing.Move;


import javax.swing.JLabel;



public class MoveBackGroundReset extends Thread {
    JLabel backlbl;
    int totalBackMove;

    public MoveBackGroundReset(JLabel backlbl,int totalBackMove) {
        this.backlbl = backlbl;
        this.totalBackMove=totalBackMove;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                backlbl.setLocation(0, backlbl.getLocation().y - totalBackMove/20);
                Thread.sleep(10);
            }
            backlbl.setLocation(0, backlbl.getLocation().y - totalBackMove%20);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
