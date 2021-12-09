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


    public List<SongPlaylist> getAllSongBySongName(List<SongPlaylist> mastersonglist,String song_name)
    {
        List<SongPlaylist> songlist = new ArrayList<SongPlaylist>();

        Optional<SongPlaylist> filterbysong = mastersonglist.stream()
                .filter(p->p.getSong_name().equalsIgnoreCase(song_name)).findAny();

        if (filterbysong.isPresent())
        {
            songlist=mastersonglist.stream()
                    .filter(p->p.getSong_name().equalsIgnoreCase(song_name)).collect(Collectors.toList());
        }
        else
        {
            System.out.println("No Such Song Found..");
        }
        return songlist;
    }

}
