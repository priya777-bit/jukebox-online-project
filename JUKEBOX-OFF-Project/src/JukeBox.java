import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.StreamSupport;

public class JukeBox
{
    public static void main(String args[]) throws LineUnavailableException, IOException, UnsupportedAudioFileException
    {
        SongDbOperation dbms = new SongDbOperation();
        List<Song> mastersonglist = new ArrayList<Song>();
        SongFilterSortOperation sfo = new SongFilterSortOperation();

        PodCastDbOperation pdb = new PodCastDbOperation();
        List<PodCast> masterpodcastlist = new ArrayList<PodCast>();
        PodCastFilterSortOperation pfo = new PodCastFilterSortOperation();

        DbOperationPlayList dbp = new DbOperationPlayList();
        List<AddSongPodCast> contentlist = new ArrayList<AddSongPodCast>();
        PlayListFilterOperation ppfo = new PlayListFilterOperation();

        int choice;

        do {
            System.out.println("1: Enter Song To Add:");
            System.out.println("2: Display/Get List Of All song:");
            System.out.println("3: Search Song By Song Name:");
            System.out.println("4: Search Song By Album Name");
            System.out.println("5: Search Song By Artist Name:");
            System.out.println("6: Search Song By Genre Name");
            System.out.println("7: Enter PodCastEpisode To Add:");
            System.out.println("8: Display/Get PodCastEpisodeList:");
            System.out.println("9: Search PodCast Episode By Celebrity Name:");
            System.out.println("10: Search PodCast Episode By Date:");
            System.out.println("11: Add Content To PlayList:");
            System.out.println("12: Get/Display Content Of PlayList");
            System.out.println("13: Play Song");

            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();

            switch (choice)
            {
                case 1 :
                    System.out.println("1: Enter Genre Name:");
                    String genre_name=sc.next();
                    System.out.println("2: Enter Album Name:");
                    String album_name=sc.next();
                    System.out.println("3: Enter Date In yyyy-MM-dd Format OR It Will Take Current Date: ");
                    long millis = System.currentTimeMillis();
                    java.sql.Date date4 = new Date(millis);
                    String date =sc.next();
                    java.util.Date dt=null;
                    java.sql.Date date1=null;
                    try
                    {
                        dt=new SimpleDateFormat("yyyy-MM-dd").parse(date);
                        date1 = new java.sql.Date(dt.getTime());
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }

                    System.out.println("4: Enter Artist Name:");
                    String artist_name=sc.next();
                    System.out.println("5: Enter Artist Gender:");
                    String artist_gender=sc.next();
                    System.out.println("6: Enter Song Name:");
                    String song_name = sc.next();
                    System.out.println("7: Enter Song Duration:");
                    String song_duration=sc.next();
                    boolean songs = dbms.addSong(genre_name,album_name
                            ,date1,artist_name,artist_gender,song_name,song_duration);
                    break;

                case 2:
                    mastersonglist = dbms.getAllSongs();
                    sfo.display(mastersonglist);
                    break;

                case 3:
                    System.out.println("Enter Song Name To Be Searched:");
                    String songname=sc.next();
                    List<Song> filterbysong = sfo.searchSortBySong(mastersonglist,songname);
                    sfo.display(filterbysong);
                    break;

                case 4:
                    System.out.println("Enter Album Name To Be Searched:");
                    String albumname = sc.next();
                    List<Song> filteralbum = sfo.searchSortByAlbum(mastersonglist,albumname);
                    sfo.display(filteralbum);
                    break;

                case 5:
                    System.out.println("Enter Artist Name To Be Searched:");
                    String artistname = sc.next();
                    List<Song> filterartist = sfo.searchSortByArtist(mastersonglist,artistname);
                    sfo.display(filterartist);
                    break;

                case 6:
                    System.out.println("Enter Genre Name To Be Searched:");
                    String genrename = sc.next();
                    List<Song> filtergenre = sfo.searchSortByGenre(mastersonglist,genrename);
                    sfo.display(filtergenre);
                    break;

                case 7:
                    System.out.println("1: Enter PodCast Type Name:");
                    String podcasttype_name = sc.next();
                    System.out.println("2: Enter Celebrity Name:");
                    String celebrity_name = sc.next();
                    System.out.println("3 Enter Narrator Name:");
                    String narrator_name = sc.next();
                    System.out.println("4: Enter Podcast Name:");
                    String podcast_name = sc.next();
                    System.out.println("5: Enter Episode Name:");
                    String episode_name = sc.next();
                    System.out.println("6: Enter Episode Number:");
                    int episode_number = sc.nextInt();
                    System.out.println("7: Enter Episode Duration:");
                    String episode_duration = sc.next();
                    System.out.println("8: Enter Date In (yyyy-MM-dd) Format OR It Will Take Current Date:");
                    String dat = sc.next();
                    java.util.Date date3 = null;
                    try
                    {
                        date3 = new SimpleDateFormat("yyyy-MM-dd").parse(dat);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    boolean podcasts = pdb.addPodCastEpisode(podcasttype_name,celebrity_name
                    ,narrator_name,podcast_name
                    ,episode_name,episode_number
                    ,episode_duration,date3);
                    break;

                case 8:
                    masterpodcastlist = pdb.getAllPodCast();
                    pfo.display(masterpodcastlist);
                    break;

                case 9:
                    System.out.println("Enter Celebrity Name To Search Its PodCast Episode:");
                    String celebrityname = sc.next();
                    List<PodCast> filtercelebrity = pfo.searchSortByCelebrityName(masterpodcastlist,celebrityname);
                    pfo.display(filtercelebrity);
                    break;

                case 10:
                    System.out.println("Enter Date In (yyyy-MM-dd) Format To Which PodCast Episode Released ");
                    String dat2 = sc.next();
                    java.util.Date dt1 = null;
                    try
                    {
                        dt1 = new SimpleDateFormat("yyyy-MM-dd").parse(dat2);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    List<PodCast> filterdate = pfo.searchSortByEpisodeReleaseDate(masterpodcastlist,dt1);
                    pfo.display(filterdate);
                    break;

                case 11:
                    System.out.println("1: Enter PlayList Name:");
                    String playlist_name = sc.next();
                    System.out.println("2: Enter Content Duration:");
                    String content_duration = sc.next();
                    System.out.println("3 Enter Existing Track Id:");
                    int track_id = sc.nextInt();

                    boolean songpodcast = dbp.addPlayListContent(playlist_name,content_duration,track_id);
                    break;

                case 12:
                    contentlist = dbp.getCombinationOfSongPodCast();
                    ppfo.display(contentlist);
                    break;

                case 13:
                    // get all items of playlist
                    // create names as string collection, get only 'song1'
                    // names : Abhang4, teh_daily, web_1
                    // path = "c:\\songs\\"+ith element" +".wav";
                    String filepath ="C:\\song1\\";
                    AudioPlayer ap = new AudioPlayer();
                    contentlist = dbp.getCombinationOfSongPodCast();
                    ppfo.display(contentlist);
                    ap.playAudio(contentlist,filepath,"song1");
                    break;

                default:
                    System.out.println("Error In Entering Choice");
                    break;
            }
        }while(choice!=14);
//
//
//
//
//        pfo.display(contentlist);
////        List<SongPlaylist> songlist = pfo.getAllSongBySongName(contentlist,"song1",
////                "katya kaljat ghusli");
//        //System.out.println("\nFiltered : " + songlist);
//        List<PodCastPlayList> podlist = pfo.getAllPodCastByPodCastName(contentlist,"song1","web 1");
//        System.out.println("Filtered Podlist :" +podlist);
//
//
//
        //pfo.display(masterpodcastlist);

        //java.util.Date date = new java.util.Date();


//        List<PodCast> searchsortbydate = pfo.searchSortByEpisodeReleaseDate(masterpodcastlist,date);
//        pfo.display(searchsortbydate);
//
//        List<PodCast> searchsortbycelebrity = pfo.searchSortByCelebrityName(masterpodcastlist,"stefen hawkins");
//        pfo.display(searchsortbycelebrity);



//
//
////
//
////
//        List<Song> mastersonglist = dbms.getAllSongs(); // mastersonglist is master data
//        sfo.display(mastersonglist);

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
//
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
