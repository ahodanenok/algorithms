package ahodanenok.algs4.ch_1_3;

/**
 * Web, exercise 1.3.26
 * https://algs4.cs.princeton.edu/13stacks/
 */
public class SongPlaylist {

    private DoubleNode<String> firstSong;
    private DoubleNode<String> lastSong;
    private DoubleNode<String> currentSong;

    public void enqueue(String song) {
        lastSong = DoubleLinkedListMethods.insertAfter(lastSong, song);
        if (firstSong == null) {
            firstSong = lastSong;
        }
    }

    public String play() {
        if (currentSong == null) {
            currentSong = firstSong;
        }

        if (currentSong == null) {
            return null;
        }

        return currentSong.value;
    }

    public void skip() {
        if (currentSong == null) {
            currentSong = firstSong;
        }

        if (currentSong != null && currentSong.next != null) {
            currentSong = currentSong.next;
        }
    }

    public void back() {
        if (currentSong == null) {
            currentSong = firstSong;
        }

        if (currentSong != null && currentSong.prev != null) {
            currentSong = currentSong.prev;
        }
    }
}
