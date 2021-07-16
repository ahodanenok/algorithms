package ahodanenok.algs4.ch_1_1;

import java.io.*;
import java.net.URL;

/**
 * Web, exercise 1.1.2
 * https://algs4.cs.princeton.edu/11model/
 */
public class Wget {

    public static void main(String[] args) throws Exception {
        URL url = new URL(args[0]);
        String fileName = new File(url.getPath()).getName();
        try (InputStream in = url.openStream();
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName))) {

            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        }
    }
}
