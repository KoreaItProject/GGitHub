package swing.SoundF;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import swing.Setting;
import swing.SoundThreadClass;

public class sound {
    Setting settings=new Setting();
    File fileselectSound = new File(settings.getSoundPath()+"selectSound.wav"); // 대기 사운드
    File fileinGameSound = new File(settings.getSoundPath()+"ingameSound.wav"); // 인게임 사운드
    File moveSound = new File(settings.getSoundPath()+"moveSound.wav"); // 움직임 사운드
    File downSoundf = new File(settings.getSoundPath()+"downSound.wav"); // 틀렸을때 사운드
    File miraSound = new File(settings.getSoundPath()+"hp.wav"); // 미라 스킬사운드
    File iceSound = new File(settings.getSoundPath()+"iceSound.wav"); // 아이스 스킬사운드
    File blackEyeSound = new File(settings.getSoundPath()+"blackEyeSound.wav"); // 블랙아이 스킬사운드
    File countDownSound = new File(settings.getSoundPath()+"countDown.wav"); // 카운트다운
    File birdSound = new File(settings.getSoundPath()+"birdSound.wav"); // 새 사운드
    File skillSound = new File(settings.getSoundPath()+"skillUsing.wav"); // 새 사운드
    File winSound = new File(settings.getSoundPath()+"win.wav"); // 이김
    File loseSound = new File(settings.getSoundPath()+"lose.wav"); // 짐


    Clip clip;
    Clip moveClip;
    SoundThreadClass tc;
    SoundThreadClass ingametc;

    public sound() {

    } // 생성자

    // 대기 사운드 스타트
    public void selectSoundStart() {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(fileselectSound));

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

        } catch (Exception e) {

        }
    }

    // 대기 사운드 스탑
    public void selectSoundStop() {
        try {

            if (clip.isRunning()) {
                clip.stop();
                clip.close();
            }

        } catch (Exception e) {

        }
    }

    // 인게임 사운드 스타트
    public void inGameSoundStart() {
        try {
            ingametc = new SoundThreadClass(clip, fileinGameSound, Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
        }
    }
    // 인게임 사운드 스탑
    public void inGameSoundStop() {
        try {
            ingametc.cut();
        } catch (Exception e) {
        }
    }

    // 움직일때 사운드
    public void moveSound() {
        try {
            tc = new SoundThreadClass(moveClip, moveSound, 0);
        } catch (Exception e) {
        }

    }

    // 틀렸을때 사운드
    public void downSound() {
        try {

            tc = new SoundThreadClass(clip, downSoundf, 0);

        } catch (Exception e) {
        }
    }
     // 이겼을때 사운드
     public void winSound() {
        try {

            tc = new SoundThreadClass(clip,winSound, 0);

        } catch (Exception e) {
        }
    }
     // 이겼을때 사운드
     public void loseSound() {
        try {

            tc = new SoundThreadClass(clip,loseSound, 0);

        } catch (Exception e) {
        }
    }

    // 미라스킬 사운드
    public void miraSkillSound() {
        try {
            tc = new SoundThreadClass(clip, miraSound, 0);
        } catch (Exception e) {
        }
    }

    // 아이스 사운드
    public void iceSkillSound() {
        try {
            tc = new SoundThreadClass(clip, iceSound, 0);
        } catch (Exception e) {
        }
    }

    // 블랙아이 사운드
    public void blackEyeSkillSound() {
        try {
            tc = new SoundThreadClass(clip, blackEyeSound, 0);
        } catch (Exception e) {
        }
    }

    // 카운드다운 사운드
    public void countDownSound() {
        try {
            Thread.sleep(300);
            tc = new SoundThreadClass(clip, countDownSound, 0);
        } catch (Exception e) {
        }
    }

    // 새 사운드
    public void birdSound() {
        try {
            tc = new SoundThreadClass(clip, birdSound, 0);
        } catch (Exception e) {
        }
    }

    // 스킬 사용 사운드
    public void skillsound() {
        try {
            tc = new SoundThreadClass(clip, skillSound, 0);
        } catch (Exception e) {
        }
    }

}
