/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interaccion_bd;

import alertas.ErrorAlert;
import alertas.WarningAlert;
import conexion.conexion;
import static interaccion_bd.opciones_de_gestionar_contrato.cn;
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
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import paneles.pnl_Gestionar_usuarios;
import paneles_de_paneles.de_gestionar_contrato_editar;
import paneles_de_paneles.de_gestionar_contrato_listar;
import paneles_de_paneles.de_gestionar_plano_listar;

/**
 *
 * @author 4l3
 */
public class opciones_de_gestionar_usuarios {
    
    static conexion cc = new conexion();
    static Connection cn = cc.conexion();
    static PreparedStatement ps;
    
    public static int registrar_user(consultas_de_gestionar_usuarios uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_usuarios.REGISTRAR;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getUsuario());
            ps.setString(2, uc.getPass());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        ErrorAlert error = new ErrorAlert(new JFrame(), true);
                        Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static int registrar_permisos(consultas_de_gestionar_usuarios uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_usuarios.REGISTRAR_PERMISOS;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getUsuario());
            ps.setString(2, uc.getApartado());
            ps.setString(3, uc.getListar());
            ps.setString(4, uc.getAdd());
            ps.setString(5, uc.getEditar());
            ps.setString(6, uc.getEliminar());
            ps.setString(7, uc.getExportar());
            ps.setString(8, uc.getImprimir());
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
                        
                        Logger.getLogger(opciones_de_gestionar_usuarios.class.getName()).log(Level.SEVERE, null, ex);
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
        System.out.println(sql);
        return rsu;
    }
    
    public static void setListar(String busca) {
        DefaultTableModel modelo = (DefaultTableModel) pnl_Gestionar_usuarios.tabla_usuarios.getModel();

        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        String sql = "";
        if (busca.equals("")) {
            sql = consultas_de_gestionar_usuarios.LISTAR;
        } else {
            sql = "SELECT * FROM usuarios WHERE ("
                    + "nombre_us LIKE'" + busca + "%'"
                    + ")";
        }
        String datos[] = new String[4];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString("nombre_us");
                datos[1] = rs.getString("pass");
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
    
     public static int actualizar_permisos(consultas_de_gestionar_usuarios uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_usuarios.ACTUALIZAR_PERMISOS;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getUsuario());
            ps.setString(2, uc.getApartado());
            ps.setString(3, uc.getListar());
            ps.setString(4, uc.getAdd());
            ps.setString(5, uc.getEditar());
            ps.setString(6, uc.getEliminar());
            ps.setString(7, uc.getExportar());
            ps.setString(8, uc.getImprimir());
            ps.setString(9, uc.getUsuario_control());
            ps.setString(10, uc.getApartado());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
        System.out.println(sql);
         System.out.println("result actualizar "+rsu);
        return rsu;
    }
     
     public static int actualizar_user(consultas_de_gestionar_usuarios uc) {
        int rsu = 0;
        String sql = consultas_de_gestionar_usuarios.ACTUALIZAR_USER;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, uc.getUsuario());
            ps.setString(2, uc.getPass());
            ps.setString(3, uc.getUsuario_control());
            
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
        System.out.println(sql);
         System.out.println("result actualizar "+rsu);
        return rsu;
    }
     
     public static int eliminar_user(String nombre) {
        int rsu = 0;
        String sql = consultas_de_gestionar_usuarios.ELIMINAR_USER;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            rsu = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsu;
    }
     
     public static int eliminar_permisos(String nombre) {
        int rsul = 0;
        String sql = consultas_de_gestionar_usuarios.ELIMINAR_PERMISOS;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nombre);
            rsul = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(sql);
        return rsul;
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
            Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, ex);
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
        return existe;
    }
     
     private void activa_checbox(){
        
    }
     public static void activa_checbox_largo(String user,String sql,JCheckBox listar,JCheckBox add,JCheckBox editar,JCheckBox eliminar,JCheckBox exportar,JCheckBox imprimir,JCheckBox desmarcar,JCheckBox marcar) {
        int listar_permiso = 0;
        int add_permiso = 0;
        int editar_permiso = 0;
        int eliminar_permiso = 0;
        int exportar_permiso = 0;
        int imprimir_permiso = 0;
        String user_permiso="";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                user_permiso = rs.getString(1);
                listar_permiso = rs.getInt(3);
                add_permiso = rs.getInt(4);
                editar_permiso = rs.getInt(5);
                eliminar_permiso = rs.getInt(6);
                exportar_permiso = rs.getInt(7);
                imprimir_permiso = rs.getInt(8);
            }
            if(user_permiso.equals(user)){
                marcar.setSelected(false);
                desmarcar.setSelected(false);
                if(listar_permiso==1){
                    listar.setSelected(true);
                }else{
                    listar.setSelected(false);
                }
                if(add_permiso==1){
                    add.setSelected(true);
                }else{
                    add.setSelected(false);
                }
                if(editar_permiso==1){
                    editar.setSelected(true);
                }else{
                    editar.setSelected(false);
                }
                if(eliminar_permiso==1){
                    eliminar.setSelected(true);
                }else{
                    eliminar.setSelected(false);
                }
                if(exportar_permiso==1){
                    exportar.setSelected(true);
                }else{
                    exportar.setSelected(false);
                }
                if(imprimir_permiso==1){
                    imprimir.setSelected(true);
                }else{
                    imprimir.setSelected(false);
                }
                if(listar_permiso==1&&add_permiso==1&&editar_permiso==1&&eliminar_permiso==1&&exportar_permiso==1&&imprimir_permiso==1){
                    marcar.setSelected(true);
                }else if(listar_permiso==0&&add_permiso==0&&editar_permiso==0&&eliminar_permiso==0&&exportar_permiso==0&&imprimir_permiso==0){
                    desmarcar.setSelected(true);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public static void activa_checbox_corto(String user,String sql,JCheckBox listar,JCheckBox add,JCheckBox editar,JCheckBox eliminar,JCheckBox desmarcar,JCheckBox marcar) {
        int listar_permiso = 0;
        int add_permiso = 0;
        int editar_permiso = 0;
        int eliminar_permiso = 0;
        String user_permiso="";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                user_permiso = rs.getString(1);
                listar_permiso = rs.getInt(3);
                add_permiso = rs.getInt(4);
                editar_permiso = rs.getInt(5);
                eliminar_permiso = rs.getInt(6);
            }
            if(user_permiso.equals(user)){
                marcar.setSelected(false);
                desmarcar.setSelected(false);
                if(listar_permiso==1){
                    listar.setSelected(true);
                }else{
                    listar.setSelected(false);
                }
                if(add_permiso==1){
                    add.setSelected(true);
                }else{
                    add.setSelected(false);
                }
                if(editar_permiso==1){
                    editar.setSelected(true);
                }else{
                    editar.setSelected(false);
                }
                if(eliminar_permiso==1){
                    eliminar.setSelected(true);
                }else{
                    eliminar.setSelected(false);
                }
                if(listar_permiso==1&&add_permiso==1&&editar_permiso==1&&eliminar_permiso==1){
                    marcar.setSelected(true);
                    listar.setSelected(true);
                    add.setSelected(true);
                    editar.setSelected(true);
                    eliminar.setSelected(true);
                }
                if(listar_permiso==0&&add_permiso==0&&editar_permiso==0&&eliminar_permiso==0){
                    desmarcar.setSelected(true);
                    listar.setSelected(false);
                    add.setSelected(false);
                    editar.setSelected(false);
                    eliminar.setSelected(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
