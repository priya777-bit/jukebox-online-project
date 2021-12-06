//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ArrayListSong
//{
//    List<Song> songlist = new ArrayList<Song>();
//
//    public List<Song> addSongList(Song song)
//    {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("Driver Registered..");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox", "root", "root");
//            System.out.println("Connection Success..");
//
//            String query = "select * from gen_alb_art_song ";
//        }
//        catch(Exception e)
//        {
//            System.out.println(e);
//        }
//    }
//}
