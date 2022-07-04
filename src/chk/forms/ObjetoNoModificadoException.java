package chk.forms;

/**
 *
 * Excepcion para cuando se edita un objeto en su formulario, pero no se realiza
 * ningun cambio.
 * 
 * Util para evitar innecesariamente reemplazar un objeto con uno igual.
 * 
 * @author chk
 */
public class ObjetoNoModificadoException extends Exception {

    /**
     * Creates a new instance of <code>ReparticionNotFoundException</code>
     * without detail message.
     */
    public ObjetoNoModificadoException() {
        super("El objeto no fue modificado");
    }

    /**
     * Constructs an instance of <code>ObjetoNoModificadoException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ObjetoNoModificadoException(String msg) {
        super(msg);
    }
}
