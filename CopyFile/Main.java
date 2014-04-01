package name.sundrop.io;

import java.io.*;

public class Main {

    public static void copyFile(String src, String dest) throws IOException {
        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(dest);
        ) {
            byte[] buf = new byte[1024]; // 1 KB
            int r;
            do {
                r = in.read(buf, 0, buf.length);
                if (r > 0) {
                    out.write(buf, 0, r);
                }
            } while (r > 0);
        }
    }

    public static String getFilename(String sInputFilename) {
        File file = new File(sInputFilename);
        return file.getName();
    }

    public static void main(String[] args) {
        String sInputFilename;
        String sOutDir;

        sInputFilename = "I:/Users/10/sundrop/1/m.zip";
        sOutDir = "I:/Users/10/sundrop/2/";

        System.out.println("Copy " + getFilename(sInputFilename) + " to " + sOutDir);

        try {
            copyFile(sInputFilename, sOutDir + "/" + getFilename(sInputFilename));
            System.out.println("Done.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
