
abstract public class Parser {
    int keyNumber;

    public void printKeyNumber() {
        System.out.println(keyNumber);
    }
    abstract String countKeys(String input);

}
