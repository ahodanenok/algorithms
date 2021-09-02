package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

public class TailTest {

    @Test
    public void testEmptyFile() {
        executeWithFile(in -> assertEquals("", Tail.read(in, 10)), "");
    }

    @Test
    public void testLessLines() {
        String content = String.format("a%nb%nc");
        executeWithFile(in -> assertEquals(content, Tail.read(in, 5)), content);
    }

    @Test
    public void testEqualLines() {
        String content = String.format("a%nb%nc%nd");
        executeWithFile(in -> assertEquals(content, Tail.read(in, 4)), content);
    }

    @Test
    public void testMoreLines() {
        String content = String.format("a%nb%nc%nd%ne");
        executeWithFile(in -> assertEquals(String.format("c%nd%ne"), Tail.read(in, 3)), content);
    }

    private void executeWithFile(Consumer<InputStream> test, String content) {
        File file = new File(System.getProperty("java.io.tmpdir"), "TailTest_" + System.currentTimeMillis());
        try {
            assertTrue(file.createNewFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream in = new FileInputStream(file)){
            test.accept(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            file.delete();
        }
    }
}
