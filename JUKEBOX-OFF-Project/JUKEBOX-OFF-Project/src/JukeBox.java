import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JukeBox
{
    public static void main(String args[])
    {
        DbOperation dbms = new DbOperation();

        long millis = System.currentTimeMillis();
        java.sql.Date date = new Date(millis);

//            String dt = "2020-02-21";
//            java.sql.Date date = Date.valueOf(dt) ;

          //int artist_id = dbms.getArtistId("priya9","female");
//        int album_id = dbms.getAlbumId("pilgrim3",date);
//        int genre_id = dbms.getGenreId("Silent3");

//        boolean addsong = dbms.addSong("slient","pilgrim3"
//                ,date,"priyadahale","female"
//                ,"Abhang4","3:00",16,3,2);

        String date = ""
        ArrayListSong songs = new ArrayListSong();
        Song song = new Song("rock","saavan",);
        List<Song> genrelist = song.


    }
}
