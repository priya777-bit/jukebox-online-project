import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PlayListFilterOperation
{
    public void display(List<AddSongPodCast> allplaylistname)
    {
        Consumer<AddSongPodCast> display = d->System.out.println(d);
        if(display instanceof SongPlaylist)
        {
            allplaylistname.stream().forEach(display);
        }
        else
        {
            allplaylistname.stream().forEach(display);
        }
    }

    public List<SongPlaylist> getAllSongBySongName(List<AddSongPodCast> mastersonglist, String playlist_name,String song_name){
        List<SongPlaylist> result = new ArrayList<SongPlaylist>();
        for(AddSongPodCast obj : mastersonglist){
            if(obj instanceof SongPlaylist){
                SongPlaylist temp = (SongPlaylist)obj;
                if(obj.getPlaylist_name().equalsIgnoreCase(playlist_name) && temp.getSong_name().equalsIgnoreCase(song_name)) {
                    result.add(temp);
                }
            }
        }
        return result;
    }

    public List<PodCastPlayList> getAllPodCastByPodCastName(List<AddSongPodCast> mastersonglist ,String playlist_name,String episode_name)
    {
        List<PodCastPlayList> result = new ArrayList<PodCastPlayList>();
        for(AddSongPodCast obj : mastersonglist)
        {
            if(obj instanceof PodCastPlayList)
            {
                PodCastPlayList temp = (PodCastPlayList)obj;
                if(obj.getPlaylist_name().equalsIgnoreCase(playlist_name) && temp.getEpisode_name().equalsIgnoreCase(episode_name))
                {
                    result.add(temp);
                }
            }
        }
        return result;
    }

//    public boolean getAllSongBySongName1(List<AddSongPodCast> mastersonglist,String playlist_name,String song_name)
//    {
//        boolean result = false;
//
//        List<AddSongPodCast> playlist = new ArrayList<AddSongPodCast>();
//
//        SongPlaylist s = new SongPlaylist();
//
//       List<SongPlaylist> songlist = new ArrayList<SongPlaylist>();
//
//        Optional<AddSongPodCast> filterbysong = mastersonglist.stream()
//                .filter(p->p.getPlaylist_name().equalsIgnoreCase(playlist_name)).findAny();
//
//
//        if (filterbysong.isPresent())
//        {
////            List<AddSongPodCast> temp = mastersonglist.stream()
////                    .filter(p->p.getPlaylist_name().equalsIgnoreCase(playlist_name)).collect(Collectors.toList());
////            System.out.println(temp);
//            System.out.println(mastersonglist.get(2));
//
//            //result=mastersonglist.get(2).equals(s.getSong_name().equalsIgnoreCase(song_name));
//        }
//        else
//        {
//            System.out.println("No Such Song Found..");
//        }
//        return result;
//    }

}
