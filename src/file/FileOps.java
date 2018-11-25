package file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class FileOps {

    String str = "";

    public static void writeTo(String list) throws IOException {
        File f = new File("myData.txt");
        FileWriter fw = new FileWriter(f, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.write(list + " ");
        bw.flush();
        bw.close();
    }

    public static String readFrom() throws FileNotFoundException, IOException {
        String str = "";
        File f = new File("myData.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            str += br.readLine()+" \n";
        }
        return str;
    }

    static String st;
    static int occ;

    public static int countForLine() throws FileNotFoundException, IOException {
        InputStream is = new BufferedInputStream(new FileInputStream("myData.txt"));
        try {
            byte[] c = new byte[1024];
            int readChars = is.read(c);
            if (readChars == -1) {
                // bail out if nothing to read
                return 0;
            }
            // make it easy for the optimizer to tune this loop
            int count = 0;
            while (readChars == 1024) {
                for (int i = 0; i < 1024;) {
                    if (c[i++] == '\n') {
                        ++count;
                    }
                }
                readChars = is.read(c);
            }
            // count remaining characters
            while (readChars != -1) {
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
                readChars = is.read(c);
            }
            return count == 0 ? 1 : count;
        } finally {
            is.close();
        }
    }
}
