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

/**
 *
 * @author 4l3
 */
public class opciones_de_gestionar_contrato {
    
    static conexion cc = new conexion();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
    public static int registrar(consultas_de_gestionar_contrato uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_contrato.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getNumero_contrato());
            ps.setString(2, uc.getNombre_contrato());
            ps.setString(3, uc.getFecha_inicio_contrato());
            ps.setString(4, uc.getFecha_final_contrato() );  
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, ex);
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
        DefaultTableModel modelo = (DefaultTableModel) de_gestionar_contrato_listar.tabla.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = consultas_de_gestionar_contrato.LISTAR;
        } else {
            sql = "SELECT * FROM contrato WHERE ("
                    + "numero_contrato LIKE'" + busca + "%' OR "
                    + "nombre_contrato LIKE'" + busca + "%' OR "
                    + "fecha_inicio_contrato LIKE'" + busca + "%' OR "
                    + "fecha_final_contrato LIKE'" + busca + "%'"
                    + ")";
        }
        String datos[] = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("numero_contrato");
                datos[1] = rs.getString("nombre_contrato");
                datos[2] = rs.getString("fecha_inicio_contrato");
                datos[3] = rs.getString("fecha_final_contrato");
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
                        Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, ex);
            error.msj1.setText(ex.toString());
            error.msj2.setText("Solucione el error antes de volverlo a intentar");
            error.msj3.setText("En caso de no saber como solucionar el error contacte con soporte técnico");
            error.preferredSize();
            error.pack();
            error.setVisible(true);
    }
    
    public static void lanza_error_variable( Exception ex, String uno, String dos){
        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, ex);
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

        String sql = "SELECT * FROM contrato WHERE id = " + id;
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
     
     public static int extraer_id(String sql) {
        int cant = 1;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cant = rs.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, ex);
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
