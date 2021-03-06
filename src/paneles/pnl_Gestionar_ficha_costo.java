/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import interaccion_bd.opciones_de_gestionar_contrato;
import interaccion_bd.opciones_de_gestionar_usuarios;

/**
 *
 * @author RojeruSan
 */
public class pnl_Gestionar_ficha_costo extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    public pnl_Gestionar_ficha_costo() {
        initComponents();
        listar_ficha_costo.setSelected(true);
         new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_ficha_costo_listar());
        pnl_Gestionar_contrato.color_performed(listar_ficha_costo,add_ficha_costo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        panel_contenedor = new javax.swing.JPanel();
        listar_ficha_costo = new rsbuttom.RSButtonMetro();
        add_ficha_costo = new rsbuttom.RSButtonMetro();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gestionar Ficha de Costo");

        panel_contenedor.setBackground(new java.awt.Color(255, 255, 255));
        panel_contenedor.setLayout(new javax.swing.BoxLayout(panel_contenedor, javax.swing.BoxLayout.LINE_AXIS));

        listar_ficha_costo.setBackground(new java.awt.Color(239, 238, 244));
        listar_ficha_costo.setForeground(new java.awt.Color(128, 128, 131));
        listar_ficha_costo.setText("Listar");
        listar_ficha_costo.setColorHover(new java.awt.Color(204, 204, 204));
        listar_ficha_costo.setColorNormal(new java.awt.Color(239, 238, 244));
        listar_ficha_costo.setColorPressed(new java.awt.Color(204, 204, 204));
        listar_ficha_costo.setColorTextHover(new java.awt.Color(128, 128, 131));
        listar_ficha_costo.setColorTextNormal(new java.awt.Color(128, 128, 131));
        listar_ficha_costo.setColorTextPressed(new java.awt.Color(128, 128, 131));
        listar_ficha_costo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listar_ficha_costo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        listar_ficha_costo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        listar_ficha_costo.setIconTextGap(25);
        listar_ficha_costo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listar_ficha_costoMousePressed(evt);
            }
        });
        listar_ficha_costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listar_ficha_costoActionPerformed(evt);
            }
        });

        add_ficha_costo.setBackground(new java.awt.Color(239, 238, 244));
        add_ficha_costo.setForeground(new java.awt.Color(128, 128, 131));
        add_ficha_costo.setText("Añadir");
        add_ficha_costo.setColorHover(new java.awt.Color(204, 204, 204));
        add_ficha_costo.setColorNormal(new java.awt.Color(239, 238, 244));
        add_ficha_costo.setColorPressed(new java.awt.Color(204, 204, 204));
        add_ficha_costo.setColorTextHover(new java.awt.Color(128, 128, 131));
        add_ficha_costo.setColorTextNormal(new java.awt.Color(128, 128, 131));
        add_ficha_costo.setColorTextPressed(new java.awt.Color(128, 128, 131));
        add_ficha_costo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add_ficha_costo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add_ficha_costo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add_ficha_costo.setIconTextGap(25);
        add_ficha_costo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add_ficha_costoMousePressed(evt);
            }
        });
        add_ficha_costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ficha_costoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                    .addComponent(panel_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listar_ficha_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_ficha_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_ficha_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listar_ficha_costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(panel_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listar_ficha_costoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listar_ficha_costoMousePressed
        // TODO add your handling code here:
        pnl_Gestionar_contrato.pressed(listar_ficha_costo,add_ficha_costo);
    }//GEN-LAST:event_listar_ficha_costoMousePressed

    private void listar_ficha_costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar_ficha_costoActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_ficha_costo_listar());
        pnl_Gestionar_contrato.color_performed(listar_ficha_costo,add_ficha_costo);
    }//GEN-LAST:event_listar_ficha_costoActionPerformed

    private void add_ficha_costoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_ficha_costoMousePressed
        // TODO add your handling code here:
        pnl_Gestionar_contrato.pressed(add_ficha_costo,listar_ficha_costo);
    }//GEN-LAST:event_add_ficha_costoMousePressed

    private void add_ficha_costoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ficha_costoActionPerformed
        // TODO add your handling code here:
        String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='ficha de costo'"
                + "and add_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_ficha_costo_añadir());
        pnl_Gestionar_contrato.color_performed(add_ficha_costo,listar_ficha_costo);
        }else{
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_add_ficha_costoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static rsbuttom.RSButtonMetro add_ficha_costo;
    private javax.swing.JLabel jLabel7;
    public static rsbuttom.RSButtonMetro listar_ficha_costo;
    private javax.swing.JPanel panel_contenedor;
    // End of variables declaration//GEN-END:variables
}
