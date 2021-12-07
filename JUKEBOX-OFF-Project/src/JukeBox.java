import java.sql.Date;
import java.text.DateFormat;
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
        java.sql.Date date4 = new Date(millis);

//            String dt = "2020-02-21";
//            java.sql.Date date = Date.valueOf(dt) ;

          //int artist_id = dbms.getArtistId("priya9","female");
//        int album_id = dbms.getAlbumId("pilgrim3",date);
//        int genre_id = dbms.getGenreId("Silent3");

//        boolean addsong = dbms.addSong("slient","pilgrim3"
//                ,date4,"priyadahale","female"
//                ,"Abhang4","3:00",16,3,2);

        java.util.Date date = new java.util.Date();
        String date1 = "yyyy-MM-dd";
        DateFormat dt = new SimpleDateFormat(date1);
        String date2 = dt.format(date);
        java.util.Date date3 = null;
        try
        {
            date3 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        ArrayListSong songs = new ArrayListSong();
        Song song = new Song("rock","saavan",date3,
                "priyaddd","female","sant tochi","4:00");
        //List<Song> genrelist = songs.addSongListByGenre(song);
        //songs.displayGenreList();

       // List<Song> albumlist = songs.addSongListByAlbum(song);
//        songs.displayAlbumList();

        //List<Song> artistlist = songs.addSongListByArtist(song);
//        songs.displayArtistList();

          //List<Song> songlist = songs.addSongListBySongName(song);
//        songs.displaySongList();

        //songs.sortByDuration(songlist);
        //songs.sortBySongName(songlist);
        //songs.sortByAlbumName(albumlist);
        //songs.sortByArtistName(artistlist);
        //songs.sortByGenreName(genrelist);

        songs.searchByAlbumName("saavan");
        //songs.searchByArtistName("priya");
        //songs.searchByGenreName("silent");
        //songs.searchBySongName("abhang");
    }
}
