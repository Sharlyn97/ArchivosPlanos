/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Moon
 */
public class GUI_ModuloMantenimientoUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form GUI_ModuloMantenimientoUsuarios
     */
    public GUI_ModuloMantenimientoUsuarios() {
        initComponents();
    }
    
    public String[] devolverInformacion()
    {
        String arreglo[];
        arreglo=new String[4]; 
        
        arreglo[1]=this.jt_NombreUsuario.getText();
        arreglo[0]=this.jt_nombreCompleto.getText();
        arreglo[2]=this.jpf_contraseña.getText();
        arreglo[3]=""+this.jComboBox1.getSelectedIndex();
        
        return arreglo;
    }
    
    public String devolverNombreUsuario()
    {
        return this.jt_NombreUsuario.getText();
    }
    
    public void mostrarInformacion(String arreglo[])
    {
        this.jt_nombreCompleto.setText(arreglo[0]);
        this.jComboBox1.setSelectedIndex(Integer.parseInt(arreglo[1]));
        this.jpf_contraseña.setText(arreglo[2]);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_NombreCompleto = new javax.swing.JLabel();
        jl_NombreUsuario = new javax.swing.JLabel();
        jl_Contraseña = new javax.swing.JLabel();
        jl_Tipo = new javax.swing.JLabel();
        jt_nombreCompleto = new javax.swing.JTextField();
        jt_NombreUsuario = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jpf_contraseña = new javax.swing.JPasswordField();

        jl_NombreCompleto.setText("Nombre Completo");

        jl_NombreUsuario.setText("Nombre Usuario");

        jl_Contraseña.setText("Contraseña");

        jl_Tipo.setText("Tipo");

        jt_nombreCompleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jt_nombreCompletoActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Administrador" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_Tipo)
                                .addGap(114, 114, 114))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_Contraseña)
                                .addGap(78, 78, 78)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpf_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_NombreCompleto)
                        .addGap(49, 49, 49)
                        .addComponent(jt_nombreCompleto))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jl_NombreUsuario)
                        .addGap(58, 58, 58)
                        .addComponent(jt_NombreUsuario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_NombreUsuario)
                    .addComponent(jt_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombreCompleto)
                    .addComponent(jt_nombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Contraseña)
                    .addComponent(jpf_contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Tipo)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jt_nombreCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jt_nombreCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jt_nombreCompletoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jl_Contraseña;
    private javax.swing.JLabel jl_NombreCompleto;
    private javax.swing.JLabel jl_NombreUsuario;
    private javax.swing.JLabel jl_Tipo;
    private javax.swing.JPasswordField jpf_contraseña;
    private javax.swing.JTextField jt_NombreUsuario;
    private javax.swing.JTextField jt_nombreCompleto;
    // End of variables declaration//GEN-END:variables
}
