package ahodanenok.algs4.ch_1_3;

/**
 * Book, exercise 1.3.44
 */
public class TextBuffer {

    private final Stack<Character> left;
    private final Stack<Character> right;

    private int position;
    private int size;

    public TextBuffer() {
        this(null);
    }

    public TextBuffer(String str) {
        this.left = new Stack<>();
        this.right = new Stack<>();

        if (str != null) {
            for (char ch : str.toCharArray()) {
                left.push(ch);
            }

            position = str.length();
            size = str.length();
        }
    }

    public void left(int offset) {
        int remainingOffset = offset;
        while (left.size() > 0 && remainingOffset > 0) {
            right.push(left.pop());
            remainingOffset--;
            position--;
        }
    }

    public void right(int offset) {
        int remainingOffset = offset;
        while (right.size() > 0 && remainingOffset > 0) {
            left.push(right.pop());
            remainingOffset--;
            position++;
        }
    }

    public void insert(char ch) {
        left.push(ch);
        position++;
        size++;
    }

    public char delete() {
        if (right.size() == 0) {
            return '\0';
        }

        size--;

        return right.pop();
    }

    public String content() {
        StringBuilder sb = new StringBuilder();

        for (char ch : left) {
            sb.insert(0, ch);
        }

        for (char ch : right) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public int position() {
        return position;
    }

    public int size() {
        return size;
    }
}
