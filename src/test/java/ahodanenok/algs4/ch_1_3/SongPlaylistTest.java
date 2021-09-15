package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SongPlaylistTest {

    @Test
    public void testEmpty() {
        SongPlaylist playlist = new SongPlaylist();
        assertNull(playlist.play());
        assertDoesNotThrow(playlist::skip);
        assertNull(playlist.play());
        assertDoesNotThrow(playlist::back);
        assertNull(playlist.play());
    }

    @Test
    public void testSingleSong() {
        SongPlaylist playlist = new SongPlaylist();
        playlist.enqueue("a");

        assertEquals("a", playlist.play());
        assertDoesNotThrow(playlist::skip);
        assertEquals("a", playlist.play());
        assertDoesNotThrow(playlist::back);
        assertEquals("a", playlist.play());
    }

    @Test
    public void testMultipleSongs() {
        SongPlaylist playlist = new SongPlaylist();
        playlist.enqueue("a");
        playlist.enqueue("b");
        playlist.enqueue("c");

        assertEquals("a", playlist.play());
        assertDoesNotThrow(playlist::skip);
        assertEquals("b", playlist.play());
        assertDoesNotThrow(playlist::back);
        assertEquals("a", playlist.play());
        assertDoesNotThrow(playlist::back);
        assertEquals("a", playlist.play());
        assertDoesNotThrow(playlist::skip);
        assertEquals("b", playlist.play());
        assertDoesNotThrow(playlist::skip);
        assertEquals("c", playlist.play());
        assertDoesNotThrow(playlist::skip);
        assertEquals("c", playlist.play());
    }
}
