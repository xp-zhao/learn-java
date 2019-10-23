package core.file.path;

import java.io.File;
import java.io.IOException;

/**
 * File Path in Java
 *
 * @author ch113
 */
public class FilePath {
    public static void main(String[] args) throws IOException {
        File file = new File("filePath.txt");
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
    }
}
