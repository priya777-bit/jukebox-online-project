import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class DbOperationPlayList
{
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
                if(rs.getString(3)!=null)
                {
                    mastersongpodcastlist.add(new SongPlaylist(rs.getString(1),rs.getString(2),
                            rs.getString(3),rs.getString(4)));
                }
                else
                {
                    mastersongpodcastlist.add(new PodCastPlayList(rs.getString(1),rs.getString(2)
                            ,rs.getString(5),rs.getString(6)));
                }

            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return mastersongpodcastlist;
    }

    private int getPlayListId(String value)
    {
        int playlist_id = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "select * from playlist where playlist_name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,value);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                playlist_id = rs.getInt(1);
            }
            else
            {
                playlist_id = addPlayListId(value);
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return playlist_id;
    }

    private int addPlayListId(String value)
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

    public boolean addPlayListContent(String playlist_name,String content_duration,int track_id)
    {
        boolean result = false;

        try
        {
           int  playlist_id = getPlayListId(playlist_name);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "insert into playlistcontent (content_duration,playlist_id,track_id) values (?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,content_duration);
            pst.setInt(2,playlist_id);
            pst.setInt(3,track_id);


            if((pst.executeUpdate())==1)
            {
                result = true;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return result;
    }
}
