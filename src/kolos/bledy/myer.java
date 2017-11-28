package kolos.bledy;

public class myer extends Exception {
    String text;

    public myer(String text) {
        super(text);
        this.text = text;
    }
}
