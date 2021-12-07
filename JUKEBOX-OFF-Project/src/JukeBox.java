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

        SongFilterSortOperation sfo = new SongFilterSortOperation();

        List<Song> mastersonglist = dbms.getAllSongs(); // mastersonglist is master data
        //sfo.display(mastersonglist);

//        List<Song> searchsortbyartist = sfo.searchSortByArtist(mastersonglist,"priyadahale");
//        sfo.display(searchsortbyartist);

//        List<Song> searchsortbyalbum = sfo.searchSortByAlbum(mastersonglist,"jazz");
//        sfo.display(searchsortbyalbum);

//        List<Song> searchsortbysong = sfo.searchSortBySong(mastersonglist,"labb par aye geet suhane");
//        sfo.display(searchsortbysong);
//
        List<Song> searchsortbygenre = sfo.searchSortByGenre(mastersonglist,"spiritual");
        sfo.display(searchsortbygenre);




//        long millis = System.currentTimeMillis();
//        java.sql.Date date4 = new Date(millis);
//
//
//        boolean addsong = dbms.addSong("rock","saavan"
//                ,date4,"bhimsen-joshi","male"
//                ,"ata kothe dhave man","8:30",5,6,1);

//        java.util.Date date = new java.util.Date();
//        String date1 = "yyyy-MM-dd";
//        DateFormat dt = new SimpleDateFormat(date1);
//        String date2 = dt.format(date);
//        java.util.Date date3 = null;
//        try
//        {
//            date3 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
//        }
//        catch (Exception e)
//        {
//            System.out.println(e);
//        }
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
