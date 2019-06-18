package paypay.sechallenge.source;

/*
 * Thrown by methods in the class ImmutableStack to 
 * indicate that the stack is empty.
 */
public class NoSuchElementException extends RuntimeException {
    /*
     * Constructs a new NoSuchElementException without error
     * message string.
     */
    public NoSuchElementException() {
        super();
    }

    /*
     * Constructs a new NoSuchElementException, saving a reference 
     * to an error message string for later retrieval by the 
     * getMessage method.
     *
     * @param s the error message string.
     */
    public NoSuchElementException(String s) {
        super(s);
    }
}
