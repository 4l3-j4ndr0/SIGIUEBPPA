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
import interaccion_bd.consultas_de_gestionar_ekipo;
import interaccion_bd.consultas_de_gestionar_tarj_combustible;
import interaccion_bd.opciones_de_gestionar_contrato;
import interaccion_bd.opciones_de_gestionar_ekipo;
import interaccion_bd.opciones_de_gestionar_tarj_combustible;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
public class de_gestionar_ekipo_editar extends javax.swing.JDialog {
    /**
     * Creates new form ErrorAlert
     */
    public de_gestionar_ekipo_editar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addEventKey();
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        RSUtilities.setCentrarVentana(this);
        RSMoveObject.setMoverVentana(this);
        
        lbl_error_indice_consumo_ekipo_editar.setVisible(false);
        lbl_error_tipo_auto_ekipo_editar.setVisible(false);
        lbl_error_numero_chapa_ekipo_editar.setVisible(false);
       
         
         //################### detectar cambios en los combobox ######################3
        combo_tipo_auto_ekipo_editar.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              lbl_error_tipo_auto_ekipo_editar.setVisible(false);
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        // ##########################################################################
        
        
        deshabilitarPegar();
    }
    
      private void deshabilitarPegar() {
        
        InputMap map1 = indice_consumo_ekipo_editar.getInputMap(indice_consumo_ekipo_editar.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

        
        InputMap map2= numero_chapa_ekipo_editar.getInputMap(numero_chapa_ekipo_editar.WHEN_FOCUSED);
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
                boton_guardar_ekipo_editarActionPerformed(e);
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
        indice_consumo_ekipo_editar = new rojeru_san.rsfield.RSTextMaterial();
        numero_chapa_ekipo_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_numero_chapa_ekipo_editar = new javax.swing.JLabel();
        lbl_error_indice_consumo_ekipo_editar = new javax.swing.JLabel();
        combo_tipo_auto_ekipo_editar = new org.bolivia.combo.SComboBox();
        lbl_error_tipo_auto_ekipo_editar = new javax.swing.JLabel();
        boton_guardar_ekipo_editar = new rojeru_san.RSButtonRiple();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(782, 552));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_ekipo/gestionar_ekipo.jpg"))); // NOI18N

        indice_consumo_ekipo_editar.setForeground(new java.awt.Color(0, 0, 0));
        indice_consumo_ekipo_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        indice_consumo_ekipo_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        indice_consumo_ekipo_editar.setPlaceholder("Índice de consumo...");
        indice_consumo_ekipo_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        indice_consumo_ekipo_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                indice_consumo_ekipo_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                indice_consumo_ekipo_editarKeyTyped(evt);
            }
        });

        numero_chapa_ekipo_editar.setForeground(new java.awt.Color(0, 0, 0));
        numero_chapa_ekipo_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        numero_chapa_ekipo_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        numero_chapa_ekipo_editar.setPlaceholder("Chapa del equipo...");
        numero_chapa_ekipo_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        numero_chapa_ekipo_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numero_chapa_ekipo_editarActionPerformed(evt);
            }
        });
        numero_chapa_ekipo_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numero_chapa_ekipo_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numero_chapa_ekipo_editarKeyTyped(evt);
            }
        });

        lbl_error_numero_chapa_ekipo_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_numero_chapa_ekipo_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_numero_chapa_ekipo_editar.setText("¡Debe ingresar número de chapa!");

        lbl_error_indice_consumo_ekipo_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_indice_consumo_ekipo_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_indice_consumo_ekipo_editar.setText("¡Debe ingresar un índice de consumo!");

        combo_tipo_auto_ekipo_editar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TIPO DE AUTO", "LIGERO", "CARGA" }));
        combo_tipo_auto_ekipo_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tipo_auto_ekipo_editarActionPerformed(evt);
            }
        });

        lbl_error_tipo_auto_ekipo_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_tipo_auto_ekipo_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_tipo_auto_ekipo_editar.setText("¡Debe ingresar un tipo de combustible!");

        boton_guardar_ekipo_editar.setBackground(new java.awt.Color(38, 86, 186));
        boton_guardar_ekipo_editar.setText("Guardar Cambios");
        boton_guardar_ekipo_editar.setColorHover(new java.awt.Color(173, 187, 194));
        boton_guardar_ekipo_editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_guardar_ekipo_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_ekipo_editarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(combo_tipo_auto_ekipo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_error_tipo_auto_ekipo_editar))
                        .addGap(173, 173, 173)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_error_numero_chapa_ekipo_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numero_chapa_ekipo_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(indice_consumo_ekipo_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_error_indice_consumo_ekipo_editar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton_guardar_ekipo_editar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(numero_chapa_ekipo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_numero_chapa_ekipo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(indice_consumo_ekipo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_indice_consumo_ekipo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_tipo_auto_ekipo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_guardar_ekipo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(lbl_error_tipo_auto_ekipo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rSPanelShadow1Layout = new javax.swing.GroupLayout(rSPanelShadow1);
        rSPanelShadow1.setLayout(rSPanelShadow1Layout);
        rSPanelShadow1Layout.setHorizontalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelShadow1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 888, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        rSPanelShadow1Layout.setVerticalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelShadow1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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

    private void boton_guardar_ekipo_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_ekipo_editarActionPerformed
         // TODO add your handling code here:
        String sql="SELECT * FROM `ekipos` WHERE `chapa?ekipo`='"+numero_chapa_ekipo_editar+"'";
        String mje1="La tarjeta que intenta introducir al sistema ya existe";
        String mje2="Por favor introduzca una nueva";
        if (combo_tipo_auto_ekipo_editar.getSelectedIndex()==0 || numero_chapa_ekipo_editar.getText().isEmpty()||
            indice_consumo_ekipo_editar.getText().isEmpty()) {
             if(numero_chapa_ekipo_editar.getText().isEmpty()){
                numero_chapa_ekipo_editar.requestFocus();
                lbl_error_numero_chapa_ekipo_editar.setText("¡Debe ingresar número de chapa!");
                lbl_error_numero_chapa_ekipo_editar.setVisible(true);
            }else if(indice_consumo_ekipo_editar.getText().isEmpty()){
                indice_consumo_ekipo_editar.requestFocus();
                lbl_error_indice_consumo_ekipo_editar.setVisible(true);
            }else if(combo_tipo_auto_ekipo_editar.getSelectedIndex()==0){
                combo_tipo_auto_ekipo_editar.requestFocus();
                lbl_error_tipo_auto_ekipo_editar.setVisible(true);
            }else if (interaccion_bd.opciones_de_gestionar_contrato.existe(numero_chapa_ekipo_editar.getText(), sql)) {
                opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mje1,mje2,"");
                numero_chapa_ekipo_editar.requestFocus();
            }
        } else {
            Runnable runnable1 = new Runnable() {
                public void run() {
                    Guardando_general l = new Guardando_general(new JFrame(), true);
                    consultas_de_gestionar_ekipo uc=new consultas_de_gestionar_ekipo();
                    l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_ekipo_editar.this);
                    l.setVisible(true);
                    try{            //toma_fecha()
                        paneles_de_paneles.de_gestionar_ekipo_editar.this.setEnabled(false);
                        uc.setTipo_auto(combo_tipo_auto_ekipo_editar.getSelectedItem().toString());
                        uc.setNumero_chapa(numero_chapa_ekipo_editar.getText());
                        uc.setIndice_consumo(indice_consumo_ekipo_editar.getText());
                        int control= opciones_de_gestionar_ekipo.actualizar(uc);
                        reset_campos();
                        paneles_de_paneles.de_gestionar_ekipo_editar.this.setEnabled(true);
                        l.setVisible(false);
                        if(control==1){
                            SuccessAlert e = new SuccessAlert(new JFrame(), true);
                            e.msj1.setText("¡Los datos del equipo fueron");
                            e.msj2.setText("guardados exitosamente!.");
                            e.msj3.setText("");
                            e.setVisible(true);
                            opciones_de_gestionar_ekipo.setListar("");
                        }

                    }catch(Exception e){
                        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, e);
                        error.msj1.setText(e.toString());
                        error.msj2.setText("Por favor solucione el error antes de volver a intentarlo.");
                        error.msj3.setText("En caso de no saber como corregir el error, por favor contacte con soporte técnico");
                        error.preferredSize();
                        error.pack();
                        error.setVisible(true);
                    }
                }
            };
            Thread t1 = new Thread(runnable1);
            t1.start();
            this.dispose();
        }
    }//GEN-LAST:event_boton_guardar_ekipo_editarActionPerformed

    private void combo_tipo_auto_ekipo_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tipo_auto_ekipo_editarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tipo_auto_ekipo_editarActionPerformed

    
    int pto=0;
    int lugares=0;
    private void indice_consumo_ekipo_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_indice_consumo_ekipo_editarKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if(caracter=='.'){
            pto++;
        }
         if( pto>=2){
            pto=2;
           }
        if( lugares>=3){
            lugares--;
           }
        
        if(caracter == KeyEvent.VK_BACK_SPACE){
          if( pto>=0){
            lugares--;
           }
          
          if(!indice_consumo_ekipo_editar.getText().contains(".")){
              pto=0;
          }
          if( pto==0){
            lugares=0;
           }
        }
        if (indice_consumo_ekipo_editar.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(indice_consumo_ekipo_editar.getText().length()<10){     
        char num = evt.getKeyChar();
        if (Character.isDigit(num)||num=='.') {
            if(num=='.'&&pto<2){
                   // escribe
                }else{
                if(pto!=0&&num!='.'){
                lugares++;
                }
                if(lugares<3 && num!='.'){
                    // escribe
                }else{
                    evt.consume();
                }
                }
        }else{
            evt.consume();
        }
        }else{
            evt.consume();
        }
        }
        
    }//GEN-LAST:event_indice_consumo_ekipo_editarKeyTyped

    private void indice_consumo_ekipo_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_indice_consumo_ekipo_editarKeyReleased
        // TODO add your handling code here:
        if(indice_consumo_ekipo_editar.getText().length()>0){
            lbl_error_indice_consumo_ekipo_editar.setVisible(false);
        }
    }//GEN-LAST:event_indice_consumo_ekipo_editarKeyReleased

    private void numero_chapa_ekipo_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numero_chapa_ekipo_editarKeyTyped
        // TODO add your handling code here:
        if (numero_chapa_ekipo_editar.getText().length() > 0 &&numero_chapa_ekipo_editar.getText().length() < 7) {
            char car = evt.getKeyChar();
            if (Character.isDigit(car)) {
            } else {
                evt.consume();
            }

        }else{
            if(numero_chapa_ekipo_editar.getText().length() < 7){
                char car = evt.getKeyChar();
                if ( Character.isLetter(car)) {
                } else {
                    evt.consume();
                }
            }else{
                evt.consume();
            }
        }
    }//GEN-LAST:event_numero_chapa_ekipo_editarKeyTyped

    private void numero_chapa_ekipo_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numero_chapa_ekipo_editarKeyReleased
        // TODO add your handling code here:
        if(numero_chapa_ekipo_editar.getText().length()>0){
            lbl_error_numero_chapa_ekipo_editar.setVisible(false);
            char car = numero_chapa_ekipo_editar.getText().charAt(0);
            car=Character.toUpperCase(car);
            String txt=numero_chapa_ekipo_editar.getText().substring(1);
            numero_chapa_ekipo_editar.setText(String.valueOf(car)+txt);
        }
    }//GEN-LAST:event_numero_chapa_ekipo_editarKeyReleased

    private void numero_chapa_ekipo_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numero_chapa_ekipo_editarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numero_chapa_ekipo_editarActionPerformed

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
    
    public static String convierte_fecha_string(Date fecha) {      
        String txt_fecha = null;
        if (fecha != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            txt_fecha=String.valueOf(sdf.format(fecha));
        }
        return txt_fecha;
    }  
    
    
    // tomar fecha en string y pasarla a date
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
        indice_consumo_ekipo_editar.setText("");
        numero_chapa_ekipo_editar.setText("");
        combo_tipo_auto_ekipo_editar.setSelectedIndex(0);
        lbl_error_indice_consumo_ekipo_editar.setVisible(false);
        lbl_error_tipo_auto_ekipo_editar.setVisible(false);
        lbl_error_numero_chapa_ekipo_editar.setVisible(false);
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
            java.util.logging.Logger.getLogger(de_gestionar_ekipo_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_ekipo_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_ekipo_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_ekipo_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                de_gestionar_ekipo_editar dialog = new de_gestionar_ekipo_editar(new javax.swing.JFrame(), true);
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
    private rojeru_san.RSButtonRiple boton_guardar_ekipo_editar;
    public static org.bolivia.combo.SComboBox combo_tipo_auto_ekipo_editar;
    public static rojeru_san.rsfield.RSTextMaterial indice_consumo_ekipo_editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_error_indice_consumo_ekipo_editar;
    private javax.swing.JLabel lbl_error_numero_chapa_ekipo_editar;
    private javax.swing.JLabel lbl_error_tipo_auto_ekipo_editar;
    public static rojeru_san.rsfield.RSTextMaterial numero_chapa_ekipo_editar;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
}