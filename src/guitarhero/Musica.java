package guitarhero;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Musica {
    Clip player;
    public void setSong(String ruta) throws LineUnavailableException, FileNotFoundException, UnsupportedAudioFileException, IOException{
        player = AudioSystem.getClip();
        player.open(AudioSystem.getAudioInputStream(new File(ruta)));
        //control = (Control)player;

    }
    public void setSong(URL ruta) throws LineUnavailableException, FileNotFoundException, UnsupportedAudioFileException, IOException{
        player = AudioSystem.getClip();
        player.open(AudioSystem.getAudioInputStream(ruta));
        //control = (Control)player;

    }
    public void setSong(File file) throws LineUnavailableException, FileNotFoundException, UnsupportedAudioFileException, IOException{
        player = AudioSystem.getClip();
        player.open(AudioSystem.getAudioInputStream(file));
        //control = (Control)player;

    }
    public void loop(int n){
        player.loop(n);
    }
    public int getPosition(){
        return (int)player.getMicrosecondPosition()/1000;
    }
    public long getMicroPosition(){
        return player.getMicrosecondPosition();
    }
    public boolean isOpen(){
        return player.isOpen();
    }
    public void play(){
        player.start();
    }
    public boolean isActive(){
        return player.isActive();
    }
    public void pause(){
        player.stop();
    }
    public void close(){
        player.close();
    }
    public long getMicrosecondLength(){
        return player.getMicrosecondLength();
    }
    public int getMilisecondLength(){
        return (int)(player.getMicrosecondLength()/1000);
    }
    public void setInicio(){
        player.setMicrosecondPosition(0);
    }
    public void setMilisecondPosition(long posicion){
        player.setMicrosecondPosition(posicion*1000);
    }
}
