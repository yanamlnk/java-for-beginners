package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Workshop.outputResults(factory.createObject(args));
    }
}
