import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer
{
    // to store current position
   long currentFrame;
   Clip clip;

   //current status of clip
    String status;

    AudioInputStream audio;
    static String filePath;

    //Constructor
    public AudioPlayer(String p) throws UnsupportedAudioFileException,IOException,LineUnavailableException
    {
        filePath=p;
        audio = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audio);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
//        play();
    }

    public void giveFilePath()
    {
        try
        {
            filePath = "C:\\songs\\s1.wav";
           AudioPlayer audioplayer  = new AudioPlayer(filePath);
           audioplayer.play();
            Scanner sc = new Scanner(System.in);

            while(true)
            {
                System.out.println("1 : play");
                System.out.println("2 : next");
                System.out.println("3 : stop");

                int c = sc.nextInt();
                audioplayer.gotoChoice(c);

                if(c==3)
                    break;
            }
            sc.close();
        }
        catch(Exception e)
        {
            System.out.println("Error with playing song");
            e.printStackTrace();
        }
    }

    //work as the user enters choice
    private void gotoChoice(int c) throws UnsupportedAudioFileException,IOException,LineUnavailableException
    {
        switch (c)
        {
            case 1:play();
            break;
            case 2:System.out.println("Enter time("+0+","+clip.getMicrosecondLength()+")");
            Scanner sc = new Scanner(System.in);
            Long c1 = sc.nextLong();
            jumpToNext(c1);
            break;
            case 3:stop();
            break;

        }
    }

    public void play()
    {
        //start the clip
        clip.start();
        status="Play";
    }

    public void jumpToNext(long c1) throws UnsupportedAudioFileException,LineUnavailableException,IOException
    {
        if(c1>0 && c1<clip.getMicrosecondLength())
        {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame=c1;
            clip.setMicrosecondPosition(c1);
            this.play();
        }
    }



    public void stop() throws UnsupportedAudioFileException,LineUnavailableException,IOException
    {
        currentFrame=0L;
        clip.stop();
        clip.close();
    }

    public void resetAudioStream() throws UnsupportedAudioFileException,LineUnavailableException,IOException
    {
        audio = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip.open(audio);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
}



//play(0); : ("C:\\songs\\"+list[0].trackid+".wav";
//n - play(1)
//n - play(2)
//p - play(1)