/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chk.plugins;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * 
 * Si queremos que un metodo sea llamado en cada modificacion de un JTextBox,
 * por alguna razon no basta con usar actionPerformed, ya que ese solo es 
 * llamado al presionar Enter para "completar" el textBox. Si queremos actualizar
 * dinamicamente en cada "keystroke", tenemos que extender DocumentListener, pero
 * NetBeans no deja hacerlo en la pestaña de Events del GUI Builder.
 * 
 * Debido a esto, tenemos que hacer una clase con la funcion update y modificar el codigo
 * de creacion del JTextBox en el GUIBuilder para que le asigne el SimpleDocumentListener
 * al JTextBox.document post creacion.
 *
 * @author chkp
 */
@FunctionalInterface
public interface SimpleDocumentListener extends DocumentListener {
    void update(DocumentEvent e);

    @Override
    default void insertUpdate(DocumentEvent e) {
        update(e);
    }
    @Override
    default void removeUpdate(DocumentEvent e) {
        update(e);
    }
    @Override
    default void changedUpdate(DocumentEvent e) {
        update(e);
    }
}
