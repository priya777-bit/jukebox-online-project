import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JukeBox
{
    public static void main(String args[])
    {
        DbOperation dbms = new DbOperation();

        long millis = System.currentTimeMillis();
        java.sql.Date date = new Date(millis);

//            String dt = "2020-02-21";
//            java.sql.Date date = Date.valueOf(dt) ;

        int artist_id = dbms.getArtistId("priya","female");
        int album_id = dbms.getAlbumId("pilgrim",date);
        int genre_id = dbms.getGenreId("Silent");

        boolean addsong = dbms.addSong("Abhang","3:00",16,3,2);
    }
}
