package swing.Skill;


import javax.swing.JLabel;



public class SkillBlackEye extends Thread {
    JLabel blackEyelbl;


    public SkillBlackEye(JLabel blackEyelbl) {
        this.blackEyelbl = blackEyelbl;

    }

    @Override
    public void run() {

        try {
            blackEyelbl.setVisible(true);    
            Thread.sleep(4400);
            blackEyelbl.setVisible(false);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}