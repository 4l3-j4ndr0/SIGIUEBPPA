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
import paneles_de_paneles.de_gestionar_plano_listar;
import paneles_de_paneles.de_gestionar_recursos_x_programa_editar;
import paneles_de_paneles.de_gestionar_recursos_x_programa_listar;

/**
 *
 * @author 4l3
 */
public class opciones_de_gestionar_recursos_x_programa {
    
    static conexion cc = new conexion();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
    public static int registrar(consultas_de_gestionar_recursos_x_programa uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_recursos_x_programa.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getCodigo());
            ps.setString(2, uc.getDescripcion());
            ps.setString(3, uc.getUm());
            ps.setString(4, uc.getCant() );  
            ps.setString(5, uc.getPrograma_pertenece() ); 
            ps.setString(6, uc.getFactura() ); 
            ps.setString(7, uc.getCarta_porte() ); 
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_recursos_x_programa.class.getName()).log(Level.SEVERE, null, ex);
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
        DefaultTableModel modelo = (DefaultTableModel) de_gestionar_recursos_x_programa_listar.tabla_recursos_x_programa.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = consultas_de_gestionar_recursos_x_programa.LISTAR;
        } else {
            sql = "SELECT * FROM recursos_x_programa WHERE ("
                    + "codigo_re LIKE'" + busca + "%' OR "
                    + "descripcion_re LIKE'" + busca + "%' OR "
                    + "programa_re LIKE'" + busca + "%' OR "
                    + "factura_re LIKE'" + busca + "%'"
                    + ")";
        }
        String datos[] = new String[7];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("codigo_re");
                datos[1] = rs.getString("descripcion_re");
                datos[2] = rs.getString("um_re");
                datos[3] = rs.getString("cant_re");
                datos[4] = rs.getString("programa_re");
                datos[5] = rs.getString("factura_re");
                datos[6] = rs.getString("carta_porte_re");
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
    
    
    
     public static void extraerDatos(de_gestionar_recursos_x_programa_editar datos, int id) {

        String sql = "SELECT * FROM recursos_x_programa WHERE codigo_re = " + id;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                de_gestionar_recursos_x_programa_editar.codigo_re_editar.setText(String.valueOf(id)); 
                de_gestionar_recursos_x_programa_editar.descripcion_re_editar.setText(rs.getString(2));
                de_gestionar_recursos_x_programa_editar.um_re_editar.setText(rs.getString(3));
                de_gestionar_recursos_x_programa_editar.cantidad_re_editar.setText(rs.getString(4));
                de_gestionar_recursos_x_programa_editar.programa_re_editar.setText(rs.getString(5));
                de_gestionar_recursos_x_programa_editar.factura_re_editar.setText(rs.getString(6));
                de_gestionar_recursos_x_programa_editar.carta_porte_re_editar.setText(rs.getString(7));
            }
        } catch (SQLException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
    }
     
     public static int actualizar(consultas_de_gestionar_recursos_x_programa uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_recursos_x_programa.ACTUALIZAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getCodigo());
            ps.setString(2, uc.getDescripcion());
            ps.setString(3, uc.getUm());
            ps.setString(4, uc.getCant());
            ps.setString(5, uc.getPrograma_pertenece());
            ps.setString(6, uc.getFactura());
            ps.setString(7, uc.getCarta_porte());
            ps.setString(8, de_gestionar_recursos_x_programa_editar.codigo_editar_control.getText());
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
        String sql = consultas_de_gestionar_recursos_x_programa.ELIMINAR;

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
