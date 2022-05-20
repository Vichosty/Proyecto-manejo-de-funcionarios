/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chk.forms;

import chk.plugins.MessageBox;
import gobierno.Contrato;
import gobierno.Contratos;
import gobierno.Genero;
import gobierno.Reparticion;
import gobierno.Reparticiones;
import gobierno.Trabajador;
import gobierno.Trabajadores;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author chkp
 */
public final class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form EnumerateUsers
     *
     */
    public MainWindow() {
        trabajadores = Trabajadores.get();
        reparticiones = Reparticiones.get();
        contratos = Contratos.get();
    
        initComponents();
        reloadTree();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
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
        reparticionSearchTextbox = new javax.swing.JTextField();
        rightPanel = new javax.swing.JPanel();
        trabajadoresTitle = new javax.swing.JLabel();
        trabajadoresScrollPane = new javax.swing.JScrollPane();
        trabajadoresTable = new javax.swing.JTable();
        trabajadoresButtonsPanel = new javax.swing.JPanel();
        trabajadoresAdd1Button = new javax.swing.JButton();
        trabajadoresAdd2Button = new javax.swing.JButton();
        trabajadoresEditButton = new javax.swing.JButton();
        trabajadoresRemoveButton = new javax.swing.JButton();
        trabajadoresSearchTextbox = new javax.swing.JTextField();
        mainButtonsPanel = new javax.swing.JPanel();
        reportButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuOptions = new javax.swing.JMenu();
        menuOptionsLaf = new javax.swing.JMenu();
        showMenu = new javax.swing.JMenu();
        showMaleCheckBox = new javax.swing.JCheckBoxMenuItem();
        showFemaleCheckBox = new javax.swing.JCheckBoxMenuItem();
        showOtherCheckBox = new javax.swing.JCheckBoxMenuItem();
        showSeparator = new javax.swing.JMenuItem();
        showPermanentCheckBox = new javax.swing.JCheckBoxMenuItem();
        showTemporaryCheckBox = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manejo de Funcionarios");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        titlePanel.setMinimumSize(new java.awt.Dimension(136, 64));
        titlePanel.setPreferredSize(new java.awt.Dimension(1085, 64));
        titlePanel.setLayout(new java.awt.GridLayout(1, 0));

        titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | java.awt.Font.BOLD, titleLabel.getFont().getSize()+8));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Menu Principal");
        titleLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        titlePanel.add(titleLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(titlePanel, gridBagConstraints);

        borderPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        borderPanel.setLayout(new java.awt.GridLayout(1, 1, 4, 4));

        splitPanel.setDividerLocation(320);

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

        reparticionSearchTextbox.getDocument().addDocumentListener(new chk.plugins.SimpleDocumentListener() {
            @Override
            public void update(javax.swing.event.DocumentEvent e) {
                filterReparticiones();
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reparticionSearchTextbox)))
                .addContainerGap())
            .addComponent(reparticionButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reparticionTitle)
                    .addComponent(reparticionSearchTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reparticionScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
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
                "ID", "Nombre", "Apellido", "Genero", "Fecha de Nacimiento", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
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

        trabajadoresSearchTextbox.setEnabled(false);
        trabajadoresSearchTextbox.getDocument().addDocumentListener(new chk.plugins.SimpleDocumentListener() {
            @Override
            public void update(javax.swing.event.DocumentEvent e) {
                filterTrabajadores();
            }
        });

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trabajadoresTitle)
                .addGap(353, 353, 353)
                .addComponent(trabajadoresSearchTextbox, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(trabajadoresButtonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(trabajadoresScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trabajadoresTitle)
                    .addComponent(trabajadoresSearchTextbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(trabajadoresScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(trabajadoresButtonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        splitPanel.setRightComponent(rightPanel);

        borderPanel.add(splitPanel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(borderPanel, gridBagConstraints);

        mainButtonsPanel.setPreferredSize(new java.awt.Dimension(381, 31));
        mainButtonsPanel.setLayout(new java.awt.GridBagLayout());

        reportButton.setText("Generar Reporte");
        reportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        mainButtonsPanel.add(reportButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 5.0;
        mainButtonsPanel.add(filler1, gridBagConstraints);

        jButton3.setText("Cargar de Base de Datos");
        jButton3.setEnabled(false);
        mainButtonsPanel.add(jButton3, new java.awt.GridBagConstraints());

        jButton4.setText("Guardar en Base de Datos");
        jButton4.setEnabled(false);
        mainButtonsPanel.add(jButton4, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(mainButtonsPanel, gridBagConstraints);

        menuOptions.setText("Options");

        menuOptionsLaf.setText("Look and Feel");
        UIManager.LookAndFeelInfo[] lookAndFeels = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo lookAndFeelInfo : lookAndFeels) {
            JMenuItem item = new JMenuItem(lookAndFeelInfo.getName());
            item.addActionListener(event -> {
                try {
                    // Set the look and feel for the frame and update the UI
                    // to use a new selected look and feel.
                    UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            menuOptionsLaf.add(item);
        }
        menuOptions.add(menuOptionsLaf);

        showMenu.setText("Mostrar");

        showMaleCheckBox.setSelected(isShowMales());
        showMaleCheckBox.setText("Hombres");
        showMaleCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showMaleCheckBoxActionPerformed(evt);
            }
        });
        showMenu.add(showMaleCheckBox);

        showFemaleCheckBox.setSelected(isShowFemales());
        showFemaleCheckBox.setText("Mujeres");
        showFemaleCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showFemaleCheckBoxActionPerformed(evt);
            }
        });
        showMenu.add(showFemaleCheckBox);

        showOtherCheckBox.setSelected(isShowOthers());
        showOtherCheckBox.setText("Otros");
        showOtherCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showOtherCheckBoxActionPerformed(evt);
            }
        });
        showMenu.add(showOtherCheckBox);

        showSeparator.setEnabled(false);
        showMenu.add(showSeparator);

        showPermanentCheckBox.setSelected(isShowPermanents());
        showPermanentCheckBox.setText("Permanentes");
        showMenu.add(showPermanentCheckBox);

        showTemporaryCheckBox.setSelected(isShowTemporaries());
        showTemporaryCheckBox.setText("Temporeros");
        showMenu.add(showTemporaryCheckBox);

        menuOptions.add(showMenu);

        menuBar.add(menuOptions);

        setJMenuBar(menuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void reparticionTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_reparticionTreeValueChanged
        // Get the selected item name
        DefaultMutableTreeNode selectedNode
                = (DefaultMutableTreeNode) evt.getPath().getLastPathComponent();
                
        Reparticion r = null;
        if (selectedNode != null) {
            r = (Reparticion) selectedNode.getUserObject();
            reparticionEditButton.setEnabled(true);
            reparticionRemoveButton.setEnabled(true);
        } else {
            reparticionEditButton.setEnabled(false);
            reparticionRemoveButton.setEnabled(false);
        }

        reloadTable(r);
    }//GEN-LAST:event_reparticionTreeValueChanged

    private void trabajadoresTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trabajadoresTableMousePressed
        JTable table = (JTable) evt.getSource();
        Point point = evt.getPoint();
        int row = table.rowAtPoint(point);
        if (row != -1 && evt.getClickCount() == 2) {
            // Edit that Trabajador!
            Object cell = table.getModel().getValueAt(row, 0);
            if (cell != null) {
                int id = (int) (cell);

                Trabajador t = trabajadores.get(id);
                if (t != null) {
                    TrabajadorEditorForm editor = new TrabajadorEditorForm(this, true, t);
                    editor.setVisible(true);
                    trabajadores.modify(id, editor.getTrabajador());

                    // Obtener la reparticion, usando la lista de la izquierda
                    Reparticion r = getReparticionFromTree(reparticionTree);
                    reloadTable(r);
                }
            }
        }
    }//GEN-LAST:event_trabajadoresTableMousePressed

    private void reparticionTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reparticionTreeMouseClicked
        JTree tree = (JTree)evt.getSource();
        
        int x = evt.getX();
        int y = evt.getY();
        
        int row = tree.getClosestRowForLocation(x, y);
        Rectangle bounds = tree.getRowBounds(row);
        if (bounds == null) { return; }
        
        // Si cliqueamos arriba o abajo del rectangulo, desactiva la seleccion
        if (y < bounds.y || y > bounds.y + bounds.height) {
            row = -1;
        }
        
        if (row == -1) {
            tree.clearSelection();
            reloadTable(null);
        }
    }//GEN-LAST:event_reparticionTreeMouseClicked

    private void trabajadoresEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajadoresEditButtonActionPerformed
        // Obtener el trabajador dada la id seleccionada
        int selectedRow = trabajadoresTable.getSelectedRow();
        int selectedId = (int) trabajadoresTable.getValueAt(selectedRow, 0);
        Trabajador t = trabajadores.get(selectedId);

        // Editar el trabajador
        TrabajadorEditorForm editor = new TrabajadorEditorForm(this, true, t);
        editor.setVisible(true);
        trabajadores.modify(selectedId, editor.getTrabajador());

        // Obtener la reparticion, usando la lista de la izquierda
        Reparticion r = getReparticionFromTree(reparticionTree);

        reloadTable(r);
    }//GEN-LAST:event_trabajadoresEditButtonActionPerformed

    private void trabajadoresRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajadoresRemoveButtonActionPerformed
        int config = JOptionPane.YES_NO_OPTION;
        int response = JOptionPane.showConfirmDialog(null,
                "Estas seguro de que deseas eliminar este contrato?", 
                "Cuidado", 
                config);
        
        if (response == JOptionPane.YES_OPTION) {
            // Obtener el trabajador dada la id seleccionada
            int selectedRow = trabajadoresTable.getSelectedRow();
            int selectedId = (int) trabajadoresTable.getValueAt(selectedRow, 0);
            Trabajador t = trabajadores.get(selectedId);

            // Obtener la reparticion, usando la lista de la izquierda
            Reparticion r = getReparticionFromTree(reparticionTree);

            // Remover el contrato entre ambos (si existe)
            contratos.remove(t.getId(), r.getId());

            reloadTable(r);
        }
    }//GEN-LAST:event_trabajadoresRemoveButtonActionPerformed

    private void trabajadoresAdd1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajadoresAdd1ButtonActionPerformed
        // Creamos un nuevo trabajador y lo agregamos al gobierno
        TrabajadorEditorForm editor = new TrabajadorEditorForm(this, true, null);
        editor.setVisible(true);
        Trabajador t = editor.getTrabajador();
        t.setId(trabajadores.getMayorId() + 1);
        trabajadores.add(t);

        // Obtener la reparticion, usando la lista de la izquierda
        Reparticion r = getReparticionFromTree(reparticionTree);
        
        // Creamos un nuevo contrato y lo agregamos al gobierno
        contratos.add(new Contrato(contratos.getMayorId() + 1, t.getId(), r.getId()));

        reloadTable(r);
    }//GEN-LAST:event_trabajadoresAdd1ButtonActionPerformed

    private void trabajadoresAdd2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trabajadoresAdd2ButtonActionPerformed
        // Obtener la reparticion, usando la lista de la izquierda
        Reparticion r = getReparticionFromTree(reparticionTree);

        TrabajadorChooserForm form = new TrabajadorChooserForm(this, true, r);
        form.setVisible(true);
        Trabajador t = form.getTrabajador();
        if (t != null && t.getId() >= 0) {
            // Creamos un nuevo contrato y lo agregamos al gobierno
            contratos.add(new Contrato(contratos.getMayorId() + 1, t.getId(), r.getId()));
        }

        reloadTable(r);
    }//GEN-LAST:event_trabajadoresAdd2ButtonActionPerformed

    private void reparticionAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reparticionAddButtonActionPerformed
        ReparticionEditorForm form = new ReparticionEditorForm(this, true, null);
        form.setVisible(true);

        Reparticion r = form.getReparticion();
        r.setId(reparticiones.getMayorId() + 1);
        reparticiones.add(r);
        reloadTree();
    }//GEN-LAST:event_reparticionAddButtonActionPerformed

    private void reparticionEditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reparticionEditButtonActionPerformed
        // Obtener reparticion seleccionada
        Reparticion r = getReparticionFromTree(reparticionTree);

        // Crear editor de reparticiones
        ReparticionEditorForm form = new ReparticionEditorForm(this, true, r);
        form.setVisible(true);

        // Reemplazar la reparticion con la nueva
        reparticiones.modify(r.getId(), form.getReparticion().getNombre());

        reloadTree();
    }//GEN-LAST:event_reparticionEditButtonActionPerformed

    private void reparticionRemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reparticionRemoveButtonActionPerformed
        int config = JOptionPane.YES_NO_OPTION;
        int response = JOptionPane.showConfirmDialog(null,
                "Estas seguro de que deseas eliminar esta reparticion?", 
                "Cuidado", 
                config);
        if (response == JOptionPane.YES_OPTION) {
            Reparticion r = getReparticionFromTree(reparticionTree);
            reparticiones.remove(r.getId());

            reloadTree();
        }
    }//GEN-LAST:event_reparticionRemoveButtonActionPerformed

    private void reportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportButtonActionPerformed
        try {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                StringBuilder sb = new StringBuilder();
                
                // Generate the report
                sb.append("[Reparticiones]:\n");
                Reparticiones rs = Reparticiones.get();
                for(int reparticionId : rs.getIDs()) {
                    Reparticion r = rs.get(reparticionId);
                    sb.append("\t").append(r.getNombre()).append(":\n");
                    for(int tIndex = 0; tIndex < r.getNumTrabajadores(); ++tIndex) {
                        Trabajador t = r.getTrabajador(tIndex);
                        sb.append("\t\t- [").append(t.getId()).append("]").append(t.getNombreCompleto()).append("\n");
                    }
                }
                sb.append("\n");
                
                Trabajadores ts = Trabajadores.get();
                sb.append("[Sin Reparticion]:\n");
                for(int trabajadorId: ts.getIDsSinReparticion()) {
                    Trabajador t = ts.get(trabajadorId);
                    sb.append("\t- [").append(t.getId()).append("]").append(t.getNombreCompleto()).append("\n");
                }
                sb.append("\n");
                
                Contratos cs = Contratos.get();
                sb.append("[Contratos]:\n");
                for(int contratoId: cs.getIDs()) {
                    Contrato c = cs.get(contratoId);
                    Trabajador t = ts.get(c.getIdTrabajador());
                    Reparticion r = rs.get(c.getIdReparticion());
                    sb.append("\t- [").append(c.getIdTrabajador()).append("]")
                            .append(t.getNombreCompleto())
                            .append(" => [").append(c.getIdReparticion()).append("]")
                            .append(r.getNombre())
                            .append("\n");
                }
                sb.append("\n");
                
                
                String report = sb.toString();
                File file = fileChooser.getSelectedFile();
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(report);
                    MessageBox.infoBox("Archivo '"+fileChooser.getName(file)+"' guardado con exito", "Generar Reporte");
                }
            }
        } catch (IOException e) {
            MessageBox.errorBox(e.getLocalizedMessage(), "IOException");
        }
    }//GEN-LAST:event_reportButtonActionPerformed

    private void showMaleCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showMaleCheckBoxActionPerformed
        setShowMales(showMaleCheckBox.isSelected());
        reloadTable(getReparticionFromTree(reparticionTree));
    }//GEN-LAST:event_showMaleCheckBoxActionPerformed

    private void showFemaleCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showFemaleCheckBoxActionPerformed
        setShowFemales(showFemaleCheckBox.isSelected());
        reloadTable(getReparticionFromTree(reparticionTree));
    }//GEN-LAST:event_showFemaleCheckBoxActionPerformed

    private void showOtherCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showOtherCheckBoxActionPerformed
        setShowOthers(showOtherCheckBox.isSelected());
        reloadTable(getReparticionFromTree(reparticionTree));
    }//GEN-LAST:event_showOtherCheckBoxActionPerformed

    public void reloadTree() {
        String filterStr = reparticionSearchTextbox.getText();
        
        Reparticion savedR = getReparticionFromTree(reparticionTree);
        DefaultMutableTreeNode savedNode = null;
        
        DefaultMutableTreeNode treeRoot = new DefaultMutableTreeNode();
        // populate the nodes
        DefaultMutableTreeNode reparticionNode;
        for (int reparticionId : reparticiones.getIDs()) {
            Reparticion r = reparticiones.get(reparticionId);
            
            // Check if the name includes the filterStr
            if (!filterStr.isEmpty()) {
                if (!r.getNombre().contains(filterStr)) {
                    continue;
                }
            }
            
            reparticionNode = new DefaultMutableTreeNode(r.getNombre());
            reparticionNode.setUserObject(r);
            treeRoot.add(reparticionNode);
            
            // If the new node is the same as the last selected node,
            // keep it selected
            if (savedR != null && r.getId() == savedR.getId()) {
                savedNode = reparticionNode;
            }
        }
        
        DefaultTreeModel treeModel = new DefaultTreeModel(treeRoot);
        this.reparticionTree.setModel(treeModel);
        
        if (savedNode != null) {
            TreePath savedPath = new TreePath(savedNode.getPath());
            reparticionTree.setSelectionPath(savedPath);
        }
        
        savedR = getReparticionFromTree(reparticionTree);
        reloadTable(savedR);
    }

    public void reloadTable(Reparticion r) {
        String filterStr = trabajadoresSearchTextbox.getText();
        
        DefaultTableModel tableModel = (DefaultTableModel) trabajadoresTable.getModel();  
        tableModel.setRowCount(0);
        if (r != null) {
            for (int contratoId : contratos.getIDsByIdReparticion(r.getId())) {
                Contrato c = contratos.get(contratoId);
                Trabajador t = trabajadores.get(c.getIdTrabajador());
                
                // Skip based on config
                if (!showMales && t.getGenero() == Genero.Hombre) { continue; }
                if (!showFemales && t.getGenero() == Genero.Mujer) { continue; }
                if (!showOthers && t.getGenero() == Genero.Otro) { continue; }
                
                // Filter the table if the filterStr is not empty
                if (!filterStr.isEmpty()) {
                    if (!t.getNombreCompleto().contains(filterStr)) {
                        continue;
                    }
                }
                
                tableModel.addRow(new Object[]{
                    t.getId(),
                    t.getNombre(),
                    t.getApellido(),
                    t.getGeneroAsString(),
                    t.getFechaDeNacimientoAsString(),
                    t.getTipo()
                });
            }
            trabajadoresAdd1Button.setEnabled(true);
            trabajadoresAdd2Button.setEnabled(true);
            trabajadoresSearchTextbox.setEnabled(true);
        } else {
            trabajadoresAdd1Button.setEnabled(false);
            trabajadoresAdd2Button.setEnabled(false);
            trabajadoresSearchTextbox.setEnabled(false);
        }
    }

    public Reparticion getReparticionFromTree(JTree tree) {
        DefaultMutableTreeNode selectedNode
                = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (selectedNode == null) { return null; }
        
        Reparticion r = (Reparticion) selectedNode.getUserObject();
        return r;
    }
    
    public void filterReparticiones() {
        reloadTree();
    }
    
    public void filterTrabajadores() {
        // Obtener la reparticion, usando la lista de la izquierda
        Reparticion r = getReparticionFromTree(reparticionTree);
        if (r != null) {
            reloadTable(r);
        }
    }

    
    public boolean isShowMales() {
        return showMales;
    }

    public void setShowMales(boolean showMales) {
        this.showMales = showMales;
    }

    public boolean isShowFemales() {
        return showFemales;
    }

    public void setShowFemales(boolean showFemales) {
        this.showFemales = showFemales;
    }

    public boolean isShowOthers() {
        return showOthers;
    }

    public void setShowOthers(boolean showOthers) {
        this.showOthers = showOthers;
    }

    public boolean isShowPermanents() {
        return showPermanents;
    }

    public void setShowPermanents(boolean showPermanents) {
        this.showPermanents = showPermanents;
    }

    public boolean isShowTemporaries() {
        return showTemporaries;
    }

    public void setShowTemporaries(boolean showTemporaries) {
        this.showTemporaries = showTemporaries;
    }
    
    private boolean showMales = true;
    private boolean showFemales = true;
    private boolean showOthers = true;
    private boolean showPermanents = true;
    private boolean showTemporaries = true;
    
    private final Trabajadores trabajadores;
    private final Reparticiones reparticiones;
    private final Contratos contratos;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel borderPanel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel mainButtonsPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuOptions;
    private javax.swing.JMenu menuOptionsLaf;
    private javax.swing.JButton reparticionAddButton;
    private javax.swing.JPanel reparticionButtonsPanel;
    private javax.swing.JButton reparticionEditButton;
    private javax.swing.JButton reparticionRemoveButton;
    private javax.swing.JScrollPane reparticionScrollPane;
    private javax.swing.JTextField reparticionSearchTextbox;
    private javax.swing.JLabel reparticionTitle;
    private javax.swing.JTree reparticionTree;
    private javax.swing.JButton reportButton;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JCheckBoxMenuItem showFemaleCheckBox;
    private javax.swing.JCheckBoxMenuItem showMaleCheckBox;
    private javax.swing.JMenu showMenu;
    private javax.swing.JCheckBoxMenuItem showOtherCheckBox;
    private javax.swing.JCheckBoxMenuItem showPermanentCheckBox;
    private javax.swing.JMenuItem showSeparator;
    private javax.swing.JCheckBoxMenuItem showTemporaryCheckBox;
    private javax.swing.JSplitPane splitPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JButton trabajadoresAdd1Button;
    private javax.swing.JButton trabajadoresAdd2Button;
    private javax.swing.JPanel trabajadoresButtonsPanel;
    private javax.swing.JButton trabajadoresEditButton;
    private javax.swing.JButton trabajadoresRemoveButton;
    private javax.swing.JScrollPane trabajadoresScrollPane;
    private javax.swing.JTextField trabajadoresSearchTextbox;
    private javax.swing.JTable trabajadoresTable;
    private javax.swing.JLabel trabajadoresTitle;
    // End of variables declaration//GEN-END:variables
}
