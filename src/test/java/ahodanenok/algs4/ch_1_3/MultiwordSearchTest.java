package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class MultiwordSearchTest {

    @Test
    public void testEmptyDocumentWords() {
        assertNull(MultiwordSearch.search(Collections.emptyList(), Arrays.asList("a", "b", "c")));
    }

    @Test
    public void testEmptySearchWords() {
        assertNull(MultiwordSearch.search(Arrays.asList("a", "b", "c"), Collections.emptyList()));
    }

    @Test
    public void testSearchSingleWordStart() {
        MultiwordSearch.Interval interval = MultiwordSearch.search(Arrays.asList("a", "b", "c"), Collections.singletonList("a"));
        assertNotNull(interval);
        assertEquals(interval.from, 0);
        assertEquals(interval.to, 0);
    }

    @Test
    public void testSearchSingleWordMiddle() {
        MultiwordSearch.Interval interval = MultiwordSearch.search(Arrays.asList("a", "b", "c"), Collections.singletonList("b"));
        assertNotNull(interval);
        assertEquals(interval.from, 1);
        assertEquals(interval.to, 1);
    }

    @Test
    public void testSearchSingleWordEnd() {
        MultiwordSearch.Interval interval = MultiwordSearch.search(Arrays.asList("a", "b", "c"), Collections.singletonList("c"));
        assertNotNull(interval);
        assertEquals(interval.from, 2);
        assertEquals(interval.to, 2);
    }

    @Test
    public void testSearchTwoWordsNotFoundFirst() {
        assertNull(MultiwordSearch.search(Arrays.asList("a", "c", "b", "e"), Arrays.asList("a", "f")));
    }

    @Test
    public void testSearchTwoWordsNotFoundSecond() {
        assertNull(MultiwordSearch.search(Arrays.asList("a", "c", "b", "e"), Arrays.asList("f", "b")));
    }

    @Test
    public void testSearchTwoWordsStart() {
        MultiwordSearch.Interval interval = MultiwordSearch.search(Arrays.asList("a", "b", "c", "d", "e"), Arrays.asList("a", "b"));
        assertNotNull(interval);
        assertEquals(interval.from, 0);
        assertEquals(interval.to, 1);
    }

    @Test
    public void testSearchTwoWordsStartMiddle() {
        MultiwordSearch.Interval interval = MultiwordSearch.search(Arrays.asList("a", "b", "c", "d", "e"), Arrays.asList("a", "c"));
        assertNotNull(interval);
        assertEquals(interval.from, 0);
        assertEquals(interval.to, 2);
    }

    @Test
    public void testSearchTwoWordsStartEnd() {
        MultiwordSearch.Interval interval = MultiwordSearch.search(Arrays.asList("a", "b", "c", "d", "e"), Arrays.asList("a", "e"));
        assertNotNull(interval);
        assertEquals(interval.from, 0);
        assertEquals(interval.to, 4);
    }

    @Test
    public void testSearchTwoWordsMiddle() {
        MultiwordSearch.Interval interval = MultiwordSearch.search(Arrays.asList("a", "b", "c", "d", "e"), Arrays.asList("b", "d"));
        assertNotNull(interval);
        assertEquals(interval.from, 1);
        assertEquals(interval.to, 3);
    }

    @Test
    public void testSearchTwoWordsMiddleEnd() {
        MultiwordSearch.Interval interval = MultiwordSearch.search(Arrays.asList("a", "b", "c", "d", "e"), Arrays.asList("c", "e"));
        assertNotNull(interval);
        assertEquals(interval.from, 2);
        assertEquals(interval.to, 4);
    }

    @Test
    public void testSearchTwoWordsMultipleIntervalsFirstShorter() {
        MultiwordSearch.Interval interval = MultiwordSearch.search(Arrays.asList("a", "b", "c", "a", "d", "e", "c", "f"), Arrays.asList("a", "c"));
        assertNotNull(interval);
        assertEquals(interval.from, 0);
        assertEquals(interval.to, 2);
    }

    @Test
    public void testSearchTwoWordsMultipleIntervalsSecondShorter() {
        MultiwordSearch.Interval interval = MultiwordSearch.search(Arrays.asList("a", "b", "b", "b", "c", "a", "d", "e", "c", "f"), Arrays.asList("a", "c"));
        assertNotNull(interval);
        assertEquals(interval.from, 5);
        assertEquals(interval.to, 8);
    }

    @Test
    public void testSearchTwoWordsMultipleIntervalsOverlapping() {
        MultiwordSearch.Interval interval = MultiwordSearch.search(Arrays.asList("a", "b", "a", "c", "c", "d", "c", "f"), Arrays.asList("a", "c"));
        assertNotNull(interval);
        assertEquals(interval.from, 2);
        assertEquals(interval.to, 3);
    }
}
