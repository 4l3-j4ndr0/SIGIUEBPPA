/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

import java.awt.Color;

/**
 *
 * @author RojeruSan
 */
public class pnl_Gestionar_prod_programa extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    public pnl_Gestionar_prod_programa() {
        initComponents();
      //  new CambiaPanel(panel_contenedor, new paneles.pnlHome());
        this.listar_contrato.setSelected(true);
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_prod_programa_listar());
        color_performed(listar_contrato, add_contrato);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        listar_contrato = new rsbuttom.RSButtonMetro();
        add_contrato = new rsbuttom.RSButtonMetro();
        panel_contenedor = new javax.swing.JPanel();

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/splash_logo.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(128, 128, 131));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Gestionar Contrato");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/splash_logo.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Roboto", 1, 48)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(128, 128, 131));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Gestionar Contrato");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(128, 128, 131));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Gestionar Contrato");

        listar_contrato.setBackground(new java.awt.Color(239, 238, 244));
        listar_contrato.setForeground(new java.awt.Color(128, 128, 131));
        listar_contrato.setText("Listar");
        listar_contrato.setColorHover(new java.awt.Color(204, 204, 204));
        listar_contrato.setColorNormal(new java.awt.Color(239, 238, 244));
        listar_contrato.setColorPressed(new java.awt.Color(204, 204, 204));
        listar_contrato.setColorTextHover(new java.awt.Color(128, 128, 131));
        listar_contrato.setColorTextNormal(new java.awt.Color(128, 128, 131));
        listar_contrato.setColorTextPressed(new java.awt.Color(128, 128, 131));
        listar_contrato.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        listar_contrato.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        listar_contrato.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        listar_contrato.setIconTextGap(25);
        listar_contrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listar_contratoMousePressed(evt);
            }
        });
        listar_contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listar_contratoActionPerformed(evt);
            }
        });

        add_contrato.setBackground(new java.awt.Color(239, 238, 244));
        add_contrato.setForeground(new java.awt.Color(128, 128, 131));
        add_contrato.setText("Añadir");
        add_contrato.setColorHover(new java.awt.Color(204, 204, 204));
        add_contrato.setColorNormal(new java.awt.Color(239, 238, 244));
        add_contrato.setColorPressed(new java.awt.Color(204, 204, 204));
        add_contrato.setColorTextHover(new java.awt.Color(128, 128, 131));
        add_contrato.setColorTextNormal(new java.awt.Color(128, 128, 131));
        add_contrato.setColorTextPressed(new java.awt.Color(128, 128, 131));
        add_contrato.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add_contrato.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        add_contrato.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add_contrato.setIconTextGap(25);
        add_contrato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                add_contratoMousePressed(evt);
            }
        });
        add_contrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_contratoActionPerformed(evt);
            }
        });

        panel_contenedor.setBackground(new java.awt.Color(255, 255, 255));
        panel_contenedor.setLayout(new javax.swing.BoxLayout(panel_contenedor, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listar_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 859, Short.MAX_VALUE)
                            .addComponent(panel_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listar_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_contratoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_contratoMousePressed
        // TODO add your handling code here:
        pressed(add_contrato,listar_contrato);
    }//GEN-LAST:event_add_contratoMousePressed

    private void add_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_contratoActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_prod_programa_añadir());
        color_performed(add_contrato,listar_contrato);
    }//GEN-LAST:event_add_contratoActionPerformed

    public static void color_performed(rsbuttom.RSButtonMetro principal, rsbuttom.RSButtonMetro uno){
        if(principal.isSelected()){
            principal.setColorNormal(new Color(204,204,204));
            principal.setColorHover(new Color(204,204,204));
            principal.setColorPressed(new Color(204,204,204));
            
            uno.setColorNormal(new Color(239,238,244));
            uno.setColorHover(new Color(204,204,204));
            uno.setColorPressed(new Color(204,204,204));
        }else{
            principal.setColorNormal(new Color(239,238,244));
            principal.setColorHover(new Color(204,204,204));
            principal.setColorPressed(new Color(204,204,204));
        }
    }
    
    public static  void pressed(rsbuttom.RSButtonMetro principal, rsbuttom.RSButtonMetro uno){
        principal.setSelected(true);
        uno.setSelected(false);
    }
    
    private void listar_contratoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listar_contratoMousePressed
        // TODO add your handling code here:
        pressed(listar_contrato,add_contrato);
    }//GEN-LAST:event_listar_contratoMousePressed

    private void listar_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar_contratoActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_prod_programa_listar());
        color_performed(listar_contrato,add_contrato);
    }//GEN-LAST:event_listar_contratoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro add_contrato;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private rsbuttom.RSButtonMetro listar_contrato;
    private javax.swing.JPanel panel_contenedor;
    // End of variables declaration//GEN-END:variables
}