/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chk.forms;

import gobierno.*;
/**
 *
 * @author chkp
 */
public final class TrabajadorEditorForm extends javax.swing.JDialog {

    /**
     * Creates new form TrabajadorView
     *
     * @param parent
     * @param modal
     * @param trabajador
     */
    public TrabajadorEditorForm(java.awt.Frame parent, boolean modal, gobierno.Trabajador trabajador, boolean isPermanent) {
        super(parent, modal);
        if (isPermanent) {
            trabajadorSaved = new TrabajadorPermanente();
        } else {
            trabajadorSaved = new TrabajadorTemporero();
        }
        
        if (trabajador != null) {
            setTrabajador(trabajador);
        }
        
        initComponents();
        
        if (trabajador != null) {
            if (isPermanent) {
                titleLabel.setText("Editar Trabajador Permanente");
                setTitle("Editar Trabajador Permanente");
            } else {
                titleLabel.setText("Editar Trabajador Temporero");
                setTitle("Editar Trabajador Temporero");
            }
        } else {
            if (isPermanent) {
                titleLabel.setText("Crear Trabajador Permanente");
                setTitle("Crear Trabajador Permanente");
                setTrabajador(new TrabajadorPermanente());
            } else {
                titleLabel.setText("Crear Trabajador Temporero");
                setTitle("Crear Trabajador Temporero");
                setTrabajador(new TrabajadorTemporero());
            }
            
            setTrabajador(trabajador);
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

        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        viewPanel = new javax.swing.JPanel();
        nombreLabel = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        apellidoLabel = new javax.swing.JLabel();
        apellidoText = new javax.swing.JTextField();
        GeneroLabel = new javax.swing.JLabel();
        fechaDeNacimientoDatePicker = new org.jdesktop.swingx.JXDatePicker();
        fechaDeNacimientoLabel1 = new javax.swing.JLabel();
        fechaDeNacimientoLabel2 = new javax.swing.JLabel();
        cajaGenero = new javax.swing.JComboBox<>();
        buttonsPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Trabajador");
        setModal(true);
        setName("editorDialog"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        titlePanel.setMinimumSize(new java.awt.Dimension(162, 64));
        titlePanel.setPreferredSize(new java.awt.Dimension(162, 64));
        titlePanel.setLayout(new java.awt.GridLayout(1, 0));

        titleLabel.setFont(titleLabel.getFont().deriveFont(titleLabel.getFont().getStyle() | java.awt.Font.BOLD, titleLabel.getFont().getSize()+8));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Editar Trabajador");
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

        nombreText.setText(trabajador.getNombre());
        nombreText.getDocument().addDocumentListener(new chk.plugins.SimpleDocumentListener() {
            @Override
            public void update(javax.swing.event.DocumentEvent e) {
                trabajador.setNombre(nombreText.getText());
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

        apellidoLabel.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        viewPanel.add(apellidoLabel, gridBagConstraints);

        apellidoText.setText(trabajador.getApellido());
        apellidoText.getDocument().addDocumentListener(new chk.plugins.SimpleDocumentListener() {
            @Override
            public void update(javax.swing.event.DocumentEvent e) {
                trabajador.setApellido(apellidoText.getText());
                checkForChanges();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 3.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        viewPanel.add(apellidoText, gridBagConstraints);

        GeneroLabel.setText("Género");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        viewPanel.add(GeneroLabel, gridBagConstraints);

        fechaDeNacimientoDatePicker.setDate(trabajador.getFechaDeNacimiento());
        fechaDeNacimientoDatePicker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaDeNacimientoDatePickerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.weightx = 3.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        viewPanel.add(fechaDeNacimientoDatePicker, gridBagConstraints);

        fechaDeNacimientoLabel1.setText("Fecha de Nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        viewPanel.add(fechaDeNacimientoLabel1, gridBagConstraints);

        fechaDeNacimientoLabel2.setText("Fecha de Nacimiento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        viewPanel.add(fechaDeNacimientoLabel2, gridBagConstraints);

        cajaGenero.setModel(new javax.swing.DefaultComboBoxModel(Genero.values()));
        cajaGenero.setSelectedItem(trabajador.getGenero());
        cajaGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaGeneroActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 3.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        viewPanel.add(cajaGenero, gridBagConstraints);

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
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        getContentPane().add(buttonsPanel, gridBagConstraints);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fechaDeNacimientoDatePickerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaDeNacimientoDatePickerActionPerformed
        this.trabajador.setFechaDeNacimiento(this.fechaDeNacimientoDatePicker.getDate());
        this.checkForChanges();
    }//GEN-LAST:event_fechaDeNacimientoDatePickerActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // Revertir los cambios a this.trabajador, usando this.trabajadorSaved
        this.trabajador.setNombre(this.trabajadorSaved.getNombre());
        this.trabajador.setApellido(this.trabajadorSaved.getApellido());
        this.trabajador.setFechaDeNacimiento(this.trabajadorSaved.getFechaDeNacimiento());
        this.trabajador.setGenero(this.trabajadorSaved.getGenero());

        nombreText.setText(this.trabajador.getNombre());
        apellidoText.setText(this.trabajador.getApellido());
        fechaDeNacimientoDatePicker.setDate(this.trabajador.getFechaDeNacimiento());
    }//GEN-LAST:event_backButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // Cerrar la ventana
        this.dispose();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cajaGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaGeneroActionPerformed
        
        if(evt.getSource()== cajaGenero){
            this.trabajador.setGenero((Genero)cajaGenero.getSelectedItem());
            this.checkForChanges();
        }
    }//GEN-LAST:event_cajaGeneroActionPerformed


    
    public void checkForChanges() {
        boolean changedSomething = false;
        if (!this.trabajador.getNombre().equals(this.trabajadorSaved.getNombre())) {
            changedSomething = true;
        } else if (!this.trabajador.getApellido().equals(this.trabajadorSaved.getApellido())) {
            changedSomething = true;
        } else if (!this.trabajador.getFechaDeNacimiento().equals(this.trabajadorSaved.getFechaDeNacimiento())) {
            changedSomething = true;
        } else if(!this.trabajador.getGenero().equals(this.trabajadorSaved.getGenero())) {
            changedSomething = true;
        }
        
        // Check if the inputs are empty
        if (this.trabajador.getNombre().isEmpty() || this.trabajador.getApellido().isEmpty()) {
            changedSomething = false;
        }

        this.saveButton.setEnabled(changedSomething);
        this.backButton.setEnabled(changedSomething);
    }

    public gobierno.Trabajador getTrabajador() {
        return this.trabajador;
    }

    public void setTrabajador(gobierno.Trabajador trabajador) {
        this.trabajador = trabajador;
        // Respalda el trabajador en caso de que no se quiera guardar cambios.
        trabajadorSaved.setNombre(this.trabajador.getNombre());
        trabajadorSaved.setApellido(this.trabajador.getApellido());
        trabajadorSaved.setFechaDeNacimiento(this.trabajador.getFechaDeNacimiento());
        trabajadorSaved.setGenero(this.trabajador.getGenero());
        
        // Actualiza los widgets
        if (this.nombreText != null) {
            this.nombreText.setText(this.trabajador.getNombre());
            this.apellidoText.setText(this.trabajador.getApellido());
            this.fechaDeNacimientoDatePicker.setDate(this.trabajador.getFechaDeNacimiento());
            this.cajaGenero.setSelectedItem(this.trabajador.getGenero());
        }
    }

    private Trabajador trabajador = null;
    private Trabajador trabajadorSaved = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel GeneroLabel;
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JTextField apellidoText;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JComboBox<String> cajaGenero;
    private org.jdesktop.swingx.JXDatePicker fechaDeNacimientoDatePicker;
    private javax.swing.JLabel fechaDeNacimientoLabel1;
    private javax.swing.JLabel fechaDeNacimientoLabel2;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreText;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JPanel viewPanel;
    // End of variables declaration//GEN-END:variables
}
