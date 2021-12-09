public class AddSongPodCast
{
    private String playlist_name;
    private String content_duration;

    //Constructor
    public AddSongPodCast()
    {

    }

    public AddSongPodCast(String playlist_name, String content_duration) {
        this.playlist_name = playlist_name;
        this.content_duration = content_duration;
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

    //ToString

    @Override
    public String toString() {
        return "AddSongPodCast{" +
                "playlist_name='" + playlist_name + '\'' +
                ", content_duration='" + content_duration + '\'' +
                '}';
    }
}
