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
import interaccion_bd.consultas_de_gestionar_tarj_combustible;
import interaccion_bd.opciones_de_gestionar_contrato;
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
public class de_gestionar_info_laboratorio_editar extends javax.swing.JDialog {
    /**
     * Creates new form ErrorAlert
     */
    public de_gestionar_info_laboratorio_editar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addEventKey();
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        RSUtilities.setCentrarVentana(this);
        RSMoveObject.setMoverVentana(this);
        
        lbl_error_cant_litro_tarjeta_editar1.setVisible(false);
        lbl_error_numero_tarjeta_editar1.setVisible(false);
        lbl_error_fecha_asignacion_tarjeta_editar.setVisible(false);
        lbl_error_tipo_combustible_editar.setVisible(false);
        lbl_error_ping_tarjeta_editar1.setVisible(false);
        lbl_error_numero_chapa_editar1.setVisible(false);
        
          //  detectar cambio en jdateChoser (fecha de inicio en agregar contrato)
        fecha_asignacion_tarjeta_editar.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    System.out.println(e.getPropertyName()
                            + ": " + (Date) e.getNewValue());
                    if(fecha_asignacion_tarjeta_editar.getDate()==null){
                    lbl_error_fecha_asignacion_tarjeta_editar.setVisible(true);
                    }
                }else{
                    lbl_error_fecha_asignacion_tarjeta_editar.setVisible(false);
                }
            }
        });
        
         //################### detectar cambios en los combobox ######################3
        combo_tipo_combustible_editar.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              lbl_error_tipo_combustible_editar.setVisible(false);
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        // ##########################################################################
        
        
        deshabilitarPegar();
    }
    
      private void deshabilitarPegar() {
        InputMap map1 = numero_tarjeta_tarjeta_editar.getInputMap(numero_tarjeta_tarjeta_editar.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

        InputMap map2 = numero_cant_litros_tarjeta_editar.getInputMap(numero_cant_litros_tarjeta_editar.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map3 = ping_tarjeta_editar.getInputMap(ping_tarjeta_editar.WHEN_FOCUSED);
        map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map4= numero_chapa_tarjeta_editar.getInputMap(numero_chapa_tarjeta_editar.WHEN_FOCUSED);
        map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
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
                boton_guardar_tarj_combustible_editarActionPerformed(e);
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
        numero_tarjeta_tarjeta_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_numero_tarjeta_editar1 = new javax.swing.JLabel();
        lbl_error_ping_tarjeta_editar1 = new javax.swing.JLabel();
        ping_tarjeta_editar = new rojeru_san.rsfield.RSTextMaterial();
        numero_cant_litros_tarjeta_editar = new rojeru_san.rsfield.RSTextMaterial();
        numero_chapa_tarjeta_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_numero_chapa_editar1 = new javax.swing.JLabel();
        lbl_error_cant_litro_tarjeta_editar1 = new javax.swing.JLabel();
        combo_tipo_combustible_editar = new org.bolivia.combo.SComboBox();
        lbl_error_fecha_asignacion_tarjeta_editar = new javax.swing.JLabel();
        lbl_error_tipo_combustible_editar = new javax.swing.JLabel();
        boton_guardar_tarj_combustible_editar = new rojeru_san.RSButtonRiple();
        fecha_asignacion_tarjeta_editar = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(782, 552));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_tarj_combustible/tarjeta_combustible3.png"))); // NOI18N

        numero_tarjeta_tarjeta_editar.setForeground(new java.awt.Color(0, 0, 0));
        numero_tarjeta_tarjeta_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        numero_tarjeta_tarjeta_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        numero_tarjeta_tarjeta_editar.setPlaceholder("Número de tarjeta...");
        numero_tarjeta_tarjeta_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        numero_tarjeta_tarjeta_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numero_tarjeta_tarjeta_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numero_tarjeta_tarjeta_editarKeyTyped(evt);
            }
        });

        lbl_error_numero_tarjeta_editar1.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_numero_tarjeta_editar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_numero_tarjeta_editar1.setText("¡Debe ingresar número de tarjeta!");

        lbl_error_ping_tarjeta_editar1.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_ping_tarjeta_editar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_ping_tarjeta_editar1.setText("¡Debe ingresar ping de tarjeta!");

        ping_tarjeta_editar.setForeground(new java.awt.Color(0, 0, 0));
        ping_tarjeta_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        ping_tarjeta_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ping_tarjeta_editar.setPlaceholder("Ping de tarjeta...");
        ping_tarjeta_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        ping_tarjeta_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ping_tarjeta_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ping_tarjeta_editarKeyTyped(evt);
            }
        });

        numero_cant_litros_tarjeta_editar.setForeground(new java.awt.Color(0, 0, 0));
        numero_cant_litros_tarjeta_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        numero_cant_litros_tarjeta_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        numero_cant_litros_tarjeta_editar.setPlaceholder("Cantidad de litros...");
        numero_cant_litros_tarjeta_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        numero_cant_litros_tarjeta_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numero_cant_litros_tarjeta_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numero_cant_litros_tarjeta_editarKeyTyped(evt);
            }
        });

        numero_chapa_tarjeta_editar.setForeground(new java.awt.Color(0, 0, 0));
        numero_chapa_tarjeta_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        numero_chapa_tarjeta_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        numero_chapa_tarjeta_editar.setPlaceholder("Chapa a la que pertenece...");
        numero_chapa_tarjeta_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        numero_chapa_tarjeta_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numero_chapa_tarjeta_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                numero_chapa_tarjeta_editarKeyTyped(evt);
            }
        });

        lbl_error_numero_chapa_editar1.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_numero_chapa_editar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_numero_chapa_editar1.setText("¡Debe ingresar número de chapa!");

        lbl_error_cant_litro_tarjeta_editar1.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_cant_litro_tarjeta_editar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_cant_litro_tarjeta_editar1.setText("¡Debe ingresar una cantidad de litros!");

        combo_tipo_combustible_editar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TIPO COMBUSTIBLE", "GASOLINA", "PETRÓLEO" }));
        combo_tipo_combustible_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_tipo_combustible_editarActionPerformed(evt);
            }
        });

        lbl_error_fecha_asignacion_tarjeta_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_asignacion_tarjeta_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_fecha_asignacion_tarjeta_editar.setText("¡Debe ingresar una fecha!");

        lbl_error_tipo_combustible_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_tipo_combustible_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_tipo_combustible_editar.setText("¡Debe ingresar un tipo de combustible!");

        boton_guardar_tarj_combustible_editar.setBackground(new java.awt.Color(38, 86, 186));
        boton_guardar_tarj_combustible_editar.setText("Guardar Cambios");
        boton_guardar_tarj_combustible_editar.setColorHover(new java.awt.Color(173, 187, 194));
        boton_guardar_tarj_combustible_editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_guardar_tarj_combustible_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_tarj_combustible_editarActionPerformed(evt);
            }
        });

        fecha_asignacion_tarjeta_editar.setDateFormatString("dd/MM/yyyy");
        fecha_asignacion_tarjeta_editar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_error_numero_chapa_editar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numero_chapa_tarjeta_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numero_tarjeta_tarjeta_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_error_fecha_asignacion_tarjeta_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_error_numero_tarjeta_editar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fecha_asignacion_tarjeta_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(combo_tipo_combustible_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_error_cant_litro_tarjeta_editar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_error_ping_tarjeta_editar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(numero_cant_litros_tarjeta_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ping_tarjeta_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_error_tipo_combustible_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_guardar_tarj_combustible_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(numero_tarjeta_tarjeta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_error_numero_tarjeta_editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(numero_chapa_tarjeta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_error_numero_chapa_editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ping_tarjeta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_error_ping_tarjeta_editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(numero_cant_litros_tarjeta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_error_cant_litro_tarjeta_editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(combo_tipo_combustible_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_error_tipo_combustible_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(fecha_asignacion_tarjeta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_error_fecha_asignacion_tarjeta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(11, 11, 11)
                .addComponent(boton_guardar_tarj_combustible_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rSPanelShadow1Layout = new javax.swing.GroupLayout(rSPanelShadow1);
        rSPanelShadow1.setLayout(rSPanelShadow1Layout);
        rSPanelShadow1Layout.setHorizontalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void boton_guardar_tarj_combustible_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_tarj_combustible_editarActionPerformed
        // TODO add your handling code here:
        String sql="SELECT * FROM `tarj_combustible` WHERE `numero_tarj`='"+numero_tarjeta_tarjeta_editar+"'";
      String mje1="La tarjeta que intenta introducir al sistema ya existe";
      String mje2="Por favor introduzca una nueva";
        if (numero_tarjeta_tarjeta_editar.getText().isEmpty()||combo_tipo_combustible_editar.getSelectedIndex()==0 || 
                ping_tarjeta_editar.getText().isEmpty()|| numero_chapa_tarjeta_editar.getText().isEmpty()|| 
                numero_cant_litros_tarjeta_editar.getText().isEmpty() ||fecha_asignacion_tarjeta_editar.getDate()==null ||
                interaccion_bd.opciones_de_gestionar_contrato.existe(numero_tarjeta_tarjeta_editar.getText(), sql)||
                numero_tarjeta_tarjeta_editar.getText().length()<16 || ping_tarjeta_editar.getText().length()<4 || 
                numero_chapa_tarjeta_editar.getText().length()<7) {
            if(numero_tarjeta_tarjeta_editar.getText().isEmpty()){
                numero_tarjeta_tarjeta_editar.requestFocus();
                lbl_error_numero_tarjeta_editar1.setText("¡Debe ingresar número de tarjeta!");
                lbl_error_numero_tarjeta_editar1.setVisible(true);
            }else if(ping_tarjeta_editar.getText().isEmpty()){
                ping_tarjeta_editar.requestFocus();
                lbl_error_ping_tarjeta_editar1.setText("¡Debe ingresar ping de tarjeta!");
                lbl_error_ping_tarjeta_editar1.setVisible(true);
            }else if(numero_chapa_tarjeta_editar.getText().isEmpty()){
                numero_chapa_tarjeta_editar.requestFocus();
                lbl_error_numero_chapa_editar1.setText("¡Debe ingresar número de chapa!");
                lbl_error_numero_chapa_editar1.setVisible(true);
            }else if(numero_cant_litros_tarjeta_editar.getText().isEmpty()){
                numero_cant_litros_tarjeta_editar.requestFocus();
                lbl_error_cant_litro_tarjeta_editar1.setVisible(true);
            }else if(fecha_asignacion_tarjeta_editar.getDate()==null){
                fecha_asignacion_tarjeta_editar.requestFocus();
                lbl_error_fecha_asignacion_tarjeta_editar.setVisible(true);
            }else if(combo_tipo_combustible_editar.getSelectedIndex()==0){
                combo_tipo_combustible_editar.requestFocus();
                lbl_error_tipo_combustible_editar.setVisible(true);
            }else if (interaccion_bd.opciones_de_gestionar_contrato.existe(numero_tarjeta_tarjeta_editar.getText(), sql)) {
                            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mje1,mje2,"");
                            numero_tarjeta_tarjeta_editar.requestFocus();
                        }else if(numero_tarjeta_tarjeta_editar.getText().length()<16){
                numero_tarjeta_tarjeta_editar.requestFocus();
                lbl_error_numero_tarjeta_editar1.setText("¡El número debe contener 16 dígitos!");
                lbl_error_numero_tarjeta_editar1.setVisible(true);
                        }else if(ping_tarjeta_editar.getText().length()<4){
                ping_tarjeta_editar.requestFocus();
                lbl_error_ping_tarjeta_editar1.setText("¡El número debe contener 4 dígitos!");
                lbl_error_ping_tarjeta_editar1.setVisible(true);
            }else if(numero_chapa_tarjeta_editar.getText().length()<7){
                numero_chapa_tarjeta_editar.requestFocus();
                lbl_error_numero_chapa_editar1.setText("¡El campo debe contener 1 letra y 6 dígitos!");
                lbl_error_numero_chapa_editar1.setVisible(true);
            }
        } else {
            Runnable runnable1 = new Runnable() {
                public void run() {
                    Guardando_general l = new Guardando_general(new JFrame(), true);
                    consultas_de_gestionar_tarj_combustible uc=new consultas_de_gestionar_tarj_combustible();
                    l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_info_laboratorio_editar.this);
                    l.setVisible(true);
                    try{            //toma_fecha()
                    paneles_de_paneles.de_gestionar_info_laboratorio_editar.this.setEnabled(false);
                    uc.setNumero_tarjeta(numero_tarjeta_tarjeta_editar.getText());
                    uc.setTipo_combustible_tarjeta(combo_tipo_combustible_editar.getSelectedItem().toString());
                    uc.setPing_tarjeta(ping_tarjeta_editar.getText());
                    uc.setChapa_tarjeta(numero_chapa_tarjeta_editar.getText());
                    uc.setCant_litros_tarjeta(numero_cant_litros_tarjeta_editar.getText());
                    uc.setFecha_asignacion_tarjeta(toma_fecha(fecha_asignacion_tarjeta_editar));
                   int control= opciones_de_gestionar_tarj_combustible.actualizar(uc);
                    reset_campos();
                    paneles_de_paneles.de_gestionar_info_laboratorio_editar.this.setEnabled(true);
                    l.setVisible(false);
                    if(control==1){
                    SuccessAlert e = new SuccessAlert(new JFrame(), true);
            e.msj1.setText("¡Los datos del contrato fueron");
            e.msj2.setText("guardados exitosamente!.");
            e.msj3.setText("");
            e.setVisible(true);
                        opciones_de_gestionar_tarj_combustible.setListar("");
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
    }//GEN-LAST:event_boton_guardar_tarj_combustible_editarActionPerformed

    private void combo_tipo_combustible_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_tipo_combustible_editarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_tipo_combustible_editarActionPerformed

    private void numero_chapa_tarjeta_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numero_chapa_tarjeta_editarKeyTyped
        // TODO add your handling code here:
        if (numero_chapa_tarjeta_editar.getText().length() > 0 &&numero_chapa_tarjeta_editar.getText().length() < 7) {
            char car = evt.getKeyChar();
            if (Character.isDigit(car)) {
            } else {
                evt.consume();
            }

        }else{
            if(numero_chapa_tarjeta_editar.getText().length() < 7){
        char car = evt.getKeyChar();
        if ( Character.isLetter(car)) {
        } else {
            evt.consume();
        }
        }else{
                evt.consume();
            }
        }
    }//GEN-LAST:event_numero_chapa_tarjeta_editarKeyTyped

    private void numero_chapa_tarjeta_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numero_chapa_tarjeta_editarKeyReleased
        // TODO add your handling code here:
        if(numero_chapa_tarjeta_editar.getText().length()>0){
            lbl_error_numero_chapa_editar1.setVisible(false);
            char car = numero_chapa_tarjeta_editar.getText().charAt(0);
            car=Character.toUpperCase(car);
            String txt=numero_chapa_tarjeta_editar.getText().substring(1);
            numero_chapa_tarjeta_editar.setText(String.valueOf(car)+txt);
        }
    }//GEN-LAST:event_numero_chapa_tarjeta_editarKeyReleased

    private void numero_cant_litros_tarjeta_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numero_cant_litros_tarjeta_editarKeyTyped
        // TODO add your handling code here:
        if(numero_cant_litros_tarjeta_editar.getText().length()<10){
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
        }
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_numero_cant_litros_tarjeta_editarKeyTyped

    private void numero_cant_litros_tarjeta_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numero_cant_litros_tarjeta_editarKeyReleased
        // TODO add your handling code here:
        if(numero_cant_litros_tarjeta_editar.getText().length()>0){
        lbl_error_cant_litro_tarjeta_editar1.setVisible(false);
    }
    }//GEN-LAST:event_numero_cant_litros_tarjeta_editarKeyReleased

    private void ping_tarjeta_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ping_tarjeta_editarKeyTyped
        // TODO add your handling code here:
        if(ping_tarjeta_editar.getText().length()<4){
                char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
            
        }
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_ping_tarjeta_editarKeyTyped

    private void ping_tarjeta_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ping_tarjeta_editarKeyReleased
        // TODO add your handling code here:
        if(ping_tarjeta_editar.getText().length()>0){
            lbl_error_ping_tarjeta_editar1.setVisible(false);
        }
    }//GEN-LAST:event_ping_tarjeta_editarKeyReleased

    private void numero_tarjeta_tarjeta_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numero_tarjeta_tarjeta_editarKeyTyped
        // TODO add your handling code here:
        if(numero_tarjeta_tarjeta_editar.getText().length()<16){
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
            
        }
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_numero_tarjeta_tarjeta_editarKeyTyped

    private void numero_tarjeta_tarjeta_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numero_tarjeta_tarjeta_editarKeyReleased
        // TODO add your handling code here:
        if(numero_tarjeta_tarjeta_editar.getText().length()>0){
            lbl_error_numero_tarjeta_editar1.setVisible(false);
        }
    }//GEN-LAST:event_numero_tarjeta_tarjeta_editarKeyReleased

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
        numero_tarjeta_tarjeta_editar.setText("");
        numero_cant_litros_tarjeta_editar.setText("");
        ping_tarjeta_editar.setText("");
        numero_chapa_tarjeta_editar.setText("");
        fecha_asignacion_tarjeta_editar.setDate(null);
        combo_tipo_combustible_editar.setSelectedIndex(0);
        lbl_error_cant_litro_tarjeta_editar1.setVisible(false);
        lbl_error_numero_tarjeta_editar1.setVisible(false);
        lbl_error_fecha_asignacion_tarjeta_editar.setVisible(false);
        lbl_error_tipo_combustible_editar.setVisible(false);
        lbl_error_ping_tarjeta_editar1.setVisible(false);
        lbl_error_numero_chapa_editar1.setVisible(false);
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
            java.util.logging.Logger.getLogger(de_gestionar_info_laboratorio_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_info_laboratorio_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_info_laboratorio_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_info_laboratorio_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                de_gestionar_info_laboratorio_editar dialog = new de_gestionar_info_laboratorio_editar(new javax.swing.JFrame(), true);
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
    private rojeru_san.RSButtonRiple boton_guardar_tarj_combustible_editar;
    public static org.bolivia.combo.SComboBox combo_tipo_combustible_editar;
    public static com.toedter.calendar.JDateChooser fecha_asignacion_tarjeta_editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_error_cant_litro_tarjeta_editar1;
    private javax.swing.JLabel lbl_error_fecha_asignacion_tarjeta_editar;
    private javax.swing.JLabel lbl_error_numero_chapa_editar1;
    private javax.swing.JLabel lbl_error_numero_tarjeta_editar1;
    private javax.swing.JLabel lbl_error_ping_tarjeta_editar1;
    private javax.swing.JLabel lbl_error_tipo_combustible_editar;
    public static rojeru_san.rsfield.RSTextMaterial numero_cant_litros_tarjeta_editar;
    public static rojeru_san.rsfield.RSTextMaterial numero_chapa_tarjeta_editar;
    public static rojeru_san.rsfield.RSTextMaterial numero_tarjeta_tarjeta_editar;
    public static rojeru_san.rsfield.RSTextMaterial ping_tarjeta_editar;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
}
