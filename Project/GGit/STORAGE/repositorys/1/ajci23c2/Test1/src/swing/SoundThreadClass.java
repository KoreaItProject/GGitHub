package swing;

import java.io.File;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.AudioSystem;

public class SoundThreadClass extends Thread {

    Clip clips;
    File file;
    int nums;

    public SoundThreadClass(Clip clip, File file, int num) {
        this.clips = clip;
        this.file = file;
        this.nums = num;

        new Thread(new Runnable() {
            public void run() {
                try {
                    if (nums == -1 | nums == Clip.LOOP_CONTINUOUSLY) {

                        clips = AudioSystem.getClip();
                        clips.open(AudioSystem.getAudioInputStream(file));

                        FloatControl gainControl = (FloatControl) clips.getControl(FloatControl.Type.MASTER_GAIN);
                        gainControl.setValue(-9.0f); // 볼륨 줄이기

                        clips.loop(num);
                        clips.start();
                    } else {
                        clips = AudioSystem.getClip();
                        clips.open(AudioSystem.getAudioInputStream(file));
                        clips.loop(num);
                        clips.start();
                    }

                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
        }).start();
    }

    public void cut(){

            clips.stop();
            clips.close();
        }
    }

