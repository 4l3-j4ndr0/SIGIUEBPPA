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
import esperas.Cargando;
import interaccion_bd.consultas_de_gestionar_contrato;
import interaccion_bd.consultas_de_gestionar_tarj_combustible;
import interaccion_bd.opciones_de_gestionar_contrato;
import interaccion_bd.opciones_de_gestionar_tarj_combustible;
import interaccion_bd.opciones_de_gestionar_usuarios;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import necesario.RSFileChooser;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 *
 * @author 4l3
 */
public class de_gestionar_info_laboratorio_listar extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    
    private int PosicionMouse;
    
    public de_gestionar_info_laboratorio_listar() {
        initComponents();
        this.tabla_tarj_combustible.setCursor(new Cursor(12));
        this.scroll.getViewport().setBackground(Color.WHITE);
        this.menu.add(pnlMenu);
        
//        interaccion_bd.opciones_de_gestionar_tarj_combustible.setListar("");

        this.tabla_tarj_combustible.setDefaultRenderer(Object.class, new modelo_tablas.Tabla_info_lab());

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtBuscar.requestFocus();
            }
        });
        timer.setRepeats(true);
        timer.start();
       // deshabilitarPegar();

        addEventKey();
    }

    
    private void addEventKey() {

        KeyStroke f4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0, false);
        Action f4Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                generarExcel();
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f4, "F4");
        this.getActionMap().put("F4", f4Action);

        //--------------------------------------------------------------------------------
        KeyStroke f5 = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0, false);
        Action f5Action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                btnPrintActionPerformed(e);
            }
        };
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(f5, "F5");
        this.getActionMap().put("F5", f5Action);
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
        tabla_tarj_combustible = new rojerusan.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new rojeru_san.rsfield.RSTextMaterial();
        jPanel3 = new javax.swing.JPanel();
        btnExportar = new rojeru_san.RSButtonRiple();
        btnPrint = new rojeru_san.RSButtonRiple();
        jLabel1 = new javax.swing.JLabel();

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

        tabla_tarj_combustible.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "No. TARJETA", "TIPO COMBUSTIBLE", "PING", "CHAPA", "CANT. LITROS", "FECHA ASIGNACIÓN", "Title 8", "Title 9", "Title 10", "Title 11", "Title 12", "Title 13", "Title 14", "Title 15", "Title 16", "Title 17", "Title 18", "Title 19", "Title 20"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_tarj_combustible.setToolTipText("");
        tabla_tarj_combustible.setAltoHead(30);
        tabla_tarj_combustible.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabla_tarj_combustible.setColorBackgoundHead(new java.awt.Color(38, 86, 186));
        tabla_tarj_combustible.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tabla_tarj_combustible.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tabla_tarj_combustible.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tabla_tarj_combustible.setColorHoverBackgound(new java.awt.Color(69, 87, 252));
        tabla_tarj_combustible.setColorSelBackgound(new java.awt.Color(69, 87, 252));
        tabla_tarj_combustible.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tabla_tarj_combustible.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabla_tarj_combustible.setGrosorBordeFilas(0);
        tabla_tarj_combustible.setHover(true);
        tabla_tarj_combustible.setMultipleSeleccion(false);
        tabla_tarj_combustible.setRowHeight(30);
        tabla_tarj_combustible.setSelectionBackground(new java.awt.Color(99, 70, 250));
        tabla_tarj_combustible.setTableHeader(null);
        tabla_tarj_combustible.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_tarj_combustibleMouseClicked(evt);
            }
        });
        scroll.setViewportView(tabla_tarj_combustible);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_coontrato/label-buscar.png"))); // NOI18N

        txtBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar.setColorMaterial(new java.awt.Color(38, 86, 186));
        txtBuscar.setPlaceholder("Buscar");
        txtBuscar.setSelectionColor(new java.awt.Color(220, 23, 111));
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExportar.setBackground(new java.awt.Color(38, 86, 186));
        btnExportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_coontrato/btnExcel.png"))); // NOI18N
        btnExportar.setText("EXPORTAR(F4)");
        btnExportar.setColorHover(new java.awt.Color(173, 187, 194));
        btnExportar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExportar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportarActionPerformed(evt);
            }
        });
        jPanel3.add(btnExportar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 42));

        btnPrint.setBackground(new java.awt.Color(38, 86, 186));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_coontrato/btn-imprimirMenu.png"))); // NOI18N
        btnPrint.setText(" (F5)");
        btnPrint.setColorHover(new java.awt.Color(173, 187, 194));
        btnPrint.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPrint.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel3.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 99, 42));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img_info_lab/cabza tabla.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scroll, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void tabla_tarj_combustibleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_tarj_combustibleMouseClicked
        int row = tabla_tarj_combustible.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.tabla_tarj_combustible.setRowSelectionInterval(row, row);
            PosicionMouse = evt.getY() / 16;
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.tabla_tarj_combustible.setRowSelectionInterval(row, row);
        }
    }//GEN-LAST:event_tabla_tarj_combustibleMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        interaccion_bd.opciones_de_gestionar_tarj_combustible.setListar(this.txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='información de laboratorio'"
                + "and exportar_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
        try{
            generarExcel();
        } catch(Exception ex) {
            ErrorAlert e = new ErrorAlert(new JFrame(), true);
            e.msj1.setText(ex.toString());
            e.msj2.setText("Corrija el error antes de volver a intentarlo.");
            e.msj3.setText("En caso de no saber como corregir el error contacte con soporte tñecnico");
            e.setVisible(true);
        }
        }else{
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    public static esperas.Cargando c = new Cargando(new JFrame(), true);
    private void generarExcel() {
        HSSFWorkbook workbook = new excel.ExcelGenerator_tarj_combustible().generateExcel();
        RSFileChooser fileChooser = new RSFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel (*.xls)", "xls");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setFileFilter(filter);
        fileChooser.setDialogTitle("GUARDAR ARCHIVO");
        if (fileChooser.showSaveDialog(this) == RSFileChooser.APPROVE_OPTION) {

            System.out.println(fileChooser.getSelectedFile().getAbsolutePath());

            File archivo = new File(fileChooser.getSelectedFile().getAbsolutePath());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    c.setVisible(true);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                        OutputStream out = null;
                        if (getFileExtension(archivo)) {
                            out = new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath());
                        } else {
                            out = new FileOutputStream(fileChooser.getSelectedFile().getAbsolutePath() + ".xls");
                        }
                        workbook.write(out);
                        workbook.close();
                        out.flush();
                        out.close();

                        c.dispose();
                        SuccessAlert s = new SuccessAlert(new JFrame(), true);
                        s.msj1.setText("Archivo guardado con éxito");
                        s.msj2.setText("");
                        s.msj3.setText("");
                        s.setVisible(true);
                    } catch (FileNotFoundException ex) {
                        c.dispose();
                        ErrorAlert e = new ErrorAlert(new JFrame(), true);
                        e.msj1.setText("Algo salio mal. El archivo que intenta sobreescribir");
                        e.msj2.setText("se encuentra abierto, cierre el archivo");
                        e.msj3.setText("e intentelo de nuevo.");
                        e.setVisible(true);

//                        Logger.getLogger(pnlAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        c.dispose();
                        ErrorAlert e = new ErrorAlert(new JFrame(), true);
                        e.msj1.setText("Algo salio mal. No fue posible");
                        e.msj2.setText("generar el archivo.");
                        e.msj3.setText("");
                        e.setVisible(true);

//                        Logger.getLogger(pnlAlmacen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }).start();
        }
    }
    
    private boolean getFileExtension(File file) {
        String ext = null;
        String s = file.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }

        if (ext != null) {
            return true;
        } else {
            return false;
        }
    }
    
    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='información de laboratorio'"
                + "and imprimir_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
        try {
            
            reportes.Reportes_box r = new reportes.Reportes_box();
            conexion cc = new conexion();
            String ruta_logo="img/splash_logo.png";
            Map parametro = new HashMap();
            parametro.put("LOGO", ruta_logo);
            
            JasperPrint jprint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("reportes/tarj_combustible.jasper"), parametro, cc.conexion());
            JRViewer jrv = new JRViewer(jprint);
            r.contenedor.removeAll();

            r.contenedor.setLayout(new BorderLayout());
            r.contenedor.add(jrv, BorderLayout.CENTER);

            r.contenedor.repaint();
            r.contenedor.revalidate();
            jrv.setVisible(true);
            r.setVisible(true);
        } catch (JRException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
        }else{
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
            String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='información de laboratorio'"
                + "and eliminar_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
            this.menu.setVisible(false);
            int fila = this.tabla_tarj_combustible.getSelectedRow();
            String id = tabla_tarj_combustible.getValueAt(fila, 0).toString();

            String nombre = this.tabla_tarj_combustible.getValueAt(fila, 1).toString();

            alertas.WarningAlert w = new alertas.WarningAlert(new JFrame(), true);
            w.msj1.setText("Se eliminara la tarjeta de");
            w.msj2.setText("numero (" + nombre + ")");
            w.msj3.setText("de manera permanente del sistema.");
            w.setVisible(true);

            if (w.hecho) {
                int control=opciones_de_gestionar_tarj_combustible.eliminar(id);
                if (control==1) {
                    opciones_de_gestionar_tarj_combustible.setListar("");

                    SuccessAlert s = new SuccessAlert(new JFrame(), true);
                    s.msj1.setText("Contrato eliminado con éxito");
                    s.msj2.setText("");
                    s.msj3.setText("");
                    s.setVisible(true);
                } else {
                    ErrorAlert e = new ErrorAlert(new JFrame(), true);
                    e.msj1.setText("Algo salio mal. No fue posible");
                    e.msj2.setText("continuar con esta acción.");
                    e.msj3.setText("");
                    e.setVisible(true);
                }
            }
        } else {
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='información de laboratorio'"
                + "and editar_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
        consultas_de_gestionar_tarj_combustible c=new consultas_de_gestionar_tarj_combustible();
            this.menu.setVisible(false);
            de_gestionar_tarj_combustible_editar m = new de_gestionar_tarj_combustible_editar(new JFrame(), true);
            int fila = de_gestionar_info_laboratorio_listar.tabla_tarj_combustible.getSelectedRow();
            String id = tabla_tarj_combustible.getValueAt(fila, 0).toString();
            interaccion_bd.opciones_de_gestionar_tarj_combustible.extraerDatos(m, id);
            m.setVisible(true);
           
        } else {
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    public String dia(){
      Calendar fecha = Calendar.getInstance();
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
      String dia2=String.valueOf(dia);
      return dia2;
    }
    
    public String mes(){
      Calendar fecha = Calendar.getInstance();
        int mes = fecha.get(Calendar.MONTH) + 1;
      String mes2=String.valueOf(mes);
      return mes2;
    }
    
    public String año(){
      Calendar fecha = Calendar.getInstance();
        int año = fecha.get(Calendar.YEAR);
      String año2=String.valueOf(año);
      return año2;
    }
    
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButtonRiple btnBorrar;
    private rojeru_san.RSButtonRiple btnEditar;
    private rojeru_san.RSButtonRiple btnExportar;
    private rojeru_san.RSButtonRiple btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private rojerusan.RSPopuMenu menu;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JScrollPane scroll;
    public static rojerusan.RSTableMetro tabla_tarj_combustible;
    public static rojeru_san.rsfield.RSTextMaterial txtBuscar;
    // End of variables declaration//GEN-END:variables
}
