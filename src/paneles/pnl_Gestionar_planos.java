/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles;

/**
 *
 * @author RojeruSan
 */
public class pnl_Gestionar_planos extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    public pnl_Gestionar_planos() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        listar_contrato = new rsbuttom.RSButtonMetro();
        add_contrato = new rsbuttom.RSButtonMetro();
        panel_contenedor = new javax.swing.JPanel();

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
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listar_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(add_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panel_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listar_contrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel_contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void listar_contratoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listar_contratoMousePressed
        // TODO add your handling code here:
        pnl_Gestionar_contrato.pressed(listar_contrato,add_contrato);
    }//GEN-LAST:event_listar_contratoMousePressed

    private void listar_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listar_contratoActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_plano_listar());
        pnl_Gestionar_contrato.color_performed(listar_contrato,add_contrato);
    }//GEN-LAST:event_listar_contratoActionPerformed

    private void add_contratoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_contratoMousePressed
        // TODO add your handling code here:
        pnl_Gestionar_contrato.pressed(add_contrato,listar_contrato);
    }//GEN-LAST:event_add_contratoMousePressed

    private void add_contratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_contratoActionPerformed
        // TODO add your handling code here:
        new CambiaPanel(panel_contenedor, new paneles_de_paneles.de_gestionar_plano_añadir());
        pnl_Gestionar_contrato.color_performed(add_contrato,listar_contrato);
    }//GEN-LAST:event_add_contratoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro add_contrato;
    private javax.swing.JLabel jLabel9;
    private rsbuttom.RSButtonMetro listar_contrato;
    private javax.swing.JPanel panel_contenedor;
    // End of variables declaration//GEN-END:variables
}