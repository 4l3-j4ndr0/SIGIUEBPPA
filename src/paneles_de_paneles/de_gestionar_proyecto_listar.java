/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneles_de_paneles;

import DAO.PdfDAO;
import DAO.PdfDAO_prep_tecnica;
import Tabla.Tabla_PdfVO;
import Tabla.Tabla_PdfVO_prep_tecnica;
import VO.PdfVO;
import VO.PdfVO_prep_tecnica;
import alertas.SuccessAlert;
import conexion.conexion;
import esperas.Guardando_general;
import interaccion_bd.opciones_de_gestionar_contrato;
import static interaccion_bd.opciones_de_gestionar_contrato.lanza_error;
import interaccion_bd.opciones_de_gestionar_prod_programa;
import interaccion_bd.opciones_de_gestionar_usuarios;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author 4l3
 */
public class de_gestionar_proyecto_listar extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    
    private int PosicionMouse;
    Tabla_PdfVO_prep_tecnica tpdf = new Tabla_PdfVO_prep_tecnica();
    int id = -1;
    
    public de_gestionar_proyecto_listar() {
        initComponents();
        
        this.tabla_proy.setCursor(new Cursor(12));
        this.scroll.getViewport().setBackground(Color.WHITE);
        this.menu.add(pnlMenu);
        
        tpdf.visualizar_PdfVO(tabla_proy);
        this.tabla_proy.setDefaultRenderer(Object.class, new modelo_tablas.Tabla_Planos());

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtBuscar_pdf.requestFocus();
            }
        });
        timer.setRepeats(true);
        timer.start();
       // deshabilitarPegar();

    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new rojerusan.RSPopuMenu();
        pnlMenu = new javax.swing.JPanel();
        btnBorrar = new rojeru_san.RSButtonRiple();
        btnEditar = new rojeru_san.RSButtonRiple();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tabla_proy = new rojerusan.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar_pdf = new rojeru_san.rsfield.RSTextMaterial();

        menu.setBackground(new java.awt.Color(255, 255, 255));
        menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        pnlMenu.setBackground(new java.awt.Color(255, 255, 255));

        btnBorrar.setBackground(new java.awt.Color(69, 87, 252));
        btnBorrar.setText("ELIMINAR");
        btnBorrar.setColorHover(new java.awt.Color(87, 103, 253));
        btnBorrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(69, 87, 252));
        btnEditar.setText("EDITAR");
        btnEditar.setColorHover(new java.awt.Color(87, 103, 253));
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        scroll.setBorder(null);

        tabla_proy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PLANO", "PDF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_proy.setToolTipText("");
        tabla_proy.setAltoHead(30);
        tabla_proy.setColorBackgoundHead(new java.awt.Color(38, 86, 186));
        tabla_proy.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tabla_proy.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tabla_proy.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tabla_proy.setColorHoverBackgound(new java.awt.Color(69, 87, 252));
        tabla_proy.setColorSelBackgound(new java.awt.Color(69, 87, 252));
        tabla_proy.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tabla_proy.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabla_proy.setGrosorBordeFilas(0);
        tabla_proy.setHover(true);
        tabla_proy.setMultipleSeleccion(false);
        tabla_proy.setRowHeight(30);
        tabla_proy.setSelectionBackground(new java.awt.Color(99, 70, 250));
        tabla_proy.getTableHeader().setReorderingAllowed(false);
        tabla_proy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_proyMouseClicked(evt);
            }
        });
        scroll.setViewportView(tabla_proy);
        if (tabla_proy.getColumnModel().getColumnCount() > 0) {
            tabla_proy.getColumnModel().getColumn(1).setPreferredWidth(10);
        }

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_coontrato/label-buscar.png"))); // NOI18N

        txtBuscar_pdf.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar_pdf.setColorMaterial(new java.awt.Color(38, 86, 186));
        txtBuscar_pdf.setPlaceholder("Buscar");
        txtBuscar_pdf.setSelectionColor(new java.awt.Color(220, 23, 111));
        txtBuscar_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar_pdfActionPerformed(evt);
            }
        });
        txtBuscar_pdf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscar_pdfKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar_pdf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar_pdf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabla_proyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_proyMouseClicked
        int row = tabla_proy.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.tabla_proy.setRowSelectionInterval(row, row);
            PosicionMouse = evt.getY() / 16;
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.tabla_proy.setRowSelectionInterval(row, row);
        }
        
        // ver plano
        int column = tabla_proy.getColumnModel().getColumnIndexAtX(evt.getX());
        int row_pdf = evt.getY() / tabla_proy.getRowHeight();
        if (row_pdf < tabla_proy.getRowCount() && row_pdf >= 0 && column < tabla_proy.getColumnCount() && column >= 0 && (evt.getModifiers() & InputEvent.BUTTON3_MASK) != InputEvent.BUTTON3_MASK) {
            id = (int) tabla_proy.getValueAt(row_pdf, 0);
            Object value = tabla_proy.getValueAt(row_pdf, column);
            try{
                Runnable runnable1 = new Runnable() {
                public void run() {
                    try{
                        if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getText().equals("Vacio")) {
                    JOptionPane.showMessageDialog(null, "No hay archivo");
                } else {
                    PdfDAO_prep_tecnica pd = new PdfDAO_prep_tecnica();
                    pd.ejecutar_archivoPDF(id);
                    try {
                        Desktop.getDesktop().open(new File("new.pdf"));
                    } catch (Exception ex) {
                        opciones_de_gestionar_contrato.lanza_error(ex);
                    }
                }

            } 
                    }catch(Exception e){
                        Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, e);
                        opciones_de_gestionar_contrato.lanza_error(e);
                    }
                }
            };
            Thread t1 = new Thread(runnable1);
            t1.start();
        }catch(Exception ex){
                opciones_de_gestionar_contrato.lanza_error(ex);
        }
        }else{
            
        }
    }//GEN-LAST:event_tabla_proyMouseClicked

    
    
    private void txtBuscar_pdfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_pdfKeyReleased
        Tabla_PdfVO_prep_tecnica tabla=new Tabla_PdfVO_prep_tecnica();
        tabla.visualizar_PdfVO_buscar(tabla_proy, txtBuscar_pdf.getText());
    }//GEN-LAST:event_txtBuscar_pdfKeyReleased

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
            String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='proyecto'"
                + "and eliminar_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
            this.menu.setVisible(false);
            int fila = this.tabla_proy.getSelectedRow();
            int id = Integer.parseInt(tabla_proy.getValueAt(fila, 0).toString());
            String nombre = this.tabla_proy.getValueAt(fila, 1).toString();

            alertas.WarningAlert w = new alertas.WarningAlert(new JFrame(), true);
            w.msj1.setText("Se eliminara el proyecto de");
            w.msj2.setText("nombre (" + nombre + ")");
            w.msj3.setText("de manera permanente del sistema.");
            w.setVisible(true);

            if (w.hecho) {
                
                Runnable runnable1 = new Runnable() {
                    public void run() {
                        Guardando_general l = new Guardando_general(new JFrame(), true);
                        l.setLocationRelativeTo(de_gestionar_proyecto_listar.this);
                        l.setVisible(true);
                        try{
                            de_gestionar_proyecto_listar.this.setEnabled(false);
                            eliminar_prep_tecnica(id);
                            SuccessAlert e = new SuccessAlert(new JFrame(), true);
                            e.msj1.setText("¡La preparación técnica fue eliminada satisfactoriamente!");
                            e.msj2.setText("");
                            e.msj3.setText("");
                            e.setVisible(true);
                            de_gestionar_proyecto_listar.this.setEnabled(true);
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
        } else {
            opciones_de_gestionar_prod_programa.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void eliminar_prep_tecnica(int id){
        eliminar_pdf(id);
        tpdf.visualizar_PdfVO(tabla_proy);
        this.tabla_proy.setDefaultRenderer(Object.class, new modelo_tablas.Tabla_Planos());
    }
    
    public void eliminar_pdf(int codigo) {
        PdfDAO_prep_tecnica pa = new PdfDAO_prep_tecnica();
        PdfVO_prep_tecnica po = new PdfVO_prep_tecnica();
        po.setCodigopdf(codigo);
        pa.Eliminar_PdfVO(po); 
    }
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
            String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='proyecto'"
                + "and eeditar_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
        this.menu.setVisible(false);
            de_gestionar_proyecto_editar m = new de_gestionar_proyecto_editar(new JFrame(), true);
            int fila = de_gestionar_proyecto_listar.tabla_proy.getSelectedRow();
            int id = Integer.parseInt(tabla_proy.getValueAt(fila, 0).toString());
            de_gestionar_proyecto_editar.id_prep_tecnica.setText(String.valueOf(id));
            extraerDatos(m, id);
            m.setVisible(true);
        }else{
            opciones_de_gestionar_prod_programa.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtBuscar_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar_pdfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar_pdfActionPerformed

    
    static conexion cc = new conexion();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    public static void extraerDatos(de_gestionar_proyecto_editar datos, int id) {

        String sql = "SELECT nombre_prep_tecnica FROM prep_tecnica WHERE id_prep_tecnica = " + id;
        try {
            
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                datos.nombre_prep_tecnica_editar.setText(String.valueOf(rs.getString(1))); 
                datos.nombre_prep_tecnica_control.setText(String.valueOf(rs.getString(1)));
            }
        } catch (SQLException ex) {
            lanza_error(ex);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnBorrar;
    private rojeru_san.RSButtonRiple btnEditar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private rojerusan.RSPopuMenu menu;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JScrollPane scroll;
    public static rojerusan.RSTableMetro tabla_proy;
    public static rojeru_san.rsfield.RSTextMaterial txtBuscar_pdf;
    // End of variables declaration//GEN-END:variables
}
