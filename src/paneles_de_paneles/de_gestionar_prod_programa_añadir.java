/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles_de_paneles;

import alertas.ErrorAlert;
import alertas.SuccessAlert;
import com.toedter.calendar.JDateChooser;
import conexion.conexion;
import esperas.Guardando_general;
import interaccion_bd.consultas_de_gestionar_contrato;
import interaccion_bd.consultas_de_gestionar_prod_programa;
import interaccion_bd.opciones_de_gestionar_contrato;
import interaccion_bd.opciones_de_gestionar_prod_programa;
import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.Font;
import paneles.*;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.MetalComboBoxButton;
import org.bolivia.combo.SComboBox;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import static paneles_de_paneles.de_gestionar_contrato_editar.nombre_cliente_contrato_editar;
import static paneles_de_paneles.de_gestionar_contrato_editar.numero_contrato_editar;
import static paneles_de_paneles.de_gestionar_prod_programa_editar.cantidad_modelo_editar;
import static paneles_de_paneles.de_gestionar_prod_programa_editar.combo_prefabricados_editar;
import static paneles_de_paneles.de_gestionar_prod_programa_editar.combo_programas_editar;

/**
 *
 * @author RojeruSan
 */
public class de_gestionar_prod_programa_añadir extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
    */
    public de_gestionar_prod_programa_añadir() {
        initComponents();
        lbl_error_programa_.setVisible(false);
        lbl_error_descripcion_prefabricado.setVisible(false);
        lbl_error_fecha_modelo.setVisible(false);
        lbl_error_cantidad_modelo.setVisible(false);
        opciones_de_gestionar_prod_programa.get_combos(combo_prefabricados, combo_programas);
        deshabilitarPegar();
        //################### detectar cambios en los combobox ######################3
        combo_prefabricados.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              lbl_error_descripcion_prefabricado.setVisible(false);
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        combo_programas.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              lbl_error_programa_.setVisible(false);
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        // ##########################################################################
        
        //  detectar cambio en jdateChoser (fecha de inicio en agregar contrato)
        fecha_modelo.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    System.out.println(e.getPropertyName()
                            + ": " + (Date) e.getNewValue());
                    if(fecha_modelo.getDate()==null){
                       lbl_error_fecha_modelo.setVisible(true);
                    }
                }else{
                    lbl_error_fecha_modelo.setVisible(false);
                }
            }
        });
        this.add(fecha_modelo);
} 
    
         private void deshabilitarPegar() {
        InputMap map1 = cantidad_modelo.getInputMap(cantidad_modelo.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
       

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_error_descripcion_prefabricado = new javax.swing.JLabel();
        lbl_error_programa_ = new javax.swing.JLabel();
        fecha_modelo = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        lbl_error_fecha_modelo = new javax.swing.JLabel();
        combo_prefabricados = new org.bolivia.combo.SComboBox();
        check_prefabricados = new check_de_android.Switch();
        combo_programas = new org.bolivia.combo.SComboBox();
        check_programas = new check_de_android.Switch();
        cantidad_modelo = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_cantidad_modelo = new javax.swing.JLabel();
        boton_guardar_nodelo_mercantil = new rojeru_san.RSButtonRiple();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(935, 474));

        lbl_error_descripcion_prefabricado.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_descripcion_prefabricado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_descripcion_prefabricado.setText("¡Debe ingresar una descripción!");

        lbl_error_programa_.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_programa_.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_programa_.setText("¡Debe ingresar un programa!");

        fecha_modelo.setDateFormatString("dd/MM/yyyy");
        fecha_modelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_prefabricado/prefabricado.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lbl_error_fecha_modelo.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_fecha_modelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_fecha_modelo.setText("¡Debe ingresar una fecha!");

        combo_prefabricados.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DESCRIPCIÓN" }));
        combo_prefabricados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                combo_prefabricadosKeyReleased(evt);
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

        combo_programas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PROGRAMA" }));

        check_programas.setToolTipText("Hacer o deshacer editable");
        check_programas.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_programas.setOnOff(false);
        check_programas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_programasMouseClicked(evt);
            }
        });

        cantidad_modelo.setForeground(new java.awt.Color(0, 0, 0));
        cantidad_modelo.setColorMaterial(new java.awt.Color(99, 70, 250));
        cantidad_modelo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cantidad_modelo.setPlaceholder("Cantidad...");
        cantidad_modelo.setSelectionColor(new java.awt.Color(220, 23, 111));
        cantidad_modelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cantidad_modeloKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad_modeloKeyTyped(evt);
            }
        });

        lbl_error_cantidad_modelo.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_cantidad_modelo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_cantidad_modelo.setText("¡Debe ingresar una cantidad!");

        boton_guardar_nodelo_mercantil.setBackground(new java.awt.Color(38, 86, 186));
        boton_guardar_nodelo_mercantil.setText("Guardar Modelo Mercantil");
        boton_guardar_nodelo_mercantil.setColorHover(new java.awt.Color(173, 187, 194));
        boton_guardar_nodelo_mercantil.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_guardar_nodelo_mercantil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_nodelo_mercantilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(combo_prefabricados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(check_prefabricados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cantidad_modelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fecha_modelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_error_programa_, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_error_descripcion_prefabricado, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_error_fecha_modelo, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(combo_programas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(check_programas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lbl_error_cantidad_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(boton_guardar_nodelo_mercantil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_prefabricados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(check_prefabricados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_descripcion_prefabricado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_programas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(check_programas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_programa_, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(cantidad_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_cantidad_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(fecha_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbl_error_fecha_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(boton_guardar_nodelo_mercantil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

     
    
    private void boton_guardar_nodelo_mercantilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_nodelo_mercantilActionPerformed
        String sql_codigo = "SELECT `codigo_prefabricado` FROM `prefabricados` WHERE `descripcion_prefabricado`='" + combo_prefabricados.getSelectedItem().toString() + "' ";
        String sql_volumen = "SELECT `volumen/u_prefabricado` FROM `prefabricados` WHERE `descripcion_prefabricado`='" + combo_prefabricados.getSelectedItem().toString() + "' ";
        String sql_precio = "SELECT `precio_cup_prefabricado` FROM `prefabricados` WHERE `descripcion_prefabricado`='" + combo_prefabricados.getSelectedItem().toString() + "'";
        String sql_buscar = "SELECT * FROM `contrato` WHERE `nombre_contrato`='"+combo_programas.getSelectedItem().toString()+"'";
       String sql_buscar2 = "SELECT * FROM `prefabricados` WHERE `descripcion_prefabricado`='"+combo_prefabricados.getSelectedItem().toString()+"'";
        String sql_1_4="SELECT `1_4_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados.getSelectedItem().toString()+"'";
       String sql_3_8="SELECT `3_8_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados.getSelectedItem().toString()+"'";
       String sql_1_2="SELECT `1_2_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados.getSelectedItem().toString()+"'";
       String sql_5_8="SELECT `5_8_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados.getSelectedItem().toString()+"'";
       String sql_3_4="SELECT `3_4_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados.getSelectedItem().toString()+"'";
       String sql_1="SELECT `1_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados.getSelectedItem().toString()+"'";
       String sql_al="SELECT `al_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados.getSelectedItem().toString()+"'";
       String sql_el="SELECT `el_aceros` FROM `aceros` WHERE `elem_aceros`='"+combo_prefabricados.getSelectedItem().toString()+"'";
        if (combo_prefabricados.getSelectedIndex() == 0 || combo_programas.getSelectedIndex() == 0 || fecha_modelo.getDate() == null
                ||cantidad_modelo.getText().isEmpty() || opciones_de_gestionar_prod_programa.existe(sql_buscar) == false||
                opciones_de_gestionar_prod_programa.existe(sql_buscar2) == false) {
            if (combo_prefabricados.getSelectedIndex() == 0) {
                combo_prefabricados.requestFocus();
                lbl_error_descripcion_prefabricado.setVisible(true);
            } else if (combo_programas.getSelectedIndex() == 0) {
                combo_programas.requestFocus();
                lbl_error_programa_.setVisible(true);
            } else if (fecha_modelo.getDate() == null) {
                fecha_modelo.requestFocus();
                lbl_error_fecha_modelo.setVisible(true);
            }else if (cantidad_modelo.getText().isEmpty()) {
                cantidad_modelo.requestFocus();
                lbl_error_cantidad_modelo.setVisible(true);
            }else if(opciones_de_gestionar_prod_programa.existe(sql_buscar) == false){
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex("El programa descrito no se encuentra en la base de datos.",
                "Por favor, si es real, regístrelo antes de volver a intentarlo.",
                "De lo contrario seleccione uno existente en nuestra base de datos");
            combo_programas.requestFocus();
            }else if(opciones_de_gestionar_prod_programa.existe(sql_buscar2) == false){
                opciones_de_gestionar_contrato.lanza_error_variable_sin_ex("El elemento descrito no se encuentra en la base de datos.",
                "",
                "Seleccione uno existente en nuestra base de datos");
            combo_programas.requestFocus();
            }
            
        } else {

            Runnable runnable1 = new Runnable() {

                public void run() {
                    Guardando_general l = new Guardando_general(new JFrame(), true);
                    consultas_de_gestionar_prod_programa uc = new consultas_de_gestionar_prod_programa();
                    l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_prod_programa_añadir.this);
                    l.setVisible(true);
                    try {
                        paneles_de_paneles.de_gestionar_prod_programa_añadir.this.setEnabled(false);
                        uc.setCodigo(opciones_de_gestionar_prod_programa.extraer_numero(sql_codigo));
                        uc.setDescripcion(combo_prefabricados.getSelectedItem().toString());
                        uc.setPrograma(combo_programas.getSelectedItem().toString());
                        uc.setFecha(toma_fecha(fecha_modelo));
                        uc.setTotal_m3((double) Math.round((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen)) * 100d) / 100d);
                        uc.setImporte((double) Math.round((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_precio)) * 100d) / 100d);
                        uc.setVolumen_unidad(opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen));
                        uc.setCantidad(Double.parseDouble(cantidad_modelo.getText()));
                        uc.setRbk("25");
                        uc.setU_m("U");
                        uc.setPreciio(opciones_de_gestionar_prod_programa.extraer_volumen(sql_precio));            //opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen))*0.445
                        uc.setCemento((double) Math.round(((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen))*0.445) * 100d) / 100d);
                        uc.setArena((double) Math.round(((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen))*0.65) * 100d) / 100d);
                        uc.setGravilla((double) Math.round(((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen))*0.69) * 100d) / 100d);
                        uc.setAditivo((double) Math.round(((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_volumen))*4.45) * 100d) / 100d);
                                                                                                                                                                      // en toneladas
                        uc.setUn_cuarto(((double) Math.round((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_1_4))/1000) * 100d) / 100d);
                        uc.setTres_octavo(((double) Math.round((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_3_8))/1000) * 100d) / 100d);
                        uc.setUn_medio(((double) Math.round((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_1_2))/1000) * 100d) / 100d);
                        uc.setCinco_octavo(((double) Math.round((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_5_8))/1000) * 100d) / 100d);
                        uc.setTres_cuartos(((double) Math.round((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_3_4))/1000) * 100d) / 100d);
                        uc.setUno(((double) Math.round((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_1))/1000) * 100d) / 100d);
                        uc.setAl(((double) Math.round((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_al))/1000) * 100d) / 100d);
                        uc.setEl(((double) Math.round((Double.parseDouble(cantidad_modelo.getText()) * opciones_de_gestionar_prod_programa.extraer_volumen(sql_el))/1000) * 100d) / 100d);
                        
                    
                    
                        int control = opciones_de_gestionar_prod_programa.registrar(uc);
                        reset_campos();
                        paneles_de_paneles.de_gestionar_prod_programa_añadir.this.setEnabled(true);
                        l.setVisible(false);
                        if (control == 1) {
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
        }

    }//GEN-LAST:event_boton_guardar_nodelo_mercantilActionPerformed

    private void check_prefabricadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_prefabricadosMouseClicked
        // TODO add your handling code here:
        if(check_prefabricados.isOnOff()){
            combo_prefabricados.setEditable(true);
        AutoCompleteDecorator.decorate(combo_prefabricados);
        }else{
            combo_prefabricados.setEditable(false);
            combo_prefabricados.requestFocus();
        }
    }//GEN-LAST:event_check_prefabricadosMouseClicked

    private void check_programasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_programasMouseClicked
        // TODO add your handling code here:
        if(check_programas.isOnOff()){
            combo_programas.setEditable(true);
            AutoCompleteDecorator.decorate(combo_programas);
        }else{
            combo_programas.setEditable(false);
            combo_programas.requestFocus();
        }
    }//GEN-LAST:event_check_programasMouseClicked

    private void cantidad_modeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad_modeloKeyReleased
        // TODO add your handling code here:
        if(cantidad_modelo.getText().length()>0){
            lbl_error_cantidad_modelo.setVisible(false);
        }
    }//GEN-LAST:event_cantidad_modeloKeyReleased

    private void cantidad_modeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad_modeloKeyTyped
        // TODO add your handling code here:
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();

        }
    }//GEN-LAST:event_cantidad_modeloKeyTyped

    private void combo_prefabricadosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo_prefabricadosKeyReleased
        // TODO add your handling code here:
        if(!combo_prefabricados.getSelectedItem().equals("")||!combo_prefabricados.getSelectedItem().equals("DESCRIPCIÓN")){
            lbl_error_cantidad_modelo.setVisible(false);
        }
    }//GEN-LAST:event_combo_prefabricadosKeyReleased

    private String toma_fecha(JDateChooser fecha) {      
        String txt_fecha = null;
        if (fecha.getDate() != null) {
             String formato = fecha.getDateFormatString();
            Date date = fecha.getDate();
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            txt_fecha=String.valueOf(sdf.format(date));
        }
        return txt_fecha;
    }                   
    
    private void reset_campos(){
        cantidad_modelo.setText("");
        fecha_modelo.setDate(null);
        combo_prefabricados.setSelectedIndex(0);
        combo_programas.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple boton_guardar_nodelo_mercantil;
    public static rojeru_san.rsfield.RSTextMaterial cantidad_modelo;
    private check_de_android.Switch check_prefabricados;
    private check_de_android.Switch check_programas;
    private org.bolivia.combo.SComboBox combo_prefabricados;
    private org.bolivia.combo.SComboBox combo_programas;
    private com.toedter.calendar.JDateChooser fecha_modelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_error_cantidad_modelo;
    private javax.swing.JLabel lbl_error_descripcion_prefabricado;
    private javax.swing.JLabel lbl_error_fecha_modelo;
    private javax.swing.JLabel lbl_error_programa_;
    // End of variables declaration//GEN-END:variables
}
