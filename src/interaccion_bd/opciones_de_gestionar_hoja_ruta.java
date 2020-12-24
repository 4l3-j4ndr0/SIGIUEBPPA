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
import paneles_de_paneles.de_gestionar_ekipo_editar;
import paneles_de_paneles.de_gestionar_ekipo_listar;
import paneles_de_paneles.de_gestionar_plano_listar;
import paneles_de_paneles.de_gestionar_tarj_combustible_editar;
import paneles_de_paneles.de_gestionar_tarj_combustible_listar;

/**
 *
 * @author 4l3
 */
public class opciones_de_gestionar_hoja_ruta {
    
    static conexion cc = new conexion();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
    
    
    
    
     public static double extraer_indice_consumo(String sql) {
        double cant = 1;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cant = rs.getDouble(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_hoja_ruta.class.getName()).log(Level.SEVERE, null, ex);
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
        return cant;
    }
     
     public static void get_combos(JComboBox combo1) {         
        try {
            
          // PREFABRICADOS 
            String sql_prefabricados = "SELECT `chapa_ekipo` FROM `ekipos` ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql_prefabricados);
            while (rs.next()) {
                combo1.addItem(rs.getString("chapa_ekipo"));
            }
            rs.close();
        } catch (Exception ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
    }
}
