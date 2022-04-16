/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chk.forms;

/**
 *
 * @author chkp
 */
public final class ReparticionEditorForm extends javax.swing.JDialog {

    /**
     * Creates new form TrabajadorView
     *
     * @param parent
     * @param modal
     * @param reparticion
     */
    public ReparticionEditorForm(java.awt.Frame parent, boolean modal, gobierno.Reparticion reparticion) {
        super(parent, modal);
        initComponents();
        if (reparticion != null) {
            setReparticion(reparticion);
        } else {
            titleLabel.setText("Crear Reparticion");
            setTitle("Crear Reparticion");
        }
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

        reparticion = new gobierno.Reparticion();
        reparticionSaved = new gobierno.Reparticion();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        viewPanel = new javax.swing.JPanel();
        nombreLabel = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        buttonsPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        reparticion.setNombre("");

        reparticionSaved.setNombre("");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Trabajador");
        setModal(true);
        setName("editorDialog"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        titlePanel.setMinimumSize(new java.awt.Dimension(168, 64));
        titlePanel.setPreferredSize(new java.awt.Dimension(168, 64));
        titlePanel.setLayout(new java.awt.GridLayout(1, 0));

        titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | java.awt.Font.BOLD, titleLabel.getFont().getSize()+8));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Editar Reparticion");
        titlePanel.add(titleLabel);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(titlePanel, gridBagConstraints);

        viewPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        viewPanel.setAutoscrolls(true);
        viewPanel.setLayout(new java.awt.GridBagLayout());

        nombreLabel.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        viewPanel.add(nombreLabel, gridBagConstraints);

        nombreText.setText(reparticion.getNombre());
        nombreText.getDocument().addDocumentListener(new chk.plugins.SimpleDocumentListener() {
            @Override
            public void update(javax.swing.event.DocumentEvent e) {
                reparticion.setNombre(nombreText.getText());
                checkForChanges();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 3.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        viewPanel.add(nombreText, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(viewPanel, gridBagConstraints);

        buttonsPanel.setLayout(new java.awt.GridLayout(1, 0, 4, 4));

        backButton.setText("Revertir Cambios");
        backButton.setEnabled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(backButton);

        saveButton.setText("Guardar Cambios");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        buttonsPanel.add(saveButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(buttonsPanel, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // Revertir los cambios a this.trabajador, usando this.trabajadorSaved
        this.reparticion.setNombre(this.reparticionSaved.getNombre());

        nombreText.setText(this.reparticion.getNombre());
    }//GEN-LAST:event_backButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // Cerrar la ventana
        this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    public void checkForChanges() {
        boolean changedSomething = false;
        if (!this.reparticion.getNombre().equals(this.reparticionSaved.getNombre())) {
            changedSomething = true;
        }

        // Check if the inputs are empty
        if (this.reparticion.getNombre().isEmpty()) {
            changedSomething = false;
        }

        this.saveButton.setEnabled(changedSomething);
        this.backButton.setEnabled(changedSomething);
    }

    public gobierno.Reparticion getReparticion() {
        return this.reparticion;
    }

    public void setReparticion(gobierno.Reparticion reparticion) {
        this.reparticion = reparticion;
        // Respalda el trabajador en caso de que no se quiera guardar cambios.
        reparticionSaved.setNombre(this.reparticion.getNombre());

        // Actualiza los widgets
        this.nombreText.setText(this.reparticion.getNombre());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreText;
    private gobierno.Reparticion reparticion;
    private gobierno.Reparticion reparticionSaved;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
