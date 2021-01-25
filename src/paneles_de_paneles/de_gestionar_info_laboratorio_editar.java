/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles_de_paneles;

import alertas.*;
import esperas.Guardando_general;
import interaccion_bd.consultas_de_gestionar_recursos_x_programa;
import interaccion_bd.opciones_de_gestionar_contrato;
import interaccion_bd.opciones_de_gestionar_recursos_x_programa;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import necesario.RSAWTUtilities;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import rojeru_san.complementos.RSMoveObject;
import rojeru_san.complementos.RSUtilities;

/**
 *
 * @author 4L3
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
        codigo_re_editar.setEnabled(false);
        um_re_editar.setEnabled(false);
        lbl_error_descripcion_re_editar.setVisible(false);
        lbl_error_cant_re_editar.setVisible(false);
        lbl_error_programa_re_editar.setVisible(false);
        lbl_error_factura_re_editar.setVisible(false);
        lbl_error_carta_porte_re_editar.setVisible(false);
        codigo_editar_control.setVisible(false);
      deshabilitarPegar();
      opciones_de_gestionar_recursos_x_programa.get_combos(combo_prefabricados_re_editar, combo_programas_re_editar);
      //################### detectar cambios en los combobox ######################3
        combo_prefabricados_re_editar.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              lbl_error_descripcion_re_editar.setVisible(false);
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        combo_programas_re_editar.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              lbl_error_programa_re_editar.setVisible(false);
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        // ##########################################################################
    }
    
     private void deshabilitarPegar() {
        InputMap map1 = codigo_re_editar.getInputMap(codigo_re_editar.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

        
        InputMap map3 = um_re_editar.getInputMap(um_re_editar.WHEN_FOCUSED);
        map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map4 = cantidad_re_editar.getInputMap(cantidad_re_editar.WHEN_FOCUSED);
        map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        
        InputMap map6 = factura_re_editar.getInputMap(factura_re_editar.WHEN_FOCUSED);
        map6.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map7 = carta_porte_re_editar.getInputMap(carta_porte_re_editar.WHEN_FOCUSED);
        map7.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
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
                boton_guardar_recursos_x_programa_editarActionPerformed(e);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cantidad_re_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_descripcion_re_editar = new javax.swing.JLabel();
        lbl_error_cant_re_editar = new javax.swing.JLabel();
        boton_guardar_recursos_x_programa_editar = new rojeru_san.RSButtonRiple();
        um_re_editar = new rojeru_san.rsfield.RSTextMaterial();
        codigo_re_editar = new rojeru_san.rsfield.RSTextMaterial();
        factura_re_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_factura_re_editar = new javax.swing.JLabel();
        lbl_error_programa_re_editar = new javax.swing.JLabel();
        carta_porte_re_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_carta_porte_re_editar = new javax.swing.JLabel();
        codigo_editar_control = new javax.swing.JLabel();
        combo_prefabricados_re_editar = new org.bolivia.combo.SComboBox();
        check_prefabricados = new check_de_android.Switch();
        combo_programas_re_editar = new org.bolivia.combo.SComboBox();
        check_programas = new check_de_android.Switch();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(782, 552));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_recursos_x_programa/recursos.jpg"))); // NOI18N

        cantidad_re_editar.setForeground(new java.awt.Color(0, 0, 0));
        cantidad_re_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        cantidad_re_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cantidad_re_editar.setPlaceholder("Cantidad...");
        cantidad_re_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        cantidad_re_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cantidad_re_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidad_re_editarKeyTyped(evt);
            }
        });

        lbl_error_descripcion_re_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_descripcion_re_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_descripcion_re_editar.setText("¡Debe ingresar una descripcion del recurso!");

        lbl_error_cant_re_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_cant_re_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_cant_re_editar.setText("¡Debe ingresar una cantidad!");

        boton_guardar_recursos_x_programa_editar.setBackground(new java.awt.Color(38, 86, 186));
        boton_guardar_recursos_x_programa_editar.setText("Guardar Cambios");
        boton_guardar_recursos_x_programa_editar.setColorHover(new java.awt.Color(173, 187, 194));
        boton_guardar_recursos_x_programa_editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_guardar_recursos_x_programa_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_recursos_x_programa_editarActionPerformed(evt);
            }
        });

        um_re_editar.setForeground(new java.awt.Color(0, 0, 0));
        um_re_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        um_re_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        um_re_editar.setPlaceholder("Unidad de medida...");
        um_re_editar.setSelectionColor(new java.awt.Color(220, 23, 111));

        codigo_re_editar.setForeground(new java.awt.Color(0, 0, 0));
        codigo_re_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        codigo_re_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        codigo_re_editar.setPlaceholder("Código del recurso...");
        codigo_re_editar.setSelectionColor(new java.awt.Color(220, 23, 111));

        factura_re_editar.setForeground(new java.awt.Color(0, 0, 0));
        factura_re_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        factura_re_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        factura_re_editar.setPlaceholder("Número de factura...");
        factura_re_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        factura_re_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                factura_re_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                factura_re_editarKeyTyped(evt);
            }
        });

        lbl_error_factura_re_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_factura_re_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_factura_re_editar.setText("¡Debe ingresar un número de factura!");

        lbl_error_programa_re_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_programa_re_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_programa_re_editar.setText("¡Debe ingresar un programa!");

        carta_porte_re_editar.setForeground(new java.awt.Color(0, 0, 0));
        carta_porte_re_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        carta_porte_re_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        carta_porte_re_editar.setPlaceholder("Número de carta porte...");
        carta_porte_re_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        carta_porte_re_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                carta_porte_re_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                carta_porte_re_editarKeyTyped(evt);
            }
        });

        lbl_error_carta_porte_re_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_carta_porte_re_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_carta_porte_re_editar.setText("¡Debe ingresar un número de carta porte!");

        codigo_editar_control.setText("jLabel1");

        combo_prefabricados_re_editar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MATERIALES" }));
        combo_prefabricados_re_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_prefabricados_re_editarActionPerformed(evt);
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

        combo_programas_re_editar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PROGRAMA" }));

        check_programas.setToolTipText("Hacer o deshacer editable");
        check_programas.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_programas.setOnOff(false);
        check_programas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_programasMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carta_porte_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbl_error_carta_porte_re_editar))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(combo_programas_re_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(check_programas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(factura_re_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_error_programa_re_editar)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(lbl_error_factura_re_editar)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lbl_error_cant_re_editar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(codigo_editar_control))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codigo_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(boton_guardar_recursos_x_programa_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lbl_error_descripcion_re_editar))
                                    .addComponent(um_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cantidad_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(combo_prefabricados_re_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(check_prefabricados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_programas_re_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(check_programas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_programa_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(codigo_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_prefabricados_re_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(check_prefabricados, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_descripcion_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(um_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cantidad_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_cant_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(factura_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_factura_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carta_porte_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_guardar_recursos_x_programa_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_error_carta_porte_re_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigo_editar_control))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rSPanelShadow1Layout = new javax.swing.GroupLayout(rSPanelShadow1);
        rSPanelShadow1.setLayout(rSPanelShadow1Layout);
        rSPanelShadow1Layout.setHorizontalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelShadow1Layout.createSequentialGroup()
                .addGap(0, 1, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        rSPanelShadow1Layout.setVerticalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelShadow1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void cantidad_re_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad_re_editarKeyReleased
        // TODO add your handling code here:
        if(cantidad_re_editar.getText().length()>0){
            lbl_error_cant_re_editar.setVisible(false);
        }
    }//GEN-LAST:event_cantidad_re_editarKeyReleased

    private void cantidad_re_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidad_re_editarKeyTyped
        // TODO add your handling code here:
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
            
        }
    }//GEN-LAST:event_cantidad_re_editarKeyTyped

    private void boton_guardar_recursos_x_programa_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_recursos_x_programa_editarActionPerformed
        // TODO add your handling code here:
        String sql="select * from recursos_x_programa where codigo_re='"+codigo_re_editar.getText()+"'";
        String mje1="El código de recursos por programa que intenta registrar ya existe";
        String mje2="Por favor introduzca un código distinto de recurso";
        String codigo=codigo_editar_control.getText();
        if (combo_prefabricados_re_editar.getSelectedIndex()==0||cantidad_re_editar.getText().isEmpty()||
                combo_programas_re_editar.getSelectedIndex()==0||factura_re_editar.getText().isEmpty()||
                carta_porte_re_editar.getText().isEmpty()) {
            if(combo_prefabricados_re_editar.getSelectedIndex()==0){
                combo_prefabricados_re_editar.requestFocus();
                lbl_error_descripcion_re_editar.setVisible(true);
            }else if(cantidad_re_editar.getText().isEmpty()){
                cantidad_re_editar.requestFocus();
                lbl_error_cant_re_editar.setVisible(true);
            }else if(combo_programas_re_editar.getSelectedIndex()==0){
                combo_programas_re_editar.requestFocus();
                lbl_error_programa_re_editar.setVisible(true);
            }else if(factura_re_editar.getText().isEmpty()){
                factura_re_editar.requestFocus();
                lbl_error_factura_re_editar.setVisible(true);
            }else if(carta_porte_re_editar.getText().isEmpty()){
                carta_porte_re_editar.requestFocus();
                lbl_error_carta_porte_re_editar.setVisible(true);
            }
        } else {
            if(codigo.equals(codigo_re_editar.getText())){
                Guardando_general l = new Guardando_general(new JFrame(), true);
                consultas_de_gestionar_recursos_x_programa uc=new consultas_de_gestionar_recursos_x_programa();
                l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_info_laboratorio_editar.this);
                l.setVisible(true);
                paneles_de_paneles.de_gestionar_info_laboratorio_editar.this.setEnabled(false);
                uc.setCodigo(codigo_re_editar.getText());
                uc.setDescripcion(combo_prefabricados_re_editar.getSelectedItem().toString());
                uc.setUm(um_re_editar.getText());
                uc.setCant(cantidad_re_editar.getText());
                uc.setPrograma_pertenece(combo_programas_re_editar.getSelectedItem().toString());
                uc.setFactura(factura_re_editar.getText());
                uc.setCarta_porte(carta_porte_re_editar.getText());
                int control= opciones_de_gestionar_recursos_x_programa.actualizar(uc);
                paneles_de_paneles.de_gestionar_info_laboratorio_editar.this.setEnabled(true);
                l.setVisible(false);
                if(control==1){
                    reset_campos();
                    opciones_de_gestionar_recursos_x_programa.setListar("");
                    SuccessAlert e = new SuccessAlert(new JFrame(), true);
                    e.msj1.setText("¡Los datos del recurso fueron");
                    e.msj2.setText("guardados exitosamente!.");
                    e.msj3.setText("");
                    e.setVisible(true);
                }
                this.dispose();
            }else{
                if (interaccion_bd.opciones_de_gestionar_contrato.existe(codigo_re_editar.getText(), sql)) {
                    opciones_de_gestionar_contrato.lanza_error_variable_sin_ex("",mje1,mje2);
                    codigo_re_editar.requestFocus();
                }else{
                    Guardando_general l = new Guardando_general(new JFrame(), true);
                    consultas_de_gestionar_recursos_x_programa uc=new consultas_de_gestionar_recursos_x_programa();
                    l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_info_laboratorio_editar.this);
                    l.setVisible(true);
                    paneles_de_paneles.de_gestionar_info_laboratorio_editar.this.setEnabled(false);
                    uc.setCodigo(codigo_re_editar.getText());
                uc.setDescripcion(combo_prefabricados_re_editar.getSelectedItem().toString());
                uc.setUm(um_re_editar.getText());
                uc.setCant(cantidad_re_editar.getText());
                uc.setPrograma_pertenece(combo_programas_re_editar.getSelectedItem().toString());
                uc.setFactura(factura_re_editar.getText());
                uc.setCarta_porte(carta_porte_re_editar.getText());
                    int control= opciones_de_gestionar_recursos_x_programa.actualizar(uc);
                    paneles_de_paneles.de_gestionar_info_laboratorio_editar.this.setEnabled(true);
                    l.setVisible(false);
                    if(control==1){
                        reset_campos();
                        opciones_de_gestionar_recursos_x_programa.setListar("");
                        SuccessAlert e = new SuccessAlert(new JFrame(), true);
                        e.msj1.setText("¡Los datos del recurso fueron");
                        e.msj2.setText("guardados exitosamente!.");
                        e.msj3.setText("");
                        e.setVisible(true);
                    }
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_boton_guardar_recursos_x_programa_editarActionPerformed

    private void factura_re_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_factura_re_editarKeyReleased
        // TODO add your handling code here:
        if(factura_re_editar.getText().length()>0){
            lbl_error_factura_re_editar.setVisible(false);
        }
    }//GEN-LAST:event_factura_re_editarKeyReleased

    private void factura_re_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_factura_re_editarKeyTyped
        // TODO add your handling code here:
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
            
        }
    }//GEN-LAST:event_factura_re_editarKeyTyped

    private void carta_porte_re_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_carta_porte_re_editarKeyReleased
        // TODO add your handling code here:
        if(carta_porte_re_editar.getText().length()>0){
            lbl_error_carta_porte_re_editar.setVisible(false);
        }
    }//GEN-LAST:event_carta_porte_re_editarKeyReleased

    private void carta_porte_re_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_carta_porte_re_editarKeyTyped
        // TODO add your handling code here:
        char num = evt.getKeyChar();
        if ((num < '0' || num > '9')) {
            evt.consume();
            
        }
    }//GEN-LAST:event_carta_porte_re_editarKeyTyped

    private void combo_prefabricados_re_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_prefabricados_re_editarActionPerformed
        // TODO add your handling code here:
        String sql_codigo="SELECT `codigo_materia_prima` FROM `materia_prima` WHERE `elem__materia_prima`='"+combo_prefabricados_re_editar.getSelectedItem().toString().trim()+"'";
        String sql_um="SELECT `um_materia_prima` FROM `materia_prima` WHERE `elem__materia_prima`='"+combo_prefabricados_re_editar.getSelectedItem().toString().trim()+"'";
        um_re_editar.setText(opciones_de_gestionar_recursos_x_programa.extraer_id(sql_um));
        codigo_re_editar.setText(opciones_de_gestionar_recursos_x_programa.extraer_id(sql_codigo));
    }//GEN-LAST:event_combo_prefabricados_re_editarActionPerformed

    private void check_prefabricadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_prefabricadosMouseClicked
        // TODO add your handling code here:
        if(check_prefabricados.isOnOff()){
            combo_prefabricados_re_editar.setEditable(true);
            AutoCompleteDecorator.decorate(combo_prefabricados_re_editar);
        }else{
            combo_prefabricados_re_editar.setEditable(false);
            combo_prefabricados_re_editar.requestFocus();
        }
    }//GEN-LAST:event_check_prefabricadosMouseClicked

    private void check_programasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_programasMouseClicked
        // TODO add your handling code here:
        if(check_programas.isOnOff()){
            combo_programas_re_editar.setEditable(true);
            AutoCompleteDecorator.decorate(combo_programas_re_editar);
        }else{
            combo_programas_re_editar.setEditable(false);
            combo_programas_re_editar.requestFocus();
        }
    }//GEN-LAST:event_check_programasMouseClicked

    
    
    
    private void reset_campos(){
        cantidad_re_editar.setText("");
        combo_prefabricados_re_editar.setSelectedIndex(0);
        codigo_re_editar.setText("");
        um_re_editar.setText("");
        combo_programas_re_editar.setSelectedIndex(0);
        factura_re_editar.setText("");
        carta_porte_re_editar.setText("");
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
    private rojeru_san.RSButtonRiple boton_guardar_recursos_x_programa_editar;
    public static rojeru_san.rsfield.RSTextMaterial cantidad_re_editar;
    public static rojeru_san.rsfield.RSTextMaterial carta_porte_re_editar;
    private check_de_android.Switch check_prefabricados;
    private check_de_android.Switch check_programas;
    public static javax.swing.JLabel codigo_editar_control;
    public static rojeru_san.rsfield.RSTextMaterial codigo_re_editar;
    public static org.bolivia.combo.SComboBox combo_prefabricados_re_editar;
    public static org.bolivia.combo.SComboBox combo_programas_re_editar;
    public static rojeru_san.rsfield.RSTextMaterial factura_re_editar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_error_cant_re_editar;
    private javax.swing.JLabel lbl_error_carta_porte_re_editar;
    private javax.swing.JLabel lbl_error_descripcion_re_editar;
    private javax.swing.JLabel lbl_error_factura_re_editar;
    private javax.swing.JLabel lbl_error_programa_re_editar;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow1;
    public static rojeru_san.rsfield.RSTextMaterial um_re_editar;
    // End of variables declaration//GEN-END:variables
}
