public class ErreurException  extends Exception {

    public ErreurException() {
        super("Opération impossible.");
    }

    public ErreurException(String message) {
        super(message);
    }
}