import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class PodCastFilterSortOperation
{
    public List<PodCast> searchSortByCelebrityName(List<PodCast> masterpodcastlist , String celebrity_name)
    {
        List<PodCast> searchsortbycelebrityname = new ArrayList<PodCast>();

        Optional<PodCast> filterbycelebrity = masterpodcastlist.stream().
                filter(p->p.getCelebrity_name().equalsIgnoreCase(celebrity_name))
                .findAny();

        if(filterbycelebrity.isPresent())
        {
            searchsortbycelebrityname = masterpodcastlist.stream().
                    filter(p->p.getCelebrity_name().equalsIgnoreCase(celebrity_name)).
                    sorted(Comparator.comparing(PodCast::getPodcasttype_name)).collect(Collectors.toList());
        }
        return searchsortbycelebrityname;
    }

    public List<PodCast> searchSortByEpisodeReleaseDate(List<PodCast> masterpodcastlist, Date episode_release_date)
    {
        List<PodCast> searchsortbyepisodereleasedate = new ArrayList<PodCast>();

        Optional<PodCast> filterbydate = masterpodcastlist.stream().filter(p->p.getEpisode_release_date().
                equals(episode_release_date)).findAny();

        if (filterbydate.isPresent())
        {
            searchsortbyepisodereleasedate = masterpodcastlist.stream().filter(p->p.getEpisode_release_date().
                    equals(episode_release_date)).sorted(Comparator.comparing(PodCast::getPodcasttype_name)).
                    collect(Collectors.toList());
        }
        return searchsortbyepisodereleasedate;
    }

    public void display(List<PodCast> displaybyparticularlist)
    {
        Consumer<PodCast> display = d->System.out.println(d);
        displaybyparticularlist.stream().forEach(display);
    }
}
