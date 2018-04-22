package chapter3;

import model.Album;
import model.Artist;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiLearning {
    public static int addUp(Stream<Integer> numbers) {
        return numbers == null
                ? 0
                : numbers.reduce(0, Integer::sum);
    }

    public static List<String> getNamesAndNationalities(List<Artist> artists) {
        return artists == null
                ? Collections.emptyList()
                : artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(Collectors.toList());
    }

    public static List<Album> getAlbumsWithLessThanFourSongs(List<Album> albums) {
        return albums == null
                ? Collections.emptyList()
                : albums.stream()
                .filter(album -> album.getTracks().count() < 4)
                .collect(Collectors.toList());
    }

    public static long countBandMembersInternal(List<Artist> artists){
//        rewrite it
//        int totalMembers = 0;
//        for (Artist artist : artists) {
//            Stream<Artist> members = artist.getMembers();
//            totalMembers +=members.count();
//        }
//        return totalMembers;

        return artists == null
                ? 0
                : artists.stream()
                .flatMap(Artist::getMembers)
                .count();
    }
}
