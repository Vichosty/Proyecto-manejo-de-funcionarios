package chk.forms;

/**
 *
 * Excepcion para cuando se busca una reparticion y no se encuentra.
 * 
 * @author chk
 */
public class ReparticionNotFoundException extends Exception {

    /**
     * Creates a new instance of <code>ReparticionNotFoundException</code>
     * without detail message.
     */
    public ReparticionNotFoundException() {
        super("Reparticion no encontrada");
    }

    /**
     * Constructs an instance of <code>ReparticionNotFoundException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ReparticionNotFoundException(String msg) {
        super(msg);
    }
}
