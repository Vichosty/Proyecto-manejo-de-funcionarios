/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chk.forms;

import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author chkp
 */
public final class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form EnumerateUsers
     * @param gobierno
     */
    public MainWindow(gobierno.Gobierno gobierno) {
        initComponents();
        setGobierno(gobierno);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gobierno = new gobierno.Gobierno();
        borderPanel = new javax.swing.JPanel();
        splitPanel = new javax.swing.JSplitPane();
        leftPanel = new javax.swing.JPanel();
        reparticionTitle = new javax.swing.JLabel();
        reparticionScrollPane = new javax.swing.JScrollPane();
        reparticionTree = new javax.swing.JTree();
        reparticionButtonsPanel = new javax.swing.JPanel();
        reparticionAddButton = new javax.swing.JButton();
        reparticionEditButton = new javax.swing.JButton();
        reparticionRemoveButton = new javax.swing.JButton();
        rightPanel = new javax.swing.JPanel();
        trabajadoresTitle = new javax.swing.JLabel();
        trabajadoresScrollPane = new javax.swing.JScrollPane();
        trabajadoresTable = new javax.swing.JTable();
        trabajadoresButtonsPanel = new javax.swing.JPanel();
        trabajadoresAdd1Button = new javax.swing.JButton();
        trabajadoresAdd2Button = new javax.swing.JButton();
        trabajadoresEditButton = new javax.swing.JButton();
        trabajadoresRemoveButton = new javax.swing.JButton();
        mainButtonsPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manejo de Funcionarios");

        borderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        borderPanel.setLayout(new java.awt.GridLayout(1, 1, 4, 4));

        splitPanel.setDividerLocation(256);

        reparticionTitle.setText("Reparticiones");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        reparticionTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        reparticionTree.setCellRenderer(new chk.plugins.CustomTreeCellRenderer());
        reparticionTree.setRootVisible(false);
        reparticionTree.setShowsRootHandles(true);
        reparticionTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        reparticionTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reparticionTreeMouseClicked(evt);
            }
        });
        reparticionTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                reparticionTreeValueChanged(evt);
            }
        });
        reparticionScrollPane.setViewportView(reparticionTree);

        reparticionButtonsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        reparticionButtonsPanel.setLayout(new java.awt.GridLayout(2, 2, 4, 4));

        reparticionAddButton.setText("Agregar");
        reparticionAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reparticionAddButtonActionPerformed(evt);
            }
        });
        reparticionButtonsPanel.add(reparticionAddButton);

        reparticionEditButton.setText("Editar");
        reparticionEditButton.setEnabled(false);
        reparticionEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reparticionEditButtonActionPerformed(evt);
            }
        });
        reparticionButtonsPanel.add(reparticionEditButton);

        reparticionRemoveButton.setText("Eliminar");
        reparticionRemoveButton.setEnabled(false);
        reparticionRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reparticionRemoveButtonActionPerformed(evt);
            }
        });
        reparticionButtonsPanel.add(reparticionRemoveButton);

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reparticionScrollPane)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addComponent(reparticionTitle)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(reparticionButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reparticionTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reparticionScrollPane)
                .addGap(18, 18, 18)
                .addComponent(reparticionButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        splitPanel.setLeftComponent(leftPanel);

        trabajadoresTitle.setText("Trabajadores");

        trabajadoresTable.setAutoCreateRowSorter(true);
        trabajadoresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Fecha de Nacimiento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        trabajadoresTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                trabajadoresTableMousePressed(evt);
            }
        });
        trabajadoresScrollPane.setViewportView(trabajadoresTable);
        if (trabajadoresTable.getColumnModel().getColumnCount() > 0) {
            trabajadoresTable.getColumnModel().getColumn(0).setMinWidth(32);
            trabajadoresTable.getColumnModel().getColumn(0).setPreferredWidth(32);
            trabajadoresTable.getColumnModel().getColumn(0).setMaxWidth(32);
        }
        trabajadoresTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (trabajadoresTable.getSelectedRow() > -1) {
                    trabajadoresEditButton.setEnabled(true);
                    trabajadoresRemoveButton.setEnabled(true);
                } else {
                    trabajadoresEditButton.setEnabled(false);
                    trabajadoresRemoveButton.setEnabled(false);
                }
            }
        });

        trabajadoresButtonsPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        trabajadoresButtonsPanel.setLayout(new java.awt.GridLayout(2, 3, 4, 4));

        trabajadoresAdd1Button.setText("Agregar Nuevo");
        trabajadoresAdd1Button.setEnabled(false);
        trabajadoresAdd1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trabajadoresAdd1ButtonActionPerformed(evt);
            }
        });
        trabajadoresButtonsPanel.add(trabajadoresAdd1Button);

        trabajadoresAdd2Button.setText("Agregar Existente");
        trabajadoresAdd2Button.setEnabled(false);
        trabajadoresAdd2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trabajadoresAdd2ButtonActionPerformed(evt);
            }
        });
        trabajadoresButtonsPanel.add(trabajadoresAdd2Button);

        trabajadoresEditButton.setText("Editar");
        trabajadoresEditButton.setEnabled(false);
        trabajadoresEditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trabajadoresEditButtonActionPerformed(evt);
            }
        });
        trabajadoresButtonsPanel.add(trabajadoresEditButton);

        trabajadoresRemoveButton.setText("Eliminar");
        trabajadoresRemoveButton.setEnabled(false);
        trabajadoresRemoveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trabajadoresRemoveButtonActionPerformed(evt);
            }
        });
        trabajadoresButtonsPanel.add(trabajadoresRemoveButton);

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trabajadoresScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addComponent(trabajadoresTitle)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(trabajadoresButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trabajadoresTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(trabajadoresScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(trabajadoresButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        splitPanel.setRightComponent(rightPanel);

        borderPanel.add(splitPanel);

        jButton1.setText("Cargar desde Base de Datos");
        jButton1.setEnabled(false);

        jButton3.setText("Guardar en Base de Datos");
        jButton3.setEnabled(false);

        javax.swing.GroupLayout mainButtonsPanelLayout = new javax.swing.GroupLayout(mainButtonsPanel);
        mainButtonsPanel.setLayout(mainButtonsPanelLayout);
        mainButtonsPanelLayout.setHorizontalGroup(
            mainButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainButtonsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addContainerGap())
        );
        mainButtonsPanelLayout.setVerticalGroup(
            mainButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainButtonsPanelLayout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(mainButtonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(borderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(borderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reparticionTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_reparticionTreeValueChanged
        // Get the selected item name
        DefaultMutableTreeNode selectedNode =
                (DefaultMutableTreeNode)reparticionTree.getLastSelectedPathComponent();
        
        gobierno.Reparticion r = null;
        if (selectedNode != null) { 
            r = (gobierno.Reparticion)selectedNode.getUserObject();
            reparticionEditButton.setEnabled(true);
            reparticionRemoveButton.setEnabled(true);
        } else {
            reparticionEditButton.setEnabled(false);
            reparticionRemoveButton.setEnabled(false);
        }
        
        reloadTable(r);
    }//GEN-LAST:event_reparticionTreeValueChanged

    private void trabajadoresTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trabajadoresTableMousePressed
        JTable table =(JTable) evt.getSource();
        Point point = evt.getPoint();
        int row = table.rowAtPoint(point);
        if (table.getSelectedRow() != -1 && evt.getClickCount() == 2) {
            // Edit that Trabajador!
            Object cell = table.getModel().getValueAt(row, 0);
            if (cell != null) {
                int id = (int)(cell);

                gobierno.Trabajador t = gobierno.getTrabajador(id);
                if (t != null) {
                    TrabajadorEditorForm editor = new TrabajadorEditorForm(this, true, t);
                    editor.setVisible(true);
                    gobierno.replaceTrabajador(id, editor.getTrabajador());

                    // Obtener la reparticion, usando la lista de la izquierda
                    gobierno.Reparticion r = getReparticionFromTree();
                    reloadTable(r);
                }
            }
        }
    }//GEN-LAST:event_trabajadoresTableMousePressed

    private void reparticionTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reparticionTreeMouseClicked
        if(reparticionTree.getRowForLocation(evt.getX(), evt.getY()) == -1) {
            reparticionTree.clearSelection();
            reloadTable(null);
        }
    }//GEN-LAST:event_reparticionTreeMouseClicked

    private void trabajadoresEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajadoresEditButtonActionPerformed
        // Obtener el trabajador dada la id seleccionada
        int selectedRow = trabajadoresTable.getSelectedRow();
        int selectedId = (int)trabajadoresTable.getValueAt(selectedRow, 0);
        gobierno.Trabajador t = gobierno.getTrabajador(selectedId);
        
        // Editar el trabajador
        TrabajadorEditorForm editor = new TrabajadorEditorForm(this, true, t);
        editor.setVisible(true);
        gobierno.replaceTrabajador(selectedId, editor.getTrabajador());
        
        // Obtener la reparticion, usando la lista de la izquierda
        gobierno.Reparticion r = getReparticionFromTree();
        
        reloadTable(r);
    }//GEN-LAST:event_trabajadoresEditButtonActionPerformed

    private void trabajadoresRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajadoresRemoveButtonActionPerformed
        int botones = JOptionPane.YES_NO_OPTION;
        int respuesta = JOptionPane.showConfirmDialog (null, 
                "Estas seguro de que deseas eliminar este contrato?", "Cuidado", botones);
        if(respuesta == JOptionPane.YES_OPTION) {   
            // Obtener el trabajador dada la id seleccionada
            int selectedRow = trabajadoresTable.getSelectedRow();
            int selectedId = (int)trabajadoresTable.getValueAt(selectedRow, 0);
            gobierno.Trabajador t = gobierno.getTrabajador(selectedId);

            // Obtener la reparticion, usando la lista de la izquierda
            gobierno.Reparticion r = getReparticionFromTree();

            // Remover el contrato entre ambos (si existe)
            gobierno.removeContrato(t.getId(), r.getId());

            reloadTable(r);
        }
    }//GEN-LAST:event_trabajadoresRemoveButtonActionPerformed

    private void trabajadoresAdd1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajadoresAdd1ButtonActionPerformed
        // Creamos un nuevo trabajador y lo agregamos al gobierno.
        TrabajadorEditorForm editor = new TrabajadorEditorForm(this, true, null);
        editor.setVisible(true);
        gobierno.Trabajador t = editor.getTrabajador();
        t.setId(gobierno.getMayorIdTrabajador() + 1);
        gobierno.addTrabajador(t);
        
        // Obtener la reparticion, usando la lista de la izquierda
        gobierno.Reparticion r = getReparticionFromTree();
        
        // Creamos un nuevo contrato y lo agregamos al gobierno.
        gobierno.Contrato c = new gobierno.Contrato(gobierno.getMayorIdContrato() + 1, t.getId(), r.getId());
        gobierno.addContrato(c);
        
        reloadTable(r);
    }//GEN-LAST:event_trabajadoresAdd1ButtonActionPerformed

    private void trabajadoresAdd2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajadoresAdd2ButtonActionPerformed
        // Obtener la reparticion, usando la lista de la izquierda
        gobierno.Reparticion r = getReparticionFromTree();
        
        TrabajadorChooserForm form = new TrabajadorChooserForm(this, true, this.gobierno, r);
        form.setVisible(true);
        gobierno.Trabajador t = form.getTrabajador();
        if (t != null && t.getId() >= 0) {
            // Creamos un nuevo contrato y lo agregamos al gobierno.
            gobierno.Contrato c = new gobierno.Contrato(gobierno.getMayorIdContrato() + 1, t.getId(), r.getId());
            gobierno.addContrato(c);
        }
        
        reloadTable(r);
    }//GEN-LAST:event_trabajadoresAdd2ButtonActionPerformed

    private void reparticionAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reparticionAddButtonActionPerformed
        ReparticionEditorForm form = new ReparticionEditorForm(this, true, null);
        form.setVisible(true);
        
        gobierno.Reparticion r = form.getReparticion();
        r.setId(gobierno.getMayorIdReparticion() + 1);
        gobierno.addReparticion(r);
        reloadTree();
    }//GEN-LAST:event_reparticionAddButtonActionPerformed

    private void reparticionEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reparticionEditButtonActionPerformed
        // Obtener reparticion seleccionada
        gobierno.Reparticion r = getReparticionFromTree();
        
        // Crear editor de reparticiones
        ReparticionEditorForm form = new ReparticionEditorForm(this, true, r);
        form.setVisible(true);
        
        // Reemplazar la reparticion con la nueva
        gobierno.renameReparticion(r.getId(), form.getReparticion().getNombre());
        
        reloadTree();
    }//GEN-LAST:event_reparticionEditButtonActionPerformed

    private void reparticionRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reparticionRemoveButtonActionPerformed
        int botones = JOptionPane.YES_NO_OPTION;
        int respuesta = JOptionPane.showConfirmDialog (null, 
                "Estas seguro de que deseas eliminar esta reparticion?", "Cuidado", botones);
        if(respuesta == JOptionPane.YES_OPTION) {
            gobierno.Reparticion r = getReparticionFromTree();
            gobierno.removeReparticion(r.getId());

            reloadTree();
        }
    }//GEN-LAST:event_reparticionRemoveButtonActionPerformed

    public void reloadTree() {
        DefaultMutableTreeNode treeRoot = new DefaultMutableTreeNode();
        // populate the nodes
        DefaultMutableTreeNode reparticionNode = null;
        for(gobierno.Reparticion reparticion : gobierno.getReparticiones()){
            reparticionNode = new DefaultMutableTreeNode(reparticion.getNombre());
            reparticionNode.setUserObject(reparticion);
            treeRoot.add(reparticionNode);
        }
        
        DefaultTreeModel treeModel = new DefaultTreeModel(treeRoot);
        this.reparticionTree.setModel(treeModel);
    }
    
    public void reloadTable(gobierno.Reparticion r) {
        DefaultTableModel tableModel = (DefaultTableModel)trabajadoresTable.getModel();
        tableModel.setRowCount(0);
        if (r != null) {
            for (gobierno.Trabajador t : gobierno.getTrabajadoresEnReparticion(r.getId())) {
                tableModel.addRow(new Object[]{ 
                    t.getId(),
                    t.getNombre(),
                    t.getApellido(),
                    t.getFechaDeNacimientoAsString()
                });
            }
            trabajadoresAdd1Button.setEnabled(true);
            trabajadoresAdd2Button.setEnabled(true);
        } else {
            trabajadoresAdd1Button.setEnabled(false);
            trabajadoresAdd2Button.setEnabled(false);
        }
    }
    
    public gobierno.Reparticion getReparticionFromTree() {
        DefaultMutableTreeNode selectedNode =
                (DefaultMutableTreeNode)reparticionTree.getLastSelectedPathComponent();
        gobierno.Reparticion r = (gobierno.Reparticion)selectedNode.getUserObject();
        return r;
    }
    
    public gobierno.Gobierno getGobierno() {
        return this.gobierno;
    }
    
    public void setGobierno(gobierno.Gobierno gobierno) {
        this.gobierno = gobierno;
        reloadTree();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel borderPanel;
    private gobierno.Gobierno gobierno;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainButtonsPanel;
    private javax.swing.JButton reparticionAddButton;
    private javax.swing.JPanel reparticionButtonsPanel;
    private javax.swing.JButton reparticionEditButton;
    private javax.swing.JButton reparticionRemoveButton;
    private javax.swing.JScrollPane reparticionScrollPane;
    private javax.swing.JLabel reparticionTitle;
    private javax.swing.JTree reparticionTree;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JSplitPane splitPanel;
    private javax.swing.JButton trabajadoresAdd1Button;
    private javax.swing.JButton trabajadoresAdd2Button;
    private javax.swing.JPanel trabajadoresButtonsPanel;
    private javax.swing.JButton trabajadoresEditButton;
    private javax.swing.JButton trabajadoresRemoveButton;
    private javax.swing.JScrollPane trabajadoresScrollPane;
    private javax.swing.JTable trabajadoresTable;
    private javax.swing.JLabel trabajadoresTitle;
    // End of variables declaration//GEN-END:variables
}