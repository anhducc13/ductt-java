package uet.oop.bomberman.audio;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Lưu trữ các audio
 */
public class Audio {

    public static String soundThemeFile = "res/audio/soundTheme.wav";
    public static String soundExploisionFile = "res/audio/audioExplosion.wav";
    public static String soundGetItemFile = "res/audio/audioGetItem.wav";
    public static String soundGameOverFile = "res/audio/audioGameOver.wav";
    public static String soundNextLevelFile = "res/audio/audioNextLevel.wav";
    public static String soundBomberDeadFile = "res/audio/audioBomberDead.wav";
    public static String soundBomberStep = "res/audio/audioStep.wav";
    public static String soundScreen = "res/audio/audioScreen.wav";

    public static Clip clipTheme;
    public static Clip clipExploision;
    public static Clip clipGetItem;
    public static Clip clipGameOver;
    public static Clip clipNextLevel;
    public static Clip clipBomberDead;
    public static Clip clipBomberStep;
    public static Clip clipScreen;


    public Audio() {
        try {
            clipTheme = AudioSystem.getClip();
            clipExploision = AudioSystem.getClip();
            clipGetItem = AudioSystem.getClip();
            clipGameOver = AudioSystem.getClip();
            clipNextLevel = AudioSystem.getClip();
            clipBomberDead = AudioSystem.getClip();
            clipBomberStep = AudioSystem.getClip();
            clipScreen = AudioSystem.getClip();

            clipTheme.open(AudioSystem.getAudioInputStream(new File(soundThemeFile)));
            clipExploision.open(AudioSystem.getAudioInputStream(new File(soundExploisionFile)));
            clipGetItem.open(AudioSystem.getAudioInputStream(new File(soundGetItemFile)));
            clipGameOver.open(AudioSystem.getAudioInputStream(new File(soundGameOverFile)));
            clipNextLevel.open(AudioSystem.getAudioInputStream(new File(soundNextLevelFile)));
            clipBomberDead.open(AudioSystem.getAudioInputStream(new File(soundBomberDeadFile)));
            clipBomberStep.open(AudioSystem.getAudioInputStream(new File(soundBomberStep)));
            clipScreen.open(AudioSystem.getAudioInputStream(new File(soundScreen)));

        } catch (LineUnavailableException e) {
        } catch (UnsupportedAudioFileException e) {
        } catch (IOException e) {
        }
    }

    public static void stopAll() {
        clipTheme.stop();
        clipExploision.stop();
        clipGetItem.stop();
        clipGameOver.stop();
        clipNextLevel.stop();
        clipBomberDead.stop();
        clipBomberStep.stop();
        clipScreen.stop();
    }



    public void stop() {

    }



    public static void main(String[] args) {
        new Audio();
        JFrame j = new JFrame();
        j.setLocationRelativeTo(null);

        j.setSize(400, 300);
        JButton btn = new JButton("Click Button");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!Audio.clipGameOver.isRunning()) {
                    Audio.clipGameOver.start();
                } else {
                    Audio.clipGameOver.stop();
                }
            }
        });
        j.add(btn);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
