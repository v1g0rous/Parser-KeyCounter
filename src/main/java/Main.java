import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = FileReader.readPath();
        FileReader.Format format = FileReader.detectFormat(path);

        if (format != null) {
            File file = FileReader.getFile(path);
            switch (format) {
                case XML -> new XmlParser().countKeys(file);
                case JSON -> new JsonParser().countKeys(file);
                case PROTO -> new ProtobufParser().countKeys(file);
            }
        }

    }

}
