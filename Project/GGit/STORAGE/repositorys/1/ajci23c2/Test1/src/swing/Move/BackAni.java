package swing.Move;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import swing.GameStartFrame;

public class BackAni extends Thread{
	JLabel backlbl;
	ImageIcon [] backgroundIcon;
	
	public BackAni(JLabel backlbl,ImageIcon [] backgroundIcon) {
		this.backgroundIcon= backgroundIcon;
		this.backlbl=backlbl;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if(GameStartFrame.gameRunning==false)
                break;
			for(int i=0;i<backgroundIcon.length;i++) {
				if(GameStartFrame.gameRunning==false)
	                 break;
				backlbl.setIcon(backgroundIcon[i]);
				try {
					Thread.sleep(140);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
			
		}
			
			 
		super.run();
	}
}
