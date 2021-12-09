public class AddSongPodCast
{
    private String playlist_name;
    private String content_duration;
    private String song_name;
    private String song_duration;
    private String episode_name;
    private String episode_duration;

    //Constructor
    public AddSongPodCast()
    {

    }

    public AddSongPodCast(String playlist_name, String content_duration, String song_name, String song_duration, String episode_name, String episode_duration) {
        this.playlist_name = playlist_name;
        this.content_duration = content_duration;
        this.song_name = song_name;
        this.song_duration = song_duration;
        this.episode_name = episode_name;
        this.episode_duration = episode_duration;
    }

    //Getter And Setter
    public String getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }

    public String getContent_duration() {
        return content_duration;
    }

    public void setContent_duration(String content_duration) {
        this.content_duration = content_duration;
    }

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

    public String getEpisode_name() {
        return episode_name;
    }

    public void setEpisode_name(String episode_name) {
        this.episode_name = episode_name;
    }

    public String getEpisode_duration() {
        return episode_duration;
    }

    public void setEpisode_duration(String episode_duration) {
        this.episode_duration = episode_duration;
    }

    //ToString

    @Override
    public String toString() {
        return "AddSongPodCast{" +
                "playlist_name='" + playlist_name + '\'' +
                ", content_duration='" + content_duration + '\'' +
                ", song_name='" + song_name + '\'' +
                ", song_duration='" + song_duration + '\'' +
                ", episode_name='" + episode_name + '\'' +
                ", episode_duration='" + episode_duration + '\'' +
                '}';
    }
}
