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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import paneles_de_paneles.de_gestionar_contrato_editar;
import paneles_de_paneles.de_gestionar_prep_tecnica_preModelo_mercantil_editar;
import paneles_de_paneles.de_gestionar_prep_tecnica_preModelo_mercantil_listar;
import paneles_de_paneles.de_gestionar_prod_programa_editar;
import paneles_de_paneles.de_gestionar_prod_programa_listar;

/**
 *
 * @author 4l3
 */
public class opciones_de_gestionar_prep_tecnica {
    
    static conexion cc = new conexion();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
    public static void get_combos(JComboBox combo1) {         
        try {
            
          // PREFABRICADOS 
            String sql_prefabricados = "SELECT `descripcion_prefabricado` FROM `prefabricados` ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql_prefabricados);
            while (rs.next()) {
                combo1.addItem(rs.getString("descripcion_prefabricado"));
            }
            rs.close();
        } catch (Exception ex) {
            lanza_error(ex);
        }
    }
    
    public static void get_combos2(JComboBox combo1) {         
        try {
            
          
            // PROGRAMAS
            String sql_programas = "SELECT `nombre_contrato` FROM `contrato`";
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql_programas); 
            while (rs2.next()) {
                combo1.addItem(rs2.getString("nombre_contrato"));
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
            Logger.getLogger(opciones_de_gestionar_prep_tecnica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;
    }
    
    public static int registrar(consultas_de_gestionar_prep_tecnica uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_prep_tecnica.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getCodigo());
            ps.setString(2, uc.getDescripcion());
            ps.setString(3, uc.getU_m());
            ps.setDouble(4, uc.getVolumen_unidad());  
            ps.setDouble(5, uc.getCantidad());  
            ps.setDouble(6, uc.getTotal_m3());  
            ps.setDouble(7, uc.getPreciio());  
            ps.setDouble(8, uc.getImporte());  
            ps.setString(9, uc.getRbk());  
            ps.setDouble(10, uc.getCemento());
            ps.setDouble(11, uc.getArena());
            ps.setDouble(12, uc.getGravilla());
            ps.setDouble(13, uc.getAditivo());
            ps.setDouble(14, uc.getUn_cuarto());
            ps.setDouble(15, uc.getTres_octavo());
            ps.setDouble(16, uc.getUn_medio());
            ps.setDouble(17, uc.getCinco_octavo());
            ps.setDouble(18, uc.getTres_cuartos());
            ps.setDouble(19, uc.getUno());
            ps.setDouble(20, uc.getAl());
            ps.setDouble(21, uc.getEl());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        Logger.getLogger(opciones_de_gestionar_prep_tecnica.class.getName()).log(Level.SEVERE, null, ex);
            lanza_error(ex);
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static void setListar(String busca) {
       
        DefaultTableModel modelo = (DefaultTableModel) de_gestionar_prep_tecnica_preModelo_mercantil_listar.tabla_pre_modelo.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = consultas_de_gestionar_prep_tecnica.LISTAR;
        } else {
            sql = "SELECT * FROM pre_modelo_mercantil WHERE descripcion_modelo LIKE'"+busca+"%'"
                    + "ORDER BY `descripcion_modelo` ASC ";
        }
        String datos[] = new String[22];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("id_pre_modelo");
                datos[1] = rs.getString("codigo_pre_modelo");
                datos[2] = rs.getString("descripcion_pre_modelo");
                datos[3] = rs.getString("um_pre_modelo");
                datos[4] = rs.getString("volunidad_pre_modelo");
                datos[5] = rs.getString("cantidad_pre_modelo");
                datos[6] = rs.getString("total_m3_pre_modelo");
                datos[7] = rs.getString("precio_cup_pre_modelo");
                datos[8] = rs.getString("importe_cup_pre_modelo");
                datos[9] = rs.getString("rbk_pre_modelo");
                datos[10] = rs.getString("cemento_pre_modelo");
                datos[11] = rs.getString("arena_pre_modelo");
                datos[12] = rs.getString("gravilla_pre_modelo");
                datos[13] = rs.getString("aditivo_pre_modelo");
                datos[14] = rs.getString("1_4_pre_modelo");
                datos[15] = rs.getString("3_8_pre_modelo");
                datos[16] = rs.getString("1_2_pre_modelo");
                datos[17] = rs.getString("5_8_pre_modelo");
                datos[18] = rs.getString("3_4_pre_modelo");
                datos[19] = rs.getString("1_pre_modelo");
                datos[20] = rs.getString("al_pre_modelo");
                datos[21] = rs.getString("el_pre_modelo");
                modelo.addRow(datos);
            }
        } catch (SQLException ex) {
            lanza_error(ex);
        }
    }
    
    public static void lanza_error( Exception ex){
        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_prep_tecnica.class.getName()).log(Level.SEVERE, null, ex);
            error.msj1.setText(ex.toString());
            error.msj2.setText("Solucione el error antes de volverlo a intentar");
            error.msj3.setText("En caso de no saber como solucionar el error contacte con soporte técnico");
            error.preferredSize();
            error.pack();
            error.setVisible(true);
    }
    
    public static void lanza_error_variable( Exception ex, String uno, String dos){
        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_prep_tecnica.class.getName()).log(Level.SEVERE, null, ex);
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
    
     public static void extraerDatos(de_gestionar_prep_tecnica_preModelo_mercantil_editar datos, int id) {

        String sql = "SELECT * FROM pre_modelo_mercantil WHERE id_pre_modelo = " + id;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                de_gestionar_prep_tecnica_preModelo_mercantil_editar.primary.setText(String.valueOf(id));
                de_gestionar_prep_tecnica_preModelo_mercantil_editar.combo_prefabricados_editar.setSelectedItem(rs.getString(3));
                System.out.println(rs.getString(7));
                de_gestionar_prep_tecnica_preModelo_mercantil_editar.cantidad_modelo_editar.setText(rs.getString(6));
            }
        } catch (SQLException ex) {
            lanza_error(ex);
        }
    }
     
     public static int actualizar(consultas_de_gestionar_prep_tecnica uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_prep_tecnica.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getCodigo());
            ps.setString(2, uc.getDescripcion());
            ps.setString(3, uc.getU_m());
            ps.setDouble(4, uc.getVolumen_unidad());
            ps.setDouble(5, uc.getCantidad());
            ps.setDouble(6, uc.getTotal_m3());
            ps.setDouble(7, uc.getPreciio());
            ps.setDouble(8, uc.getImporte());
            ps.setString(9, uc.getRbk());
            ps.setDouble(10, uc.getCemento());
            ps.setDouble(11, uc.getArena());
            ps.setDouble(12, uc.getGravilla());
            ps.setDouble(13, uc.getAditivo());
            ps.setDouble(14, uc.getUn_cuarto());
            ps.setDouble(15, uc.getTres_octavo());
            ps.setDouble(16, uc.getUn_medio());
            ps.setDouble(17, uc.getCinco_octavo());
            ps.setDouble(18, uc.getTres_cuartos());
            ps.setDouble(19, uc.getUno());
            ps.setDouble(20, uc.getAl());
            ps.setDouble(21, uc.getEl());
            ps.setString(22, uc.getId());
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
            Logger.getLogger(opciones_de_gestionar_prep_tecnica.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(opciones_de_gestionar_prep_tecnica.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
     
     public static boolean existe(String sql) {
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
            Logger.getLogger(opciones_de_gestionar_prep_tecnica.class.getName()).log(Level.SEVERE, null, ex);
            lanza_error(ex);
        }
        return existe;
    }
     
     public static int eliminar(int id) {
        int rsu = 0;
        String sql = consultas_de_gestionar_prep_tecnica.ELIMINAR;

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
     
     public static int eliminar_todos() {
        int rsu = 0;
        String sql = consultas_de_gestionar_prep_tecnica.ELIMINAR_TODO;

        try {
            ps = cn.prepareStatement(sql);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
}
