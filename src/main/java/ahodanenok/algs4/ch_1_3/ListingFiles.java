package ahodanenok.algs4.ch_1_3;

import edu.princeton.cs.algs4.Queue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Book, exercise 1.3.43
 */
public class ListingFiles {

    public static void main(String[] args) throws Exception {
        print(new File(args[0]), System.out);
    }

    public static void print(File dir, Appendable out) throws Exception {
        if (!dir.exists()) {
            throw new FileNotFoundException(String.format("Directory '%s' not found", dir.getAbsolutePath()));
        }

        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(String.format("File '%s' is not a directory", dir.getAbsolutePath()));
        }

        Queue<File> queue = new Queue<>();
        queue.enqueue(dir);

        while (!queue.isEmpty()) {
            File currentFile = queue.dequeue();
            if (currentFile.isFile()) {
                out.append(currentFile.getAbsolutePath()).append(System.lineSeparator());
            } else {
                File[] childFiles = currentFile.listFiles();
                if (childFiles != null) {
                    Arrays.sort(childFiles, Comparator.comparing(File::getName));
                    for (File childFile : childFiles) {
                        queue.enqueue(childFile);
                    }
                }
            }
        }
    }
}
