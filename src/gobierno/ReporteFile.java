/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gobierno;

import chk.plugins.MessageBox;
import java.awt.Component;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author chk
 */
public class ReporteFile {

    public boolean reportar(Component parent) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
                StringBuilder sb = new StringBuilder();

                Reparticiones.get().imprimir(sb);
                Trabajadores.get().imprimir(sb);
                Contratos.get().imprimir(sb);

                String report = sb.toString();
                File file = fileChooser.getSelectedFile();
                try ( FileWriter writer = new FileWriter(file)) {
                    writer.write(report);
                    MessageBox.infoBox("Archivo '" + fileChooser.getName(file) + "' guardado con exito", "Generar Reporte");
                }
            }
        } catch (IOException e) {
            MessageBox.errorBox(e.getLocalizedMessage(), "IOException");
            return (false);
        }

        return (true);
    }
}
