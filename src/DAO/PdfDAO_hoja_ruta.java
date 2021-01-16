package DAO;

import conexion.conexion;
import VO.PdfVO;
import VO.PdfVO_hoja_ruta;
import VO.PdfVO_prep_tecnica;
import VO.PdfVO_proy;
import interaccion_bd.opciones_de_gestionar_contrato;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import paneles_de_paneles.de_gestionar_hoja_ruta_listar;
import paneles_de_paneles.de_gestionar_plano_listar;
import paneles_de_paneles.de_gestionar_prep_tecnica_listar;
import paneles_de_paneles.de_gestionar_proyecto_listar;
import rojeru_san.rsfield.RSTextMaterial;

public class PdfDAO_hoja_ruta {

    /*Metodo listar*/
    public ArrayList<PdfVO_hoja_ruta> Listar_PdfVO() {
        ArrayList<PdfVO_hoja_ruta> list = new ArrayList<PdfVO_hoja_ruta>();
        conexion conec = new conexion();
        String sql = "SELECT * FROM hoja_ruta";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.conexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO_hoja_ruta vo = new PdfVO_hoja_ruta();
                vo.setCodigopdf(rs.getInt(1));
                vo.setChapa(rs.getString(2));
                vo.setTotal_km(rs.getString(3));
                vo.setConsumo(rs.getString(4));
                vo.setArchivopdf(rs.getBytes(5));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
                opciones_de_gestionar_contrato.lanza_error(ex);
            }
        }
        return list;
    }
    
    /*Metodo listar*/
    public ArrayList<PdfVO_hoja_ruta> buscar_PdfVO(String busca) {
        ArrayList<PdfVO_hoja_ruta> list = new ArrayList<>();
        conexion conec = new conexion();
        String sql="";
        if(de_gestionar_hoja_ruta_listar.txtBuscar_pdf.getText().isEmpty()){
            sql = "SELECT * FROM hoja_ruta";
        }else{
         
        sql = "SELECT * FROM hoja_ruta WHERE ("
                    + "id_hoja_ruta LIKE'" + busca + "%'or "
                + "total_km_hoja_ruta LIKE'" + busca + "%'or "
                 + "consumo_hoja_ruta LIKE'" + busca + "%'or "
                + "chapa_hoja_ruta LIKE'" + busca + "%')";
        }
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
           // ps.setString(1,busca);
            ps = conec.conexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO_hoja_ruta vo = new PdfVO_hoja_ruta();
                 vo.setCodigopdf(rs.getInt(1));
                vo.setChapa(rs.getString(2));
                vo.setTotal_km(rs.getString(3));
                vo.setConsumo(rs.getString(4));
                vo.setArchivopdf(rs.getBytes(5));
                list.add(vo);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                rs.close();
                conec.desconectar();
            } catch (Exception ex) {
                opciones_de_gestionar_contrato.lanza_error(ex);
            }
        }
        return list;
    }


    /*Metodo agregar*/
    public void Agregar_PdfVO(PdfVO_hoja_ruta vo) {
        conexion conec = new conexion();
        String sql = "INSERT INTO hoja_ruta ( chapa_hoja_ruta, total_km_hoja_ruta,consumo_hoja_ruta, pdf_hoja_ruta) VALUES( ?, ?,?,?);";
        PreparedStatement ps = null;
        try {
            ps = conec.conexion().prepareStatement(sql);
            ps.setString(1, vo.getChapa());
            ps.setString(2, vo.getTotal_km());
            ps.setString(3, vo.getConsumo());
            ps.setBytes(4, vo.getArchivopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(opciones_de_gestionar_contrato.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
                opciones_de_gestionar_contrato.lanza_error(ex);
            }
        }
    }


    /*Metodo Modificar*/
    public void Modificar_PdfVO(PdfVO_hoja_ruta vo) {
        conexion conec = new conexion();
        String sql = "UPDATE hoja_ruta SET chapa_hoja_ruta = ?, total_km_hoja_ruta=?, consumo_hoja_ruta=?, pdf_hoja_ruta = ? WHERE id_hoja_ruta = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.conexion().prepareStatement(sql);
            ps.setString(1, vo.getChapa());
            ps.setString(2, vo.getTotal_km());
            ps.setString(3, vo.getConsumo());
            ps.setBytes(4, vo.getArchivopdf());
            ps.setInt(5, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
                opciones_de_gestionar_contrato.lanza_error(ex);
            }
        }
    }

    public void Modificar_PdfVO2(PdfVO_hoja_ruta vo) {
        conexion conec = new conexion();
        String sql = "UPDATE hoja_ruta SET chapa_hoja_ruta = ?, total_km_hoja_ruta=?, consumo_hoja_ruta=? WHERE id_hoja_ruta = ?";
        PreparedStatement ps = null;
        try {
            ps = conec.conexion().prepareStatement(sql);
            ps.setString(1, vo.getChapa());
            ps.setString(2, vo.getTotal_km());
            ps.setString(3, vo.getConsumo());
            ps.setInt(4, vo.getCodigopdf());
            ps.executeUpdate();
            System.out.println(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
                opciones_de_gestionar_contrato.lanza_error(ex);
            }
        }
    }

    /*Metodo Eliminar*/
    public void Eliminar_PdfVO(PdfVO_hoja_ruta vo) {
        conexion conec = new conexion();
        String sql = "DELETE FROM hoja_ruta WHERE id_hoja_ruta = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.conexion().prepareStatement(sql);
            ps.setInt(1, vo.getCodigopdf());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                ps.close();
                conec.desconectar();
            } catch (Exception ex) {
                opciones_de_gestionar_contrato.lanza_error(ex);
            }
        }
    }

    //Permite mostrar PDF contenido en la base de datos
    public void ejecutar_archivoPDF(int id) {

        conexion cn = new conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        byte[] b = null;

        try {
            ps = cn.conexion().prepareStatement("SELECT pdf_hoja_ruta FROM hoja_ruta WHERE id_hoja_ruta = ?;");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                b = rs.getBytes(1);
            }
            InputStream bos = new ByteArrayInputStream(b);

            int tamanoInput = bos.available();
            byte[] datosPDF = new byte[tamanoInput];
            bos.read(datosPDF, 0, tamanoInput);

            OutputStream out = new FileOutputStream("new.pdf");
            out.write(datosPDF);

            //abrir archivo
            out.close();
            bos.close();
            ps.close();
            rs.close();
            cn.desconectar();

        } catch (IOException | NumberFormatException | SQLException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
    }

}
