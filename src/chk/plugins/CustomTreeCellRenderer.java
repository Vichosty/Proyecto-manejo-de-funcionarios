/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chk.plugins;

import java.awt.Component;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * Esta clase se encarga de mostrar nuestras distintas clases cuando son
 * agregadas a un JTree.
 *
 * Esta clase es necesaria, ya que por defecto Java no es capaz de recibir un
 * Object en el modelo del JTree y automaticamente mostrar un icono distinto
 * basado en la clase del Object.
 *
 * @author chkp
 */
public class CustomTreeCellRenderer extends DefaultTreeCellRenderer {

    private final ImageIcon reparticionIcon;
    private final ImageIcon trabajadorIcon;
    private final ImageIcon trabajadorPermanenteIcon;
    private final ImageIcon contratoIcon;

    public CustomTreeCellRenderer() {
        super();

        reparticionIcon = new ImageIcon(new ImageIcon(gobierno.Reparticion.getIconPath()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        trabajadorIcon = new ImageIcon(new ImageIcon(gobierno.Trabajador.getIconPath()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        trabajadorPermanenteIcon = new ImageIcon(new ImageIcon(gobierno.TrabajadorPermanente.getIconPath()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        contratoIcon = new ImageIcon(new ImageIcon(gobierno.Contrato.getIconPath()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
            boolean leaf, int row, boolean hasFocus) {

        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

        Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
        if (userObject instanceof gobierno.Reparticion) {
            gobierno.Reparticion reparticion = (gobierno.Reparticion) userObject;
            setIcon(reparticionIcon);
            setText(reparticion.getNombre());
        } else if (userObject instanceof gobierno.Trabajador) {
            gobierno.Trabajador trabajador = (gobierno.Trabajador) userObject;
            if (trabajador instanceof gobierno.TrabajadorPermanente) {
                setIcon(trabajadorPermanenteIcon);
            } else {
                setIcon(trabajadorIcon);
            }
            setText(trabajador.getNombreCompleto());
        } else if (userObject instanceof gobierno.Contrato) {
            gobierno.Contrato contrato = (gobierno.Contrato) userObject;
            setIcon(contratoIcon);
            setText(contrato.toString());
        } else {
            setIcon(null);
            setText(value.toString());
        }

        return this;
    }
}
