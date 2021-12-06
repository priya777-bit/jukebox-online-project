import java.sql.*;

import static java.sql.Statement.*;

public class DbOperation
{
    Song song;

    public DbOperation() {
        song = new Song();
    }

    public int getArtistId(String artist_name,String artist_gender)
    {
        int artist_id=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "select * from artist where artist_name=? and artist_gender=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,artist_name);
            pst.setString(2,artist_gender);
            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                 artist_id = rs.getInt(1);
                 return artist_id;
            }
            else
            {
                artist_id = addArtistId(artist_name,artist_gender);
                return artist_id;
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
            PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, artist_name);
            pst.setString(2,artist_gender);
            if((pst.executeUpdate())==1)
            {
                ResultSet rs = pst.getGeneratedKeys();
                if(rs.next())
                {artist_id=rs.getInt(1);
                return artist_id;}
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return artist_id;
    }

    public int getAlbumId(String album_name,Date album_release_date)
    {
        int album_id=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "select * from album where album_name=? and album_release_date=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,album_name);
            pst.setDate(2,new java.sql.Date(album_release_date.getTime()));
            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                album_id=rs.getInt(1);
                return album_id;
            }
            else
            {
                album_id=addAlbumId(album_name,album_release_date);
                return album_id;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return album_id;
    }

    public int addAlbumId(String album_name,Date album_release_date)
    {
        int album_id=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "insert into album(album_name,album_release_date) values(?,?)";
            PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,album_name);
            pst.setDate(2,new java.sql.Date(album_release_date.getTime()));
            if((pst.executeUpdate())==1)
            {
                ResultSet rs = pst.getGeneratedKeys();
                if(rs.next())
                {album_id = rs.getInt(1);
                return album_id;}
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return album_id;
    }

    public int getGenreId(String genre_name)
    {
        int genre_id=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "select * from genre where genre_name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,genre_name);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                genre_id=rs.getInt(1);
                return genre_id;
            }
            else
            {
                genre_id=addGenreId(genre_name);
                return genre_id;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return genre_id;
    }

    public int addGenreId(String genre_name)
    {
        int genre_id=0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
            System.out.println("Connection Success..");

            String query = "insert into genre(genre_name) values(?)";
            PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,genre_name);
            if((pst.executeUpdate())==1)
            {
                ResultSet rs = pst.getGeneratedKeys();
                if(rs.next())
                {genre_id = rs.getInt(1);
                return genre_id;}
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return genre_id;
    }
    public boolean addSong(String song_name,String song_duration,int artist_id,int album_id,int genre_id)
    {
        boolean result = false;

        try
        {

            artist_id = getArtistId(song.getArtist_name(),song.getArtist_gender());

            album_id = getAlbumId(song.getAlbum_name(),new java.sql.Date(song.getAlbum_release_date().getTime()));

            genre_id = getGenreId(song.getGenre_name());

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","root");
            System.out.println("Connection Success..");

            String query = "insert into song (song_name,song_duration,artist_id,album_id,genre_id) values(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,song_name);
            pst.setString(2,song_duration);
            pst.setInt(3,artist_id);
            pst.setInt(4,album_id);
            pst.setInt(5,genre_id);

            int res = pst.executeUpdate();

            if((pst.executeUpdate()==1))
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
