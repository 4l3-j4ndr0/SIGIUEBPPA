/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interaccion_bd;

import alertas.ErrorAlert;
import alertas.WarningAlert;
import conexion.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import paneles_de_paneles.de_gestionar_contrato_editar;
import paneles_de_paneles.de_gestionar_contrato_listar;
import paneles_de_paneles.de_gestionar_plano_listar;
import paneles_de_paneles.de_gestionar_prod_programa_listar;

/**
 *
 * @author 4l3
 */
public class opciones_de_gestionar_prod_programa {
    
    static conexion cc = new conexion();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
    public static void get_combos(JComboBox combo1, JComboBox combo2) {         
        try {
            
          // PREFABRICADOS 
            String sql_prefabricados = "SELECT `descripcion_prefabricado` FROM `prefabricados` ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql_prefabricados);
            while (rs.next()) {
                combo1.addItem(rs.getString("descripcion_prefabricado"));
            }
            rs.close();
            // PROGRAMAS
            String sql_programas = "SELECT `nombre_contrato` FROM `contrato`";
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql_programas); 
            while (rs2.next()) {
                combo2.addItem(rs2.getString("nombre_contrato"));
            }
        } catch (Exception ex) {
            lanza_error(ex);
        }
    }
    
    public static int extraer_id(String sql) {
        int cant = 1;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cant = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_prod_programa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;
    }
    
    public static int registrar(consultas_de_gestionar_prod_programa uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_prod_programa.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getCodigo());
            ps.setString(2, uc.getDescripcion());
            ps.setString(3, uc.getU_m());
            ps.setDouble(4, uc.getVolumen_unidad());  
            ps.setDouble(5, uc.getCantidad());  
            ps.setString(6, uc.getPrograma());  
            ps.setDouble(7, uc.getTotal_m3());  
            ps.setDouble(8, uc.getPreciio());  
            ps.setDouble(9, uc.getImporte());  
            ps.setString(10, uc.getFecha());  
            ps.setString(11, uc.getRbk());  
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        Logger.getLogger(opciones_de_gestionar_prod_programa.class.getName()).log(Level.SEVERE, null, ex);
            lanza_error(ex);
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static void setListar(String busca) {
       
        DefaultTableModel modelo = (DefaultTableModel) de_gestionar_prod_programa_listar.tabla_prod_programa.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = consultas_de_gestionar_prod_programa.LISTAR;
        } else {
            sql = "SELECT * FROM modelo_mercantil WHERE descripcion_modelo LIKE'"+busca+"%' OR programa_modelo LIKE'"+busca+"%'"
                    + "ORDER BY `descripcion_modelo` ASC ";
        }
        String datos[] = new String[11];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("codigo_modelo");
                datos[1] = rs.getString("descripcion_modelo");
                datos[2] = rs.getString("u/m_modelo");
                datos[3] = rs.getString("vol/unidad_modelo");
                datos[4] = rs.getString("cantidad_modelo");
                datos[5] = rs.getString("programa_modelo");
                datos[6] = rs.getString("total_m3_modelo");
                datos[7] = rs.getString("precio_cup_modelo");
                datos[8] = rs.getString("importe_cup_modelo");
                datos[9] = rs.getString("fecha_modelo");
                datos[10] = rs.getString("rbk_modelo");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            lanza_error(ex);
        }
    }
    
    
    public static String getFechaLimite(int idc) {
        String fecha = "";
        String sql = "SELECT fecha_final_contrato FROM contrato WHERE numero_contrato = " + idc;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                fecha = rs.getString(1);
            }
        } catch (SQLException ex) {
            ErrorAlert error = new ErrorAlert(new JFrame(), true);
            error.msj1.setText(ex.toString());
            error.msj2.setText("Por favor contacte con soporte técnico");
            error.msj3.setText("");
            error.preferredSize();
            error.pack();
            error.setVisible(true);
        }
        return fecha;
    }
    
    public static String getFechaInicio(int idc) {
        String fecha = "";
        String sql = "SELECT fecha_inicio_contrato FROM contrato WHERE numero_contrato = " + idc;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                fecha = rs.getString(1);
            }
        } catch (SQLException ex) {
            ErrorAlert error = new ErrorAlert(new JFrame(), true);
            error.msj1.setText(ex.toString());
            error.msj2.setText("Por favor contacte con soporte técnico");
            error.msj3.setText("");
            error.preferredSize();
            error.pack();
            error.setVisible(true);
        }
        return fecha;
    }
    
    public static String fechaactual() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/YYYY");
        return formatofecha.format(fecha);

    }
    
    public static void lanza_error( Exception ex){
        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_prod_programa.class.getName()).log(Level.SEVERE, null, ex);
            error.msj1.setText(ex.toString());
            error.msj2.setText("Solucione el error antes de volverlo a intentar");
            error.msj3.setText("En caso de no saber como solucionar el error contacte con soporte técnico");
            error.preferredSize();
            error.pack();
            error.setVisible(true);
    }
    
    public static void lanza_error_variable( Exception ex, String uno, String dos){
        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_prod_programa.class.getName()).log(Level.SEVERE, null, ex);
            error.msj1.setText(ex.toString());
            error.msj2.setText(uno);
            error.msj3.setText(dos);
            error.preferredSize();
            error.pack();
            error.setVisible(true);
    }
    
    public static void lanza_error_variable_sin_ex( String cero, String uno, String dos){
        ErrorAlert error = new ErrorAlert(new JFrame(), true);
            error.msj1.setText(cero);
            error.msj2.setText(uno);
            error.msj3.setText(dos);
            error.preferredSize();
            error.pack();
            error.setVisible(true);
    }
    
    public static void lanza_ALERT(String uno, String dos, String tres){
        WarningAlert alerta = new WarningAlert(new JFrame(), true);
            alerta.msj1.setText(uno);
            alerta.msj2.setText(dos);
            alerta.msj3.setText(tres);
            alerta.preferredSize();
            alerta.pack();
            alerta.setVisible(true);
    }
    
     public static void extraerDatos(de_gestionar_contrato_editar datos, int id) {

        String sql = "SELECT * FROM modelo_mercantil WHERE id_modelo = " + id;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                de_gestionar_contrato_editar.numero_contrato_editar.setText(String.valueOf(rs.getString(2))); 
                de_gestionar_contrato_editar.nombre_cliente_contrato_editar.setText(rs.getString(3));
                de_gestionar_contrato_editar.fecha_inicio_contrato_editar.setDate(de_gestionar_contrato_editar.ParseFecha(rs.getString(4)));
                de_gestionar_contrato_editar.lbl_fecha_expira_contrato_editar.setText(rs.getString(5));
                de_gestionar_contrato_editar.id_editar.setText(String.valueOf(id));
            }
        } catch (SQLException ex) {
            lanza_error(ex);
        }
    }
     
     public static int actualizar(consultas_de_gestionar_contrato uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_contrato.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNumero_contrato());
            ps.setString(2, uc.getNombre_contrato());
            ps.setString(3, uc.getFecha_inicio_contrato());
            ps.setString(4, uc.getFecha_final_contrato());
            ps.setString(5, uc.getPrimaryKey());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            lanza_error(ex);
        }
        System.out.println(sql);
         System.out.println("result actualizar "+rsu);
        return rsu;
    }
     
     
     
      public static String extraer_numero(String sql) {
       String cant = "";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cant = rs.getString(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_prod_programa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;
    }
      
      public static double extraer_volumen(String sql) {
      
       double total=0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                total = rs.getDouble(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_prod_programa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
     
     public static boolean existe(String nombre,String sql) {
        String c = null;
        boolean existe=false;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
             if (rs.next()) {
                c = rs.getString(1);
            }
            if (c != null) {
                existe=true;
            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_prod_programa.class.getName()).log(Level.SEVERE, null, ex);
            lanza_error(ex);
        }
        return existe;
    }
     
     public static int eliminar(int id) {
        int rsu = 0;
        String sql = consultas_de_gestionar_contrato.ELIMINAR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
     
     
}
