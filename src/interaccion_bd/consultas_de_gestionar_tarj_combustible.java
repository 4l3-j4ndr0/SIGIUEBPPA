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
public class consultas_de_gestionar_tarj_combustible {
    private String numero_tarjeta;
    private String tipo_combustible_tarjeta;
    private String ping_tarjeta;
    private String chapa_tarjeta;
    private String cant_litros_tarjeta;
    private String fecha_asignacion_tarjeta;
    public static String id_tarj;
    
    public static String REGISTRAR = "INSERT INTO tarj_combustible(numero_tarJ, tipo_comb_tarj, ping_tarj, chapa_tarj, cant_litros_tarj, fecha_asignacion_tarj) "
            + "VALUES(?,?,?,?,?,?)";
    
    public static String LISTAR = "SELECT * FROM tarj_combustible";
    
    
    public static String ACTUALIZAR = "UPDATE `tarj_combustible` SET `numero_tarj`=?,`tipo_comb_tarj`=?,`ping_tarj`=?,`chapa_tarj`=?,"
            + "`cant_litros_tarj`=?,`fecha_asignacion_tarj`=? WHERE `id_tarj`=? ";
            
    public static String ELIMINAR = "DELETE FROM tarj_combustible WHERE id_tarj = ?";

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public String getTipo_combustible_tarjeta() {
        return tipo_combustible_tarjeta;
    }

    public void setTipo_combustible_tarjeta(String tipo_combustible_tarjeta) {
        this.tipo_combustible_tarjeta = tipo_combustible_tarjeta;
    }

    public String getPing_tarjeta() {
        return ping_tarjeta;
    }

    public void setPing_tarjeta(String ping_tarjeta) {
        this.ping_tarjeta = ping_tarjeta;
    }

    public String getChapa_tarjeta() {
        return chapa_tarjeta;
    }

    public void setChapa_tarjeta(String chapa_tarjeta) {
        this.chapa_tarjeta = chapa_tarjeta;
    }

    public String getCant_litros_tarjeta() {
        return cant_litros_tarjeta;
    }

    public void setCant_litros_tarjeta(String cant_litros_tarjeta) {
        this.cant_litros_tarjeta = cant_litros_tarjeta;
    }

    public String getFecha_asignacion_tarjeta() {
        return fecha_asignacion_tarjeta;
    }

    public void setFecha_asignacion_tarjeta(String fecha_asignacion_tarjeta) {
        this.fecha_asignacion_tarjeta = fecha_asignacion_tarjeta;
    }

    public String getId_tarj() {
        return id_tarj;
    }

    public void setId_tarj(String id_tarj) {
        this.id_tarj = id_tarj;
    }
    
    
    

    
}
