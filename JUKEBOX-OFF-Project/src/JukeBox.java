import java.util.Date;

public class JukeBox
{
    private int genre_id;
    private String genre_name;

    private int album_id;
    private String album_name;
    private Date album_release_date;

    private int artist_id;
    private String artist_name;
    private String artist_gender;

    private int song_id;
    private String song_name;
    private String song_duration;

    //Getter And Setter
    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public Date getAlbum_release_date() {
        return album_release_date;
    }

    public void setAlbum_release_date(Date album_release_date) {
        this.album_release_date = album_release_date;
    }

    public int getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(int artist_id) {
        this.artist_id = artist_id;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getArtist_gender() {
        return artist_gender;
    }

    public void setArtist_gender(String artist_gender) {
        this.artist_gender = artist_gender;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
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
}
