import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JukeBox
{
    public static void main(String args[])
    {
        DbOperation dbms = new DbOperation();
        List<Song> songs=dbms.getAllSongs(); // songs is master data
        //songs.stream().sorted(Comparator.comparing(Song::getGenre_name)).findAny();
        dbms.searchByGenreName("silent");
        dbms.searchByAlbumName("pilgrim3");
        dbms.searchByArtistName("priyadahale");
        dbms.searchBySongName("abhang4");

        dbms.sortByAlbumName("pilgrim3");
        dbms.sortByArtistName("priyadahale");
        dbms.sortByDuration("3:00");
        dbms.sortByGenreName("silent");
        dbms.sortBySongName("abhang4");
        //
        // filter for artists 'Anand'
        //List<Song> filter1 = abcd.getSongsByArtist(songs,'Anand');
        // songs.stream().filter

        //


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
        //ArrayListSong songs = new ArrayListSong();
     //   Song song = new Song("rock","saavan",date3,
       //         "priyaddd","female","sant tochi","4:00");
//        List<Song> genrelist = songs.addSongListByGenre(song);
//        songs.displayGenreList();
//        System.out.println("Genre List Is .."+genrelist);

        //addSong(song); //
        // add song to song table : to check whether artist,album,genre are existing
//          List<Song> albumlist = songs.addSongListByAlbum(song);
//          songs.displayAlbumList();
//          System.out.println("Album List Is .."+albumlist);

        //List<Song> artistlist = songs.addSongListByArtist(song);
//        songs.displayArtistList();

          //List<Song> songlist = songs.addSongListBySongName(song);
//        songs.displaySongList();

         //songs.sortByDuration(songlist);
        //songs.sortBySongName(songlist);
          //songs.sortByAlbumName(albumlist);
          //System.out.println("Sorted Songs Are .."+songs);
        //songs.sortByArtistName(artistlist);
        //songs.sortByGenreName(genrelist);

         //songs.searchByAlbumName("pilgrim");
        // System.out.println("Search By Album Name .."+songs);
        //songs.searchByArtistName("priya");
       // songs.searchByGenreName("silent");
        //songs.searchBySongName("abhang");
    }
}
