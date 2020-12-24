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
public class opciones_de_gestionar_ekipo {
    
    static conexion cc = new conexion();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
    public static int registrar(consultas_de_gestionar_ekipo uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_ekipo.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNumero_chapa());
            ps.setString(2, uc.getTipo_auto());
            ps.setString(3, uc.getIndice_consumo());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_ekipo.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static void setListar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) de_gestionar_ekipo_listar.tabla_ekipo.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = consultas_de_gestionar_ekipo.LISTAR;
        } else {
            sql = "SELECT * FROM ekipos WHERE ("
                    + "chapa_ekipo LIKE'" + busca + "%' OR "
                    + "tipo_ekipo LIKE'" + busca + "%' OR "
                    + "indice_consumo_ekipo LIKE'" + busca + "%')";
        }
        String datos[] = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("id_ekipo");
                datos[1] = rs.getString("chapa_ekipo");
                datos[2] = rs.getString("tipo_ekipo");
                datos[3] = rs.getString("indice_consumo_ekipo");
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
    
     public static void extraerDatos(de_gestionar_ekipo_editar datos, String id) {

        String sql = "SELECT * FROM ekipos WHERE id_ekipo = '" + id+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                de_gestionar_ekipo_editar.numero_chapa_ekipo_editar.setText(rs.getString(2));
                de_gestionar_ekipo_editar.indice_consumo_ekipo_editar.setText(rs.getString(4));
                de_gestionar_ekipo_editar.combo_tipo_auto_ekipo_editar.setSelectedItem(rs.getString(3));
                consultas_de_gestionar_ekipo.id_ekipo=id;
            }
        } catch (SQLException ex) {
            opciones_de_gestionar_prod_programa.lanza_error(ex);
        }
    }
     
     public static int actualizar(consultas_de_gestionar_ekipo uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_ekipo.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNumero_chapa());
            ps.setString(2, uc.getTipo_auto());
            ps.setString(3, uc.getIndice_consumo());
            ps.setString(4, uc.getId_ekipo() );
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            opciones_de_gestionar_prod_programa.lanza_error(ex);
        }
        System.out.println(sql);
         System.out.println("result actualizar "+rsu);
        return rsu;
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
            Logger.getLogger(opciones_de_gestionar_ekipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;
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
            Logger.getLogger(opciones_de_gestionar_ekipo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;
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
            Logger.getLogger(opciones_de_gestionar_ekipo.class.getName()).log(Level.SEVERE, null, ex);
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
        return existe;
    }
     
     public static int eliminar(String id) {
        int rsu = 0;
        String sql = consultas_de_gestionar_ekipo.ELIMINAR;

        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, id);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
     
     
}
