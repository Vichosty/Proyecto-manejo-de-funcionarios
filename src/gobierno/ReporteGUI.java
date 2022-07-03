/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gobierno;

import chk.forms.ReporteEditorForm;
import java.awt.Component;
import java.awt.Frame;

/**
 *
 * @author chk
 */
public class ReporteGUI {

    public boolean reportar(Component parent) {
        StringBuilder sb = new StringBuilder();

        Reparticiones.get().imprimir(sb);
        Trabajadores.get().imprimir(sb);
        Contratos.get().imprimir(sb);

        String report = sb.toString();
        ReporteEditorForm ref = new ReporteEditorForm((Frame) parent, true, report);
        ref.setVisible(true);

        return (true);
    }
}
