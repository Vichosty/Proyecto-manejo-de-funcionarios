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
 * @author chkp
 */
public class CustomTreeCellRenderer extends DefaultTreeCellRenderer {
    // private final JLabel label;
    private ImageIcon reparticionIcon;
    private ImageIcon trabajadorIcon;
    private ImageIcon gobiernoIcon;
    private ImageIcon contratoIcon;

    public CustomTreeCellRenderer() {
        super();
        
        reparticionIcon = new ImageIcon(new ImageIcon(gobierno.Reparticion.getIconPath()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        trabajadorIcon = new ImageIcon(new ImageIcon(gobierno.Trabajador.getIconPath()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        gobiernoIcon = new ImageIcon(new ImageIcon(gobierno.Gobierno.getIconPath()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        contratoIcon = new ImageIcon(new ImageIcon(gobierno.Contrato.getIconPath()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        // label = new JLabel();
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        
        Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
        if (userObject instanceof gobierno.Reparticion) {
            gobierno.Reparticion reparticion = (gobierno.Reparticion)userObject;
            setIcon(reparticionIcon);
            setText(reparticion.getNombre());
        } else if (userObject instanceof gobierno.Trabajador) {
            gobierno.Trabajador trabajador = (gobierno.Trabajador)userObject;
            setIcon(trabajadorIcon);
            setText(trabajador.getNombreCompleto());
        } else {
            setIcon(null);
            setText(value.toString());
        }
        
        return this;
    }
}
