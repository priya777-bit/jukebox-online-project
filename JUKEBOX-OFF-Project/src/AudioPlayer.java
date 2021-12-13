import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer
{
    List<String> names;
    int index=0;
    // to store current position
   long currentFrame;
   Clip clip;

   //current status of clip
    String status;

    AudioInputStream audio;
    static String filePath;

    //Constructor
    public AudioPlayer()
    {
    }

    public void playAudio(List<AddSongPodCast> list,String filePath,String plName)
            throws UnsupportedAudioFileException,IOException,LineUnavailableException
    {
        try {
            names = new ArrayList<String>();
            for (AddSongPodCast aspc : list) {
                if (aspc.getPlaylist_name().equalsIgnoreCase(plName)) {
                    if (aspc instanceof SongPlaylist) {
                        names.add(filePath + ((SongPlaylist)aspc).getSong_name() + ".wav");
                        System.out.println(((SongPlaylist)aspc).getSong_name());
                    } else {
                        names.add(filePath + ((PodCastPlayList) aspc).getEpisode_name() + ".wav");
                        System.out.println(((PodCastPlayList) aspc).getEpisode_name());
                    }
                }
            }
            audio = AudioSystem.getAudioInputStream(new File(names.get(index)).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audio);
            //clip.loop(Clip.LOOP_CONTINUOUSLY);

            Scanner sc = new Scanner(System.in);

            while(true)
            {
                System.out.println("1 : Play");
                System.out.println("2 : Jump-To-Specific-Time");
                System.out.println("3 : Stop");
                System.out.println("4 : Play-Previous");
                System.out.println("5 : Play-Next");

                int c = sc.nextInt();
                gotoChoice(c);

                if(c==3)
                    break;

            }
            sc.close();
        }
        catch (ClassCastException c)
        {
            System.out.println(c);
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
            jumpToSpecificTime(c1);
            break;
            case 3:stop();
            break;
            case 4:previous();
            break;
            case 5:next();
            break;

        }
    }

    public void play()
    {
        //start the clip
        clip.start();
        status="Play";
    }

    public void jumpToSpecificTime(long c) throws UnsupportedAudioFileException,LineUnavailableException,IOException
    {
        if(c>0 && c<clip.getMicrosecondLength())
        {
            clip.stop();
            clip.close();
            resetAudioStream();
            currentFrame=c;
            clip.setMicrosecondPosition(c);
            this.play();
        }
    }



    public void stop() throws UnsupportedAudioFileException,LineUnavailableException,IOException
    {
        currentFrame=0L;
        clip.stop();
        clip.close();
    }

    public void next() throws UnsupportedAudioFileException,LineUnavailableException,IOException {
        int count = 0;
        try {
            if (count < names.size()) {
                clip.stop();
                audio = AudioSystem.getAudioInputStream(new File(names.get(++index)).getAbsoluteFile());
                clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            }
        }
        catch(Exception e)
        {
            System.out.println("There Is No Next Play..");
        }
    }

    public void previous() throws UnsupportedAudioFileException,LineUnavailableException,IOException {
        int count = 0;
        try {
            if (count < names.size()) {
                clip.stop();
                audio = AudioSystem.getAudioInputStream(new File(names.get(--index)).getAbsoluteFile());
                clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            }
        }
        catch (Exception e)
        {
            System.out.println("There Is No Previous Play..");
        }
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