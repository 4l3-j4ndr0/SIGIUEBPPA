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
public class de_gestionar_prep_tecnica_listar extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    
    private int PosicionMouse;
    Tabla_PdfVO_prep_tecnica tpdf = new Tabla_PdfVO_prep_tecnica();
    int id = -1;
    
    public de_gestionar_prep_tecnica_listar() {
        initComponents();
        
        this.tabla_prep_tecnica.setCursor(new Cursor(12));
        this.scroll.getViewport().setBackground(Color.WHITE);
        this.menu.add(pnlMenu);
        
        tpdf.visualizar_PdfVO(tabla_prep_tecnica);
        this.tabla_prep_tecnica.setDefaultRenderer(Object.class, new modelo_tablas.Tabla_Planos());

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
        tabla_prep_tecnica = new rojerusan.RSTableMetro();
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

        tabla_prep_tecnica.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_prep_tecnica.setToolTipText("");
        tabla_prep_tecnica.setAltoHead(30);
        tabla_prep_tecnica.setColorBackgoundHead(new java.awt.Color(38, 86, 186));
        tabla_prep_tecnica.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tabla_prep_tecnica.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tabla_prep_tecnica.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tabla_prep_tecnica.setColorHoverBackgound(new java.awt.Color(69, 87, 252));
        tabla_prep_tecnica.setColorSelBackgound(new java.awt.Color(69, 87, 252));
        tabla_prep_tecnica.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tabla_prep_tecnica.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabla_prep_tecnica.setGrosorBordeFilas(0);
        tabla_prep_tecnica.setHover(true);
        tabla_prep_tecnica.setMultipleSeleccion(false);
        tabla_prep_tecnica.setRowHeight(30);
        tabla_prep_tecnica.setSelectionBackground(new java.awt.Color(99, 70, 250));
        tabla_prep_tecnica.getTableHeader().setReorderingAllowed(false);
        tabla_prep_tecnica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_prep_tecnicaMouseClicked(evt);
            }
        });
        scroll.setViewportView(tabla_prep_tecnica);
        if (tabla_prep_tecnica.getColumnModel().getColumnCount() > 0) {
            tabla_prep_tecnica.getColumnModel().getColumn(1).setPreferredWidth(10);
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

    private void tabla_prep_tecnicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_prep_tecnicaMouseClicked
        int row = tabla_prep_tecnica.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.tabla_prep_tecnica.setRowSelectionInterval(row, row);
            PosicionMouse = evt.getY() / 16;
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.tabla_prep_tecnica.setRowSelectionInterval(row, row);
        }
        
        // ver plano
        int column = tabla_prep_tecnica.getColumnModel().getColumnIndexAtX(evt.getX());
        int row_pdf = evt.getY() / tabla_prep_tecnica.getRowHeight();
        if (row_pdf < tabla_prep_tecnica.getRowCount() && row_pdf >= 0 && column < tabla_prep_tecnica.getColumnCount() && column >= 0 && (evt.getModifiers() & InputEvent.BUTTON3_MASK) != InputEvent.BUTTON3_MASK) {
            id = (int) tabla_prep_tecnica.getValueAt(row_pdf, 0);
            Object value = tabla_prep_tecnica.getValueAt(row_pdf, column);
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
    }//GEN-LAST:event_tabla_prep_tecnicaMouseClicked

    
    
    private void txtBuscar_pdfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_pdfKeyReleased
        Tabla_PdfVO_prep_tecnica tabla=new Tabla_PdfVO_prep_tecnica();
        tabla.visualizar_PdfVO_buscar(tabla_prep_tecnica, txtBuscar_pdf.getText());
    }//GEN-LAST:event_txtBuscar_pdfKeyReleased

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
//        if (privilegios.Operaciones.EliminarProducto(principal.Principal.lblID.getText())) {
            this.menu.setVisible(false);
            int fila = this.tabla_prep_tecnica.getSelectedRow();
            int id = Integer.parseInt(tabla_prep_tecnica.getValueAt(fila, 0).toString());
            String nombre = this.tabla_prep_tecnica.getValueAt(fila, 1).toString();

            alertas.WarningAlert w = new alertas.WarningAlert(new JFrame(), true);
            w.msj1.setText("Se eliminara la preparación técnica de");
            w.msj2.setText("nombre (" + nombre + ")");
            w.msj3.setText("de manera permanente del sistema.");
            w.setVisible(true);

            if (w.hecho) {
                
                Runnable runnable1 = new Runnable() {
                    public void run() {
                        Guardando_general l = new Guardando_general(new JFrame(), true);
                        l.setLocationRelativeTo(de_gestionar_prep_tecnica_listar.this);
                        l.setVisible(true);
                        try{
                            de_gestionar_prep_tecnica_listar.this.setEnabled(false);
                            eliminar_prep_tecnica(id);
                            SuccessAlert e = new SuccessAlert(new JFrame(), true);
                            e.msj1.setText("¡La preparación técnica fue eliminada satisfactoriamente!");
                            e.msj2.setText("");
                            e.msj3.setText("");
                            e.setVisible(true);
                            de_gestionar_prep_tecnica_listar.this.setEnabled(true);
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
//        } else {
//            ErrorAlert e = new ErrorAlert(new JFrame(), true);
//            e.msj1.setText("No cuentas con los privilegios");
//            e.msj2.setText("para acceder a esta opción.");
//            e.msj3.setText("");
//            e.setVisible(true);
//        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void eliminar_prep_tecnica(int id){
        eliminar_pdf(id);
        tpdf.visualizar_PdfVO(tabla_prep_tecnica);
        this.tabla_prep_tecnica.setDefaultRenderer(Object.class, new modelo_tablas.Tabla_Planos());
    }
    
    public void eliminar_pdf(int codigo) {
        PdfDAO_prep_tecnica pa = new PdfDAO_prep_tecnica();
        PdfVO_prep_tecnica po = new PdfVO_prep_tecnica();
        po.setCodigopdf(codigo);
        pa.Eliminar_PdfVO(po); 
    }
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
            this.menu.setVisible(false);
            de_gestionar_prep_tecnica_editar m = new de_gestionar_prep_tecnica_editar(new JFrame(), true);
            int fila = de_gestionar_prep_tecnica_listar.tabla_prep_tecnica.getSelectedRow();
            int id = Integer.parseInt(tabla_prep_tecnica.getValueAt(fila, 0).toString());
            de_gestionar_prep_tecnica_editar.id_prep_tecnica.setText(String.valueOf(id));
            extraerDatos(m, id);
            m.setVisible(true);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtBuscar_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar_pdfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar_pdfActionPerformed

    
    static conexion cc = new conexion();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    public static void extraerDatos(de_gestionar_prep_tecnica_editar datos, int id) {

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
    public static rojerusan.RSTableMetro tabla_prep_tecnica;
    public static rojeru_san.rsfield.RSTextMaterial txtBuscar_pdf;
    // End of variables declaration//GEN-END:variables
}
