public class SongPlaylist extends AddSongPodCast
{
    private String song_name;
    private String song_duration;

    //Constructor
    public SongPlaylist()
    {

    }

    public SongPlaylist(String playlist_name, String content_duration, String song_name, String song_duration) {
        super(playlist_name, content_duration);
        this.song_name = song_name;
        this.song_duration = song_duration;
    }

    //Getter And Setter

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSong_duration() {
        return song_duration;
    }

    public void setSong_duration(String song_duration) {
        this.song_duration = song_duration;
    }

    //ToString

    @Override
    public String toString() {
        return super.toString()+'\''+"SongPlaylist{" +
                "song_name='" + song_name + '\'' +
                ", song_duration='" + song_duration + '\'' +
                '}';
    }
}
