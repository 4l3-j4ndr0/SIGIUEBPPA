/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles_de_paneles;

import alertas.*;
import esperas.Guardando_general;
import interaccion_bd.consultas_de_gestionar_info_lab;
import interaccion_bd.consultas_de_gestionar_recursos_x_programa;
import interaccion_bd.opciones_de_gestionar_contrato;
import interaccion_bd.opciones_de_gestionar_info_lab;
import interaccion_bd.opciones_de_gestionar_prod_programa;
import interaccion_bd.opciones_de_gestionar_recursos_x_programa;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
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
        lbl_error_asent_editar.setVisible(false);
        lbl_error_fecha_info_lab_editar.setVisible(false);
        lbl_error_lmpm_editar.setVisible(false);
        lbl_error_num_materiales_editar.setVisible(false);
        lbl_error_vol_m3_editar.setVisible(false);
        lbl_error_x1_28dias_editar.setVisible(false);
        lbl_error_x1_editar.setVisible(false);
        lbl_error_x2_28dias_editar.setVisible(false);
        lbl_error_x2_editar.setVisible(false);
        lbl_error_x3_28dias_editar.setVisible(false);
        lbl_error_x3_editar.setVisible(false);
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);
        
      deshabilitarPegar();
        opciones_de_gestionar_info_lab.get_combos(combo_lm_editar, combo_pm_editar);
      //################### detectar cambios en los combobox ######################3
        combo_lm_editar.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              lbl_error_lmpm_editar.setVisible(false);
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        
        combo_pm_editar.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              lbl_error_lmpm_editar.setVisible(false);
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        // ##########################################################################
   
        //  detectar cambio en jdateChoser )
        fecha_info_lab_editar.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    System.out.println(e.getPropertyName()
                            + ": " + (Date) e.getNewValue());
                    if(fecha_info_lab_editar.getDate()==null){
                    lbl_error_fecha_info_lab_editar.setVisible(true);
                    }
                }else{
                    lbl_error_fecha_info_lab_editar.setVisible(false);
                }
            }
        });
    }
    private int Vertical_Y;
    private int Horizontal_X;
    
     private void deshabilitarPegar() {
        InputMap map1 = num_materiales_editar.getInputMap(num_materiales_editar.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");

        InputMap map2 = x3_28dias_editar.getInputMap(x3_28dias_editar.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map3 = fecha_info_lab_editar.getInputMap(fecha_info_lab_editar.WHEN_FOCUSED);
        map3.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map4 = vol_m3_editar.getInputMap(vol_m3_editar.WHEN_FOCUSED);
        map4.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map5 = x1_editar.getInputMap(x1_editar.WHEN_FOCUSED);
        map5.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map6 = x2_editar.getInputMap(x2_editar.WHEN_FOCUSED);
        map6.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map7 = x3_editar.getInputMap(x3_editar.WHEN_FOCUSED);
        map7.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map8 = asent_editar.getInputMap(asent_editar.WHEN_FOCUSED);
        map8.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map9 = x1_28dias_editar.getInputMap(x1_28dias_editar.WHEN_FOCUSED);
        map9.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
        
        InputMap map10 = x2_28dias_editar.getInputMap(x2_28dias_editar.WHEN_FOCUSED);
        map10.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
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
                boton_guardar_info_lab_editarActionPerformed(e);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        panel_contenedor = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        num_materiales_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_num_materiales_editar = new javax.swing.JLabel();
        fecha_info_lab_editar = new com.toedter.calendar.JDateChooser();
        lbl_error_fecha_info_lab_editar = new javax.swing.JLabel();
        x1_editar = new rojeru_san.rsfield.RSTextMaterial();
        vol_m3_editar = new rojeru_san.rsfield.RSTextMaterial();
        asent_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_asent_editar = new javax.swing.JLabel();
        lbl_error_vol_m3_editar = new javax.swing.JLabel();
        lbl_error_x1_editar = new javax.swing.JLabel();
        x2_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_x2_editar = new javax.swing.JLabel();
        x3_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_x3_editar = new javax.swing.JLabel();
        x1_28dias_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_x1_28dias_editar = new javax.swing.JLabel();
        x3_28dias_editar = new rojeru_san.rsfield.RSTextMaterial();
        x2_28dias_editar = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_x2_28dias_editar = new javax.swing.JLabel();
        lbl_error_x3_28dias_editar = new javax.swing.JLabel();
        combo_pm_editar = new org.bolivia.combo.SComboBox();
        combo_lm_editar = new org.bolivia.combo.SComboBox();
        check_lm_editar = new check_de_android.Switch();
        check_pm_editar = new check_de_android.Switch();
        lbl_error_lmpm_editar = new javax.swing.JLabel();
        boton_guardar_info_lab_editar = new rojeru_san.RSButtonRiple();
        jLabel1 = new javax.swing.JLabel();
        control = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        panel_contenedor.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(782, 552));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        num_materiales_editar.setForeground(new java.awt.Color(0, 0, 0));
        num_materiales_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        num_materiales_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        num_materiales_editar.setPlaceholder("Número de materiales...");
        num_materiales_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        num_materiales_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num_materiales_editarActionPerformed(evt);
            }
        });
        num_materiales_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                num_materiales_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                num_materiales_editarKeyTyped(evt);
            }
        });

        lbl_error_num_materiales_editar.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error_num_materiales_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_num_materiales_editar.setText("¡Debe ingresar un número!");

        fecha_info_lab_editar.setDateFormatString("dd/MM/yyyy");
        fecha_info_lab_editar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fecha_info_lab_editar.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
                fecha_info_lab_editarAncestorRemoved(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        lbl_error_fecha_info_lab_editar.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error_fecha_info_lab_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_fecha_info_lab_editar.setText("¡Debe ingresar una fecha!");

        x1_editar.setForeground(new java.awt.Color(0, 0, 0));
        x1_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        x1_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        x1_editar.setPlaceholder("X1 (3 días)...");
        x1_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        x1_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                x1_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                x1_editarKeyTyped(evt);
            }
        });

        vol_m3_editar.setForeground(new java.awt.Color(0, 0, 0));
        vol_m3_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        vol_m3_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        vol_m3_editar.setPlaceholder("Volumen (m3)...");
        vol_m3_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        vol_m3_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vol_m3_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                vol_m3_editarKeyTyped(evt);
            }
        });

        asent_editar.setForeground(new java.awt.Color(0, 0, 0));
        asent_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        asent_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        asent_editar.setPlaceholder("Asent. (cm)...");
        asent_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        asent_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                asent_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                asent_editarKeyTyped(evt);
            }
        });

        lbl_error_asent_editar.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error_asent_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_asent_editar.setText("¡Debe ingresar un número!");

        lbl_error_vol_m3_editar.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error_vol_m3_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_vol_m3_editar.setText("¡Debe ingresar un número!");

        lbl_error_x1_editar.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error_x1_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_x1_editar.setText("¡Debe ingresar un número!");

        x2_editar.setForeground(new java.awt.Color(0, 0, 0));
        x2_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        x2_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        x2_editar.setPlaceholder("x2 (3 días)...");
        x2_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        x2_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                x2_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                x2_editarKeyTyped(evt);
            }
        });

        lbl_error_x2_editar.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error_x2_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_x2_editar.setText("¡Debe ingresar un número!");

        x3_editar.setForeground(new java.awt.Color(0, 0, 0));
        x3_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        x3_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        x3_editar.setPlaceholder("X3 (3 días)...");
        x3_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        x3_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                x3_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                x3_editarKeyTyped(evt);
            }
        });

        lbl_error_x3_editar.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error_x3_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_x3_editar.setText("¡Debe ingresar un número!");

        x1_28dias_editar.setForeground(new java.awt.Color(0, 0, 0));
        x1_28dias_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        x1_28dias_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        x1_28dias_editar.setPlaceholder("X1 (28 días)...");
        x1_28dias_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        x1_28dias_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                x1_28dias_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                x1_28dias_editarKeyTyped(evt);
            }
        });

        lbl_error_x1_28dias_editar.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error_x1_28dias_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_x1_28dias_editar.setText("¡Debe ingresar un número!");

        x3_28dias_editar.setForeground(new java.awt.Color(0, 0, 0));
        x3_28dias_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        x3_28dias_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        x3_28dias_editar.setPlaceholder("X3 (28 días)...");
        x3_28dias_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        x3_28dias_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                x3_28dias_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                x3_28dias_editarKeyTyped(evt);
            }
        });

        x2_28dias_editar.setForeground(new java.awt.Color(0, 0, 0));
        x2_28dias_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        x2_28dias_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        x2_28dias_editar.setPlaceholder("x2 (28 días)...");
        x2_28dias_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        x2_28dias_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                x2_28dias_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                x2_28dias_editarKeyTyped(evt);
            }
        });

        lbl_error_x2_28dias_editar.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error_x2_28dias_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_x2_28dias_editar.setText("¡Debe ingresar un número!");

        lbl_error_x3_28dias_editar.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error_x3_28dias_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_x3_28dias_editar.setText("¡Debe ingresar un número!");

        combo_pm_editar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MATERIALES (PM)" }));
        combo_pm_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_pm_editarActionPerformed(evt);
            }
        });

        combo_lm_editar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MATERIALES (LM)" }));
        combo_lm_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_lm_editarActionPerformed(evt);
            }
        });

        check_lm_editar.setToolTipText("Hacer o deshacer editable");
        check_lm_editar.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_lm_editar.setOnOff(false);
        check_lm_editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_lm_editarMouseClicked(evt);
            }
        });

        check_pm_editar.setToolTipText("Hacer o deshacer editable");
        check_pm_editar.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_pm_editar.setOnOff(false);
        check_pm_editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_pm_editarMouseClicked(evt);
            }
        });

        lbl_error_lmpm_editar.setForeground(new java.awt.Color(255, 0, 0));
        lbl_error_lmpm_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_lmpm_editar.setText("¡Debe seleccionar almenos un material!");

        boton_guardar_info_lab_editar.setBackground(new java.awt.Color(38, 86, 186));
        boton_guardar_info_lab_editar.setText("Guardar ");
        boton_guardar_info_lab_editar.setColorHover(new java.awt.Color(173, 187, 194));
        boton_guardar_info_lab_editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_guardar_info_lab_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_info_lab_editarActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_info_lab/info_lab.png"))); // NOI18N

        control.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(x1_28dias_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(x2_28dias_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_error_vol_m3_editar)
                            .addComponent(lbl_error_asent_editar)
                            .addComponent(lbl_error_x1_28dias_editar)
                            .addComponent(lbl_error_x2_28dias_editar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(asent_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(vol_m3_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(check_lm_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(combo_lm_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addComponent(control)))))
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(x1_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(combo_pm_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(check_pm_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(x3_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbl_error_num_materiales_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(num_materiales_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fecha_info_lab_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_error_fecha_info_lab_editar, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(x2_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x3_28dias_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_error_x1_editar)
                    .addComponent(lbl_error_x2_editar)
                    .addComponent(lbl_error_x3_editar)
                    .addComponent(lbl_error_x3_28dias_editar))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(lbl_error_lmpm_editar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(boton_guardar_info_lab_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(num_materiales_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_num_materiales_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fecha_info_lab_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_fecha_info_lab_editar)
                        .addGap(15, 15, 15)))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vol_m3_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x1_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(control))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_error_x1_editar)
                    .addComponent(lbl_error_vol_m3_editar))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(asent_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x2_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_error_asent_editar)
                    .addComponent(lbl_error_x2_editar))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(x1_28dias_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(x3_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_error_x3_editar)
                    .addComponent(lbl_error_x1_28dias_editar))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(x2_28dias_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_x2_28dias_editar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(x3_28dias_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbl_error_x3_28dias_editar)))
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_lm_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_lm_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_pm_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(check_pm_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addComponent(lbl_error_lmpm_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(boton_guardar_info_lab_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout panel_contenedorLayout = new javax.swing.GroupLayout(panel_contenedor);
        panel_contenedor.setLayout(panel_contenedorLayout);
        panel_contenedorLayout.setHorizontalGroup(
            panel_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panel_contenedorLayout.setVerticalGroup(
            panel_contenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jScrollPane2.setViewportView(panel_contenedor);

        javax.swing.GroupLayout rSPanelShadow1Layout = new javax.swing.GroupLayout(rSPanelShadow1);
        rSPanelShadow1.setLayout(rSPanelShadow1Layout);
        rSPanelShadow1Layout.setHorizontalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)
        );
        rSPanelShadow1Layout.setVerticalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelShadow1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void num_materiales_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_num_materiales_editarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_num_materiales_editarActionPerformed

    private void num_materiales_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_num_materiales_editarKeyReleased
        // TODO add your handling code here:
        if(num_materiales_editar.getText().length()>0){
            lbl_error_num_materiales_editar.setVisible(false);
        }
    }//GEN-LAST:event_num_materiales_editarKeyReleased

    private void num_materiales_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_num_materiales_editarKeyTyped
        // TODO add your handling code here:
        if(num_materiales_editar.getText().length()<10){
            char num = evt.getKeyChar();
            if ((num < '0' || num > '9')) {
                evt.consume();
            }
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_num_materiales_editarKeyTyped

    private void fecha_info_lab_editarAncestorRemoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_fecha_info_lab_editarAncestorRemoved
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha_info_lab_editarAncestorRemoved

    private void x1_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x1_editarKeyReleased
        // TODO add your handling code here:
        if(x1_editar.getText().length()>0){
            lbl_error_x1_editar.setVisible(false);
        }
    }//GEN-LAST:event_x1_editarKeyReleased

    int ptox1_editar=0;
    int lugaresx1_editar=0;
    private void x1_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x1_editarKeyTyped
        // TODO add your handling code here:

        char caracter = evt.getKeyChar();
        if(caracter=='.'){
            ptox1_editar++;
        }
        if( ptox1_editar>=2){
            ptox1_editar=2;
        }
        if( lugaresx1_editar>=3){
            lugaresx1_editar--;
        }

        if(caracter == KeyEvent.VK_BACK_SPACE){
            if( ptox1_editar>=0){
                lugaresx1_editar--;
            }

            if(!x1_editar.getText().contains(".")){
                ptox1_editar=0;
            }
            if( ptox1_editar==0){
                lugaresx1_editar=0;
            }
        }
        if (x1_editar.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(x1_editar.getText().length()<10){
                char num = evt.getKeyChar();
                if (Character.isDigit(num)||num=='.') {
                    if(num=='.'&&ptox1_editar<2){
                        // escribe
                    }else{
                        if(ptox1_editar!=0&&num!='.'){
                            lugaresx1_editar++;
                        }
                        if(lugaresx1_editar<3 && num!='.'){
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
    }//GEN-LAST:event_x1_editarKeyTyped

    private void vol_m3_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vol_m3_editarKeyReleased
        // TODO add your handling code here:
        if(vol_m3_editar.getText().length()>0){
            lbl_error_vol_m3_editar.setVisible(false);
        }
    }//GEN-LAST:event_vol_m3_editarKeyReleased

    int ptovol_m3_editar=0;
    int lugaresvol_m3_editar=0;
    private void vol_m3_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vol_m3_editarKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if(caracter=='.'){
            ptovol_m3_editar++;
        }
        if( ptovol_m3_editar>=2){
            ptovol_m3_editar=2;
        }
        if( lugaresvol_m3_editar>=3){
            lugaresvol_m3_editar--;
        }

        if(caracter == KeyEvent.VK_BACK_SPACE){
            if( ptovol_m3_editar>=0){
                lugaresvol_m3_editar--;
            }

            if(!vol_m3_editar.getText().contains(".")){
                ptovol_m3_editar=0;
            }
            if( ptovol_m3_editar==0){
                lugaresvol_m3_editar=0;
            }
        }
        if (vol_m3_editar.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(vol_m3_editar.getText().length()<10){
                char num = evt.getKeyChar();
                if (Character.isDigit(num)||num=='.') {
                    if(num=='.'&&ptovol_m3_editar<2){
                        // escribe
                    }else{
                        if(ptovol_m3_editar!=0&&num!='.'){
                            lugaresvol_m3_editar++;
                        }
                        if(lugaresvol_m3_editar<3 && num!='.'){
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
    }//GEN-LAST:event_vol_m3_editarKeyTyped

    private void asent_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_asent_editarKeyReleased
        // TODO add your handling code here:
        if(asent_editar.getText().length()>0){
            lbl_error_asent_editar.setVisible(false);
        }
    }//GEN-LAST:event_asent_editarKeyReleased

    int ptoasent_editar=0;
    int lugaresasent_editar;
    private void asent_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_asent_editarKeyTyped
        // TODO add your handling code here:

        char caracter = evt.getKeyChar();
        if(caracter=='.'){
            ptoasent_editar++;
        }
        if( ptoasent_editar>=2){
            ptoasent_editar=2;
        }
        if( lugaresasent_editar>=3){
            lugaresasent_editar--;
        }

        if(caracter == KeyEvent.VK_BACK_SPACE){
            if( ptoasent_editar>=0){
                lugaresasent_editar--;
            }

            if(!asent_editar.getText().contains(".")){
                ptoasent_editar=0;
            }
            if( ptoasent_editar==0){
                lugaresasent_editar=0;
            }
        }
        if (asent_editar.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(asent_editar.getText().length()<10){
                char num = evt.getKeyChar();
                if (Character.isDigit(num)||num=='.') {
                    if(num=='.'&&ptoasent_editar<2){
                        // escribe
                    }else{
                        if(ptoasent_editar!=0&&num!='.'){
                            lugaresasent_editar++;
                        }
                        if(lugaresasent_editar<3 && num!='.'){
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
    }//GEN-LAST:event_asent_editarKeyTyped

    private void x2_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x2_editarKeyReleased
        // TODO add your handling code here:
        if(x2_editar.getText().length()>0){
            lbl_error_x2_editar.setVisible(false);
        }
    }//GEN-LAST:event_x2_editarKeyReleased

    int ptox2_editar=0;
    int lugaresx2_editar;
    private void x2_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x2_editarKeyTyped
        // TODO add your handling code here:

        char caracter = evt.getKeyChar();
        if(caracter=='.'){
            ptox2_editar++;
        }
        if( ptox2_editar>=2){
            ptox2_editar=2;
        }
        if( lugaresx2_editar>=3){
            lugaresx2_editar--;
        }

        if(caracter == KeyEvent.VK_BACK_SPACE){
            if( ptox2_editar>=0){
                lugaresx2_editar--;
            }

            if(!x2_editar.getText().contains(".")){
                ptox2_editar=0;
            }
            if( ptox2_editar==0){
                lugaresx2_editar=0;
            }
        }
        if (x2_editar.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(x2_editar.getText().length()<10){
                char num = evt.getKeyChar();
                if (Character.isDigit(num)||num=='.') {
                    if(num=='.'&&ptox2_editar<2){
                        // escribe
                    }else{
                        if(ptox2_editar!=0&&num!='.'){
                            lugaresx2_editar++;
                        }
                        if(lugaresx2_editar<3 && num!='.'){
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
    }//GEN-LAST:event_x2_editarKeyTyped

    private void x3_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x3_editarKeyReleased
        // TODO add your handling code here:
        if(x3_editar.getText().length()>0){
            lbl_error_x3_editar.setVisible(false);
        }
    }//GEN-LAST:event_x3_editarKeyReleased

    int ptox3_editar=0;
    int lugaresx3_editar;
    private void x3_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x3_editarKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if(caracter=='.'){
            ptox3_editar++;
        }
        if( ptox3_editar>=2){
            ptox3_editar=2;
        }
        if( lugaresx3_editar>=3){
            lugaresx3_editar--;
        }

        if(caracter == KeyEvent.VK_BACK_SPACE){
            if( ptox3_editar>=0){
                lugaresx3_editar--;
            }

            if(!x3_editar.getText().contains(".")){
                ptox3_editar=0;
            }
            if( ptox3_editar==0){
                lugaresx3_editar=0;
            }
        }
        if (x3_editar.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(x3_editar.getText().length()<10){
                char num = evt.getKeyChar();
                if (Character.isDigit(num)||num=='.') {
                    if(num=='.'&&ptox3_editar<2){
                        // escribe
                    }else{
                        if(ptox3_editar!=0&&num!='.'){
                            lugaresx3_editar++;
                        }
                        if(lugaresx3_editar<3 && num!='.'){
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
    }//GEN-LAST:event_x3_editarKeyTyped

    private void x1_28dias_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x1_28dias_editarKeyReleased
        // TODO add your handling code here:
        if(x1_28dias_editar.getText().length()>0){
            lbl_error_x1_28dias_editar.setVisible(false);
        }
    }//GEN-LAST:event_x1_28dias_editarKeyReleased

    int ptox1_28dias_editar=0;
    int lugaresx1_28dias_editar;
    private void x1_28dias_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x1_28dias_editarKeyTyped
        // TODO add your handling code here:

        char caracter = evt.getKeyChar();
        if(caracter=='.'){
            ptox1_28dias_editar++;
        }
        if( ptox1_28dias_editar>=2){
            ptox1_28dias_editar=2;
        }
        if( lugaresx1_28dias_editar>=3){
            lugaresx1_28dias_editar--;
        }

        if(caracter == KeyEvent.VK_BACK_SPACE){
            if( ptox1_28dias_editar>=0){
                lugaresx1_28dias_editar--;
            }

            if(!x1_28dias_editar.getText().contains(".")){
                ptox1_28dias_editar=0;
            }
            if( ptox1_28dias_editar==0){
                lugaresx1_28dias_editar=0;
            }
        }
        if (x1_28dias_editar.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(x1_28dias_editar.getText().length()<10){
                char num = evt.getKeyChar();
                if (Character.isDigit(num)||num=='.') {
                    if(num=='.'&&ptox1_28dias_editar<2){
                        // escribe
                    }else{
                        if(ptox1_28dias_editar!=0&&num!='.'){
                            lugaresx1_28dias_editar++;
                        }
                        if(lugaresx1_28dias_editar<3 && num!='.'){
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
    }//GEN-LAST:event_x1_28dias_editarKeyTyped

    private void x3_28dias_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x3_28dias_editarKeyReleased
        // TODO add your handling code here:
        if(x3_28dias_editar.getText().length()>0){
            lbl_error_x3_28dias_editar.setVisible(false);
        }
    }//GEN-LAST:event_x3_28dias_editarKeyReleased

    int ptox3_28dias_editar=0;
    int lugaresx3_28dias_editar;
    private void x3_28dias_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x3_28dias_editarKeyTyped
        // TODO add your handling code here:
        char caracter = evt.getKeyChar();
        if(caracter=='.'){
            ptox3_28dias_editar++;
        }
        if( ptox3_28dias_editar>=2){
            ptox3_28dias_editar=2;
        }
        if( lugaresx3_28dias_editar>=3){
            lugaresx3_28dias_editar--;
        }

        if(caracter == KeyEvent.VK_BACK_SPACE){
            if( ptox3_28dias_editar>=0){
                lugaresx3_28dias_editar--;
            }

            if(!x3_28dias_editar.getText().contains(".")){
                ptox3_28dias_editar=0;
            }
            if( ptox3_28dias_editar==0){
                lugaresx3_28dias_editar=0;
            }
        }
        if (x3_28dias_editar.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(x3_28dias_editar.getText().length()<10){
                char num = evt.getKeyChar();
                if (Character.isDigit(num)||num=='.') {
                    if(num=='.'&&ptox3_28dias_editar<2){
                        // escribe
                    }else{
                        if(ptox3_28dias_editar!=0&&num!='.'){
                            lugaresx3_28dias_editar++;
                        }
                        if(lugaresx3_28dias_editar<3 && num!='.'){
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
    }//GEN-LAST:event_x3_28dias_editarKeyTyped

    private void x2_28dias_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x2_28dias_editarKeyReleased
        // TODO add your handling code here:
        if(x2_28dias_editar.getText().length()>0){
            lbl_error_x2_28dias_editar.setVisible(false);
        }
    }//GEN-LAST:event_x2_28dias_editarKeyReleased

    int ptox2_28dias_editar=0;
    int lugaresx2_28dias_editar;
    private void x2_28dias_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_x2_28dias_editarKeyTyped
        // TODO add your handling code here:

        char caracter = evt.getKeyChar();
        if(caracter=='.'){
            ptox2_28dias_editar++;
        }
        if( ptox2_28dias_editar>=2){
            ptox2_28dias_editar=2;
        }
        if( lugaresx2_28dias_editar>=3){
            lugaresx2_28dias_editar--;
        }

        if(caracter == KeyEvent.VK_BACK_SPACE){
            if( ptox2_28dias_editar>=0){
                lugaresx2_28dias_editar--;
            }

            if(!x2_28dias_editar.getText().contains(".")){
                ptox2_28dias_editar=0;
            }
            if( ptox2_28dias_editar==0){
                lugaresx2_28dias_editar=0;
            }
        }
        if (x2_28dias_editar.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(x2_28dias_editar.getText().length()<10){
                char num = evt.getKeyChar();
                if (Character.isDigit(num)||num=='.') {
                    if(num=='.'&&ptox2_28dias_editar<2){
                        // escribe
                    }else{
                        if(ptox2_28dias_editar!=0&&num!='.'){
                            lugaresx2_28dias_editar++;
                        }
                        if(lugaresx2_28dias_editar<3 && num!='.'){
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
    }//GEN-LAST:event_x2_28dias_editarKeyTyped

    private void combo_pm_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_pm_editarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_pm_editarActionPerformed

    private void combo_lm_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_lm_editarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_lm_editarActionPerformed

    private void check_lm_editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_lm_editarMouseClicked
        // TODO add your handling code here:
        if(check_lm_editar.isOnOff()){
            combo_lm_editar.setEditable(true);
            AutoCompleteDecorator.decorate(combo_lm_editar);
        }else{
            combo_lm_editar.setEditable(false);
            combo_lm_editar.requestFocus();
        }
    }//GEN-LAST:event_check_lm_editarMouseClicked

    private void check_pm_editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_pm_editarMouseClicked
        // TODO add your handling code here:
        if(check_pm_editar.isOnOff()){
            combo_pm_editar.setEditable(true);
            AutoCompleteDecorator.decorate(combo_pm_editar);
        }else{
            combo_pm_editar.setEditable(false);
            combo_pm_editar.requestFocus();
        }
    }//GEN-LAST:event_check_pm_editarMouseClicked

    private void boton_guardar_info_lab_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_info_lab_editarActionPerformed
        String sql_lm = "SELECT * FROM `prefabricados` WHERE `descripcion_prefabricado`='" + combo_lm_editar.getSelectedItem().toString().trim() + "'";
        String sql_pm = "SELECT * FROM `prefabricados` WHERE `descripcion_prefabricado`='" + combo_pm_editar.getSelectedItem().toString().trim() + "'";
        System.out.println(combo_lm_editar.getSelectedItem().toString());
        System.out.println(opciones_de_gestionar_prod_programa.existe(sql_lm));
        if (num_materiales_editar.getText().isEmpty() || fecha_info_lab_editar.getDate() == null || vol_m3_editar.getText().isEmpty() || x1_editar.getText().isEmpty()
            || asent_editar.getText().isEmpty()
            || x2_editar.getText().isEmpty() || x1_28dias_editar.getText().isEmpty() || x3_editar.getText().isEmpty() || x2_28dias_editar.getText().isEmpty()
            || x3_28dias_editar.getText().isEmpty() || (combo_lm_editar.getSelectedIndex() == 0 && combo_pm_editar.getSelectedIndex() == 0)
            || (opciones_de_gestionar_prod_programa.existe(sql_lm) == false && combo_pm_editar.getSelectedIndex() == 0)
            || (opciones_de_gestionar_prod_programa.existe(sql_pm) == false && combo_lm_editar.getSelectedIndex() == 0)) {
            if (num_materiales_editar.getText().isEmpty()) {
                num_materiales_editar.requestFocus();
                lbl_error_num_materiales_editar.setVisible(true);
            } else if (fecha_info_lab_editar.getDate() == null) {
                fecha_info_lab_editar.requestFocus();
                lbl_error_fecha_info_lab_editar.setVisible(true);
            } else if (vol_m3_editar.getText().isEmpty()) {
                vol_m3_editar.requestFocus();
                lbl_error_vol_m3_editar.setVisible(true);
            } else if (x1_editar.getText().isEmpty()) {
                x1_editar.requestFocus();
                lbl_error_x1_editar.setVisible(true);
            } else if (asent_editar.getText().isEmpty()) {
                asent_editar.requestFocus();
                lbl_error_asent_editar.setVisible(true);
            } else if (x2_editar.getText().isEmpty()) {
                x2_editar.requestFocus();
                lbl_error_x2_editar.setVisible(true);
            } else if (x1_28dias_editar.getText().isEmpty()) {
                x1_28dias_editar.requestFocus();
                lbl_error_x1_28dias_editar.setVisible(true);
            } else if (x3_editar.getText().isEmpty()) {
                x3_editar.requestFocus();
                lbl_error_x3_editar.setVisible(true);
            } else if (x2_28dias_editar.getText().isEmpty()) {
                x2_28dias_editar.requestFocus();
                lbl_error_x2_28dias_editar.setVisible(true);
            } else if (x3_28dias_editar.getText().isEmpty()) {
                x3_28dias_editar.requestFocus();
                lbl_error_x3_28dias_editar.setVisible(true);
            } else if (combo_lm_editar.getSelectedIndex() == 0 && combo_pm_editar.getSelectedIndex() == 0) {
                combo_lm_editar.requestFocus();
                lbl_error_lmpm_editar.setVisible(true);
            } else if (opciones_de_gestionar_prod_programa.existe(sql_lm) == false && combo_pm_editar.getSelectedIndex() == 0) {
                opciones_de_gestionar_contrato.lanza_error_variable_sin_ex("El elemento descrito no se encuentra en la base de datos.",
                    "",
                    "Seleccione uno existente en nuestra base de datos");
                combo_lm_editar.requestFocus();

            } else if (opciones_de_gestionar_prod_programa.existe(sql_pm) == false && combo_lm_editar.getSelectedIndex() == 0) {
                opciones_de_gestionar_contrato.lanza_error_variable_sin_ex("El elemento descrito no se encuentra en la base de datos.",
                    "Por favor, elija uno de los existentes en nuestra base de datos.",
                    "");
                combo_pm_editar.requestFocus();
            } else if (combo_lm_editar.getSelectedIndex() != 0 && combo_pm_editar.getSelectedIndex() != 0) {
                if (opciones_de_gestionar_prod_programa.existe(sql_lm) == false) {
                    opciones_de_gestionar_contrato.lanza_error_variable_sin_ex("El elemento descrito no se encuentra en la base de datos.",
                        "Por favor, elija uno de los existentes en nuestra base de datos.",
                        "");
                    combo_lm_editar.requestFocus();
                }
                if (opciones_de_gestionar_prod_programa.existe(sql_pm) == false) {
                    opciones_de_gestionar_contrato.lanza_error_variable_sin_ex("El elemento descrito no se encuentra en la base de datos.",
                        "Por favor, elija uno de los existentes en nuestra base de datos.",
                        "");
                    combo_pm_editar.requestFocus();
                }
            }
        } else {
            Guardando_general l = new Guardando_general(new JFrame(), true);
            consultas_de_gestionar_info_lab uc = new consultas_de_gestionar_info_lab();
            l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_info_laboratorio_editar.this);
            l.setVisible(true);
            paneles_de_paneles.de_gestionar_info_laboratorio_editar.this.setEnabled(false);
            uc.setNum_materiales(num_materiales_editar.getText());
            uc.setFecha(de_gestionar_contrato_editar.toma_fecha(fecha_info_lab_editar));
            uc.setVol(vol_m3_editar.getText());
            uc.setAsent(asent_editar.getText());
            uc.setX1(x1_editar.getText());
            uc.setX2(x2_editar.getText());
            uc.setX3(x3_editar.getText());
            uc.setX1_28dias(x1_28dias_editar.getText());
            uc.setX2_28dias(x2_28dias_editar.getText());
            uc.setX3_28dias(x3_28dias_editar.getText());
            if (combo_lm_editar.getSelectedIndex() != 0) {
                uc.setLm(combo_lm_editar.getSelectedItem().toString());
            } else {
                uc.setLm("");
            }
            if (combo_pm_editar.getSelectedIndex() != 0) {
                uc.setPm(combo_pm_editar.getSelectedItem().toString());
            } else {
                uc.setPm("");
            }
            uc.setElementos(uc.getLm() + " " + uc.getPm());
            System.out.println(uc.getElementos());
            int control = opciones_de_gestionar_info_lab.actualizar(uc);
            paneles_de_paneles.de_gestionar_info_laboratorio_editar.this.setEnabled(true);
            l.setVisible(false);
            if (control == 1) {
                reset_campos();
                opciones_de_gestionar_info_lab.setListar("");
//                interaccion_bd.opciones_de_gestionar_info_lab.setListar("");
                //################### ocultar primera columna ############################# (no impide tomar el dato de la tabla)
                de_gestionar_info_laboratorio_listar.tabla_info_lab.getColumnModel().getColumn(0).setMaxWidth(0);
                de_gestionar_info_laboratorio_listar.tabla_info_lab.getColumnModel().getColumn(0).setMinWidth(0);
                de_gestionar_info_laboratorio_listar.tabla_info_lab.getColumnModel().getColumn(0).setPreferredWidth(0);
                //##########################################################################
                this.dispose();
                SuccessAlert e = new SuccessAlert(new JFrame(), true);
                e.msj1.setText("¡La informacion para el laboratorio");
                e.msj2.setText("fue guardada exitosamente!.");
                e.msj3.setText("");
                e.setVisible(true);
            }
            
        }
    }//GEN-LAST:event_boton_guardar_info_lab_editarActionPerformed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        // TODO add your handling code here:
        if (getX() == 0 && getY() == 0) {
        } else {
            setLocation(evt.getXOnScreen() - Horizontal_X, evt.getYOnScreen() - Vertical_Y);
            if (evt.getYOnScreen() == 0) {
                // Maximizar();
            }
        }
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        // TODO add your handling code here:
        Vertical_Y = evt.getY();
        Horizontal_X = evt.getX();
    }//GEN-LAST:event_jPanel2MousePressed

    
    
    
    private void reset_campos(){
        num_materiales_editar.setText("");
        fecha_info_lab_editar.setDate(null);
        vol_m3_editar.setText("");
        asent_editar.setText("");
        x1_editar.setText("");
        x2_editar.setText("");
        x3_editar.setText("");
        x1_28dias_editar.setText("");
        x2_28dias_editar.setText("");
        x3_28dias_editar.setText("");
        combo_lm_editar.setSelectedIndex(0);
        combo_pm_editar.setSelectedIndex(0);
        lbl_error_fecha_info_lab_editar.setVisible(false);
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
    public static rojeru_san.rsfield.RSTextMaterial asent_editar;
    private rojeru_san.RSButtonRiple boton_guardar_info_lab_editar;
    private check_de_android.Switch check_lm_editar;
    private check_de_android.Switch check_pm_editar;
    public static org.bolivia.combo.SComboBox combo_lm_editar;
    public static org.bolivia.combo.SComboBox combo_pm_editar;
    public static javax.swing.JLabel control;
    public static com.toedter.calendar.JDateChooser fecha_info_lab_editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_error_asent_editar;
    private javax.swing.JLabel lbl_error_fecha_info_lab_editar;
    private javax.swing.JLabel lbl_error_lmpm_editar;
    private javax.swing.JLabel lbl_error_num_materiales_editar;
    private javax.swing.JLabel lbl_error_vol_m3_editar;
    private javax.swing.JLabel lbl_error_x1_28dias_editar;
    private javax.swing.JLabel lbl_error_x1_editar;
    private javax.swing.JLabel lbl_error_x2_28dias_editar;
    private javax.swing.JLabel lbl_error_x2_editar;
    private javax.swing.JLabel lbl_error_x3_28dias_editar;
    private javax.swing.JLabel lbl_error_x3_editar;
    public static rojeru_san.rsfield.RSTextMaterial num_materiales_editar;
    private javax.swing.JPanel panel_contenedor;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow1;
    public static rojeru_san.rsfield.RSTextMaterial vol_m3_editar;
    public static rojeru_san.rsfield.RSTextMaterial x1_28dias_editar;
    public static rojeru_san.rsfield.RSTextMaterial x1_editar;
    public static rojeru_san.rsfield.RSTextMaterial x2_28dias_editar;
    public static rojeru_san.rsfield.RSTextMaterial x2_editar;
    public static rojeru_san.rsfield.RSTextMaterial x3_28dias_editar;
    public static rojeru_san.rsfield.RSTextMaterial x3_editar;
    // End of variables declaration//GEN-END:variables
}
