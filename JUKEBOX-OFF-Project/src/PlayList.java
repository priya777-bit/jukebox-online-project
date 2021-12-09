import java.nio.channels.ScatteringByteChannel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class PlayList
{
    public void display(List<AddSongPodCast> allplaylistname)
    {
        Consumer<AddSongPodCast> display = d->System.out.println(d);
        allplaylistname.stream().forEach(display);
    }

    public List<AddSongPodCast> getCombinationOfSongPodCast()
    {
        List<AddSongPodCast> mastersongpodcastlist = new ArrayList<AddSongPodCast>();

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "select * from p_play";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                mastersongpodcastlist.add(new AddSongPodCast(rs.getString(1)
                        ,rs.getString(2),rs.getString(3)
                        , rs.getString(4), rs.getString(5),rs.getString(6)));
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return mastersongpodcastlist;
    }

    public List<AddSongPodCast> addSongToPlayList(int menu , String song_name)
    {
        AddSongPodCast afo = new AddSongPodCast();

        List<AddSongPodCast> songnamelist = getCombinationOfSongPodCast();

        int playlist_id = getPlayListId(menu,song_name);

        Optional<AddSongPodCast> filterbysongname = songnamelist.stream()
                .filter(p->p.getSong_name().equalsIgnoreCase(song_name)).findAny();
        try
        {
            if (filterbysongname.isPresent()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Driver Registered..");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
                System.out.println("Connection Success..");

                String query = "select * from song where song_name=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1,song_name);
                ResultSet rs = pst.executeQuery();

                if (rs.next())
                {
                    int song_id= rs.getInt(1);
                    String query2 = "insert into playlistcontent (content_duration,playlist_id,track_id) values(?,?,?)";
                    pst.setString(1,afo.getContent_duration());
                    pst.setInt(2,menu);
                    pst.setInt(3,song_id);
                    display(songnamelist);
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return songnamelist;
    }

    public int getPlayListId(int menu , String value)
    {
        int playlist_id = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "select * from playlist where value=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,value);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                playlist_id = rs.getInt(1);
            }
            else
            {
                playlist_id = addPlayListId(menu,value);
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return playlist_id;
    }

    public int addPlayListId(int menu , String value)
    {
        int playlist_id = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "insert into playlist (playlist_name) values(?)";
            PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,value);
            if((pst.executeUpdate())==1)
            {
                ResultSet rs = pst.getGeneratedKeys();
                if(rs.next())
                {
                    playlist_id = rs.getInt(1);
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return playlist_id;
    }

    public Optional<AddSongPodCast> getAllSongBySongName(List<AddSongPodCast> mastersonglist,String song_name)
    {
        Optional<AddSongPodCast> filterbysong = mastersonglist.stream()
                .filter(p->p.getSong_name().equalsIgnoreCase(song_name)).findAny();

        if (filterbysong.isPresent())
        {
            mastersonglist.stream()
                    .filter(p->p.getSong_name().equalsIgnoreCase(song_name));
        }
        else
        {
            System.out.println("No Such Song Found..");
        }
        return filterbysong;
    }
}
