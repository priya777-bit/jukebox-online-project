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
        PodCastDbOperation pdb = new PodCastDbOperation();
        List<PodCast> masterpodcastlist = pdb.getAllPodCast();
        PodCastFilterSortOperation pfo = new PodCastFilterSortOperation();

        //java.util.Date date = new java.util.Date();
        String date1 = "2021-12-07";
        //DateFormat dt = new SimpleDateFormat(date1);
        //String date2 = dt.format(date);
        java.util.Date date = null;
        try
        {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        List<PodCast> searchsortbydate = pfo.searchSortByEpisodeReleaseDate(masterpodcastlist,date);
        pfo.display(searchsortbydate);

//        List<PodCast> searchsortbycelebrity = pfo.searchSortByCelebrityName(masterpodcastlist,"stefen hawkins");
//        pfo.display(searchsortbycelebrity);

//        long millis = System.currentTimeMillis();
//        java.sql.Date date4 = new Date(millis);

//        boolean result = pdb.addPodCastEpisode("horror"
//                ,"soni","shades"
//                ,"mossaic","web 1"
//                ,10,"01:30:25",date4,6,7,8,10);
//        SongDbOperation dbms = new SongDbOperation();
//
//        SongFilterSortOperation sfo = new SongFilterSortOperation();
//
//        List<Song> mastersonglist = dbms.getAllSongs(); // mastersonglist is master data
        //sfo.display(mastersonglist);

//        List<Song> searchsortbyartist = sfo.searchSortByArtist(mastersonglist,"priyadahale");
//        sfo.display(searchsortbyartist);

//        List<Song> searchsortbyalbum = sfo.searchSortByAlbum(mastersonglist,"jazz");
//        sfo.display(searchsortbyalbum);

//        List<Song> searchsortbysong = sfo.searchSortBySong(mastersonglist,"labb par aye geet suhane");
//        sfo.display(searchsortbysong);
//
//        List<Song> searchsortbygenre = sfo.searchSortByGenre(mastersonglist,"spiritual");
//        sfo.display(searchsortbygenre);
//
//
//        boolean addsong = dbms.addSong("rock","saavan"
//                ,date4,"bhimsen-joshi","male"
//                ,"ata kothe dhave man","8:30",5,6,1);
//*************************************************************************//////////////////////////////////
//
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
