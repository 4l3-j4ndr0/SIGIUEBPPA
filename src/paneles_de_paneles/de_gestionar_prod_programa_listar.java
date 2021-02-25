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
import interaccion_bd.opciones_de_gestionar_usuarios;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author 4l3
 */
public class de_gestionar_prod_programa_listar extends javax.swing.JPanel {

    /**
     * Creates new form pnlHome
     */
    
    private int PosicionMouse;
    private String programa="";
    private Date fecha_desde;
    private Date fecha_hasta;
    private java.sql.Date fecha_desde_ok = null;
    private java.sql.Date fecha_hasta_ok=null;
    public de_gestionar_prod_programa_listar() {
        initComponents();
        this.tabla_prod_programa.setCursor(new Cursor(12));
        this.scroll.getViewport().setBackground(Color.WHITE);
        this.menu.add(pnlMenu);
        opciones_de_gestionar_prod_programa.get_combos2(combo_programas_prod_programa);
        interaccion_bd.opciones_de_gestionar_prod_programa.setListar("");

        this.tabla_prod_programa.setDefaultRenderer(Object.class, new modelo_tablas.Tabla_Prod_programa());

//        Timer timer = new Timer(500, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                txtBuscar_prod_programa.requestFocus();
//            }
//        });
//        timer.setRepeats(true);
//        timer.start();
       // deshabilitarPegar();

        addEventKey();
        //################### detectar cambios en los combobox ######################3
        combo_programas_prod_programa.addItemListener(new ItemListener() {
           public void itemStateChanged(ItemEvent arg0) {
               //Do Something
            if(opciones_de_gestionar_prod_programa.existe("select * from modelo_mercantil limit 1")){
               txtBuscar_prod_programa.setText("");
             String first_date="SELECT Min(`fecha`) FROM `modelo_mercantil`";
             String last_date="SELECT Max(`fecha`) FROM `modelo_mercantil`";
               if(fecha_desde_modelo.getDate()!=null){
                 fecha_desde=fecha_desde_modelo.getDate();
                  fecha_desde_ok = new java.sql.Date(fecha_desde.getTime());
                 
             }else{
                    fecha_desde=opciones_de_gestionar_prod_programa.extraer_fecha(first_date);
                    fecha_desde_ok = new java.sql.Date(fecha_desde.getTime());
                }
             if(fecha_hasta_modelo.getDate()!=null){
                 fecha_hasta=fecha_hasta_modelo.getDate();
                 fecha_hasta_ok = new java.sql.Date(fecha_hasta.getTime());
                 
             }else{
                 fecha_hasta=opciones_de_gestionar_prod_programa.extraer_fecha(last_date);
                 fecha_hasta_ok = new java.sql.Date(fecha_hasta.getTime());
             }
             if(!combo_programas_prod_programa.getSelectedItem().toString().equals("PROGRAMA")){
              programa=combo_programas_prod_programa.getSelectedItem().toString();
           }
             String sql_con_rango_fecha_sin_programa="SELECT * FROM `modelo_mercantil` WHERE `fecha` BETWEEN '"+fecha_desde_ok+"' AND '"+fecha_hasta_ok+"'";
             String sql_con_rango_fecha_and_programa="SELECT * FROM `modelo_mercantil` WHERE `fecha` BETWEEN '"+fecha_desde_ok+"' AND '"+fecha_hasta_ok+"' and `programa_modelo` = '"+programa+"'";
             
//        fecha_hasta=toma_fecha(fecha_hasta_modelo);
//        programa=combo_programas_prod_programa.getSelectedItem().toString();
        if(!combo_programas_prod_programa.getSelectedItem().toString().equals("PROGRAMA")){
        interaccion_bd.opciones_de_gestionar_prod_programa.setListar_con_filtro_fecha_y_programa(sql_con_rango_fecha_and_programa);
        }else if(combo_programas_prod_programa.getSelectedItem().toString().equals("PROGRAMA")){
            interaccion_bd.opciones_de_gestionar_prod_programa.setListar_con_filtro_fecha_y_programa(sql_con_rango_fecha_sin_programa);
        }else if((combo_programas_prod_programa.getSelectedItem().toString().equals("PROGRAMA")) && (fecha_desde_modelo.getDate()==null) && 
                (fecha_hasta_modelo.getDate()==null)){
            opciones_de_gestionar_prod_programa.setListar("");
        }
           }else{
           opciones_de_gestionar_prod_programa.setListar("");
        }
           }
           
            public void itemStateChangedd(ItemEvent e) {
             //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
       });
        // ##########################################################################
   
        //  detectar cambio en jdateChoser (fecha de inicio en agregar contrato)
        fecha_desde_modelo.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if(opciones_de_gestionar_prod_programa.existe("select * from modelo_mercantil limit 1")){
                String first_date="SELECT Min(`fecha`) FROM `modelo_mercantil`";
             String last_date="SELECT Max(`fecha`) FROM `modelo_mercantil`";
             
               if(fecha_desde_modelo.getDate()!=null){
                 fecha_desde=fecha_desde_modelo.getDate();
                  fecha_desde_ok = new java.sql.Date(fecha_desde.getTime());
                 
             }else{
                    fecha_desde=opciones_de_gestionar_prod_programa.extraer_fecha(first_date);
                    fecha_desde_ok = new java.sql.Date(fecha_desde.getTime());
                }
             if(fecha_hasta_modelo.getDate()!=null){
                 fecha_hasta=fecha_hasta_modelo.getDate();
                 fecha_hasta_ok = new java.sql.Date(fecha_hasta.getTime());
                 
             }else{
                 fecha_hasta=opciones_de_gestionar_prod_programa.extraer_fecha(last_date);
                 fecha_hasta_ok = new java.sql.Date(fecha_hasta.getTime());
             }
             if(!combo_programas_prod_programa.getSelectedItem().toString().equals("PROGRAMA")){
              programa=combo_programas_prod_programa.getSelectedItem().toString();
           }
             String sql_con_rango_fecha_sin_programa="SELECT * FROM `modelo_mercantil` WHERE `fecha` BETWEEN '"+fecha_desde_ok+"' AND '"+fecha_hasta_ok+"'";
             String sql_con_rango_fecha_and_programa="SELECT * FROM `modelo_mercantil` WHERE `fecha` BETWEEN '"+fecha_desde_ok+"' AND '"+fecha_hasta_ok+"' and `programa_modelo` = '"+programa+"'";
               
//        fecha_hasta=toma_fecha(fecha_hasta_modelo);
//        programa=combo_programas_prod_programa.getSelectedItem().toString();
        if(!combo_programas_prod_programa.getSelectedItem().toString().equals("PROGRAMA")){
        interaccion_bd.opciones_de_gestionar_prod_programa.setListar_con_filtro_fecha_y_programa(sql_con_rango_fecha_and_programa);
        }else if(combo_programas_prod_programa.getSelectedItem().toString().equals("PROGRAMA")){
            interaccion_bd.opciones_de_gestionar_prod_programa.setListar_con_filtro_fecha_y_programa(sql_con_rango_fecha_sin_programa);
        }else if((combo_programas_prod_programa.getSelectedItem().toString().equals("PROGRAMA")) && (fecha_desde_modelo.getDate()==null) && 
                (fecha_hasta_modelo.getDate()==null)){
            opciones_de_gestionar_prod_programa.setListar("");
        }
            }else{
                   opciones_de_gestionar_prod_programa.setListar(""); 
                }
            }
        });
        
        fecha_hasta_modelo.getDateEditor().addPropertyChangeListener(
                new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if(opciones_de_gestionar_prod_programa.existe("select * from modelo_mercantil limit 1")){
                String first_date="SELECT Min(`fecha`) FROM `modelo_mercantil`";
             String last_date="SELECT Max(`fecha`) FROM `modelo_mercantil`";
               if(fecha_desde_modelo.getDate()!=null){
                 fecha_desde=fecha_desde_modelo.getDate();
                  fecha_desde_ok = new java.sql.Date(fecha_desde.getTime());
                 
             }else{
                    fecha_desde=opciones_de_gestionar_prod_programa.extraer_fecha(first_date);
                    fecha_desde_ok = new java.sql.Date(fecha_desde.getTime());
                }
             if(fecha_hasta_modelo.getDate()!=null){
                 fecha_hasta=fecha_hasta_modelo.getDate();
                 fecha_hasta_ok = new java.sql.Date(fecha_hasta.getTime());
                 
             }else{
                 fecha_hasta=opciones_de_gestionar_prod_programa.extraer_fecha(last_date);
                 fecha_hasta_ok = new java.sql.Date(fecha_hasta.getTime());
             }
             if(!combo_programas_prod_programa.getSelectedItem().toString().equals("PROGRAMA")){
              programa=combo_programas_prod_programa.getSelectedItem().toString();
           }
             String sql_con_rango_fecha_sin_programa="SELECT * FROM `modelo_mercantil` WHERE `fecha` BETWEEN '"+fecha_desde_ok+"' AND '"+fecha_hasta_ok+"'";
             String sql_con_rango_fecha_and_programa="SELECT * FROM `modelo_mercantil` WHERE `fecha` BETWEEN '"+fecha_desde_ok+"' AND '"+fecha_hasta_ok+"' and `programa_modelo` = '"+programa+"'";
             
//        fecha_hasta=toma_fecha(fecha_hasta_modelo);
//        programa=combo_programas_prod_programa.getSelectedItem().toString();
        if(!combo_programas_prod_programa.getSelectedItem().toString().equals("PROGRAMA")){
        interaccion_bd.opciones_de_gestionar_prod_programa.setListar_con_filtro_fecha_y_programa(sql_con_rango_fecha_and_programa);
        }else if(combo_programas_prod_programa.getSelectedItem().toString().equals("PROGRAMA")){
            interaccion_bd.opciones_de_gestionar_prod_programa.setListar_con_filtro_fecha_y_programa(sql_con_rango_fecha_sin_programa);
        }else if((combo_programas_prod_programa.getSelectedItem().toString().equals("PROGRAMA")) && (fecha_desde_modelo.getDate()==null) && 
                (fecha_hasta_modelo.getDate()==null)){
            opciones_de_gestionar_prod_programa.setListar("");
        }
                }else{
                    opciones_de_gestionar_prod_programa.setListar("");
                }
            }
        });
        
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
        combo_programas_prod_programa = new org.bolivia.combo.SComboBox();
        check_programas = new check_de_android.Switch();
        fecha_desde_modelo = new com.toedter.calendar.JDateChooser();
        fecha_hasta_modelo = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

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

        combo_programas_prod_programa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PROGRAMA" }));

        check_programas.setToolTipText("Hacer o deshacer editable");
        check_programas.setBackgroundColor(new java.awt.Color(38, 86, 186));
        check_programas.setOnOff(false);
        check_programas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                check_programasMouseClicked(evt);
            }
        });

        fecha_desde_modelo.setDateFormatString("dd/MM/yyyy");
        fecha_desde_modelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        fecha_hasta_modelo.setDateFormatString("dd/MM/yyyy");
        fecha_hasta_modelo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DESDE");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("HASTA");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel4.setBackground(new java.awt.Color(38, 86, 186));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("KG");
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(38, 86, 186));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("UNIDAD DE MEDIDA");
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(38, 86, 186));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("M3");
        jLabel6.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(38, 86, 186));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("L");
        jLabel7.setOpaque(true);

        jLabel8.setBackground(new java.awt.Color(38, 86, 186));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("M3");
        jLabel8.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(38, 86, 186));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("TM");
        jLabel9.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 2018, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar_prod_programa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(combo_programas_prod_programa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(check_programas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(fecha_desde_modelo, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(fecha_hasta_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBuscar_prod_programa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(fecha_desde_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fecha_hasta_modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(check_programas, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(combo_programas_prod_programa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
        combo_programas_prod_programa.setSelectedIndex(0);
        interaccion_bd.opciones_de_gestionar_prod_programa.setListar(this.txtBuscar_prod_programa.getText());
    }//GEN-LAST:event_txtBuscar_prod_programaKeyReleased

    private void btnExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportarActionPerformed
        String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='producción por programa'"
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
                String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='producción por programa'"
                + "and imprimir_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
        try {
            
            if(fecha_desde_modelo.getDate()!=null || fecha_hasta_modelo.getDate()!=null || combo_programas_prod_programa.getSelectedIndex()!=0){
            // aki llamo al reporte con el filtro
            if(combo_programas_prod_programa.getSelectedIndex()!=0){
            reportes.Reportes_box r = new reportes.Reportes_box();
            conexion cc = new conexion();
            String ruta_logo="img/splash_logo.png";
            Map parametro = new HashMap();
            parametro.put("LOGO", ruta_logo);
            parametro.put("programa", combo_programas_prod_programa.getSelectedItem().toString());
            parametro.put("fecha_inicio", fecha_desde);
            parametro.put("fecha_final", fecha_hasta);
            JasperPrint jprint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("reportes/prod_x_programa_filtrado.jasper"), parametro, cc.conexion());
            JRViewer jrv = new JRViewer(jprint);
            r.contenedor.removeAll();

            r.contenedor.setLayout(new BorderLayout());
            r.contenedor.add(jrv, BorderLayout.CENTER);

            r.contenedor.repaint();
            r.contenedor.revalidate();
            jrv.setVisible(true);
            r.setVisible(true);
            }else{
                System.out.println("listo impr sin programa");
                reportes.Reportes_box r = new reportes.Reportes_box();
            conexion cc = new conexion();
            String ruta_logo="img/splash_logo.png";
            Map parametro = new HashMap();
            parametro.put("LOGO", ruta_logo);
            parametro.put("fecha_inicio", fecha_desde);
            parametro.put("fecha_final", fecha_hasta);
            JasperPrint jprint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("reportes/prod_x_programa_filtrado_all_program.jasper"), parametro, cc.conexion());
            JRViewer jrv = new JRViewer(jprint);
            r.contenedor.removeAll();

            r.contenedor.setLayout(new BorderLayout());
            r.contenedor.add(jrv, BorderLayout.CENTER);

            r.contenedor.repaint();
            r.contenedor.revalidate();
            jrv.setVisible(true);
            r.setVisible(true);
            }
            }else{
                // reporte completo 
                
            reportes.Reportes_box r = new reportes.Reportes_box();
            conexion cc = new conexion();
            String ruta_logo="img/splash_logo.png";
            Map parametro = new HashMap();
            parametro.put("LOGO", ruta_logo);
            System.out.println("listo pa imprimir");
            JasperPrint jprint = JasperFillManager.fillReport(this.getClass().getClassLoader().getResourceAsStream("reportes/prod_x_programa.jasper"), parametro, cc.conexion());
            JRViewer jrv = new JRViewer(jprint);
            r.contenedor.removeAll();

            r.contenedor.setLayout(new BorderLayout());
            r.contenedor.add(jrv, BorderLayout.CENTER);

            r.contenedor.repaint();
            r.contenedor.revalidate();
            jrv.setVisible(true);
            r.setVisible(true);
                
            }
        } catch (JRException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
        }else{
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
            String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='producción por programa'"
                + "and eliminar_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
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
        } else {
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String sql_permiso="SELECT * FROM `permisos` WHERE `usuario_permisos`='"+principal.Principal.user.getText().trim()+"' and `apartado_permisos`='producción por programa'"
                + "and editar_permisos='1' ";
        String mj1="Usted no cuenta con los permisos requeridos para accedeer a este apartado.";
        String mj2="Si considera que estamos en un error contacte con el administrador del ";
        String mj3="sistema para que le otorgue los permisos pertinentes";
        if(opciones_de_gestionar_usuarios.existe(sql_permiso)){
        consultas_de_gestionar_contrato c=new consultas_de_gestionar_contrato();
            this.menu.setVisible(false);
            de_gestionar_prod_programa_editar m = new de_gestionar_prod_programa_editar(new JFrame(), true);
            int fila = de_gestionar_prod_programa_listar.tabla_prod_programa.getSelectedRow();
            int id = Integer.parseInt(tabla_prod_programa.getValueAt(fila, 0).toString());
          //  de_gestionar_contrato_editar.numero_contrato_control.setText(opciones_de_gestionar_contrato.extraer_numero("select numero_contrato from contrato where id="+id));
            interaccion_bd.opciones_de_gestionar_prod_programa.extraerDatos(m, id);
            m.setVisible(true);
            
        } else {
            opciones_de_gestionar_contrato.lanza_error_variable_sin_ex(mj1, mj2, mj3);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void check_programasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_check_programasMouseClicked
        // TODO add your handling code here:
        if(check_programas.isOnOff()){
            combo_programas_prod_programa.setEditable(true);
            AutoCompleteDecorator.decorate(combo_programas_prod_programa);
        }else{
            combo_programas_prod_programa.setEditable(false);
            combo_programas_prod_programa.requestFocus();
        }
    }//GEN-LAST:event_check_programasMouseClicked

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
    private check_de_android.Switch check_programas;
    private org.bolivia.combo.SComboBox combo_programas_prod_programa;
    private com.toedter.calendar.JDateChooser fecha_desde_modelo;
    private com.toedter.calendar.JDateChooser fecha_hasta_modelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
