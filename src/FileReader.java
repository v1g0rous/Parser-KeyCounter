import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

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

    public static Format detectFormat(String input) {
        Format format = null;
        // blabla определяем input здесь
        // если XML, inputFormat = XML
        // если JSON, inputFormat = JSON
        // если PROTOBUFFER = PROTOBUFFER

        return format;
    }


}
