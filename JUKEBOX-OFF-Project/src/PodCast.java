import java.util.Date;

public class PodCast
{
    private String podcasttype_name;
    private String narrator_name;
    private String celebrity_name;
    private String podcast_name;
    private String episode_name;
    private int episode_number;
    private String episode_duration;
    private Date episode_release_date;

    //Constructor
    public PodCast()
    {

    }

    public PodCast(String podcasttype_name, String narrator_name, String celebrity_name, String podcast_name, String episode_name, int episode_number, String episode_duration, Date episode_release_date) {
        this.podcasttype_name = podcasttype_name;
        this.narrator_name = narrator_name;
        this.celebrity_name = celebrity_name;
        this.podcast_name = podcast_name;
        this.episode_name = episode_name;
        this.episode_number = episode_number;
        this.episode_duration = episode_duration;
        this.episode_release_date = episode_release_date;
    }

    //Getter And Setter
    public String getPodcasttype_name() {
        return podcasttype_name;
    }

    public void setPodcasttype_name(String podcasttype_name) {
        this.podcasttype_name = podcasttype_name;
    }

    public String getNarrator_name() {
        return narrator_name;
    }

    public void setNarrator_name(String narrator_name) {
        this.narrator_name = narrator_name;
    }

    public String getCelebrity_name() {
        return celebrity_name;
    }

    public void setCelebrity_name(String celebrity_name) {
        this.celebrity_name = celebrity_name;
    }

    public String getPodcast_name() {
        return podcast_name;
    }

    public void setPodcast_name(String podcast_name) {
        this.podcast_name = podcast_name;
    }

    public String getEpisode_name() {
        return episode_name;
    }

    public void setEpisode_name(String episode_name) {
        this.episode_name = episode_name;
    }

    public int getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(int episode_number) {
        this.episode_number = episode_number;
    }

    public String getEpisode_duration() {
        return episode_duration;
    }

    public void setEpisode_duration(String episode_duration) {
        this.episode_duration = episode_duration;
    }

    public Date getEpisode_release_date() {
        return episode_release_date;
    }

    public void setEpisode_release_date(Date episode_release_date) {
        this.episode_release_date = episode_release_date;
    }

    //ToString

    @Override
    public String toString() {
        return "PodCast{" +
                "podcasttype_name='" + podcasttype_name + '\'' +
                ", narrator_name='" + narrator_name + '\'' +
                ", celebrity_name='" + celebrity_name + '\'' +
                ", podcast_name='" + podcast_name + '\'' +
                ", episode_name='" + episode_name + '\'' +
                ", episode_number=" + episode_number +
                ", episode_duration='" + episode_duration + '\'' +
                ", episode_release_date=" + episode_release_date +
                '}';
    }
}
