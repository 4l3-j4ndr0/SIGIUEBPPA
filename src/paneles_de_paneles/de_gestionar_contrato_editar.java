/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles_de_paneles;

import alertas.*;
import com.toedter.calendar.JDateChooser;
import esperas.Guardando_general;
import interaccion_bd.consultas_de_gestionar_contrato;
import interaccion_bd.opciones_de_gestionar_contrato;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import necesario.RSAWTUtilities;
import static paneles_de_paneles.de_gestionar_contrato_añadir.nombre_cliente_contrato;
import static paneles_de_paneles.de_gestionar_contrato_añadir.numero_contrato;
import rojeru_san.complementos.RSMoveObject;
import rojeru_san.complementos.RSUtilities;

/**
 *
 * @author RojeruSan
 */
public class de_gestionar_contrato_editar extends javax.swing.JDialog {

    /**
     * Creates new form ErrorAlert
     */
    public de_gestionar_contrato_editar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addEventKey();
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        RSUtilities.setCentrarVentana(this);
        RSMoveObject.setMoverVentana(this);
        
        lbl_error_numero_contrato_editar.setVisible(false);
        lbl_error_nombre_cliente_editar.setVisible(false);
        lbl.setVisible(false);
        lbl_error_fecha_inicio_editar.setVisible(false);
        id.setVisible(false);
        
         //  detectar cambio en jdateChoser (fecha de inicio en agregar contrato)
        fecha_inicio_contrato_editar.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    System.out.println(e.getPropertyName()
                            + ": " + (Date) e.getNewValue());
                    if(fecha_inicio_contrato_editar.getDate()!=null){
                    lbl_fecha_expira_contrato_editar.setText(toma_fecha(fecha_inicio_contrato_editar).substring(0,6)+String.valueOf(Integer.parseInt(toma_fecha(fecha_inicio_contrato_editar).substring(6))+1));
                    lbl.setVisible(true);
                    lbl_fecha_expira_contrato_editar.setVisible(true);
                    }
                }else{
                    lbl_fecha_expira_contrato_editar.setText("");
                    lbl_error_fecha_inicio_editar.setVisible(false);
                    lbl.setVisible(false);
                    lbl_fecha_expira_contrato_editar.setVisible(false);
                }
            }
        });
      deshabilitarPegar();
    }
    
     private void deshabilitarPegar() {
        InputMap map1 = numero_contrato_editar.getInputMap(numero_contrato_editar.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

        InputMap map2 = nombre_cliente_contrato_editar.getInputMap(nombre_cliente_contrato_editar.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
    
    private void addEventKey() {
        KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false);
        Action escapeAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escape, "ESCAPE");
        getRootPane().getActionMap().put("ESCAPE", escapeAction);
//----------------------------------------------------------------------------------------------
         KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false);
        Action enterAction = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enter, "ENTER");
        getRootPane().getActionMap().put("ENTER", enterAction);
        
       
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSPanelShadow1 = new rojeru_san.rspanel.RSPanelShadow();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        numero_contrato_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_numero_contrato_editar = new javax.swing.JLabel();
        nombre_cliente_contrato_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_nombre_cliente_editar = new javax.swing.JLabel();
        fecha_inicio_contrato_editar = new com.toedter.calendar.JDateChooser();
        lbl = new javax.swing.JLabel();
        lbl_fecha_expira_contrato_editar = new javax.swing.JLabel();
        lbl_error_fecha_inicio_editar = new javax.swing.JLabel();
        boton_guardar_contrato_editar = new rojeru_san.RSButtonRiple();
        id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(782, 552));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_coontrato/contrato2.png"))); // NOI18N

        numero_contrato_editar.setForeground(new java.awt.Color(0, 0, 0));
        numero_contrato_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        numero_contrato_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        numero_contrato_editar.setPlaceholder("Número de contrato...");
        numero_contrato_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        numero_contrato_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numero_contrato_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numero_contrato_editarKeyTyped(evt);
            }
        });

        lbl_error_numero_contrato_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_numero_contrato_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_numero_contrato_editar.setText("¡Debe ingresar número de contrato!");

        nombre_cliente_contrato_editar.setForeground(new java.awt.Color(0, 0, 0));
        nombre_cliente_contrato_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        nombre_cliente_contrato_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nombre_cliente_contrato_editar.setPlaceholder("Nombre cliente...");
        nombre_cliente_contrato_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        nombre_cliente_contrato_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombre_cliente_contrato_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_cliente_contrato_editarKeyTyped(evt);
            }
        });

        lbl_error_nombre_cliente_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_nombre_cliente_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_nombre_cliente_editar.setText("¡Debe ingresar un nombre de cliente!");

        fecha_inicio_contrato_editar.setDateFormatString("dd/MM/yyyy");
        fecha_inicio_contrato_editar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl.setForeground(new java.awt.Color(0, 0, 0));
        lbl.setText("Fecha de vencimiento: ");

        lbl_fecha_expira_contrato_editar.setForeground(new java.awt.Color(0, 0, 0));
        lbl_fecha_expira_contrato_editar.setText("FECHA");

        lbl_error_fecha_inicio_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_inicio_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_fecha_inicio_editar.setText("¡Debe ingresar una fecha de inicio!");

        boton_guardar_contrato_editar.setBackground(new java.awt.Color(38, 86, 186));
        boton_guardar_contrato_editar.setText("Guardar Cambios");
        boton_guardar_contrato_editar.setColorHover(new java.awt.Color(173, 187, 194));
        boton_guardar_contrato_editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_guardar_contrato_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_contrato_editarActionPerformed(evt);
            }
        });

        id.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(468, Short.MAX_VALUE)
                .addComponent(id)
                .addGap(273, 273, 273))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addComponent(jLabel1)
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numero_contrato_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(fecha_inicio_contrato_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl)
                            .addGap(0, 0, 0)
                            .addComponent(lbl_fecha_expira_contrato_editar))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbl_error_nombre_cliente_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nombre_cliente_contrato_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_error_numero_contrato_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(boton_guardar_contrato_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_error_fecha_inicio_editar))
                    .addContainerGap(52, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(id)
                .addContainerGap(501, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(95, 95, 95)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(numero_contrato_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_error_numero_contrato_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(nombre_cliente_contrato_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, 0)
                            .addComponent(lbl_error_nombre_cliente_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fecha_inicio_contrato_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_fecha_expira_contrato_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbl_error_fecha_inicio_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(boton_guardar_contrato_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel1))
                    .addContainerGap(95, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout rSPanelShadow1Layout = new javax.swing.GroupLayout(rSPanelShadow1);
        rSPanelShadow1.setLayout(rSPanelShadow1Layout);
        rSPanelShadow1Layout.setHorizontalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelShadow1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        rSPanelShadow1Layout.setVerticalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelShadow1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numero_contrato_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numero_contrato_editarKeyReleased
        // TODO add your handling code here:
        if(numero_contrato_editar.getText().length()>0){
            lbl_error_numero_contrato_editar.setVisible(false);
        }
    }//GEN-LAST:event_numero_contrato_editarKeyReleased

    private void numero_contrato_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numero_contrato_editarKeyTyped
        // TODO add your handling code here:
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();

        }
    }//GEN-LAST:event_numero_contrato_editarKeyTyped

    private void nombre_cliente_contrato_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_cliente_contrato_editarKeyReleased
        // TODO add your handling code here:
        if(nombre_cliente_contrato_editar.getText().length()>0){
            lbl_error_nombre_cliente_editar.setVisible(false);
        }
    }//GEN-LAST:event_nombre_cliente_contrato_editarKeyReleased

    private void nombre_cliente_contrato_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_cliente_contrato_editarKeyTyped
        // TODO add your handling code here:
        char letras = evt.getKeyChar();
        if ((letras < 'a' || letras > 'z') && (letras < 'A' | letras > 'Z')) {
            if ((letras != 'ñ') && (letras != 'Ñ') && (letras != 'á') && (letras != 'Á') && (letras != 'é') && (letras != 'É') && (letras != 'í')
                && (letras != 'Í') && (letras != 'ó') && (letras != 'Ó') && (letras != 'ú') && (letras != 'Ú') && (letras != ' ')) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_nombre_cliente_contrato_editarKeyTyped

    private void boton_guardar_contrato_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_contrato_editarActionPerformed
        if (nombre_cliente_contrato_editar.getText().isEmpty()||numero_contrato_editar.getText().isEmpty()||fecha_inicio_contrato_editar.getDate()==null) {
            if(numero_contrato_editar.getText().isEmpty()){
                numero_contrato_editar.requestFocus();
                lbl_error_numero_contrato_editar.setVisible(true);
            }else if(nombre_cliente_contrato_editar.getText().isEmpty()){
                nombre_cliente_contrato_editar.requestFocus();
                lbl_error_nombre_cliente_editar.setVisible(true);
            }else if(fecha_inicio_contrato_editar.getDate()==null){
                fecha_inicio_contrato_editar.requestFocus();
                lbl_error_fecha_inicio_editar.setVisible(true);
            }
        } else {
            Runnable runnable1 = new Runnable() {
                public void run() {
                    Guardando_general l = new Guardando_general(new JFrame(), true);
                    consultas_de_gestionar_contrato uc=new consultas_de_gestionar_contrato();
                    l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_contrato_editar.this);
                    l.setVisible(true);
                    try{
                        paneles_de_paneles.de_gestionar_contrato_editar.this.setEnabled(false);
                        uc.setNumero_contrato(numero_contrato_editar.getText());
                        uc.setNombre_contrato(nombre_cliente_contrato_editar.getText());
                        uc.setFecha_inicio_contrato(toma_fecha(fecha_inicio_contrato_editar));
                        uc.setFecha_final_contrato(lbl_fecha_expira_contrato_editar.getText());
                        uc.setPrimaryKey(id.getText());
                        int control= opciones_de_gestionar_contrato.actualizar(uc);
                        reset_campos();
                        paneles_de_paneles.de_gestionar_contrato_editar.this.setEnabled(true);
                        l.setVisible(false);
                        if(control==1){
                            opciones_de_gestionar_contrato.setListar("");
                            SuccessAlert e = new SuccessAlert(new JFrame(), true);
                            e.msj1.setText("¡Los datos del contrato fueron");
                            e.msj2.setText("guardados exitosamente!.");
                            e.msj3.setText("");
                            e.setVisible(true);
                        }
                    }catch(Exception e){
                        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, e);
                        error.msj1.setText(e.toString());
                        error.msj2.setText("Por favor solucione el error antes de volver a intentarlo.");
                        error.msj3.setText("En caso de no saber como corregir el error, por favor contacte con soporte técnico");
                        error.setVisible(true);
                    }
                }
            };
            Thread t1 = new Thread(runnable1);
            t1.start();
            this.dispose();
        }
    }//GEN-LAST:event_boton_guardar_contrato_editarActionPerformed

    public static String toma_fecha(JDateChooser fecha) {      
        String txt_fecha = null;
        if (fecha.getDate() != null) {
             String formato = fecha.getDateFormatString();
            Date date = fecha.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            txt_fecha=String.valueOf(sdf.format(date));
        }
        return txt_fecha;
    }   
    
     public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
    
    private void reset_campos(){
        numero_contrato_editar.setText("");
        nombre_cliente_contrato_editar.setText("");
        fecha_inicio_contrato_editar.setDate(null);
        lbl.setVisible(false);
        lbl_fecha_expira_contrato_editar.setVisible(false);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_contrato_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_contrato_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_contrato_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_contrato_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                de_gestionar_contrato_editar dialog = new de_gestionar_contrato_editar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple boton_guardar_contrato_editar;
    public static com.toedter.calendar.JDateChooser fecha_inicio_contrato_editar;
    public static javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lbl_error_fecha_inicio_editar;
    private javax.swing.JLabel lbl_error_nombre_cliente_editar;
    private javax.swing.JLabel lbl_error_numero_contrato_editar;
    public static javax.swing.JLabel lbl_fecha_expira_contrato_editar;
    public static rojeru_san.rsfield.RSTextMaterial nombre_cliente_contrato_editar;
    public static rojeru_san.rsfield.RSTextMaterial numero_contrato_editar;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
}