/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles_de_paneles;

import DAO.PdfDAO;
import DAO.PdfDAO_ficha_costo;
import DAO.PdfDAO_prep_tecnica;
import Tabla.Tabla_PdfVO;
import Tabla.Tabla_PdfVO_ficha_costo;
import Tabla.Tabla_PdfVO_prep_tecnica;
import VO.PdfVO;
import VO.PdfVO_ficha_costo;
import VO.PdfVO_prep_tecnica;
import alertas.*;
import com.toedter.calendar.JDateChooser;
import esperas.Guardando_general;
import interaccion_bd.opciones_de_gestionar_contrato;
import java.awt.Event;
import java.awt.event.ActionEvent;
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
import static paneles_de_paneles.de_gestionar_plano_listar.tabla_plano;
import rojeru_san.complementos.RSMoveObject;
import rojeru_san.complementos.RSUtilities;

/**
 *
 * @author RojeruSan
 */
public class de_gestionar_ficha_costo_editar extends javax.swing.JDialog {

    /**
     * Creates new form ErrorAlert
     */
    public de_gestionar_ficha_costo_editar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
lbl_error_nombre_ficha_costo_editar.setVisible(false);
        lbl_error_pdf_ficha_costo_editar.setVisible(false);
        deshabilitarPegar();
        id_ficha_costo_control.setVisible(false);
        nombre_ficha_costo_control.setVisible(false);
        RSAWTUtilities.setOpaque(this, false);
        RSUtilities.setCentrarVentana(this);
        RSMoveObject.setMoverVentana(this);
        addEventKey();
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
        lb_foto_ficha_costo = new javax.swing.JLabel();
        boton_busca_ficha_costo_editar = new rojeru_san.RSButtonRiple();
        lbl_error_pdf_ficha_costo_editar = new javax.swing.JLabel();
        boton_guardar_ficha_costo_editar = new rojeru_san.RSButtonRiple();
        lbl_error_nombre_ficha_costo_editar = new javax.swing.JLabel();
        nombre_ficha_costo_editar = new rojeru_san.rsfield.RSTextMaterial();
        id_ficha_costo_control = new javax.swing.JLabel();
        nombre_ficha_costo_control = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        rSPanelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(782, 552));

        lb_foto_ficha_costo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_foto_ficha_costo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_ficha_costo/ficha_costo.png"))); // NOI18N

        boton_busca_ficha_costo_editar.setBackground(new java.awt.Color(38, 86, 186));
        boton_busca_ficha_costo_editar.setText("Modificar Ficha de Costo");
        boton_busca_ficha_costo_editar.setColorHover(new java.awt.Color(173, 187, 194));
        boton_busca_ficha_costo_editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_busca_ficha_costo_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_busca_ficha_costo_editarActionPerformed(evt);
            }
        });

        lbl_error_pdf_ficha_costo_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_pdf_ficha_costo_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_pdf_ficha_costo_editar.setText("¡Debe buscar una ficha de costo!");

        boton_guardar_ficha_costo_editar.setBackground(new java.awt.Color(38, 86, 186));
        boton_guardar_ficha_costo_editar.setText("Guardar Cambios");
        boton_guardar_ficha_costo_editar.setColorHover(new java.awt.Color(173, 187, 194));
        boton_guardar_ficha_costo_editar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_guardar_ficha_costo_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_ficha_costo_editarActionPerformed(evt);
            }
        });

        lbl_error_nombre_ficha_costo_editar.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_nombre_ficha_costo_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_nombre_ficha_costo_editar.setText("¡Debe ingresar un nombre de ficha de costo!");

        nombre_ficha_costo_editar.setForeground(new java.awt.Color(0, 0, 0));
        nombre_ficha_costo_editar.setColorMaterial(new java.awt.Color(99, 70, 250));
        nombre_ficha_costo_editar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nombre_ficha_costo_editar.setPlaceholder("Nombre de la ficha de costo...");
        nombre_ficha_costo_editar.setSelectionColor(new java.awt.Color(220, 23, 111));
        nombre_ficha_costo_editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombre_ficha_costo_editarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_ficha_costo_editarKeyTyped(evt);
            }
        });

        id_ficha_costo_control.setText("jLabel1");

        nombre_ficha_costo_control.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_foto_ficha_costo, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(id_ficha_costo_control)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(nombre_ficha_costo_control))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_error_nombre_ficha_costo_editar)
                                    .addComponent(nombre_ficha_costo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boton_guardar_ficha_costo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(boton_busca_ficha_costo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(lbl_error_pdf_ficha_costo_editar)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_ficha_costo_control)
                    .addComponent(nombre_ficha_costo_control))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(nombre_ficha_costo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_error_nombre_ficha_costo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(boton_guardar_ficha_costo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addComponent(lb_foto_ficha_costo)
                        .addGap(60, 60, 60)
                        .addComponent(boton_busca_ficha_costo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_error_pdf_ficha_costo_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );

        javax.swing.GroupLayout rSPanelShadow1Layout = new javax.swing.GroupLayout(rSPanelShadow1);
        rSPanelShadow1.setLayout(rSPanelShadow1Layout);
        rSPanelShadow1Layout.setHorizontalGroup(
            rSPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
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
                boton_guardar_ficha_costo_editarActionPerformed(e);
            }
        };
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(enter, "ENTER");
        getRootPane().getActionMap().put("ENTER", enterAction);
        
       
    }
    
    private void deshabilitarPegar() {
        InputMap map2 = nombre_ficha_costo_editar.getInputMap(nombre_ficha_costo_editar.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
             
    
    private void boton_busca_ficha_costo_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_busca_ficha_costo_editarActionPerformed
        // TODO add your handling code here:
        try{
            JFileChooser j = new JFileChooser();
            FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
            j.setFileFilter(fi);
            int se = j.showOpenDialog(this);
            if (se == 0) {
                this.boton_busca_ficha_costo_editar.setText("" + j.getSelectedFile().getName());
                ruta_archivo = j.getSelectedFile().getAbsolutePath();

                lb_foto_ficha_costo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_planos/pdf2.png")));
                lbl_error_pdf_ficha_costo_editar.setVisible(false);
            }
        }catch(Exception ex){
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
    }//GEN-LAST:event_boton_busca_ficha_costo_editarActionPerformed

    Tabla_PdfVO_ficha_costo tpdf = new Tabla_PdfVO_ficha_costo();
    private void boton_guardar_ficha_costo_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_ficha_costo_editarActionPerformed
        String sql="select * from ficha_costo where nombre_ficha='"+nombre_ficha_costo_editar.getText()+"'";
        String mje1="Ya existe una ficha de costo con ese nombre("+nombre_ficha_costo_editar.getText()+")";
        String mje2="¿Desea guardarla de todas farmas?";
        String mje3="La base de datos contendrá más de una ficha de costo con el mismo nombre";
        if (nombre_ficha_costo_editar.getText().isEmpty()) {
                lbl_error_nombre_ficha_costo_editar.setVisible(true);
        } else {
            if (interaccion_bd.opciones_de_gestionar_contrato.existe(nombre_ficha_costo_editar.getText(), sql) && !nombre_ficha_costo_control.getText().equals(nombre_ficha_costo_editar.getText())) {
                WarningAlert a=new WarningAlert(new JFrame(), true);
                a.msj1.setText(mje1);
                a.msj2.setText(mje2);
                a.msj3.setText(mje3);
                a.setVisible(true);
                if(a.hecho==false){
                    nombre_ficha_costo_editar.requestFocus();
                }else{
                    
                    
                     Runnable runnable1 = new Runnable() {
                    public void run() {
                        Guardando_general l = new Guardando_general(new JFrame(), true);
                        l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_ficha_costo_editar.this);
                        l.setVisible(true);
                        try{
                            de_gestionar_ficha_costo_editar.this.setEnabled(false);
                            
                            modificar();
                            SuccessAlert e = new SuccessAlert(new JFrame(), true);
                            e.msj1.setText("¡Los datos de la ficha de costo fueron");
                            e.msj2.setText("guardados exitosamente!.");
                            e.msj3.setText("");
                            e.setVisible(true);
                            de_gestionar_ficha_costo_editar.this.setEnabled(true);
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
            }else{
                    
                Runnable runnable1 = new Runnable() {
                    public void run() {
                        Guardando_general l = new Guardando_general(new JFrame(), true);
                        l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_ficha_costo_editar.this);
                        l.setVisible(true);
                        try{
                            paneles_de_paneles.de_gestionar_ficha_costo_editar.this.setEnabled(false);
                            
                            modificar();
                            SuccessAlert e = new SuccessAlert(new JFrame(), true);
                            e.msj1.setText("¡Los datos de la ficha de costo fueron");
                            e.msj2.setText("guardados exitosamente!.");
                            e.msj3.setText("");
                            e.setVisible(true);
                            de_gestionar_ficha_costo_editar.this.setEnabled(true);
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
         }
        this.dispose();
    }//GEN-LAST:event_boton_guardar_ficha_costo_editarActionPerformed

    private void modificar() {                                             
        String nombre = nombre_ficha_costo_editar.getText();
        File ruta = new File(ruta_archivo);
        if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
            modificar_pdf(Integer.parseInt(id_ficha_costo_control.getText()), nombre, ruta);
            tpdf.visualizar_PdfVO(de_gestionar_ficha_costo_listar.tabla_ficha_costo);
        } else if (ruta_archivo.trim().length() == 0) {
            modificar_pdf(Integer.parseInt(id_ficha_costo_control.getText()), nombre);
            tpdf.visualizar_PdfVO(de_gestionar_ficha_costo_listar.tabla_ficha_costo);
        }
        ruta_archivo = "";
        de_gestionar_ficha_costo_listar.tabla_ficha_costo.setDefaultRenderer(Object.class, new modelo_tablas.Tabla_Planos());
    } 
    
    public void modificar_pdf(int codigo, String nombre, File ruta) {
        PdfDAO_ficha_costo pa = new PdfDAO_ficha_costo();
        PdfVO_ficha_costo po = new PdfVO_ficha_costo();
        po.setCodigopdf(codigo);
        po.setNombrepdf(nombre);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            po.setArchivopdf(pdf);
        } catch (IOException ex) {
            po.setArchivopdf(null);
            //System.out.println("Error al agregar archivo pdf "+ex.getMessage());
        }
        pa.Modificar_PdfVO(po);
    }

    public void modificar_pdf(int codigo, String nombre) {
        PdfDAO_ficha_costo pa = new PdfDAO_ficha_costo();
        PdfVO_ficha_costo po = new PdfVO_ficha_costo();
        po.setCodigopdf(codigo);
        po.setNombrepdf(nombre);
        pa.Modificar_PdfVO2(po);
    }
    
    private void nombre_ficha_costo_editarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_ficha_costo_editarKeyReleased
        // TODO add your handling code here:
        if(nombre_ficha_costo_editar.getText().length()>0){
            lbl_error_nombre_ficha_costo_editar.setVisible(false);
        }
    }//GEN-LAST:event_nombre_ficha_costo_editarKeyReleased

    private void nombre_ficha_costo_editarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_ficha_costo_editarKeyTyped
        // TODO add your handling code here:
        char letras = evt.getKeyChar();
        if ((letras < 'a' || letras > 'z') && (letras < 'A' | letras > 'Z')) {
            if ((letras != 'ñ') && (letras != 'Ñ') && (letras != 'á') && (letras != 'Á') && (letras != 'é') && (letras != 'É') && (letras != 'í')
                && (letras != 'Í') && (letras != 'ó') && (letras != 'Ó') && (letras != 'ú') && (letras != 'Ú') && (letras != ' ')) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_nombre_ficha_costo_editarKeyTyped

    
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
            java.util.logging.Logger.getLogger(de_gestionar_ficha_costo_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_ficha_costo_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_ficha_costo_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(de_gestionar_ficha_costo_editar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                de_gestionar_ficha_costo_editar dialog = new de_gestionar_ficha_costo_editar(new javax.swing.JFrame(), true);
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
    private rojeru_san.RSButtonRiple boton_busca_ficha_costo_editar;
    private rojeru_san.RSButtonRiple boton_guardar_ficha_costo_editar;
    public static javax.swing.JLabel id_ficha_costo_control;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb_foto_ficha_costo;
    private javax.swing.JLabel lbl_error_nombre_ficha_costo_editar;
    private javax.swing.JLabel lbl_error_pdf_ficha_costo_editar;
    public static javax.swing.JLabel nombre_ficha_costo_control;
    public static rojeru_san.rsfield.RSTextMaterial nombre_ficha_costo_editar;
    private rojeru_san.rspanel.RSPanelShadow rSPanelShadow1;
    // End of variables declaration//GEN-END:variables
}