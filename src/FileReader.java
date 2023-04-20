import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static String readPath() {
        System.out.println("Enter path to the file to count its keys: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    enum Format {
        XML,
        JSON,
        PROTOBUFFER
    }

    public static String readFile() throws IOException {
        try {
            StringBuilder content = new StringBuilder();
            String path = ".\\test.txt";

            List<String> lines = Files.readAllLines(Path.of(path));
            for (String line : lines) {
                content.append(line);
            }

            return content.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Format detectFormat(String path) {
        try {
            String format = "";

            if (path != null) {
                int lastDotIndex = path.lastIndexOf(".");
                format = path.substring(lastDotIndex + 1);
            }

            return Format.valueOf(format.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }


}
