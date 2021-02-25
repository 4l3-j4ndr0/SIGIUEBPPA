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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import paneles_de_paneles.de_gestionar_contrato_editar;
import paneles_de_paneles.de_gestionar_contrato_listar;
import paneles_de_paneles.de_gestionar_info_laboratorio_editar;
import paneles_de_paneles.de_gestionar_info_laboratorio_listar;
import paneles_de_paneles.de_gestionar_plano_listar;
import paneles_de_paneles.de_gestionar_recursos_x_programa_editar;
import paneles_de_paneles.de_gestionar_recursos_x_programa_listar;
import paneles_de_paneles.de_gestionar_tarj_combustible_editar;

/**
 *
 * @author 4l3
 */
public class opciones_de_gestionar_info_lab {
    
    static conexion cc = new conexion();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
    public static int registrar(consultas_de_gestionar_info_lab uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_info_lab.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNum_materiales());
            ps.setString(2, uc.getElementos());
            ps.setString(3, uc.getFecha());
            ps.setString(4, "250");  
            ps.setString(5, "P-350"); 
            ps.setString(6, uc.getVol()); 
            ps.setString(7, "445"); 
            ps.setString(8, "857"); 
            ps.setString(9, "857"); 
            ps.setString(10, "4.45"); 
            ps.setString(11, "231"); 
            ps.setString(12, uc.getAsent()); 
            ps.setString(13, uc.getX1()); 
            ps.setString(14, uc.getX2()); 
            ps.setString(15, uc.getX3()); 
            ps.setString(16, (String.valueOf((double) (Math.round((Double.parseDouble(uc.getX1())+Double.parseDouble(uc.getX2())+Double.parseDouble(uc.getX3()))/3)) * 100d))); 
            ps.setString(17, uc.getX1_28dias()); 
            ps.setString(18, uc.getX2_28dias()); 
            ps.setString(19, uc.getX3_28dias()); 
            ps.setString(20, (String.valueOf((double) (Math.round((Double.parseDouble(uc.getX1_28dias())+Double.parseDouble(uc.getX2_28dias())+Double.parseDouble(uc.getX3_28dias()))/3) * 100d) / 100d)));
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_info_lab.class.getName()).log(Level.SEVERE, null, ex);
            error.msj1.setText(ex.toString());
            error.msj2.setText("Por favor solucione el error antes de volver a intentarlo.");
            error.msj3.setText("En caso de no saber como corregir el error, por favor contacte con soporte técnico");
            error.preferredSize();
            error.pack();
            error.setVisible(true);
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static void get_combos(JComboBox lm, JComboBox pm) {         
        try {
            
          // LM
//            String sql_prefabricados = "SELECT `descripcion_prefabricado` FROM `prefabricados` ";
            String sql_LM = "SELECT `descripcion_prefabricado` FROM `prefabricados` WHERE `descripcion_prefabricado` like 'lm%'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql_LM);
            while (rs.next()) {
                lm.addItem(rs.getString("descripcion_prefabricado"));
            }
            rs.close();
            // PM
            String sql_pM = "SELECT `descripcion_prefabricado` FROM `prefabricados` WHERE `descripcion_prefabricado` like 'pm%' ";
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql_pM); 
            while (rs2.next()) {
                pm.addItem(rs2.getString("descripcion_prefabricado"));
            }
        } catch (Exception ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
    }
    
    public static void setListar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) de_gestionar_info_laboratorio_listar.tabla_info_lab.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = consultas_de_gestionar_info_lab.LISTAR;
        } else {
            sql = "SELECT * FROM info_lab WHERE ("
                    + "elementos_info_lab LIKE'" + busca + "%' OR "
                    + "fecha_info_lab LIKE'" + busca + "%'"
                    + ")";
        }
        String datos[] = new String[21];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("id_info_lab");
                datos[1] = rs.getString("num_materiales_info_lab");
                datos[2] = rs.getString("elementos_info_lab");
                datos[3] = rs.getString("fecha_info_lab");
                datos[4] = rs.getString("rbk_info_lab");
                datos[5] = rs.getString("tipoCto_info_lab");
                datos[6] = rs.getString("vol_info_lab");
                datos[7] = rs.getString("cem_info_lab");
                datos[8] = rs.getString("grav_info_lab");
                datos[9] = rs.getString("aren_info_lab");
                datos[10] = rs.getString("adit_info_lab");
                datos[11] = rs.getString("agua_info_lab");
                datos[12] = rs.getString("asent_info_lab");
                datos[13] = rs.getString("x1_info_lab");
                datos[14] = rs.getString("x2_info_lab");
                datos[15] = rs.getString("x3_info_lab");
                datos[16] = rs.getString("xm_info_lab");
                datos[17] = rs.getString("x1_28dias_info_lab");
                datos[18] = rs.getString("x2_28dias_info_lab");
                datos[19] = rs.getString("x3_28dias_info_lab");
                datos[20] = rs.getString("xm_28dias_info_lab");
                modelo.addRow(datos);
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
    }
    
    
    
     public static void extraerDatos(de_gestionar_info_laboratorio_editar datos, int id) {

        String sql = "SELECT * FROM info_lab WHERE id_info_lab = " + id;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String [] lm=rs.getString(3).split(" ");
                datos.num_materiales_editar.setText(rs.getString(2)); 
                datos.vol_m3_editar.setText(rs.getString(7));
                datos.fecha_info_lab_editar.setDate(de_gestionar_tarj_combustible_editar.ParseFecha(rs.getString(4)));
                datos.asent_editar.setText(rs.getString(13));
                datos.x1_editar.setText(rs.getString(14));
                datos.x2_editar.setText(rs.getString(15));
                datos.x3_editar.setText(rs.getString(16));
                datos.x1_28dias_editar.setText(rs.getString(18));
                datos.x2_28dias_editar.setText(rs.getString(19));
                datos.x3_28dias_editar.setText(rs.getString(20));
                datos.combo_lm_editar.setSelectedItem(rs.getString(3).trim());
                datos.control.setText(String.valueOf(id));
                
                if(rs.getString(3).contains("LM") && !rs.getString(3).contains("PM") ){
                datos.combo_lm_editar.setSelectedItem(lm [0]);
                }else if(rs.getString(3).contains("PM") && !rs.getString(3).contains("LM") ){
                    System.out.println("tiene pm");
                    System.out.println(lm [0]);
                    System.out.println(lm [1]);
                datos.combo_pm_editar.setSelectedItem(lm [1]);
                }else if(rs.getString(3).contains("LM") && rs.getString(3).contains("PM") ){
                    datos.combo_lm_editar.setSelectedItem(lm [0]);
                    datos.combo_pm_editar.setSelectedItem(lm [1]);
                }
            }
        } catch (SQLException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
    }
     
     public static String extraer_id(String sql) {
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
     
     public static int actualizar(consultas_de_gestionar_info_lab uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_info_lab.ACTUALIZAR;
        try {
             ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNum_materiales());
            ps.setString(2, uc.getElementos());
            ps.setString(3, uc.getFecha());
            ps.setString(4, "250");  
            ps.setString(5, "P-350"); 
            ps.setString(6, uc.getVol()); 
            ps.setString(7, "445"); 
            ps.setString(8, "857"); 
            ps.setString(9, "857"); 
            ps.setString(10, "4.45"); 
            ps.setString(11, "231"); 
            ps.setString(12, uc.getAsent()); 
            ps.setString(13, uc.getX1()); 
            ps.setString(14, uc.getX2()); 
            ps.setString(15, uc.getX3()); 
            ps.setString(16, (String.valueOf((double) (Math.round((Double.parseDouble(uc.getX1())+Double.parseDouble(uc.getX2())+Double.parseDouble(uc.getX3()))/3)) * 100d))); 
            ps.setString(17, uc.getX1_28dias()); 
            ps.setString(18, uc.getX2_28dias()); 
            ps.setString(19, uc.getX3_28dias()); 
            ps.setString(20, (String.valueOf((double) (Math.round((Double.parseDouble(uc.getX1_28dias())+Double.parseDouble(uc.getX2_28dias())+Double.parseDouble(uc.getX3_28dias()))/3) * 100d) / 100d)));
            ps.setString(21, de_gestionar_info_laboratorio_editar.control.getText());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
        System.out.println(sql);
         System.out.println("result actualizar "+rsu);
        return rsu;
    }
     
     
     public static int eliminar(int id) {
        int rsu = 0;
        String sql = consultas_de_gestionar_info_lab.ELIMINAR;

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
        String sql = consultas_de_gestionar_info_lab.ELIMINAR_TODOS;

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
