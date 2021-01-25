/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import interaccion_bd.opciones_de_gestionar_contrato;
import interaccion_bd.opciones_de_gestionar_usuarios;
import java.awt.Color;

/**
 *
 * @author RojeruSan
 */
public class pnl_Gestionar_prep_tecnica extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    public pnl_Gestionar_prep_tecnica() {
        initComponents();
        this.listar_prep_tecnica.setSelected(true);
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_prep_tecnica_listar());
        color_performed(listar_prep_tecnica,add_prep_tecnica,preModelo_prep_tecnica);
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
        listar_prep_tecnica = new rsbuttom.RSButtonMetro();
        add_prep_tecnica = new rsbuttom.RSButtonMetro();
        panel_contenedor = new javax.swing.JPanel();
        preModelo_prep_tecnica = new rsbuttom.RSButtonMetro();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gestionar Preparación técnica");

        listar_prep_tecnica.setBackground(new java.awt.Color(239, 238, 244));
        listar_prep_tecnica.setForeground(new java.awt.Color(128, 128, 131));
        listar_prep_tecnica.setText("Listar");
        listar_prep_tecnica.setColorHover(new java.awt.Color(204, 204, 204));
        listar_prep_tecnica.setColorNormal(new java.awt.Color(239, 238, 244));
        listar_prep_tecnica.setColorPressed(new java.awt.Color(204, 204, 204));
        listar_prep_tecnica.setColorTextHover(new java.awt.Color(128, 128, 131));
        listar_prep_tecnica.setColorTextNormal(new java.awt.Color(128, 128, 131));
        listar_prep_tecnica.setColorTextPressed(new java.awt.Color(128, 128, 131));
        listar_prep_tecnica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listar_prep_tecnica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        listar_prep_tecnica.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        listar_prep_tecnica.setIconTextGap(25);
        listar_prep_tecnica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listar_prep_tecnicaMousePressed(evt);
            }
        });
        listar_prep_tecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listar_prep_tecnicaActionPerformed(evt);
            }
        });

        add_prep_tecnica.setBackground(new java.awt.Color(239, 238, 244));
        add_prep_tecnica.setForeground(new java.awt.Color(128, 128, 131));
        add_prep_tecnica.setText("Añadir");
        add_prep_tecnica.setColorHover(new java.awt.Color(204, 204, 204));
        add_prep_tecnica.setColorNormal(new java.awt.Color(239, 238, 244));
        add_prep_tecnica.setColorPressed(new java.awt.Color(204, 204, 204));
        add_prep_tecnica.setColorTextHover(new java.awt.Color(128, 128, 131));
        add_prep_tecnica.setColorTextNormal(new java.awt.Color(128, 128, 131));
        add_prep_tecnica.setColorTextPressed(new java.awt.Color(128, 128, 131));
        add_prep_tecnica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add_prep_tecnica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add_prep_tecnica.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add_prep_tecnica.setIconTextGap(25);
        add_prep_tecnica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add_prep_tecnicaMousePressed(evt);
            }
        });
        add_prep_tecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_prep_tecnicaActionPerformed(evt);
            }
        });

        panel_contenedor.setBackground(new java.awt.Color(255, 255, 255));
        panel_contenedor.setLayout(new javax.swing.BoxLayout(panel_contenedor, javax.swing.BoxLayout.LINE_AXIS));

        preModelo_prep_tecnica.setBackground(new java.awt.Color(239, 238, 244));
        preModelo_prep_tecnica.setForeground(new java.awt.Color(128, 128, 131));
        preModelo_prep_tecnica.setText("PRE- MODELO MERCANTIL");
        preModelo_prep_tecnica.setColorHover(new java.awt.Color(204, 204, 204));
        preModelo_prep_tecnica.setColorNormal(new java.awt.Color(239, 238, 244));
        preModelo_prep_tecnica.setColorPressed(new java.awt.Color(204, 204, 204));
        preModelo_prep_tecnica.setColorTextHover(new java.awt.Color(128, 128, 131));
        preModelo_prep_tecnica.setColorTextNormal(new java.awt.Color(128, 128, 131));
        preModelo_prep_tecnica.setColorTextPressed(new java.awt.Color(128, 128, 131));
        preModelo_prep_tecnica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        preModelo_prep_tecnica.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        preModelo_prep_tecnica.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        preModelo_prep_tecnica.setIconTextGap(25);
        preModelo_prep_tecnica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                preModelo_prep_tecnicaMousePressed(evt);
            }
        });
        preModelo_prep_tecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preModelo_prep_tecnicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listar_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preModelo_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listar_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preModelo_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_prep_tecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_prep_tecnicaActionPerformed
        // TODO add your handling code here:
        String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='preparación técnica'"
                + "and add_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_prep_tecnica_añadir());
        pnl_Gestionar_contrato.color_performed(add_prep_tecnica,listar_prep_tecnica);
        }else{
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_add_prep_tecnicaActionPerformed

    private void add_prep_tecnicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_prep_tecnicaMousePressed
        // TODO add your handling code here:
        pressed(add_prep_tecnica,listar_prep_tecnica,preModelo_prep_tecnica);
    }//GEN-LAST:event_add_prep_tecnicaMousePressed

    private void listar_prep_tecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar_prep_tecnicaActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_prep_tecnica_listar());
        color_performed(listar_prep_tecnica,add_prep_tecnica,preModelo_prep_tecnica);
    }//GEN-LAST:event_listar_prep_tecnicaActionPerformed

    private void listar_prep_tecnicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listar_prep_tecnicaMousePressed
        // TODO add your handling code here:
        pressed(listar_prep_tecnica,add_prep_tecnica,preModelo_prep_tecnica);
    }//GEN-LAST:event_listar_prep_tecnicaMousePressed

    private void preModelo_prep_tecnicaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_preModelo_prep_tecnicaMousePressed
        // TODO add your handling code here:
         pressed(preModelo_prep_tecnica,listar_prep_tecnica,add_prep_tecnica);
    }//GEN-LAST:event_preModelo_prep_tecnicaMousePressed

    private void preModelo_prep_tecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preModelo_prep_tecnicaActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_prep_tecnica_preModelo_mercantil_listar());
        color_performed(preModelo_prep_tecnica,listar_prep_tecnica,add_prep_tecnica);
    }//GEN-LAST:event_preModelo_prep_tecnicaActionPerformed

    public static void color_performed(rsbuttom.RSButtonMetro principal, rsbuttom.RSButtonMetro uno, rsbuttom.RSButtonMetro dos){
        if(principal.isSelected()){
            principal.setColorNormal(new Color(204,204,204));
            principal.setColorHover(new Color(204,204,204));
            principal.setColorPressed(new Color(204,204,204));
            
            uno.setColorNormal(new Color(239,238,244));
            uno.setColorHover(new Color(204,204,204));
            uno.setColorPressed(new Color(204,204,204));
            
            dos.setColorNormal(new Color(239,238,244));
            dos.setColorHover(new Color(204,204,204));
            dos.setColorPressed(new Color(204,204,204));
        }else{
            principal.setColorNormal(new Color(239,238,244));
            principal.setColorHover(new Color(204,204,204));
            principal.setColorPressed(new Color(204,204,204));
        }
    }
    
    public static  void pressed(rsbuttom.RSButtonMetro principal, rsbuttom.RSButtonMetro uno, rsbuttom.RSButtonMetro dos){
        principal.setSelected(true);
        uno.setSelected(false);
        dos.setSelected(false);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static rsbuttom.RSButtonMetro add_prep_tecnica;
    private javax.swing.JLabel jLabel7;
    public static rsbuttom.RSButtonMetro listar_prep_tecnica;
    public static javax.swing.JPanel panel_contenedor;
    public static rsbuttom.RSButtonMetro preModelo_prep_tecnica;
    // End of variables declaration//GEN-END:variables
}
