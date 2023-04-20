import java.io.File;
import java.io.IOException;

abstract public class Parser {
    int keyNumber;

    public void printKeyNumber() {
        System.out.println(keyNumber);
    }
    abstract void countKeys(File file) throws IOException;

}
