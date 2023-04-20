import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static final String PATH_CANNOT_BE_NULL = "Path cannot be null";
    public static final String PATH_MISSING_EXTENSION = "Path does not have an extension";
    public static final String UNKNOWN_FILE_EXTENSION = "Unknown file extension";
    public static final String ENTER_FILE_PATH = "Enter path to the file to count its keys, (e.g. .\\test.txt):";

    public static String readPath() {
        System.out.println(ENTER_FILE_PATH);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    enum Format {
        XML,
        JSON,
        PROTO
    }

    public static String readFile(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        if (path == null) {
            throw new IllegalArgumentException(PATH_CANNOT_BE_NULL);
        }

        try {
            List<String> lines = Files.readAllLines(Path.of(path));
            for (String line : lines) {
                content.append(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    public static Format detectFormat(String path) {

        if (path == null) {
            throw new IllegalArgumentException(PATH_CANNOT_BE_NULL);
        }

        int lastDotIndex = path.lastIndexOf(".");

        if (lastDotIndex == -1) {
            throw new IllegalArgumentException(PATH_MISSING_EXTENSION);
        }

        try {
            String extension = path.substring(lastDotIndex + 1);
            return Format.valueOf(extension.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(UNKNOWN_FILE_EXTENSION);
        }
    }

}
