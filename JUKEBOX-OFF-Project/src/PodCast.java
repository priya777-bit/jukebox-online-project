public class PodCast
{
    private String podcasttype_name;
    private String narrator_name;
    private String celebrity_name;
    private String podcast_name;
    private String episode_name;
    private String episode_number;
    private String episode_duration;

    //Constructor
    public PodCast()
    {

    }

    public PodCast(String podcasttype_name, String narrator_name, String celebrity_name, String podcast_name, String episode_name, String episode_number, String episode_duration) {
        this.podcasttype_name = podcasttype_name;
        this.narrator_name = narrator_name;
        this.celebrity_name = celebrity_name;
        this.podcast_name = podcast_name;
        this.episode_name = episode_name;
        this.episode_number = episode_number;
        this.episode_duration = episode_duration;
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

    public String getEpisode_number() {
        return episode_number;
    }

    public void setEpisode_number(String episode_number) {
        this.episode_number = episode_number;
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
        return "PodCast{" +
                "podcasttype_name='" + podcasttype_name + '\'' +
                ", narrator_name='" + narrator_name + '\'' +
                ", celebrity_name='" + celebrity_name + '\'' +
                ", podcast_name='" + podcast_name + '\'' +
                ", episode_name='" + episode_name + '\'' +
                ", episode_number='" + episode_number + '\'' +
                ", episode_duration='" + episode_duration + '\'' +
                '}';
    }
}
