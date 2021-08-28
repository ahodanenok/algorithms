package ahodanenok.algs4.ch_1_3;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ListingFilesTest.TestDirectoryExtension.class)
public class ListingFilesTest {

    @Test
    public void testNotExistingDirectory() {
        File file = new File("testNotExistingDirectory");
        Assumptions.assumeFalse(file.exists()); // really :)
        FileNotFoundException e = assertThrows(FileNotFoundException.class, () -> ListingFiles.print(file, null));
        assertEquals("Directory '" + file.getAbsolutePath() + "' not found", e.getMessage());
    }

    @Test
    public void testNotDirectory(File dir) throws Exception {
        File a = new File(dir, "a.txt");
        assertTrue(a.createNewFile());

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> ListingFiles.print(a, null));
        assertEquals("File '" + a.getAbsolutePath() + "' is not a directory", e.getMessage());
    }

    @Test
    public void testEmptyDirectory(File dir) throws Exception {
        StringWriter out = new StringWriter();
        ListingFiles.print(dir, out);
        assertEquals("", out.toString());
    }

    @Test
    public void testOnlyFiles(File dir) throws Exception {
        File a = new File(dir, "a.txt");
        assertTrue(a.createNewFile());

        File b = new File(dir, "b.txt");
        assertTrue(b.createNewFile());

        StringWriter sw = new StringWriter();
        ListingFiles.print(dir, sw);
        assertEquals(String.format("%s%n%s%n", a.getAbsolutePath(), b.getAbsolutePath()), sw.toString());
    }

    @Test
    public void testOnlyDirectories(File dir) throws Exception {
        File d1 = new File(dir, "dir1");
        assertTrue(d1.mkdir());

        File d2 = new File(dir, "dir2");
        assertTrue(d2.mkdir());

        File d3 = new File(dir, "dir3");
        assertTrue(d3.mkdir());

        StringWriter sw = new StringWriter();
        ListingFiles.print(dir, sw);
        assertEquals("", sw.toString());
    }

    @Test
    public void testNestedFiles(File dir) throws Exception {
        // dir2
        File d2 = new File(dir, "dir2");
        assertTrue(d2.mkdir());
        // dir2/b.txt
        File b = new File(d2, "b.txt");
        assertTrue(b.createNewFile());
        // dir2/a.txt
        File a = new File(d2, "a.txt");
        assertTrue(a.createNewFile());

        // dir1
        File d1 = new File(dir, "dir1");
        assertTrue(d1.mkdir());
        // dir1/e.txt
        File e = new File(d1, "e.txt");
        assertTrue(e.createNewFile());
        // dir1/c.txt
        File c = new File(d1, "c.txt");
        assertTrue(c.createNewFile());
        // dir1/d.txt
        File d = new File(d1, "d.txt");
        assertTrue(d.createNewFile());
        // dir1/dir1_1
        File d1_1 = new File(d1, "dir1_1");
        assertTrue(d1_1.mkdir());
        // dir1/dir1_1/k.txt
        File k = new File(d1_1, "k.txt");
        assertTrue(k.createNewFile());
        // dir1/dir1_1/g.txt
        File g = new File(d1_1, "g.txt");
        assertTrue(g.createNewFile());
        // dir1/dir1_2
        File d1_2 = new File(d1, "dir1_2");
        assertTrue(d1_2.mkdir());
        // dir1/dir1_2/f.txt
        File f = new File(d1_2, "f.txt");
        assertTrue(f.createNewFile());

        StringWriter sw = new StringWriter();
        ListingFiles.print(dir, sw);
        assertEquals(
            c.getAbsolutePath() + System.lineSeparator()
                + d.getAbsolutePath() + System.lineSeparator()
                + e.getAbsolutePath() + System.lineSeparator()
                + a.getAbsolutePath() + System.lineSeparator()
                + b.getAbsolutePath() + System.lineSeparator()
                + g.getAbsolutePath() + System.lineSeparator()
                + k.getAbsolutePath() + System.lineSeparator()
                + f.getAbsolutePath() + System.lineSeparator(),
            sw.toString()
        );
    }

    static class TestDirectoryExtension implements ParameterResolver, AfterEachCallback {

        private static final ExtensionContext.Namespace NS =
            ExtensionContext.Namespace.create(TestDirectoryExtension.class.getName());

        @Override
        public void afterEach(ExtensionContext context) throws Exception {
            File dir = context.getStore(NS).remove(getKeyInStore(context), File.class);
            if (dir == null) {
                return;
            }

            Files.walkFileTree(Paths.get(dir.getAbsolutePath()), new SimpleFileVisitor<Path>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        }

        @Override
        public boolean supportsParameter(
                ParameterContext parameterContext, ExtensionContext extensionContext)
                throws ParameterResolutionException {

            return parameterContext.getParameter().getType() == File.class;
        }

        @Override
        public Object resolveParameter(
                ParameterContext parameterContext, ExtensionContext extensionContext)
                throws ParameterResolutionException {

            File tmpDir = new File(System.getProperty("java.io.tmpdir"));
            if (!tmpDir.exists()) {
                throw new ParameterResolutionException(
                        String.format("Temp directory '%s' doesn't exist", tmpDir.getAbsolutePath()));
            }

            File dir = new File(tmpDir, this.getClass().getSimpleName() + "_" + System.currentTimeMillis());
            if (dir.exists()) {
                throw new ParameterResolutionException(
                        String.format("Directory '%s' already exists", dir.getAbsolutePath()));
            }

            boolean created = dir.mkdir();
            if (!created) {
                throw new ParameterResolutionException(
                        String.format("Can't create directory '%s'", dir.getAbsolutePath()));
            }

            extensionContext.getStore(NS).put(getKeyInStore(extensionContext), dir);

            return dir;
        }

        private String getKeyInStore(ExtensionContext context) {
            return context.getUniqueId() + "_testDir";
        }
    }
}
