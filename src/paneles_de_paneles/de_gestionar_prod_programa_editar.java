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
import interaccion_bd.consultas_de_gestionar_prod_programa;
import interaccion_bd.opciones_de_gestionar_contrato;
import interaccion_bd.opciones_de_gestionar_prod_programa;
import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import necesario.RSAWTUtilities;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import static paneles_de_paneles.de_gestionar_contrato_añadir.nombre_cliente_contrato;
import static paneles_de_paneles.de_gestionar_contrato_añadir.numero_contrato;
import rojeru_san.complementos.RSMoveObject;
import rojeru_san.complementos.RSUtilities;

/**
 *
 * @author RojeruSan
 */
public class de_gestionar_prod_programa_editar extends javax.swing.JDialog {
    /**
     * Creates new form ErrorAlert
     */
    public de_gestionar_prod_programa_editar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        addEventKey();
        initComponents();

        RSAWTUtilities.setOpaque(this, false);
        RSUtilities.setCentrarVentana(this);
        RSMoveObject.setMoverVentana(this);
        
        lbl_error_programa_editar.setVisible(false);
        lbl_error_descripcion_prefabricado_editar.setVisible(false);
        lbl_error_fecha_modelo_editar.setVisible(false);
        lbl_error_cantidad_modelo_editar.setVisible(false);
        opciones_de_gestionar_prod_programa.get_combos(combo_prefabricados_editar, combo_programas_editar);
        deshabilitarPegar();
        
        
      deshabilitarPegar();
      
       //################### detectar cambios en los combobox ######################3
        combo_prefabricados_editar.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              lbl_error_descripcion_prefabricado_editar.setVisible(false);
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        combo_programas_editar.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              lbl_error_programa_editar.setVisible(false);
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        // ##########################################################################
      
         //  detectar cambio en jdateChoser (fecha de inicio en agregar contrato)
        fecha_modelo_editar.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    System.out.println(e.getPropertyName()
                            + ": " + (Date) e.getNewValue());
                    if(fecha_modelo_editar.getDate()!=null){
                       lbl_error_fecha_modelo_editar.setVisible(false);
                    }
                }else{
                    lbl_error_fecha_modelo_editar.setVisible(true);
                }
            }
        });
        
    }
    
     private void deshabilitarPegar() {
        InputMap map1 = cantidad_modelo_editar.getInputMap(cantidad_modelo_editar.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
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
                boton_guardar_nodelo_mercantil_editarActionPerformed(e);
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
        lbl_error_descripcion_prefabricado_editar = new javax.swing.JLabel();
        lbl_error_programa_editar = new javax.swing.JLabel();
        fecha_modelo_editar = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        boton_guardar_nodelo_mercantil_editar = new rojeru_san.RSButtonRiple();
        lbl_error_fecha_modelo_editar = new javax.swing.JLabel();
        combo_prefabricados_editar = new org.bolivia.combo.SComboBox();
        check_prefabricados = new check_de_android.Switch();
        combo_programas_editar = new org.bolivia.combo.SComboBox();
        check_programas = new check_de_android.Switch();
        cantidad_modelo_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_cantidad_modelo_editar = new javax.swing.JLabel();
        primary = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(782, 552));

        lbl_error_descripcion_prefabricado_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_descripcion_prefabricado_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_descripcion_prefabricado_editar.setText("¡Debe ingresar una descripción!");

        lbl_error_programa_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_programa_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_programa_editar.setText("¡Debe ingresar un programa!");

        fecha_modelo_editar.setDateFormatString("dd/MM/yyyy");
        fecha_modelo_editar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_prefabricado/prefabricado.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        boton_guardar_nodelo_mercantil_editar.setBackground(new java.awt.Color(38, 86, 186));
        boton_guardar_nodelo_mercantil_editar.setText("Guardar Cambios");
        boton_guardar_nodelo_mercantil_editar.setColorHover(new java.awt.Color(173, 187, 194));
        boton_guardar_nodelo_mercantil_editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_guardar_nodelo_mercantil_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_nodelo_mercantil_editarActionPerformed(evt);
            }
        });

        lbl_error_fecha_modelo_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_modelo_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_fecha_modelo_editar.setText("¡Debe ingresar una fecha!");

        combo_prefabricados_editar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DESCRIPCIÓN" }));
        combo_prefabricados_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_prefabricados_editarActionPerformed(evt);
            }
        });
        combo_prefabricados_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_prefabricados_editarKeyReleased(evt);
            }
        });

        check_prefabricados.setToolTipText("Hacer o deshacer editable");
        check_prefabricados.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_prefabricados.setOnOff(false);
        check_prefabricados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_prefabricadosMouseClicked(evt);
            }
        });

        combo_programas_editar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PROGRAMA" }));

        check_programas.setToolTipText("Hacer o deshacer editable");
        check_programas.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_programas.setOnOff(false);
        check_programas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_programasMouseClicked(evt);
            }
        });

        cantidad_modelo_editar.setForeground(new java.awt.Color(0, 0, 0));
        cantidad_modelo_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        cantidad_modelo_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cantidad_modelo_editar.setPlaceholder("Cantidad...");
        cantidad_modelo_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        cantidad_modelo_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cantidad_modelo_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad_modelo_editarKeyTyped(evt);
            }
        });

        lbl_error_cantidad_modelo_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_cantidad_modelo_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_cantidad_modelo_editar.setText("¡Debe ingresar una cantidad!");

        primary.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combo_prefabricados_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(check_prefabricados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cantidad_modelo_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fecha_modelo_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_error_programa_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_error_descripcion_prefabricado_editar, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_error_fecha_modelo_editar, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(combo_programas_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(check_programas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(boton_guardar_nodelo_mercantil_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_error_cantidad_modelo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(primary)
                .addGap(431, 431, 431))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_prefabricados_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(check_prefabricados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_descripcion_prefabricado_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_programas_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(check_programas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_programa_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(cantidad_modelo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_cantidad_modelo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(fecha_modelo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbl_error_fecha_modelo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(boton_guardar_nodelo_mercantil_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(primary)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout rSPanelShadow1Layout = new javax.swing.GroupLayout(rSPanelShadow1);
        rSPanelShadow1.setLayout(rSPanelShadow1Layout);
        rSPanelShadow1Layout.setHorizontalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelShadow1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 922, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        rSPanelShadow1Layout.setVerticalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelShadow1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void boton_guardar_nodelo_mercantil_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_nodelo_mercantil_editarActionPerformed
        String sql_codigo = "SELECT `codigo_prefabricado` FROM `prefabricados` WHERE `descripcion_prefabricado`='" + combo_prefabricados_editar.getSelectedItem().toString() + "' ";
        String sql_volumen = "SELECT `volumen/u_prefabricado` FROM `prefabricados` WHERE `descripcion_prefabricado`='" + combo_prefabricados_editar.getSelectedItem().toString() + "' ";
        String sql_precio = "SELECT `precio_cup_prefabricado` FROM `prefabricados` WHERE `descripcion_prefabricado`='" + combo_prefabricados_editar.getSelectedItem().toString() + "'";
        String sql_buscar = "SELECT * FROM `contrato` WHERE `nombre_contrato`='"+combo_programas_editar.getSelectedItem().toString()+"'";
        String sql_buscar2 = "SELECT * FROM `prefabricados` WHERE `descripcion_prefabricado`='"+combo_prefabricados_editar.getSelectedItem().toString()+"'";
        String sql_1_4="SELECT `1_4_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados_editar.getSelectedItem().toString()+"'";
        String sql_3_8="SELECT `3_8_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados_editar.getSelectedItem().toString()+"'";
        String sql_1_2="SELECT `1_2_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados_editar.getSelectedItem().toString()+"'";
        String sql_5_8="SELECT `5_8_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados_editar.getSelectedItem().toString()+"'";
        String sql_3_4="SELECT `3_4_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados_editar.getSelectedItem().toString()+"'";
        String sql_1="SELECT `1_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados_editar.getSelectedItem().toString()+"'";
        String sql_al="SELECT `al_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados_editar.getSelectedItem().toString()+"'";
        String sql_el="SELECT `el_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados_editar.getSelectedItem().toString()+"'";
        if (combo_prefabricados_editar.getSelectedIndex() == 0 || combo_programas_editar.getSelectedIndex() == 0 || 
                fecha_modelo_editar.getDate() == null||cantidad_modelo_editar.getText().isEmpty() ||
                opciones_de_gestionar_prod_programa.existe(sql_buscar) == false||opciones_de_gestionar_prod_programa.existe(sql_buscar2) == false) {
            if (combo_prefabricados_editar.getSelectedIndex() == 0) {
                combo_prefabricados_editar.requestFocus();
                lbl_error_descripcion_prefabricado_editar.setVisible(true);
                JOptionPane.showMessageDialog(null,"prefabricados");
            } else if (combo_programas_editar.getSelectedIndex() == 0) {
                combo_programas_editar.requestFocus();
                lbl_error_programa_editar.setVisible(true);
            } else if (fecha_modelo_editar.getDate() == null) {
                fecha_modelo_editar.requestFocus();
                lbl_error_fecha_modelo_editar.setVisible(true);
            }else if (cantidad_modelo_editar.getText().isEmpty()) {
                cantidad_modelo_editar.requestFocus();
                lbl_error_cantidad_modelo_editar.setVisible(true);
            }else if(opciones_de_gestionar_prod_programa.existe(sql_buscar) == false){
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex("El programa descrito no se encuentra en la base de datos.",
                "Por favor, si es real, regístrelo antes de volver a intentarlo.",
                "De lo contrario seleccione uno existente en nuestra base de datos");
            combo_programas_editar.requestFocus();
            }else if(opciones_de_gestionar_prod_programa.existe(sql_buscar2) == false){
                opciones_de_gestionar_contrato.lanza_error_variable_sin_ex("El elemento descrito no se encuentra en la base de datos.",
                "",
                "Seleccione uno existente en nuestra base de datos");
            combo_programas_editar.requestFocus();
            }
            
        } else {

            Runnable runnable1 = new Runnable() {

                public void run() {
                    Guardando_general l = new Guardando_general(new JFrame(), true);
                    consultas_de_gestionar_prod_programa uc = new consultas_de_gestionar_prod_programa();
                    l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_prod_programa_editar.this);
                    l.setVisible(true);
                    try {
                        paneles_de_paneles.de_gestionar_prod_programa_editar.this.setEnabled(false);
                        uc.setPrimaryKey(Integer.parseInt(primary.getText()));
                        uc.setCodigo(opciones_de_gestionar_prod_programa.extraer_numero(sql_codigo));
                        uc.setDescripcion(combo_prefabricados_editar.getSelectedItem().toString());
                        uc.setPrograma(combo_programas_editar.getSelectedItem().toString());
                        uc.setFecha(fecha_modelo_editar.getDate());
                        uc.setTotal_m3((double) Math.round((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen)) * 100d) / 100d);
                        uc.setImporte((double) Math.round((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_precio)) * 100d) / 100d);
                        uc.setVolumen_unidad(opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen));
                        uc.setCantidad(Double.parseDouble(cantidad_modelo_editar.getText()));
                        uc.setRbk("25");
                        uc.setU_m("U");
                        uc.setPreciio(opciones_de_gestionar_prod_programa.extraer_volumen(sql_precio));            //opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen))*0.445
                    uc.setCemento((double) Math.round(((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen))*0.445) * 100d) / 100d);
                    uc.setArena((double) Math.round(((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen))*0.65) * 100d) / 100d);
                    uc.setGravilla((double) Math.round(((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen))*0.69) * 100d) / 100d);
                    uc.setAditivo((double) Math.round(((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen))*4.45) * 100d) / 100d);
                    // en toneladas
                    uc.setUn_cuarto(((double) Math.round((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_1_4))/1000) * 100d) / 100d);
                    uc.setTres_octavo(((double) Math.round((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_3_8))/1000) * 100d) / 100d);
                    uc.setUn_medio(((double) Math.round((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_1_2))/1000) * 100d) / 100d);
                    uc.setCinco_octavo(((double) Math.round((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_5_8))/1000) * 100d) / 100d);
                    uc.setTres_cuartos(((double) Math.round((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_3_4))/1000) * 100d) / 100d);
                    uc.setUno(((double) Math.round((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_1))/1000) * 100d) / 100d);
                    uc.setAl(((double) Math.round((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_al))/1000) * 100d) / 100d);
                    uc.setEl(((double) Math.round((Double.parseDouble(cantidad_modelo_editar.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_el))/1000) * 100d) / 100d);

                    int control = opciones_de_gestionar_prod_programa.actualizar(uc);
                    reset_campos();
                    paneles_de_paneles.de_gestionar_prod_programa_editar.this.setEnabled(true);
                    l.setVisible(false);
                    if (control == 1) {
                        interaccion_bd.opciones_de_gestionar_prod_programa.setListar("");
                        SuccessAlert e = new SuccessAlert(new JFrame(), true);
                        e.msj1.setText("¡Los datos del Modelo Mercantil fueron");
                        e.msj2.setText("guardados exitosamente!.");
                        e.msj3.setText("");
                        e.setVisible(true);
                    }

                } catch (Exception e) {
                    Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, e);
                    opciones_de_gestionar_contrato.lanza_error(e);
                }
            }
        };
        Thread t1 = new Thread(runnable1);
        t1.start();
        this.dispose();
        }
        
    }//GEN-LAST:event_boton_guardar_nodelo_mercantil_editarActionPerformed

    private void combo_prefabricados_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_prefabricados_editarKeyReleased
        // TODO add your handling code here:
        if(!combo_prefabricados_editar.getSelectedItem().equals("")||!combo_prefabricados_editar.getSelectedItem().equals("DESCRIPCIÓN")){
            lbl_error_cantidad_modelo_editar.setVisible(false);
        }
    }//GEN-LAST:event_combo_prefabricados_editarKeyReleased

    private void check_prefabricadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_prefabricadosMouseClicked
        // TODO add your handling code here:
        if(check_prefabricados.isOnOff()){
            combo_prefabricados_editar.setEditable(true);
            AutoCompleteDecorator.decorate(combo_prefabricados_editar);
        }else{
            combo_prefabricados_editar.setEditable(false);
            combo_prefabricados_editar.requestFocus();
        }
    }//GEN-LAST:event_check_prefabricadosMouseClicked

    private void check_programasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_programasMouseClicked
        // TODO add your handling code here:
        if(check_programas.isOnOff()){
            combo_programas_editar.setEditable(true);
            AutoCompleteDecorator.decorate(combo_programas_editar);
        }else{
            combo_programas_editar.setEditable(false);
            combo_programas_editar.requestFocus();
        }
    }//GEN-LAST:event_check_programasMouseClicked

    private void cantidad_modelo_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad_modelo_editarKeyReleased
        // TODO add your handling code here:
        if(cantidad_modelo_editar.getText().length()>0){
            lbl_error_cantidad_modelo_editar.setVisible(false);
        }
    }//GEN-LAST:event_cantidad_modelo_editarKeyReleased

    private void cantidad_modelo_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad_modelo_editarKeyTyped
        // TODO add your handling code here:
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();

        }
    }//GEN-LAST:event_cantidad_modelo_editarKeyTyped

    private void combo_prefabricados_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_prefabricados_editarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_prefabricados_editarActionPerformed

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
        cantidad_modelo_editar.setText("");
        fecha_modelo_editar.setDate(null);
        combo_prefabricados_editar.setSelectedIndex(0);
        combo_programas_editar.setSelectedIndex(0);
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
            java.util.logging.Logger.getLogger(de_gestionar_prod_programa_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_prod_programa_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_prod_programa_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_prod_programa_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                de_gestionar_prod_programa_editar dialog = new de_gestionar_prod_programa_editar(new javax.swing.JFrame(), true);
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
    private rojeru_san.RSButtonRiple boton_guardar_nodelo_mercantil_editar;
    public static rojeru_san.rsfield.RSTextMaterial cantidad_modelo_editar;
    private check_de_android.Switch check_prefabricados;
    private check_de_android.Switch check_programas;
    public static org.bolivia.combo.SComboBox combo_prefabricados_editar;
    public static org.bolivia.combo.SComboBox combo_programas_editar;
    public static com.toedter.calendar.JDateChooser fecha_modelo_editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_error_cantidad_modelo_editar;
    private javax.swing.JLabel lbl_error_descripcion_prefabricado_editar;
    private javax.swing.JLabel lbl_error_fecha_modelo_editar;
    private javax.swing.JLabel lbl_error_programa_editar;
    public static javax.swing.JLabel primary;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
}
