public class PodCastPlayList extends AddSongPodCast
{
    private String episode_name;
    private String episode_duration;

    //
    public PodCastPlayList()
    {

    }
    public PodCastPlayList(String playlist_name, String content_duration, String episode_name, String episode_duration) {
        super(playlist_name, content_duration);
        this.episode_name = episode_name;
        this.episode_duration = episode_duration;
    }

    //

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

    //

    @Override
    public String toString() {
        return super.toString()+'\''+"PodCastPlayList{" +
                "episode_name='" + episode_name + '\'' +
                ", episode_duration='" + episode_duration + '\'' +
                '}';
    }
}
