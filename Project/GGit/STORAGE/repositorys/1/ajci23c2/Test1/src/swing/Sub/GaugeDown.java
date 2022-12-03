package swing.Sub;

import swing.GameStartFrame;
import swing.SingleStartFrame;

public class GaugeDown extends Thread{

	int mode;
	public GaugeDown(int mode){
		this.mode=mode;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(mode==0){
				if(GameStartFrame.gauge<100&&GameStartFrame.gauge>0){
					GameStartFrame.gauge-=1;
				}
				if(GameStartFrame.gameRunning==false)
					break;
			}else if(mode==1){
				if(SingleStartFrame.gauge<100&&SingleStartFrame.gauge>0){
					SingleStartFrame.gauge-=1;
				}
				if(SingleStartFrame.gameRunning==false)
					break;
			}else if(mode==2){
				if(SingleStartFrame.comGauge<100&&SingleStartFrame.comGauge>0){
					SingleStartFrame.comGauge-=1;
				}
				if(SingleStartFrame.gameRunning==false)
					break;
			}
				
		}
		

	}
}