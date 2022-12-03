package swing.Sub;

import swing.GameStartFrame;
import swing.Setting;
import swing.SingleStartFrame;

public class TimerCount extends Thread {
    private int gameTime, timer = 0;
    public int time;

    public TimerCount() {
        super();
        gameTime = new Setting().getGameTime();

    }

    @Override
    public void run() {

        try {
            while (gameTime + 1 > timer) { // 100>0


                Thread.sleep(1000);
                timer++;
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String getTime() {
        time = gameTime - timer;
        int minute = time / 60;
        int second = time % 60;

        return minute + "분 " + second + "초";
    }

    public int getTime2() {
        return time;
    }

}
