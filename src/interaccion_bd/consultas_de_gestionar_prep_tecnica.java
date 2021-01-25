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
public class consultas_de_gestionar_prep_tecnica {
    private String id;
    private String codigo;
    private String descripcion;
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
    
    
    public static String REGISTRAR = "INSERT INTO `pre_modelo_mercantil`(`codigo_pre_modelo`, `descripcion_pre_modelo`, `um_pre_modelo`, "
            + "`volunidad_pre_modelo`, `cantidad_pre_modelo`, `total_m3_pre_modelo`, `precio_cup_pre_modelo`, `importe_cup_pre_modelo`, "
            + "`rbk_pre_modelo`, `cemento_pre_modelo`, `arena_pre_modelo`, `gravilla_pre_modelo`, `aditivo_pre_modelo`, `1_4_pre_modelo`, "
            + "`3_8_pre_modelo`, `1_2_pre_modelo`, `5_8_pre_modelo`, `3_4_pre_modelo`, `1_pre_modelo`, `al_pre_modelo`, `el_pre_modelo`)"
            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    public static String LISTAR = "SELECT * FROM pre_modelo_mercantil";
    
    public static String ACTUALIZAR = "UPDATE `pre_modelo_mercantil` SET `codigo_pre_modelo`=?,"
            + "`descripcion_pre_modelo`=?,`um_pre_modelo`=?,`volunidad_pre_modelo`=?,`cantidad_pre_modelo`=?,"
            + "`total_m3_pre_modelo`=?,`precio_cup_pre_modelo`=?,`importe_cup_pre_modelo`=?,`rbk_pre_modelo`=?,"
            + "`cemento_pre_modelo`=?,`arena_pre_modelo`=?,`gravilla_pre_modelo`=?,`aditivo_pre_modelo`=?,"
            + "`1_4_pre_modelo`=?,`3_8_pre_modelo`=?,`1_2_pre_modelo`=?,`5_8_pre_modelo`=?,"
            + "`3_4_pre_modelo`=?,`1_pre_modelo`=?,`al_pre_modelo`=?,`el_pre_modelo`=? "
            + "WHERE `id_pre_modelo`=? ";
            
    public static String ELIMINAR = "DELETE FROM pre_modelo_mercantil WHERE id_pre_modelo = ?";
    
     public static String ELIMINAR_TODO = "TRUNCATE `pre_modelo_mercantil`";

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
