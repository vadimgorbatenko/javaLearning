package chapter3;

import model.Album;
import model.Artist;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiLearning {
    // Q1
    public static int addUp(Stream<Integer> numbers) {
        return numbers == null
                ? 0
                : numbers.reduce(0, Integer::sum);
    }

    // Q1
    public static List<String> getNamesAndNationalities(List<Artist> artists) {
        return artists == null
                ? Collections.emptyList()
                : artists.stream()
                .flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
                .collect(Collectors.toList());
    }

    // Q1
    public static List<Album> getAlbumsWithLessThanFourSongs(List<Album> albums) {
        return albums == null
                ? Collections.emptyList()
                : albums.stream()
                .filter(album -> album.getTracks().count() < 4)
                .collect(Collectors.toList());
    }

    //Q2
    public static long countBandMembersInternal(List<Artist> artists) {
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

    // Q7
    public static long countLowerCase(String string) {
        return string == null
                ? 0
                : string.chars()
                .filter(Character::isLowerCase)
                .count();
    }

    // Q8
    public static Optional<String> mostLowercaseString(List<String> strings) {
        return strings == null
                ? Optional.empty()
                : strings.stream()
                .max(Comparator.comparingLong(StreamApiLearning::countLowerCase));
    }
}
