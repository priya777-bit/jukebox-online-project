import java.sql.*;

import static java.sql.Statement.*;

public class DbOperation
{
    public int getArtistId(String artist_name)
    {
        int artist_id=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "select * from artist";
            PreparedStatement pst = con.prepareStatement(query, RETURN_GENERATED_KEYS);
            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                 rs = pst.getGeneratedKeys();
                 artist_id = rs.getInt(1);
                 return artist_id;
            }
            else
            {
                artist_id = addArtistId(artist_name)
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return artist_id;
    }

    public int addArtistId(String artist_name,String artist_gender)
    {
        int artist_id=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "insert into artist(artist_name,artist_gender) values(?,?)";
            PreparedStatement pst = con.prepareStatement(query, RETURN_GENERATED_KEYS);
            pst.setString(1, artist_name);
            pst.setString(2,artist_gender);
            if((pst.executeUpdate())==1)
            {
                ResultSet rs = pst.getGeneratedKeys();
                artist_id=rs.getInt(1);
                return artist_id;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return artist_id;
    }
    public void addSong(String song_name)
    {
        int artist_id = getArtistId(artist_name);

        int album_id = getAlbumId(artist_name);

        int genre_id = getGenreId(artist_name);

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","root");
            System.out.println("Connection Success..");

            String query = "insert into song (song_name,)"
        }
    }
}
