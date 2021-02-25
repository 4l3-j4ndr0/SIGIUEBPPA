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
public class consultas_de_gestionar_recursos_x_programa {
    private String codigo;
    private String descripcion;
    private String um;
    private String cant;
    private String programa_pertenece;
    private String factura;
    private String carta_porte;
    
    
    public static String REGISTRAR = "INSERT INTO recursos_x_programa(codigo_re, descripcion_re, um_re, cant_re, programa_re,factura_re,carta_porte_re) "
            + "VALUES(?,?,?,?,?,?,?)";
    
    public static String REGISTRAR_CONTROL = "INSERT INTO recursos_x_programa_control(codigo_re_control, descripcion_re_control, cant_re_control, programa_re_control) "
            + "VALUES(?,?,?,?)";
    
    public static String LISTAR = "SELECT * FROM recursos_x_programa";
    
    public static String LISTAR_ORDENADO = "SELECT `codigo_re`,`descripcion_re`,sum(`cant_re`) as cant_re,`programa_re` FROM recursos_x_programa group by `codigo_re`,`programa_re` order by `programa_re`  ASC ";
    
    public static String ACTUALIZAR = "UPDATE recursos_x_programa SET codigo_re=?,descripcion_re=?,um_re=?,cant_re=?,programa_re=?,"
            + "factura_re=? ,carta_porte_re=? WHERE id_re=? ";
    
    public static String ACTUALIZAR_CONTROL = "UPDATE recursos_x_programa_control SET codigo_re_control=?,descripcion_re_control=?,"
            + "cant_re_control=?,programa_re_control=? WHERE codigo_re_control=? and programa_re_control=?";
    
    public static String ELIMINAR = "DELETE FROM recursos_x_programa WHERE id_re = ?";
    
    public static String ELIMINAR_CONTROL = "DELETE FROM recursos_x_programa_control WHERE codigo_re_control = ? and programa_re_control=?";


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUm() {
        return um;
    }

    public void setUm(String um) {
        this.um = um;
    }

    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public String getPrograma_pertenece() {
        return programa_pertenece;
    }

    public void setPrograma_pertenece(String programa_pertenece) {
        this.programa_pertenece = programa_pertenece;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getCarta_porte() {
        return carta_porte;
    }

    public void setCarta_porte(String carta_porte) {
        this.carta_porte = carta_porte;
    }
    
    
    

    
    
    
}
