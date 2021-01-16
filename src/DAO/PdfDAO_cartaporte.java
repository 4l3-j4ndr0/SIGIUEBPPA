package DAO;

import conexion.conexion;
import VO.PdfVO;
import VO.PdfVO_cartaporte;
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
import paneles_de_paneles.de_gestionar_cartaporte_listar;
import paneles_de_paneles.de_gestionar_plano_listar;
import paneles_de_paneles.de_gestionar_prep_tecnica_listar;
import paneles_de_paneles.de_gestionar_proyecto_listar;
import rojeru_san.rsfield.RSTextMaterial;

public class PdfDAO_cartaporte {

    /*Metodo listar*/
    public ArrayList<PdfVO_cartaporte> Listar_PdfVO() {
        ArrayList<PdfVO_cartaporte> list = new ArrayList<PdfVO_cartaporte>();
        conexion conec = new conexion();
        String sql = "SELECT * FROM cartaportes";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = conec.conexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO_cartaporte vo = new PdfVO_cartaporte();
                vo.setCodigopdf(rs.getInt(1));
                vo.setNombrepdf(rs.getString(2));
                vo.setArchivopdf(rs.getBytes(3));
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
    public ArrayList<PdfVO_cartaporte> buscar_PdfVO(String busca) {
        ArrayList<PdfVO_cartaporte> list = new ArrayList<>();
        conexion conec = new conexion();
        String sql="";
        if(de_gestionar_cartaporte_listar.txtBuscar_pdf.getText().isEmpty()){
            sql = "SELECT * FROM cartaportes";
        }else{
         
        sql = "SELECT * FROM cartaportes WHERE ("
                    + "id_cartaporte LIKE'" + busca + "%'or "
                + "numero_cartaporte LIKE'" + busca + "%')";
        }
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
           // ps.setString(1,busca);
            ps = conec.conexion().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                PdfVO_cartaporte vo = new PdfVO_cartaporte();
                vo.setCodigopdf(rs.getInt(1));
                vo.setNombrepdf(rs.getString(2));
                vo.setArchivopdf(rs.getBytes(3));
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
    public void Agregar_PdfVO(PdfVO_cartaporte vo) {
        conexion conec = new conexion();
        String sql = "INSERT INTO cartaportes ( numero_cartaporte, pdf_cartaporte) VALUES( ?, ?);";
        PreparedStatement ps = null;
        try {
            ps = conec.conexion().prepareStatement(sql);
            ps.setString(1, vo.getNombrepdf());
            ps.setBytes(2, vo.getArchivopdf());
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


    /*Metodo Modificar*/
    public void Modificar_PdfVO(PdfVO_cartaporte vo) {
        conexion conec = new conexion();
        String sql = "UPDATE cartaportes SET numero_cartaporte = ?, pdf_cartaporte = ? WHERE id_cartaporte = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.conexion().prepareStatement(sql);
            ps.setString(1, vo.getNombrepdf());
            ps.setBytes(2, vo.getArchivopdf());
            ps.setInt(3, vo.getCodigopdf());
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

    public void Modificar_PdfVO2(PdfVO_cartaporte vo) {
        conexion conec = new conexion();
        String sql = "UPDATE cartaportes SET numero_cartaporte = ? WHERE id_cartaporte = ?;";
        PreparedStatement ps = null;
        try {
            ps = conec.conexion().prepareStatement(sql);
            ps.setString(1, vo.getNombrepdf());
            ps.setInt(2, vo.getCodigopdf());
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

    /*Metodo Eliminar*/
    public void Eliminar_PdfVO(PdfVO_cartaporte vo) {
        conexion conec = new conexion();
        String sql = "DELETE FROM cartaportes WHERE id_cartaporte = ?;";
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
            ps = cn.conexion().prepareStatement("SELECT pdf_cartaporte FROM cartaportes WHERE id_cartaporte = ?");
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
