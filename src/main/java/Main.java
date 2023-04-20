import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = FileReader.readPath();
        FileReader.Format format = FileReader.detectFormat(path);

        if (format != null) {
            String input = FileReader.readFile(path);
            switch (format) {
                case XML -> new XmlParser().countKeys(input);
                case JSON -> new JsonParser().countKeys(input);
                case PROTO -> new ProtobufParser().countKeys(input);
            }
        }

    }

}
