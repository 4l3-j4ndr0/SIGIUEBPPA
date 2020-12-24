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
public class consultas_de_gestionar_ekipo {
    private String numero_chapa;
    private String tipo_auto;
    private String indice_consumo;
    public static String id_ekipo;
    
    
    public static String REGISTRAR = "INSERT INTO ekipos(chapa_ekipo, tipo_ekipo, indice_consumo_ekipo) "
            + "VALUES(?,?,?)";
    
    public static String LISTAR = "SELECT * FROM ekipos";
    
    public static String ACTUALIZAR = "UPDATE `ekipos` SET `chapa_ekipo`=?,`tipo_ekipo`=?,`indice_consumo_ekipo`=?  WHERE id_ekipo=? ";
            
    public static String ELIMINAR = "DELETE FROM ekipos WHERE id_ekipo = ?";

    public String getNumero_chapa() {
        return numero_chapa;
    }

    public void setNumero_chapa(String numero_chapa) {
        this.numero_chapa = numero_chapa;
    }

    public String getTipo_auto() {
        return tipo_auto;
    }

    public void setTipo_auto(String tipo_auto) {
        this.tipo_auto = tipo_auto;
    }

    public String getIndice_consumo() {
        return indice_consumo;
    }

    public void setIndice_consumo(String indice_consumo) {
        this.indice_consumo = indice_consumo;
    }

    public String getId_ekipo() {
        return id_ekipo;
    }

    public void setId_ekipo(String id_ekipo) {
        this.id_ekipo = id_ekipo;
    }
    
    
    
    
}
