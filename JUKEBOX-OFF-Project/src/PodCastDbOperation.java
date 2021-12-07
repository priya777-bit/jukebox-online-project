import jdk.jshell.spi.SPIResolutionException;

import java.sql.*;

public class PodCastDbOperation
{
    private int getPodCastTypeId(String podcasttype_name)
    {
        int podcasttype_id = 0;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered ..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/podcast","root","root");
            System.out.println("Connection Success ..");

            String query = "select * from podcasttype where podcasttype_name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,podcasttype_name);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                podcasttype_id = rs.getInt(1);
                return podcasttype_id;
            }
            else
            {
                podcasttype_id = addPodCastTypeId(podcasttype_name);
                return podcasttype_id;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return podcasttype_id;
    }

    private int addPodCastTypeId(String podcasttype_name)
    {
        int podcasttype_id = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered ..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/podcast","root","root");
            System.out.println("Connection Success ..");

            String query = "insert into podcasttype (podcasttype_name) values(?)";
            PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,podcasttype_name);

            if((pst.executeUpdate())==1)
            {
                ResultSet rs = pst.getGeneratedKeys();
                if(rs.next())
                {
                    podcasttype_id = rs.getInt(1);
                    return podcasttype_id;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return podcasttype_id;
    }

    private int getCelebrityId(String celebrity_name)
    {
        int celebrity_id = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered ..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/podcast","root","root");
            System.out.println("Connection Success ..");

            String query = "select * from celebrity where celebrity_name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,celebrity_name);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                celebrity_id = rs.getInt(1);
                return celebrity_id;
            }
            else
            {
                celebrity_id = addCelebrityId(celebrity_name);
                return celebrity_id;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return celebrity_id;
    }

    private int addCelebrityId(String celebrity_name)
    {
        int celebrity_id = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered ..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/podcast","root","root");
            System.out.println("Connection Success ..");

            String query = "insert into celebrity (celebrity_name) values (?)";
            PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,celebrity_name);

            if((pst.executeUpdate())==1)
            {
                ResultSet rs = pst.getGeneratedKeys();
                if(rs.next())
                {
                    celebrity_id = rs.getInt(1);
                    return celebrity_id;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return celebrity_id;
    }

    private int getNarratorId(String narrator_name)
    {
        int narrator_id = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered ..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/podcast","root","root");
            System.out.println("Connection Success ..");

            String query = "select * from narrator where narrator_name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,narrator_name);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                narrator_id = rs.getInt(1);
                return narrator_id;
            }
            else
            {
                narrator_id = addNarratorId(narrator_name);
                return narrator_id;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return narrator_id;
    }

    private int addNarratorId(String narrator_name)
    {
        int narrator_id = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered ..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/podcast","root","root");
            System.out.println("Connection Success ..");

            String query = "insert into narrator (narrator_name) values (?)";
            PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,narrator_name);

            if((pst.executeUpdate())==1)
            {
                ResultSet rs = pst.getGeneratedKeys();
                if(rs.next())
                {
                    narrator_id = rs.getInt(1);
                    return narrator_id;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return narrator_id;
    }

    private int getPodtCastId(String podcast_name,String podcasttype_name,String celebrity_name
            ,String narrator_name,int podcasttype_id,int celebrity_id,int narrator_id)
    {
        int podcast_id = 0;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered ..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/podcast","root","root");
            System.out.println("Connection Success ..");

            String query = "select * from podcast where podcast_name=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,podcast_name);
            ResultSet rs = pst.executeQuery();
            if(rs.next())
            {
                podcast_id = rs.getInt(1);
                return podcast_id;
            }
            else
            {
                podcast_id = addPodCastID(podcast_name,podcasttype_name,celebrity_name
                        ,narrator_name,podcasttype_id,celebrity_id,narrator_id);
                return podcast_id;
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return podcast_id;
    }

    private int addPodCastID(String podcast_name,String podcasttype_name,String celebrity_name
            ,String narrator_name,int podcasttype_id,int celebrity_id,int narrator_id)
    {
        int podcast_id = 0;

        try
        {
            podcasttype_id = getPodCastTypeId(podcasttype_name);

            celebrity_id = getCelebrityId(celebrity_name);

            narrator_id = getNarratorId(narrator_name);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered ..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/podcast","root","root");
            System.out.println("Connection Success ..");

            String query = "insert into podcast (podcast_name,podcasttype_id,celebrity_id,narrator_id) " +
                    "values (?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,podcast_name);
            pst.setInt(2,podcasttype_id);
            pst.setInt(3,celebrity_id);
            pst.setInt(4,narrator_id);

            if((pst.executeUpdate())==1)
            {
                ResultSet rs = pst.getGeneratedKeys();
                if(rs.next())
                {
                    podcast_id = rs.getInt(1);
                    return podcast_id;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return podcast_id;
    }

    public boolean addPodCastEpisode(String podcasttype_name , String celebrity_name , String narrator_name ,
            String podcast_name , String episode_name
            , int episode_number , String episode_duration
            , int podcasttype_id , int celebrity_id , int narrator_id,int podcast_id)
    {
        boolean result = false;

        try
        {
            podcast_id = getPodtCastId(podcast_name,podcasttype_name,celebrity_name,
                    narrator_name,podcasttype_id,celebrity_id,narrator_id);

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Registered ..");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/podcast","root","root");
            System.out.println("Connection Success ..");

            String query = "insert into podcastepisode (episode_name,episode_number,episode_duration,podcast_id) " +
                    "values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,episode_name);
            pst.setInt(2,episode_number);
            pst.setString(3,episode_duration);
            pst.setInt(4,podcast_id);

            if((pst.executeUpdate())==1)
            {
                result =  true;
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return result;
    }
}
