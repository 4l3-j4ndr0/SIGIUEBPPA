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
public class consultas_de_gestionar_prod_programa {
    private String codigo;
    private String descripcion;
    private String programa;
    private String fecha;
    private double total_m3;
    private double importe;
    private double volumen_unidad;
    private String u_m;
    private double cantidad;
    private String rbk;
    private double preciio;
    
    
    public static String REGISTRAR = "INSERT INTO `modelo_mercantil`(`codigo_modelo`, `descripcion_modelo`, `u/m_modelo`, "
            + "`vol/unidad_modelo`, `cantidad_modelo`, `programa_modelo`, `total_m3_modelo`, `precio_cup_modelo`, `importe_cup_modelo`, "
            + "`fecha_modelo`, `rbk_modelo`) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    
    public static String LISTAR = "SELECT * FROM modelo_mercantil";
    
    public static String ACTUALIZAR = "UPDATE modelo_mercantil SET codigo_modelo=?,descripcion_modelo=?,volumen/unidad_modelo=?,"
            + "cantidad_modelo=?, rbk_modelo=?, total_m3_modelo=?, precio_cup_modelo=?, importe_cup_modelo=?, programa_modelo=?, fecha_modelo=? WHERE id_modelo=? ";
            
    public static String ELIMINAR = "DELETE FROM modelo_mercantil WHERE id_modelo = ?";

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal_m3() {
        return total_m3;
    }

    public void setTotal_m3(double total_m3) {
        this.total_m3 = total_m3;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getVolumen_unidad() {
        return volumen_unidad;
    }

    public void setVolumen_unidad(double volumen_unidad) {
        this.volumen_unidad = volumen_unidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    

    public String getRbk() {
        return rbk;
    }

    public void setRbk(String rbk) {
        this.rbk = rbk;
    }

    public double getPreciio() {
        return preciio;
    }

    public void setPreciio(double preciio) {
        this.preciio = preciio;
    }

    

    public String getU_m() {
        return u_m;
    }

    public void setU_m(String u_m) {
        this.u_m = u_m;
    }
    
    
    

   
}
