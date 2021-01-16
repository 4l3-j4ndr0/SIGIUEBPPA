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
public class pnl_Gestionar_info_laboratorio extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    public pnl_Gestionar_info_laboratorio() {
        initComponents();
        listar_info_lab.setSelected(true);
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_info_laboratorio_listar());
        pnl_Gestionar_contrato.color_performed(listar_info_lab,add_info_lab);
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
        add_info_lab = new rsbuttom.RSButtonMetro();
        listar_info_lab = new rsbuttom.RSButtonMetro();
        panel_contenedor = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gestionar Información del Laboratorio");

        add_info_lab.setBackground(new java.awt.Color(239, 238, 244));
        add_info_lab.setForeground(new java.awt.Color(128, 128, 131));
        add_info_lab.setText("Añadir");
        add_info_lab.setColorHover(new java.awt.Color(204, 204, 204));
        add_info_lab.setColorNormal(new java.awt.Color(239, 238, 244));
        add_info_lab.setColorPressed(new java.awt.Color(204, 204, 204));
        add_info_lab.setColorTextHover(new java.awt.Color(128, 128, 131));
        add_info_lab.setColorTextNormal(new java.awt.Color(128, 128, 131));
        add_info_lab.setColorTextPressed(new java.awt.Color(128, 128, 131));
        add_info_lab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add_info_lab.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add_info_lab.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add_info_lab.setIconTextGap(25);
        add_info_lab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add_info_labMousePressed(evt);
            }
        });
        add_info_lab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_info_labActionPerformed(evt);
            }
        });

        listar_info_lab.setBackground(new java.awt.Color(239, 238, 244));
        listar_info_lab.setForeground(new java.awt.Color(128, 128, 131));
        listar_info_lab.setText("Listar");
        listar_info_lab.setColorHover(new java.awt.Color(204, 204, 204));
        listar_info_lab.setColorNormal(new java.awt.Color(239, 238, 244));
        listar_info_lab.setColorPressed(new java.awt.Color(204, 204, 204));
        listar_info_lab.setColorTextHover(new java.awt.Color(128, 128, 131));
        listar_info_lab.setColorTextNormal(new java.awt.Color(128, 128, 131));
        listar_info_lab.setColorTextPressed(new java.awt.Color(128, 128, 131));
        listar_info_lab.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listar_info_lab.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        listar_info_lab.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        listar_info_lab.setIconTextGap(25);
        listar_info_lab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listar_info_labMousePressed(evt);
            }
        });
        listar_info_lab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listar_info_labActionPerformed(evt);
            }
        });

        panel_contenedor.setBackground(new java.awt.Color(255, 255, 255));
        panel_contenedor.setLayout(new javax.swing.BoxLayout(panel_contenedor, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(listar_info_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_info_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_info_lab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listar_info_lab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_info_labMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_info_labMousePressed
        // TODO add your handling code here:
        pnl_Gestionar_contrato.pressed(add_info_lab,listar_info_lab);
    }//GEN-LAST:event_add_info_labMousePressed

    private void add_info_labActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_info_labActionPerformed
        // TODO add your handling code here:
        String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='información de laboratorio'"
                + "and add_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_info_laboratorio_añadir());
        pnl_Gestionar_contrato.color_performed(add_info_lab,listar_info_lab);
        }else{
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_add_info_labActionPerformed

    private void listar_info_labMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listar_info_labMousePressed
        // TODO add your handling code here:
        pnl_Gestionar_contrato.pressed(listar_info_lab,add_info_lab);
    }//GEN-LAST:event_listar_info_labMousePressed

    private void listar_info_labActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar_info_labActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_info_laboratorio_listar());
        pnl_Gestionar_contrato.color_performed(listar_info_lab,add_info_lab);
    }//GEN-LAST:event_listar_info_labActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static rsbuttom.RSButtonMetro add_info_lab;
    private javax.swing.JLabel jLabel7;
    public static rsbuttom.RSButtonMetro listar_info_lab;
    private javax.swing.JPanel panel_contenedor;
    // End of variables declaration//GEN-END:variables
}
