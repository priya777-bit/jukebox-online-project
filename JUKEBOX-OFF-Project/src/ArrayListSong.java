import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class ArrayListSong
{
    List<Song>  genrelist = new ArrayList<Song>();
    List<Song> albumlist = new ArrayList<Song>();
    List<Song> artistlist = new ArrayList<Song>();
    List<Song> songlist = new ArrayList<Song>();
    Consumer<Song> display = (d)->System.out.println(d);
    Optional<Song> searchbysongname = Optional.empty();
    Optional<Song> searchbyalbumname = Optional.empty();
    Optional<Song> searchbyartistname = Optional.empty();
    Optional<Song> searchbygenrename = Optional.empty();

    public List<Song> addSongListByGenre(Song song)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "select * from gen_alb_art_song where genre_name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,song.getGenre_name());
            ResultSet rs = pst.executeQuery();

            while(rs.next())
            {
                song.setGenre_name(rs.getString(1));
                genrelist.add(song);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return genrelist;
    }

    public List<Song> addSongListByAlbum(Song song)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "select * from gen_alb_art_song where album_name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,song.getAlbum_name());
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                song.setAlbum_name(rs.getString(2));
                albumlist.add(song);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return albumlist;
    }

    public List<Song> addSongListByArtist(Song song)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "select * from gen_alb_art_song where artist_name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,song.getArtist_name());
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
                song.setArtist_name(rs.getString(4));
                artistlist.add(song);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return artistlist;
    }

    public List<Song> addSongListBySongName(Song song)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "select * from gen_alb_art_song where song_name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,song.getSong_name());
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                song.setSong_name(rs.getString(6));
                songlist.add(song);
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return songlist;
    }

    public void displayGenreList()
    {
        genrelist.forEach(display);
    }

    public void displayAlbumList()
    {
        albumlist.forEach(display);
    }

    public void displayArtistList()
    {
        artistlist.forEach(display);
    }

    public void displaySongList()
    {
        songlist.forEach(display);
    }

    public void sortByDuration(List<Song> songlist)
    {
        songlist.stream().sorted(Comparator.comparing(Song::getSong_duration)).forEach(display);
    }

    public void sortBySongName(List<Song> songlist)
    {
        songlist.stream().sorted(Comparator.comparing(Song::getSong_name)).forEach(display);
    }

    public void sortByArtistName(List<Song> artistlist)
    {
        artistlist.stream().sorted(Comparator.comparing(Song::getArtist_name)).forEach(display);
    }

    public void sortByAlbumName(List<Song> albumlist)
    {
        albumlist.stream().sorted(Comparator.comparing(Song::getAlbum_name)).forEach(display);
    }

    public void sortByGenreName(List<Song> genrelist)
    {
        genrelist.stream().sorted(Comparator.comparing(Song::getGenre_name)).forEach(display);
    }

    public void searchBySongName(String song_name)
    {
        searchbysongname = songlist.stream().filter(p->p.getSong_name().equalsIgnoreCase(song_name)).findAny();

        if(searchbysongname.isPresent())
        {
            songlist.stream().filter(p->p.getSong_name().equalsIgnoreCase(song_name)).forEach(display);
        }
        else
        {
            System.out.println("No Such Song Name Exists..");
        }
    }

    public void searchByAlbumName(String album_name)
    {
        searchbyalbumname = albumlist.stream().filter(p->p.getAlbum_name().equalsIgnoreCase(album_name)).findAny();

        if(searchbyalbumname.isPresent())
        {
            albumlist.stream().filter(p->p.getAlbum_name().equalsIgnoreCase(album_name)).forEach(display);
        }
        else
        {
            System.out.println("No Such Album Found ..");
        }
    }

    public void searchByArtistName(String artist_name)
    {
        searchbyartistname = artistlist.stream().filter(p->p.getArtist_name().equalsIgnoreCase(artist_name)).findAny();

        if(searchbyartistname.isPresent())
        {
            artistlist.stream().filter(p->p.getArtist_name().equalsIgnoreCase(artist_name)).forEach(display);
        }
        else
        {
            System.out.println("No SUch Artist Found ..");
        }
    }

    public void searchByGenreName(String genre_name)
    {
        searchbygenrename = genrelist.stream().filter(p->p.getGenre_name().equalsIgnoreCase(genre_name)).findAny();

        if(searchbygenrename.isPresent())
        {
            genrelist.stream().filter(p->p.getGenre_name().equalsIgnoreCase(genre_name)).forEach(display);
        }
        else
        {
            System.out.println("No Such Genre Found ..");
        }
    }
}
