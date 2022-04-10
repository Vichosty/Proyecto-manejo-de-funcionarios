/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chk.plugins;

import java.awt.Component;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeCellRenderer;

/**
 *
 * @author chkp
 */
public class CustomTreeCellRenderer implements TreeCellRenderer {
    private final JLabel label;
    private ImageIcon reparticionIcon;
    private ImageIcon trabajadorIcon;
    private ImageIcon gobiernoIcon;
    private ImageIcon contratoIcon;
    private Border selectedBorder;

    public CustomTreeCellRenderer() {
        reparticionIcon = new ImageIcon(new ImageIcon(gobierno.Reparticion.getIconPath()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        trabajadorIcon = new ImageIcon(new ImageIcon(gobierno.Trabajador.getIconPath()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        gobiernoIcon = new ImageIcon(new ImageIcon(gobierno.Gobierno.getIconPath()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        contratoIcon = new ImageIcon(new ImageIcon(gobierno.Contrato.getIconPath()).getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        selectedBorder = BorderFactory.createDashedBorder(SystemColor.textInactiveText, 1, 1);
        label = new JLabel();
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        
        Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
        if (userObject instanceof gobierno.Reparticion) {
            gobierno.Reparticion reparticion = (gobierno.Reparticion)userObject;
            label.setIcon(reparticionIcon);
            label.setText(reparticion.getNombre());
        } else if (userObject instanceof gobierno.Trabajador) {
            gobierno.Trabajador trabajador = (gobierno.Trabajador)userObject;
            label.setIcon(trabajadorIcon);
            label.setText(trabajador.getNombreCompleto());
        } else {
            label.setIcon(null);
            label.setText(value.toString());
        }
        
        if (selected) {
            label.setOpaque(true);
            label.setBackground(SystemColor.textHighlight);
            label.setForeground(SystemColor.textHighlightText);
        } else {
            label.setOpaque(false);
            label.setBackground(SystemColor.text);
            label.setForeground(SystemColor.textText);
        }
        
        return label;
    }
}
