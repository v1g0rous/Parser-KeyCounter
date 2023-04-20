import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = FileReader.readFile();
        FileReader.Format format = FileReader.detectFormat(input);

        switch (format) {
            case XML -> new XmlParser().countKeys(input);
            case JSON -> new JsonParser().countKeys(input);
            case PROTOBUFFER -> new ProtobufParser().countKeys(input);
        }
    }

}
