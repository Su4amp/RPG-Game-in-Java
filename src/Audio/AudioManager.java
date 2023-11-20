package src.Audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioManager {
    public AudioManager(){
        loadAudios("/src/Resources/Audio/Hello_-it_s-Me_.wav");
    }
    public void loadAudios(String path){
        try{
           AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(AudioManager.class.getResourceAsStream(path));
           Clip clip = AudioSystem.getClip();
           clip.open(audioInputStream);
           clip.start();
        } catch (UnsupportedAudioFileException | LineUnavailableException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}


