/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles_de_paneles;

import DAO.PdfDAO;
import DAO.PdfDAO_prep_tecnica;
import DAO.PdfDAO_proy;
import Tabla.Tabla_PdfVO;
import Tabla.Tabla_PdfVO_prep_tecnica;
import VO.PdfVO;
import VO.PdfVO_prep_tecnica;
import VO.PdfVO_proy;
import alertas.ErrorAlert;
import alertas.SuccessAlert;
import alertas.WarningAlert;
import esperas.Guardando_general;
import interaccion_bd.opciones_de_gestionar_contrato;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.InputMap;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author RojeruSan
 */
public class de_gestionar_prep_tecnica_añadir extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    public de_gestionar_prep_tecnica_añadir() {
        initComponents();
        lbl_error_nombre_prep_tecnica.setVisible(false);
        lbl_error_pdf_prep_tecnica.setVisible(false);
        deshabilitarPegar();
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

        nombre_prep_tecnica = new rojeru_san.rsfield.RSTextMaterial();
        lbl_error_nombre_prep_tecnica = new javax.swing.JLabel();
        boton_guardar_prep_tecnica = new rojeru_san.RSButtonRiple();
        lb_foto = new javax.swing.JLabel();
        boton_busca_prep_tecnica = new rojeru_san.RSButtonRiple();
        lbl_error_pdf_prep_tecnica = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        nombre_prep_tecnica.setForeground(new java.awt.Color(0, 0, 0));
        nombre_prep_tecnica.setColorMaterial(new java.awt.Color(99, 70, 250));
        nombre_prep_tecnica.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        nombre_prep_tecnica.setPlaceholder("Nombre de la preparación técnica...");
        nombre_prep_tecnica.setSelectionColor(new java.awt.Color(220, 23, 111));
        nombre_prep_tecnica.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombre_prep_tecnicaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombre_prep_tecnicaKeyTyped(evt);
            }
        });

        lbl_error_nombre_prep_tecnica.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_nombre_prep_tecnica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_nombre_prep_tecnica.setText("¡Debe ingresar un nombre de preparación técnica!");

        boton_guardar_prep_tecnica.setBackground(new java.awt.Color(38, 86, 186));
        boton_guardar_prep_tecnica.setText("Guardar Preparación Técnica");
        boton_guardar_prep_tecnica.setColorHover(new java.awt.Color(173, 187, 194));
        boton_guardar_prep_tecnica.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_guardar_prep_tecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_guardar_prep_tecnicaActionPerformed(evt);
            }
        });

        lb_foto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_prefabricado/prep_tecnicaOK.png"))); // NOI18N
        lb_foto.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        boton_busca_prep_tecnica.setBackground(new java.awt.Color(38, 86, 186));
        boton_busca_prep_tecnica.setText("Buscar Preparación Técnica");
        boton_busca_prep_tecnica.setColorHover(new java.awt.Color(173, 187, 194));
        boton_busca_prep_tecnica.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        boton_busca_prep_tecnica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_busca_prep_tecnicaActionPerformed(evt);
            }
        });

        lbl_error_pdf_prep_tecnica.setForeground(new java.awt.Color(243, 66, 53));
        lbl_error_pdf_prep_tecnica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_error/label-error-backup.png"))); // NOI18N
        lbl_error_pdf_prep_tecnica.setText("¡Debe buscar una preparación técnica!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_foto)
                        .addGap(79, 79, 79)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombre_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boton_guardar_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl_error_nombre_prep_tecnica)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_busca_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbl_error_pdf_prep_tecnica)))))
                .addContainerGap(159, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lb_foto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(nombre_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_error_nombre_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(boton_guardar_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boton_busca_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbl_error_pdf_prep_tecnica, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nombre_prep_tecnicaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_prep_tecnicaKeyReleased
        // TODO add your handling code here:
        if(nombre_prep_tecnica.getText().length()>0){
            lbl_error_nombre_prep_tecnica.setVisible(false);
        }
    }//GEN-LAST:event_nombre_prep_tecnicaKeyReleased

    private void nombre_prep_tecnicaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre_prep_tecnicaKeyTyped
        // TODO add your handling code here:
        char letras = evt.getKeyChar();
        if ((letras < 'a' || letras > 'z') && (letras < 'A' | letras > 'Z')) {
            if ((letras != 'ñ') && (letras != 'Ñ') && (letras != 'á') && (letras != 'Á') && (letras != 'é') && (letras != 'É') && (letras != 'í')
                && (letras != 'Í') && (letras != 'ó') && (letras != 'Ó') && (letras != 'ú') && (letras != 'Ú') && (letras != ' ')) {
                evt.consume();
            }
        }
    }//GEN-LAST:event_nombre_prep_tecnicaKeyTyped

    Tabla_PdfVO_prep_tecnica tpdf = new Tabla_PdfVO_prep_tecnica();
    private void boton_guardar_prep_tecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_guardar_prep_tecnicaActionPerformed
       String sql="select * from proy where nombre_proy='"+nombre_prep_tecnica.getText()+"'";
       String mje1="Ya existe una preparación técnica con ese nombre("+nombre_prep_tecnica.getText()+")";
       String mje2="¿Desea guardarlo de todas farmas?";
       String mje3="La base de datos contendrá más de una preparación técnica con el mismo nombre";
        if (nombre_prep_tecnica.getText().isEmpty()||boton_busca_prep_tecnica.getText().equals("Buscar Preparación Técnica")) {
               if(nombre_prep_tecnica.getText().isEmpty()){
                lbl_error_nombre_prep_tecnica.setVisible(true);
               }else if(boton_busca_prep_tecnica.getText().equals("Buscar Preparación Técnica")){
                lbl_error_pdf_prep_tecnica.setVisible(true);
               }
        } else {
            if (interaccion_bd.opciones_de_gestionar_contrato.existe(nombre_prep_tecnica.getText(), sql)) {
                WarningAlert a=new WarningAlert(new JFrame(), true);
                            a.msj1.setText(mje1);
                            a.msj2.setText(mje2);
                            a.msj3.setText(mje3);
                            a.setVisible(true);
                            if(a.hecho==false){
                            nombre_prep_tecnica.requestFocus();
                            }else{
                                Runnable runnable1 = new Runnable() {
                public void run() {
                    Guardando_general l = new Guardando_general(new JFrame(), true);
                    l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_prep_tecnica_añadir.this);
                    l.setVisible(true);
                    try{
                    paneles_de_paneles.de_gestionar_prep_tecnica_añadir.this.setEnabled(false);
                    accion_guardar();
                    paneles_de_paneles.de_gestionar_prep_tecnica_añadir.this.setEnabled(true);
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
                    l.setLocationRelativeTo(paneles_de_paneles.de_gestionar_prep_tecnica_añadir.this);
                    l.setVisible(true);
                    try{
                    paneles_de_paneles.de_gestionar_prep_tecnica_añadir.this.setEnabled(false);
                    accion_guardar();
                    paneles_de_paneles.de_gestionar_prep_tecnica_añadir.this.setEnabled(true);
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
    }//GEN-LAST:event_boton_guardar_prep_tecnicaActionPerformed

    public void accion_guardar(){
        try{
        String nombre = nombre_prep_tecnica.getText();
        File ruta = new File(ruta_archivo);
        if (nombre.trim().length() != 0 && ruta_archivo.trim().length() != 0) {
            guardar_pdf(nombre, ruta);
         //   tpdf.visualizar_PdfVO(tabla);
            ruta_archivo = "";
            reset_campos();
            SuccessAlert e = new SuccessAlert(new JFrame(), true);
            e.msj1.setText("¡Los datos de la preparación técnica fueron");
            e.msj2.setText("guardados exitosamente!.");
            e.msj3.setText("");
            e.setVisible(true);
        } 
        }catch(Exception ex){
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
    }
    
    public void guardar_pdf( String nombre, File ruta) {
        PdfDAO_proy pa = new PdfDAO_proy();
        PdfVO_proy po = new PdfVO_proy();
        po.setNombrepdf(nombre);
        try {
            byte[] pdf = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(pdf);
            po.setArchivopdf(pdf);
        } catch (IOException ex) {
            po.setArchivopdf(null);
        }
        pa.Agregar_PdfVO(po);
    }
    
    private void boton_busca_prep_tecnicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_busca_prep_tecnicaActionPerformed
        // TODO add your handling code here:
        try{
         JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fi = new FileNameExtensionFilter("pdf", "pdf");
        j.setFileFilter(fi);
        int se = j.showOpenDialog(this);
        if (se == 0) {
            this.boton_busca_prep_tecnica.setText("" + j.getSelectedFile().getName());
          ruta_archivo = j.getSelectedFile().getAbsolutePath();
          
          lb_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_planos/pdf2.png"))); 
          lbl_error_pdf_prep_tecnica.setVisible(false);
        }  
        }catch(Exception ex){
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
    }//GEN-LAST:event_boton_busca_prep_tecnicaActionPerformed

     private void deshabilitarPegar() {
        InputMap map2 = nombre_prep_tecnica.getInputMap(nombre_prep_tecnica.WHEN_FOCUSED);
        map2.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK), "null");
    }
               
    private void reset_campos(){
        nombre_prep_tecnica.setText("");
        boton_busca_prep_tecnica.setText("Buscar Preparación Técnica");
        lb_foto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_prefabricado/prep_tecnicaOK.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple boton_busca_prep_tecnica;
    private rojeru_san.RSButtonRiple boton_guardar_prep_tecnica;
    private javax.swing.JLabel lb_foto;
    private javax.swing.JLabel lbl_error_nombre_prep_tecnica;
    private javax.swing.JLabel lbl_error_pdf_prep_tecnica;
    public static rojeru_san.rsfield.RSTextMaterial nombre_prep_tecnica;
    // End of variables declaration//GEN-END:variables
}
