package chapter3;

import data.SampleData;
import model.Album;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static chapter3.StreamApiLearning.addUp;
import static chapter3.StreamApiLearning.countLowerCase;
import static chapter3.StreamApiLearning.getAlbumsWithLessThanFourSongs;
import static chapter3.StreamApiLearning.getNamesAndNationalities;
import static chapter3.StreamApiLearning.mostLowercaseString;
import static data.SampleData.aLoveSupreme;
import static data.SampleData.manyTrackAlbum;
import static data.SampleData.sampleShortAlbum;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class StreamApiLearningTest {
    @Test
    public void addUpTest() {
        assertEquals(1, addUp(Stream.of(1)));
        assertEquals(10, addUp(Stream.of(1, 2, 3, 4)));
        assertEquals(4, addUp(Stream.of(-1, -2, 3, 4)));
        assertEquals(0, addUp(Stream.of()));
        assertEquals(0, addUp(null));
    }

    @Test
    public void getNamesAndNationalitiesTest() {
        assertEquals(Collections.emptyList(), getNamesAndNationalities(null));
        assertEquals(Collections.emptyList(), Collections.emptyList());

        List<String> namesAndOrigins = getNamesAndNationalities(SampleData.getThreeArtists());
        assertEquals(asList("John Coltrane", "US", "John Lennon", "UK", "The Beatles", "UK"), namesAndOrigins);
    }

    @Test
    public void findsShortAlbums() {
        assertEquals(Collections.emptyList(), getAlbumsWithLessThanFourSongs(null));
        assertEquals(Collections.emptyList(), getAlbumsWithLessThanFourSongs(Collections.emptyList()));

        List<Album> input = asList(manyTrackAlbum, sampleShortAlbum, aLoveSupreme);
        List<Album> result = getAlbumsWithLessThanFourSongs(input);
        assertEquals(asList(sampleShortAlbum, aLoveSupreme), result);
    }

    @Test
    public void noLowercaseLettersInAnEmptyString() {
        assertEquals(0, countLowerCase(""));
    }

    @Test
    public void countsLowercaseLetterExample() {
        assertEquals(3, countLowerCase("aBcDeF"));
    }

    @Test
    public void suppoertsNoLowercaseLetters() {
        assertEquals(0, countLowerCase("ABCDEF"));
    }

    @Test
    public void noStringReturnedForEmptyList() {
        assertFalse(mostLowercaseString(Collections.emptyList()).isPresent());
    }

    @Test
    public void findsMostLowercaseString() {
        Optional<String> result = mostLowercaseString(asList("a", "abc", "ABCde"));
        assertEquals(Optional.of("abc"), result);
    }
}
