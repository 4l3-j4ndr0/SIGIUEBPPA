/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interaccion_bd;

/**
 *
 * @author 4l3
 */
public class consultas_de_gestionar_usuarios {
    
    String usuario;
    String usuario_control;
    String pass;
    String apartado;
    String listar;
    String add;
    String editar;
    String eliminar;
    String exportar;
    String imprimir;
       
    
    public static String REGISTRAR = "INSERT INTO usuarios(nombre_us, pass) "
            + "VALUES(?,?)";
    
    public static String REGISTRAR_PERMISOS = "INSERT INTO `permisos`(`usuario_permisos`, `apartado_permisos`, `listar_permisos`, `add_permisos`, "
            + "`editar_permisos`, `eliminar_permisos`, `exportar_permisos`, `imprimir_permisos`) VALUES (?,?,?,?,?,?,?,?)";
    
    public static String LISTAR = "SELECT * FROM usuarios";
    
    public static String ACTUALIZAR_PERMISOS = "UPDATE `permisos` SET `usuario_permisos`=?,`apartado_permisos`=?,"
            + "`listar_permisos`=?,`add_permisos`=?,`editar_permisos`=?,`eliminar_permisos`=?,"
            + "`exportar_permisos`=?,`imprimir_permisos`=? WHERE `usuario_permisos`=? and `apartado_permisos`=?";
    public static String ACTUALIZAR_USER="UPDATE `usuarios` SET `nombre_us`=?,`pass`=? WHERE `nombre_us`=?";
            
    public static String ELIMINAR_USER = "DELETE FROM usuarios WHERE nombre_us = ?";
    public static String ELIMINAR_PERMISOS = "DELETE FROM `permisos` WHERE `usuario_permisos`= ?";

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getListar() {
        return listar;
    }

    public void setListar(String listar) {
        this.listar = listar;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getEditar() {
        return editar;
    }

    public void setEditar(String editar) {
        this.editar = editar;
    }

    public String getEliminar() {
        return eliminar;
    }

    public void setEliminar(String eliminar) {
        this.eliminar = eliminar;
    }

    public String getExportar() {
        return exportar;
    }

    public void setExportar(String exportar) {
        this.exportar = exportar;
    }

    public String getImprimir() {
        return imprimir;
    }

    public void setImprimir(String imprimir) {
        this.imprimir = imprimir;
    }

    public String getApartado() {
        return apartado;
    }

    public void setApartado(String apartado) {
        this.apartado = apartado;
    }

    public String getUsuario_control() {
        return usuario_control;
    }

    public void setUsuario_control(String usuario_control) {
        this.usuario_control = usuario_control;
    }

   
    
    
}
