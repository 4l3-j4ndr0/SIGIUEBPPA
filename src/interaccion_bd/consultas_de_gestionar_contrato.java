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
public class consultas_de_gestionar_contrato {
    private String numero_contrato;
    private String nombre_contrato;
    private String fecha_inicio_contrato;
    private String fecha_final_contrato;
    private String primaryKey;
    
    
    public static String REGISTRAR = "INSERT INTO contrato(numero_contrato, nombre_contrato, fecha_inicio_contrato, fecha_final_contrato) "
            + "VALUES(?,?,?,?)";
    
    public static String LISTAR = "SELECT * FROM contrato";
    
    public static String ACTUALIZAR = "UPDATE `contrato` SET `numero_contrato`=?,`nombre_contrato`=?,`fecha_inicio_contrato`=?,"
            + "`fecha_final_contrato`=? WHERE id=? ";
            
    public static String ELIMINAR = "DELETE FROM contrato WHERE id = ?";
    
    
    

    public String getNumero_contrato() {
        return numero_contrato;
    }

    public void setNumero_contrato(String numero_contrato) {
        this.numero_contrato = numero_contrato;
    }

    public String getNombre_contrato() {
        return nombre_contrato;
    }

    public void setNombre_contrato(String nombre_contrato) {
        this.nombre_contrato = nombre_contrato;
    }

    public String getFecha_inicio_contrato() {
        return fecha_inicio_contrato;
    }

    public void setFecha_inicio_contrato(String fecha_inicio_contrato) {
        this.fecha_inicio_contrato = fecha_inicio_contrato;
    }

    public String getFecha_final_contrato() {
        return fecha_final_contrato;
    }

    public void setFecha_final_contrato(String fecha_final_contrato) {
        this.fecha_final_contrato = fecha_final_contrato;
    }

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }
    
    
    
}
