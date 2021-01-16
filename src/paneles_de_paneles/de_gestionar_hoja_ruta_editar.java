/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles_de_paneles;

import DAO.PdfDAO;
import DAO.PdfDAO_hoja_ruta;
import Tabla.Tabla_PdfVO;
import Tabla.Tabla_PdfVO_hoja_ruta;
import VO.PdfVO;
import VO.PdfVO_hoja_ruta;
import alertas.*;
import com.toedter.calendar.JDateChooser;
import esperas.Guardando_general;
import interaccion_bd.opciones_de_gestionar_contrato;
import interaccion_bd.opciones_de_gestionar_hoja_ruta;
import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException; 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import necesario.RSAWTUtilities;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import static paneles_de_paneles.de_gestionar_plano_listar.tabla_plano;
import rojeru_san.complementos.RSMoveObject;
import rojeru_san.complementos.RSUtilities;

/**
 *
 * @author RojeruSan
 */
public class de_gestionar_hoja_ruta_editar extends javax.swing.JDialog {

    /**
     * Creates new form ErrorAlert
     */
    public de_gestionar_hoja_ruta_editar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lbl_error_km_hoja_ruta_editar.setVisible(false);
        lbl_error_pdf_km_hoja_ruta_editar.setVisible(false);
        deshabilitarPegar();
        RSAWTUtilities.setOpaque(this, false);
        RSUtilities.setCentrarVentana(this);
        RSMoveObject.setMoverVentana(this);
        addEventKey();
        combo_chapa_hoja_ruta_editar.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
              lbl_error_chapa_hoja_ruta_editar.setVisible(false);
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
         opciones_de_gestionar_hoja_ruta.get_combos(combo_chapa_hoja_ruta_editar);
         id_hoja_ruta.setVisible(false);
    }
     String  ruta_archivo="";
     
    

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
        lb_foto = new javax.swing.JLabel();
        boton_busca_hoja_ruta_editar = new rojeru_san.RSButtonRiple();
        lbl_error_pdf_km_hoja_ruta_editar = new javax.swing.JLabel();
        boton_guardar_km_hoja_ruta_editar = new rojeru_san.RSButtonRiple();
        lbl_error_km_hoja_ruta_editar = new javax.swing.JLabel();
        km_hoja_ruta_editar = new rojeru_san.rsfield.RSTextMaterial();
        combo_chapa_hoja_ruta_editar = new org.bolivia.combo.SComboBox();
        check_android_hoja_ruta_editar = new check_de_android.Switch();
        lbl_error_chapa_hoja_ruta_editar = new javax.swing.JLabel();
        id_hoja_ruta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(782, 552));

        lb_foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_hoja_ruta/prueba fibnal.png"))); // NOI18N

        boton_busca_hoja_ruta_editar.setBackground(new java.awt.Color(38, 86, 186));
        boton_busca_hoja_ruta_editar.setText("Modificar Hoja de Ruta");
        boton_busca_hoja_ruta_editar.setColorHover(new java.awt.Color(173, 187, 194));
        boton_busca_hoja_ruta_editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_busca_hoja_ruta_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_busca_hoja_ruta_editarActionPerformed(evt);
            }
        });

        lbl_error_pdf_km_hoja_ruta_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_pdf_km_hoja_ruta_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_pdf_km_hoja_ruta_editar.setText("¡Debe buscar una hoja de ruta!");

        boton_guardar_km_hoja_ruta_editar.setBackground(new java.awt.Color(38, 86, 186));
        boton_guardar_km_hoja_ruta_editar.setText("Guardar Cambios");
        boton_guardar_km_hoja_ruta_editar.setColorHover(new java.awt.Color(173, 187, 194));
        boton_guardar_km_hoja_ruta_editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_guardar_km_hoja_ruta_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_km_hoja_ruta_editarActionPerformed(evt);
            }
        });

        lbl_error_km_hoja_ruta_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_km_hoja_ruta_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_km_hoja_ruta_editar.setText("¡Debe ingresar un total de km!");

        km_hoja_ruta_editar.setForeground(new java.awt.Color(0, 0, 0));
        km_hoja_ruta_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        km_hoja_ruta_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        km_hoja_ruta_editar.setPlaceholder("Total de km recorridos...");
        km_hoja_ruta_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        km_hoja_ruta_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                km_hoja_ruta_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                km_hoja_ruta_editarKeyTyped(evt);
            }
        });

        combo_chapa_hoja_ruta_editar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHAPA DEL VEHÍCULO" }));
        combo_chapa_hoja_ruta_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_chapa_hoja_ruta_editarActionPerformed(evt);
            }
        });

        check_android_hoja_ruta_editar.setOnOff(false);
        check_android_hoja_ruta_editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_android_hoja_ruta_editarMouseClicked(evt);
            }
        });

        lbl_error_chapa_hoja_ruta_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_chapa_hoja_ruta_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_chapa_hoja_ruta_editar.setText("¡Debe ingresar una chapa de vehiculo!");

        id_hoja_ruta.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_error_pdf_km_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(boton_busca_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(id_hoja_ruta))))
                    .addComponent(lb_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(combo_chapa_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(check_android_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbl_error_km_hoja_ruta_editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(boton_guardar_km_hoja_ruta_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(km_hoja_ruta_editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbl_error_chapa_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_foto, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_chapa_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(check_android_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addComponent(lbl_error_chapa_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(km_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbl_error_km_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(boton_guardar_km_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(boton_busca_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(id_hoja_ruta))
                .addGap(0, 0, 0)
                .addComponent(lbl_error_pdf_km_hoja_ruta_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rSPanelShadow1Layout = new javax.swing.GroupLayout(rSPanelShadow1);
        rSPanelShadow1.setLayout(rSPanelShadow1Layout);
        rSPanelShadow1Layout.setHorizontalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
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
                boton_guardar_km_hoja_ruta_editarActionPerformed(e);
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enter, "ENTER");
        getRootPane().getActionMap().put("ENTER", enterAction);
        
       
    }
    
    private void deshabilitarPegar() {
        InputMap map1 = km_hoja_ruta_editar.getInputMap(km_hoja_ruta_editar.WHEN_FOCUSED);
        map1.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
             
    
    private void boton_busca_hoja_ruta_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_busca_hoja_ruta_editarActionPerformed
        // TODO add your handling code here:
        try{
            JFileChooser j = new JFileChooser();
            FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
            j.setFileFilter(fi);
            int se = j.showOpenDialog(this);
            if (se == 0) {
                this.boton_busca_hoja_ruta_editar.setText("" + j.getSelectedFile().getName());
                ruta_archivo = j.getSelectedFile().getAbsolutePath();

                lb_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_planos/pdf2.png")));
                lbl_error_pdf_km_hoja_ruta_editar.setVisible(false);
            }
        }catch(Exception ex){
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
    }//GEN-LAST:event_boton_busca_hoja_ruta_editarActionPerformed

    Tabla_PdfVO_hoja_ruta tpdf = new Tabla_PdfVO_hoja_ruta();
    private void boton_guardar_km_hoja_ruta_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_km_hoja_ruta_editarActionPerformed
        String sql="select * from ekipos where chapa_ekipo='"+combo_chapa_hoja_ruta_editar.getSelectedItem().toString().trim()+"'";
        String mje1="No existe un vehículo con esta chapa: ("+combo_chapa_hoja_ruta_editar.getSelectedItem().toString()+")";
        String mje2="¿Por favor, verifique su chapa nuevamente ?";
        String mje3="En caso de que el número de chapa este correcto primero debe agregar el equipo";
        if (combo_chapa_hoja_ruta_editar.getSelectedIndex()==0
                ||km_hoja_ruta_editar.getText().isEmpty()||interaccion_bd.opciones_de_gestionar_prod_programa.existe(sql)==false) {
              
            if(combo_chapa_hoja_ruta_editar.getSelectedIndex()==0){
                lbl_error_chapa_hoja_ruta_editar.setVisible(true);
                combo_chapa_hoja_ruta_editar.requestFocus();
               }else if(km_hoja_ruta_editar.getText().isEmpty()){
                   lbl_error_km_hoja_ruta_editar.setVisible(true);
                   km_hoja_ruta_editar.requestFocus();
               }else if(interaccion_bd.opciones_de_gestionar_prod_programa.existe(sql)==false){
                   combo_chapa_hoja_ruta_editar.requestFocus();
                   opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mje1, mje2, mje3);
               }
        } else {
            
                Runnable runnable1 = new Runnable() {
                    public void run() {
                        Guardando_general l = new Guardando_general(new JFrame(), true);
                        l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_hoja_ruta_editar.this);
                        l.setVisible(true);
                        try{
                            paneles_de_paneles.de_gestionar_hoja_ruta_editar.this.setEnabled(false);
                            
                            modificar();
                            SuccessAlert e = new SuccessAlert(new JFrame(), true);
                            e.msj1.setText("¡Los datos de la hoja de ruta fueron");
                            e.msj2.setText("guardados exitosamente!.");
                            e.msj3.setText("");
                            e.setVisible(true);
                            de_gestionar_hoja_ruta_editar.this.setEnabled(true);
                            l.setVisible(false);
                        }catch(Exception e){
                            Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, e);
                            opciones_de_gestionar_contrato.lanza_error(e);
                        }
                    }
                };
                Thread t1 = new Thread(runnable1);
                t1.start();
                
                       
         }
        this.dispose();
    }//GEN-LAST:event_boton_guardar_km_hoja_ruta_editarActionPerformed

    private void modificar() {                                             
        String chapa = combo_chapa_hoja_ruta_editar.getSelectedItem().toString();
        String km = km_hoja_ruta_editar.getText();
        String consumo=String.valueOf(de_gestionar_hoja_ruta_añadir.dame_consumo(chapa)*Double.parseDouble(km));
        File ruta = new File(ruta_archivo);
        if (chapa.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
            modificar_pdf(chapa, km, consumo, Integer.parseInt(id_hoja_ruta.getText()),  ruta);
            System.out.println("MODIFICAR CON RUTA");
            tpdf.visualizar_PdfVO(de_gestionar_hoja_ruta_listar.tabla_hoja_ruta);
        } else if (ruta_archivo.trim().length() == 0) {
            modificar_pdf(chapa,km, consumo,Integer.parseInt(id_hoja_ruta.getText()));
            System.out.println("MODIFICAR SIN RUTA");
            tpdf.visualizar_PdfVO(de_gestionar_hoja_ruta_listar.tabla_hoja_ruta);
        }
        ruta_archivo = "";
        de_gestionar_hoja_ruta_listar.tabla_hoja_ruta.setDefaultRenderer(Object.class, new modelo_tablas.Tabla_Planos());
    } 
    
    public void modificar_pdf( String chapa, String km, String consumo, int id, File ruta) {
        PdfDAO_hoja_ruta pa = new PdfDAO_hoja_ruta();
        
        PdfVO_hoja_ruta po = new PdfVO_hoja_ruta();
        po.setChapa(chapa);
        po.setTotal_km(km);
        po.setConsumo(consumo);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            po.setArchivopdf(pdf);
        } catch (IOException ex) {
            po.setArchivopdf(null);
            System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        po.setCodigopdf(id);
        pa.Modificar_PdfVO(po);
    }

    public void modificar_pdf(String chapa, String km, String consumo, int id) {
        PdfDAO_hoja_ruta pa = new PdfDAO_hoja_ruta();
        PdfVO_hoja_ruta po = new PdfVO_hoja_ruta();
        po.setChapa(chapa);
        po.setTotal_km(km);
        po.setConsumo(consumo);
         po.setCodigopdf(id);
        pa.Modificar_PdfVO2(po);
    }
    
    private void km_hoja_ruta_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_km_hoja_ruta_editarKeyReleased
        // TODO add your handling code here:
        if(km_hoja_ruta_editar.getText().length()>0){
            lbl_error_km_hoja_ruta_editar.setVisible(false);
        }
    }//GEN-LAST:event_km_hoja_ruta_editarKeyReleased

    int pto=0;
    int lugares=0;
    private void km_hoja_ruta_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_km_hoja_ruta_editarKeyTyped
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
          
          if(!km_hoja_ruta_editar.getText().contains(".")){
              pto=0;
          }
          if( pto==0){
            lugares=0;
           }
        }
        if (km_hoja_ruta_editar.getText().length() <1 ) {
            char car = evt.getKeyChar();
            if (car!='.' && Character.isDigit(car)) {
                // escribe
            } else {
                evt.consume();  // desecha
            }

        }else{
            if(km_hoja_ruta_editar.getText().length()<10){     
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
    }//GEN-LAST:event_km_hoja_ruta_editarKeyTyped

    private void combo_chapa_hoja_ruta_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_chapa_hoja_ruta_editarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_chapa_hoja_ruta_editarActionPerformed

    private void check_android_hoja_ruta_editarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_android_hoja_ruta_editarMouseClicked
        // TODO add your handling code here:
        if(check_android_hoja_ruta_editar.isOnOff()){
            combo_chapa_hoja_ruta_editar.setEditable(true);
            AutoCompleteDecorator.decorate(combo_chapa_hoja_ruta_editar);
        }else{
            combo_chapa_hoja_ruta_editar.setEditable(false);
            combo_chapa_hoja_ruta_editar.requestFocus();
        }
    }//GEN-LAST:event_check_android_hoja_ruta_editarMouseClicked

   
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
            java.util.logging.Logger.getLogger(de_gestionar_hoja_ruta_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_hoja_ruta_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_hoja_ruta_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_hoja_ruta_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                de_gestionar_hoja_ruta_editar dialog = new de_gestionar_hoja_ruta_editar(new javax.swing.JFrame(), true);
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
    private rojeru_san.RSButtonRiple boton_busca_hoja_ruta_editar;
    private rojeru_san.RSButtonRiple boton_guardar_km_hoja_ruta_editar;
    private check_de_android.Switch check_android_hoja_ruta_editar;
    public static org.bolivia.combo.SComboBox combo_chapa_hoja_ruta_editar;
    public static javax.swing.JLabel id_hoja_ruta;
    private javax.swing.JPanel jPanel1;
    public static rojeru_san.rsfield.RSTextMaterial km_hoja_ruta_editar;
    private javax.swing.JLabel lb_foto;
    private javax.swing.JLabel lbl_error_chapa_hoja_ruta_editar;
    private javax.swing.JLabel lbl_error_km_hoja_ruta_editar;
    private javax.swing.JLabel lbl_error_pdf_km_hoja_ruta_editar;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
}
