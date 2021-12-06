import java.sql.Date;

public class JukeBox
{
    public static void main(String args[])
    {
        DbOperation dbms = new DbOperation();

        long millis = System.currentTimeMillis();
        java.sql.Date date = new Date(millis);

        //int artist_id = dbms.getArtistId("priya","female");
        //int album_id = dbms.getAlbumId("pilgrim",date);
        //int genre_id = dbms.getGenreId("Silent");

        boolean addsong = dbms.addSong("Abhang","3:00",1,1,1);
    }
}
