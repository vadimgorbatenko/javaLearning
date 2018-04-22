package chapter3;

import data.SampleData;
import model.Album;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static data.SampleData.aLoveSupreme;
import static data.SampleData.manyTrackAlbum;
import static data.SampleData.sampleShortAlbum;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class StreamApiLearningTest {
    @Test
    public void addUpTest() {
        assertEquals(1, StreamApiLearning.addUp(Stream.of(1)));
        assertEquals(10, StreamApiLearning.addUp(Stream.of(1, 2, 3, 4)));
        assertEquals(4, StreamApiLearning.addUp(Stream.of(-1, -2, 3, 4)));
        assertEquals(0, StreamApiLearning.addUp(Stream.of()));
        assertEquals(0, StreamApiLearning.addUp(null));
    }

    @Test
    public void getNamesAndNationalitiesTest() {
        assertEquals(Collections.emptyList(), StreamApiLearning.getNamesAndNationalities(null));
        assertEquals(Collections.emptyList(), Collections.emptyList());

        List<String> namesAndOrigins = StreamApiLearning.getNamesAndNationalities(SampleData.getThreeArtists());
        assertEquals(asList("John Coltrane", "US", "John Lennon", "UK", "The Beatles", "UK"), namesAndOrigins);
    }

    @Test
    public void findsShortAlbums() {
        assertEquals(Collections.emptyList(), StreamApiLearning.getAlbumsWithLessThanFourSongs(null));
        assertEquals(Collections.emptyList(), StreamApiLearning.getAlbumsWithLessThanFourSongs(Collections.emptyList()));

        List<Album> input = asList(manyTrackAlbum, sampleShortAlbum, aLoveSupreme);
        List<Album> result = StreamApiLearning.getAlbumsWithLessThanFourSongs(input);
        assertEquals(asList(sampleShortAlbum, aLoveSupreme), result);
    }
}
