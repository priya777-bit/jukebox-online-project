import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SongFilterSortOperation
{
    public List<Song> searchSortByArtist(List<Song> mastersonglist, String artist_name)
    {
        List<Song> searchsortbyartist = new ArrayList<Song>();

        Optional filterbyartist = mastersonglist.stream()
                .filter(p->p.getArtist_name().equalsIgnoreCase(artist_name))
                .sorted(Comparator.comparing(Song::getSong_name)).findAny();

        if(filterbyartist.isPresent())
        {
            searchsortbyartist = mastersonglist.stream()
                    .filter(p->p.getArtist_name().equalsIgnoreCase(artist_name))
                    .sorted(Comparator.comparing(Song::getSong_name)).collect(Collectors.toList());
        }
        return searchsortbyartist;
    }

    public List<Song> searchSortByAlbum(List<Song> mastersonglist , String album_name)
    {
        List<Song> searchsortbyalbum = new ArrayList<Song>();

        Optional filterbyalbum = mastersonglist.stream()
                .filter(p->p.getAlbum_name().equalsIgnoreCase(album_name))
                .sorted(Comparator.comparing(Song::getSong_name)).findAny();

        if(filterbyalbum.isPresent())
        {
            searchsortbyalbum = mastersonglist.stream()
                    .filter(p->p.getAlbum_name().equalsIgnoreCase(album_name))
                    .sorted(Comparator.comparing(Song::getSong_name)).collect(Collectors.toList());
        }
        return searchsortbyalbum;
    }

    public List<Song> searchSortBySong(List<Song> mastersonglist , String song_name)
    {
        List<Song> searchsortbysong = new ArrayList<Song>();

        Optional filterbysong = mastersonglist.stream()
                .filter(p->p.getSong_name().equalsIgnoreCase(song_name))
                .sorted(Comparator.comparing(Song::getSong_name)).findAny();

        if(filterbysong.isPresent())
        {
            searchsortbysong = mastersonglist.stream()
                    .filter(p->p.getSong_name().equalsIgnoreCase(song_name))
                    .sorted(Comparator.comparing(Song::getSong_name)).collect(Collectors.toList());
        }
        return searchsortbysong;
    }

    public List<Song> searchSortByGenre(List<Song> mastersonglist , String genre_name)
    {
        List<Song> searchsortbygenre = new ArrayList<Song>();

        Optional filterbygenre = mastersonglist.stream()
                .filter(p->p.getGenre_name().equalsIgnoreCase(genre_name))
                .sorted(Comparator.comparing(Song::getSong_name)).findAny();

        if(filterbygenre.isPresent())
        {
            searchsortbygenre = mastersonglist.stream()
                    .filter(p->p.getGenre_name().equalsIgnoreCase(genre_name))
                    .sorted(Comparator.comparing(Song::getSong_name)).collect(Collectors.toList());
        }
        return searchsortbygenre;
    }

    public void display(List<Song> displaybyparticularlist)
    {
        Consumer<Song> display = d->System.out.println(d);
        displaybyparticularlist.stream().forEach(display);
    }
}
