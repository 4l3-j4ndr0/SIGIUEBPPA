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
public class pnl_Gestionar_equipo extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    public pnl_Gestionar_equipo() {
        initComponents();
        listar_ekipo.setSelected(true);
         new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_ekipo_listar());
        pnl_Gestionar_contrato.color_performed(listar_ekipo,add_ekipo);
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
        add_ekipo = new rsbuttom.RSButtonMetro();
        listar_ekipo = new rsbuttom.RSButtonMetro();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(128, 128, 131));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gestionar Equipos");

        panel_contenedor.setBackground(new java.awt.Color(255, 255, 255));
        panel_contenedor.setLayout(new javax.swing.BoxLayout(panel_contenedor, javax.swing.BoxLayout.LINE_AXIS));

        add_ekipo.setBackground(new java.awt.Color(239, 238, 244));
        add_ekipo.setForeground(new java.awt.Color(128, 128, 131));
        add_ekipo.setText("Añadir");
        add_ekipo.setColorHover(new java.awt.Color(204, 204, 204));
        add_ekipo.setColorNormal(new java.awt.Color(239, 238, 244));
        add_ekipo.setColorPressed(new java.awt.Color(204, 204, 204));
        add_ekipo.setColorTextHover(new java.awt.Color(128, 128, 131));
        add_ekipo.setColorTextNormal(new java.awt.Color(128, 128, 131));
        add_ekipo.setColorTextPressed(new java.awt.Color(128, 128, 131));
        add_ekipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add_ekipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add_ekipo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add_ekipo.setIconTextGap(25);
        add_ekipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add_ekipoMousePressed(evt);
            }
        });
        add_ekipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ekipoActionPerformed(evt);
            }
        });

        listar_ekipo.setBackground(new java.awt.Color(239, 238, 244));
        listar_ekipo.setForeground(new java.awt.Color(128, 128, 131));
        listar_ekipo.setText("Listar");
        listar_ekipo.setColorHover(new java.awt.Color(204, 204, 204));
        listar_ekipo.setColorNormal(new java.awt.Color(239, 238, 244));
        listar_ekipo.setColorPressed(new java.awt.Color(204, 204, 204));
        listar_ekipo.setColorTextHover(new java.awt.Color(128, 128, 131));
        listar_ekipo.setColorTextNormal(new java.awt.Color(128, 128, 131));
        listar_ekipo.setColorTextPressed(new java.awt.Color(128, 128, 131));
        listar_ekipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listar_ekipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        listar_ekipo.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        listar_ekipo.setIconTextGap(25);
        listar_ekipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listar_ekipoMousePressed(evt);
            }
        });
        listar_ekipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listar_ekipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_contenedor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listar_ekipo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_ekipo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_ekipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listar_ekipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_ekipoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_ekipoMousePressed
        // TODO add your handling code here:
        pnl_Gestionar_contrato.pressed(add_ekipo, listar_ekipo);
    }//GEN-LAST:event_add_ekipoMousePressed

    private void add_ekipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ekipoActionPerformed
        // TODO add your handling code here:
         String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='equipo'"
                + "and add_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_ekipo_añadir());
        pnl_Gestionar_contrato.color_performed(add_ekipo,listar_ekipo);
        }else{
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_add_ekipoActionPerformed

    private void listar_ekipoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listar_ekipoMousePressed
        // TODO add your handling code here:
        pnl_Gestionar_contrato.pressed(listar_ekipo,add_ekipo);
    }//GEN-LAST:event_listar_ekipoMousePressed

    private void listar_ekipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar_ekipoActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_ekipo_listar());
        pnl_Gestionar_contrato.color_performed(listar_ekipo,add_ekipo);
    }//GEN-LAST:event_listar_ekipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro add_ekipo;
    private javax.swing.JLabel jLabel7;
    private rsbuttom.RSButtonMetro listar_ekipo;
    private javax.swing.JPanel panel_contenedor;
    // End of variables declaration//GEN-END:variables
}
