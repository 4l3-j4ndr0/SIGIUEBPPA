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
public class consultas_de_gestionar_info_lab {
    private String num_materiales;
    private String fecha;
    private String vol;
    private String asent;
    private String x1;
    private String x2;
    private String x3;
    private String x1_28dias;
    private String x2_28dias;;
    private String x3_28dias;;
    private String lm;
    private String pm;
    private String elementos;
    
    
    public static String REGISTRAR = "INSERT INTO `info_lab`(`num_materiales_info_lab`, `elementos_info_lab`, `fecha_info_lab`, `rbk_info_lab`, "
            + "`tipoCto_info_lab`, `vol_info_lab`, `cem_info_lab`, `grav_info_lab`, `aren_info_lab`, `adit_info_lab`, `agua_info_lab`, "
            + "`asent_info_lab`, `x1_info_lab`, `x2_info_lab`, `x3_info_lab`, `xm_info_lab`, `x1_28dias_info_lab`, `x2_28dias_info_lab`, "
            + "`x3_28dias_info_lab`, `xm_28dias_info_lab`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    public static String LISTAR = "SELECT * FROM `info_lab`";
    
    public static String ACTUALIZAR = "UPDATE `info_lab` SET `num_materiales_info_lab`=?,"
            + "`elementos_info_lab`=?,`fecha_info_lab`=?,`rbk_info_lab`=?,`tipoCto_info_lab`=?,"
            + "`vol_info_lab`=?,`cem_info_lab`=?,`grav_info_lab`=?,`aren_info_lab`=?,"
            + "`adit_info_lab`=?,`agua_info_lab`=?,`asent_info_lab`=?,`x1_info_lab`=?,"
            + "`x2_info_lab`=?,`x3_info_lab`=?,`xm_info_lab`=?,`x1_28dias_info_lab`=?,"
            + "`x2_28dias_info_lab`=?,`x3_28dias_info_lab`=?,`xm_28dias_info_lab`=?"
            + " WHERE id_info_lab=? ";
            
    public static String ELIMINAR = "DELETE FROM `info_lab` WHERE id_info_lab = ?";
    
    public static String ELIMINAR_TODOS="TRUNCATE `info_lab`";

    public String getNum_materiales() {
        return num_materiales;
    }

    public void setNum_materiales(String num_materiales) {
        this.num_materiales = num_materiales;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol;
    }

    public String getAsent() {
        return asent;
    }

    public void setAsent(String asent) {
        this.asent = asent;
    }

    public String getX1() {
        return x1;
    }

    public void setX1(String x1) {
        this.x1 = x1;
    }

    public String getX2() {
        return x2;
    }

    public void setX2(String x2) {
        this.x2 = x2;
    }

    public String getX3() {
        return x3;
    }

    public void setX3(String x3) {
        this.x3 = x3;
    }

    public String getX1_28dias() {
        return x1_28dias;
    }

    public void setX1_28dias(String x1_28dias) {
        this.x1_28dias = x1_28dias;
    }

    public String getX2_28dias() {
        return x2_28dias;
    }

    public void setX2_28dias(String x2_28dias) {
        this.x2_28dias = x2_28dias;
    }

    public String getX3_28dias() {
        return x3_28dias;
    }

    public void setX3_28dias(String x3_28dias) {
        this.x3_28dias = x3_28dias;
    }

    public String getLm() {
        return lm;
    }

    public void setLm(String lm) {
        this.lm = lm;
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getElementos() {
        return elementos;
    }

    public void setElementos(String elementos) {
        this.elementos = elementos;
    }

    
}
