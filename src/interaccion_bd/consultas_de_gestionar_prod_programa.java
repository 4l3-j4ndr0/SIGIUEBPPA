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
    private int primaryKey;
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
    private double cemento;
    private double arena;
    private double gravilla;
    private double aditivo;
    private double un_cuarto;
    private double tres_octavo;
    private double un_medio;
    private double cinco_octavo;
    private double tres_cuartos;
    private double uno;
    private double al;
    private double el;
    
    
    public static String REGISTRAR = "INSERT INTO `modelo_mercantil`( `codigo_modelo`, `descripcion_modelo`, `u/m_modelo`, "
            + "`vol/unidad_modelo`, `cantidad_modelo`, `programa_modelo`, `total_m3_modelo`, `precio_cup_modelo`, `importe_cup_modelo`, "
            + "`fecha_modelo`, `rbk_modelo`, `cemento_modelo`, `arena_modelo`, `gravilla_modelo`, `aditivo_modelo`, `1_4_modelo`, `3_8_modelo`,"
            + " `1_2_modelo`, `5_8_modelo`, `3_4_modelo`, `1_modelo`, `al_modelo`, `el_modelo`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    public static String LISTAR = "SELECT * FROM modelo_mercantil";
    
    public static String ACTUALIZAR = "UPDATE `modelo_mercantil` SET `codigo_modelo`=?,"
            + "`descripcion_modelo`=?,`u/m_modelo`=?,`vol/unidad_modelo`=?,`cantidad_modelo`=?,"
            + "`programa_modelo`=?,`total_m3_modelo`=?,`precio_cup_modelo`=?,`importe_cup_modelo`=?,"
            + "`fecha_modelo`=?,`rbk_modelo`=?, `cemento_modelo`=?,`arena_modelo`=?,`gravilla_modelo`=?,`aditivo_modelo`=?,"
            + "`1_4_modelo`=?,`3_8_modelo`=?,`1_2_modelo`=?,`5_8_modelo`=?,`3_4_modelo`=?,"
            + "`1_modelo`=?,`al_modelo`=?,`el_modelo`=? WHERE id_modelo=? ";
            
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

    public double getCemento() {
        return cemento;
    }

    public void setCemento(double cemento) {
        this.cemento = cemento;
    }

    public double getArena() {
        return arena;
    }

    public void setArena(double arena) {
        this.arena = arena;
    }

    public double getGravilla() {
        return gravilla;
    }

    public void setGravilla(double gravilla) {
        this.gravilla = gravilla;
    }

    public double getAditivo() {
        return aditivo;
    }

    public void setAditivo(double aditivo) {
        this.aditivo = aditivo;
    }

    public double getUn_cuarto() {
        return un_cuarto;
    }

    public void setUn_cuarto(double un_cuarto) {
        this.un_cuarto = un_cuarto;
    }

    public double getTres_octavo() {
        return tres_octavo;
    }

    public void setTres_octavo(double tres_octavo) {
        this.tres_octavo = tres_octavo;
    }

    public double getUn_medio() {
        return un_medio;
    }

    public void setUn_medio(double un_medio) {
        this.un_medio = un_medio;
    }

    public double getCinco_octavo() {
        return cinco_octavo;
    }

    public void setCinco_octavo(double cinco_octavo) {
        this.cinco_octavo = cinco_octavo;
    }

    public double getTres_cuartos() {
        return tres_cuartos;
    }

    public void setTres_cuartos(double tres_cuartos) {
        this.tres_cuartos = tres_cuartos;
    }

    public double getUno() {
        return uno;
    }

    public void setUno(double uno) {
        this.uno = uno;
    }

    public double getAl() {
        return al;
    }

    public void setAl(double al) {
        this.al = al;
    }

    public double getEl() {
        return el;
    }

    public void setEl(double el) {
        this.el = el;
    }

    public int getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(int primaryKey) {
        this.primaryKey = primaryKey;
    }
}
