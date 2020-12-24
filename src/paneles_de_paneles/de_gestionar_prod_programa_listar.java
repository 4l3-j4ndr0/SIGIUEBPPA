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
import interaccion_bd.opciones_de_gestionar_contrato;
import interaccion_bd.opciones_de_gestionar_prod_programa;
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
import javax.swing.JOptionPane;
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
public class de_gestionar_prod_programa_listar extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    
    private int PosicionMouse;
    
    public de_gestionar_prod_programa_listar() {
        initComponents();
        this.tabla_prod_programa.setCursor(new Cursor(12));
        this.scroll.getViewport().setBackground(Color.WHITE);
        this.menu.add(pnlMenu);
        
        interaccion_bd.opciones_de_gestionar_prod_programa.setListar("");

        this.tabla_prod_programa.setDefaultRenderer(Object.class, new modelo_tablas.Tabla_Prod_programa());

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtBuscar_prod_programa.requestFocus();
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
        tabla_prod_programa = new rojerusan.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar_prod_programa = new rojeru_san.rsfield.RSTextMaterial();
        jPanel3 = new javax.swing.JPanel();
        btnExportar = new rojeru_san.RSButtonRiple();
        btnPrint = new rojeru_san.RSButtonRiple();

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

        tabla_prod_programa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CODIGO", "DESCRIPCIÓN", "U/M", "VOLUMEN X UNIDAD", "CANTIDAD", "PROGRAMA", "TOTAL M3", "PRECIO CUP", "IMPORTE CUP", "FECHA", "RBK", "CEMENTO", "ARENA", "GRAVILLA", "ADITIVO", "1/4", "3/8", "1/2", "5/8", "3/4", "1", "AL", "EL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla_prod_programa.setToolTipText("");
        tabla_prod_programa.setAltoHead(30);
        tabla_prod_programa.setColorBackgoundHead(new java.awt.Color(38, 86, 186));
        tabla_prod_programa.setColorBordeHead(new java.awt.Color(255, 255, 255));
        tabla_prod_programa.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tabla_prod_programa.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tabla_prod_programa.setColorHoverBackgound(new java.awt.Color(69, 87, 252));
        tabla_prod_programa.setColorSelBackgound(new java.awt.Color(69, 87, 252));
        tabla_prod_programa.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tabla_prod_programa.setFuenteHead(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tabla_prod_programa.setGrosorBordeFilas(0);
        tabla_prod_programa.setHover(true);
        tabla_prod_programa.setMultipleSeleccion(false);
        tabla_prod_programa.setRowHeight(30);
        tabla_prod_programa.setSelectionBackground(new java.awt.Color(99, 70, 250));
        tabla_prod_programa.getTableHeader().setReorderingAllowed(false);
        tabla_prod_programa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_prod_programaMouseClicked(evt);
            }
        });
        scroll.setViewportView(tabla_prod_programa);
        if (tabla_prod_programa.getColumnModel().getColumnCount() > 0) {
            tabla_prod_programa.getColumnModel().getColumn(0).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(1).setPreferredWidth(2);
            tabla_prod_programa.getColumnModel().getColumn(2).setPreferredWidth(30);
            tabla_prod_programa.getColumnModel().getColumn(3).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(4).setPreferredWidth(70);
            tabla_prod_programa.getColumnModel().getColumn(5).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(7).setPreferredWidth(2);
            tabla_prod_programa.getColumnModel().getColumn(8).setPreferredWidth(2);
            tabla_prod_programa.getColumnModel().getColumn(9).setPreferredWidth(25);
            tabla_prod_programa.getColumnModel().getColumn(10).setPreferredWidth(2);
            tabla_prod_programa.getColumnModel().getColumn(11).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(12).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(13).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(14).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(15).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(16).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(17).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(18).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(19).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(20).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(21).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(22).setPreferredWidth(1);
            tabla_prod_programa.getColumnModel().getColumn(23).setPreferredWidth(1);
        }

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_coontrato/label-buscar.png"))); // NOI18N

        txtBuscar_prod_programa.setForeground(new java.awt.Color(0, 0, 0));
        txtBuscar_prod_programa.setColorMaterial(new java.awt.Color(38, 86, 186));
        txtBuscar_prod_programa.setPlaceholder("Buscar");
        txtBuscar_prod_programa.setSelectionColor(new java.awt.Color(220, 23, 111));
        txtBuscar_prod_programa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscar_prod_programaKeyReleased(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar_prod_programa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(426, 426, 426)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 2018, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBuscar_prod_programa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void tabla_prod_programaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_prod_programaMouseClicked
        int row = tabla_prod_programa.rowAtPoint(evt.getPoint());
        if ((evt.getModifiers() & InputEvent.BUTTON3_MASK) == InputEvent.BUTTON3_MASK) {
            this.tabla_prod_programa.setRowSelectionInterval(row, row);
            PosicionMouse = evt.getY() / 16;
            menu.show(evt.getComponent(), evt.getX(), evt.getY());
        } else {
            this.tabla_prod_programa.setRowSelectionInterval(row, row);
        }
    }//GEN-LAST:event_tabla_prod_programaMouseClicked

    private void txtBuscar_prod_programaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar_prod_programaKeyReleased
        interaccion_bd.opciones_de_gestionar_prod_programa.setListar(this.txtBuscar_prod_programa.getText());
    }//GEN-LAST:event_txtBuscar_prod_programaKeyReleased

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        try{
            generarExcel();
        } catch(Exception ex) {
            ErrorAlert e = new ErrorAlert(new JFrame(), true);
            e.msj1.setText(ex.toString());
            e.msj2.setText("Corrija el error antes de volver a intentarlo.");
            e.msj3.setText("En caso de no saber como corregir el error contacte con soporte tñecnico");
            e.setVisible(true);
        }
    }//GEN-LAST:event_btnExportarActionPerformed

    public static esperas.Cargando c = new Cargando(new JFrame(), true);
    private void generarExcel() {
        HSSFWorkbook workbook = new excel.ExcelGenerator_prod_programa().generateExcel();
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
//        public void report() {
        try {
            
            reportes.Reportes_box r = new reportes.Reportes_box();
            conexion cc = new conexion();
            String ruta_logo="img/splash_logo.png";
            Map parametro = new HashMap();
            parametro.put("LOGO", ruta_logo);
            
            JasperPrint jprint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("reportes/prod_programaa.jasper"), parametro, cc.conexion());
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
    
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
//        if (privilegios.Operaciones.EliminarProducto(principal.Principal.lblID.getText())) {
            this.menu.setVisible(false);
            int fila = this.tabla_prod_programa.getSelectedRow();
            int id = Integer.parseInt(tabla_prod_programa.getValueAt(fila, 0).toString());

            String nombre = this.tabla_prod_programa.getValueAt(fila, 2).toString();

            alertas.WarningAlert w = new alertas.WarningAlert(new JFrame(), true);
            w.msj1.setText("Se eliminara la fila seleccionada del");
            w.msj2.setText("con descripción (" + nombre + ")");
            w.msj3.setText("de manera permanente del sistema.");
            w.setVisible(true);

            if (w.hecho) {
                int control=opciones_de_gestionar_prod_programa.eliminar(id);
                if (control==1) {
                    opciones_de_gestionar_prod_programa.setListar("");

                    SuccessAlert s = new SuccessAlert(new JFrame(), true);
                    s.msj1.setText("Fila eliminada con éxito");
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
//        } else {
//            ErrorAlert e = new ErrorAlert(new JFrame(), true);
//            e.msj1.setText("No cuentas con los privilegios");
//            e.msj2.setText("para acceder a esta opción.");
//            e.msj3.setText("");
//            e.setVisible(true);
//        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
            consultas_de_gestionar_contrato c=new consultas_de_gestionar_contrato();
            this.menu.setVisible(false);
            de_gestionar_prod_programa_editar m = new de_gestionar_prod_programa_editar(new JFrame(), true);
            int fila = de_gestionar_prod_programa_listar.tabla_prod_programa.getSelectedRow();
            int id = Integer.parseInt(tabla_prod_programa.getValueAt(fila, 0).toString());
          //  de_gestionar_contrato_editar.numero_contrato_control.setText(opciones_de_gestionar_contrato.extraer_numero("select numero_contrato from contrato where id="+id));
            interaccion_bd.opciones_de_gestionar_prod_programa.extraerDatos(m, id);
            m.setVisible(true);
            
//        if (privilegios.Operaciones.EditarProducto(principal.Principal.lblID.getText())) {
//            this.menu.setVisible(false);
//            ModalEditar m = new ModalEditar(new JFrame(), true);
//            int fila = this.tabla.getSelectedRow();
//
//            int id = Integer.parseInt(this.tabla.getValueAt(fila, 0).toString());
//            Operaciones.extraerDatos(m, String.valueOf(id));
//            m.setVisible(true);
//        } else {
//            ErrorAlert e = new ErrorAlert(new JFrame(), true);
//            e.msj1.setText("No cuentas con los privilegios");
//            e.msj2.setText("para acceder a esta opción.");
//            e.msj3.setText("");
//            e.setVisible(true);
//        }
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private rojerusan.RSPopuMenu menu;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JScrollPane scroll;
    public static rojerusan.RSTableMetro tabla_prod_programa;
    public static rojeru_san.rsfield.RSTextMaterial txtBuscar_prod_programa;
    // End of variables declaration//GEN-END:variables
}
