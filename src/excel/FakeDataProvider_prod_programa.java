package excel;

import conexion.conexion;
import interaccion_bd.opciones_de_gestionar_contrato;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Data provider for excel
 *
 * @author angel
 */
public final class FakeDataProvider_prod_programa {

    private static conexion cn = new conexion();
    static PreparedStatement ps;

    /**
     * Return the columns name for the table
     */
    public static List<String> getTableHeaders() {
        List<String> tableHeader = new ArrayList<String>();
        tableHeader.add("CÓDIGO");
        tableHeader.add("DESCRIPCIÓN");
        tableHeader.add("U/M");
        tableHeader.add("VOLUMEN X UNIDAD");
        tableHeader.add("CANTIDAD");
        tableHeader.add("PROGRAMA");
        tableHeader.add("TOTAL M3");
        tableHeader.add("PRECIO CUP");
        tableHeader.add("IMPORTE CUP");
        tableHeader.add("FECHA");
        tableHeader.add("RBK");
        return tableHeader;
    }

    /**
     * Return values for the table
     *
     * @param numberOfRows Number of rows we want to receive
     *
     * @return Values
     */
    public static List<List<String>> getTableContent(int numberOfRows) {
        try {
            if (numberOfRows <= 0) {
                throw new IllegalArgumentException("The number of rows must be a positive integer");
            }

            List<List<String>> tableContent = new ArrayList<List<String>>();

            String SQL = "SELECT * FROM modelo_mercantil";
            Statement st = cn.conect.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            int i = 0;
            List<String> row = null;
            while (rs.next()) {
                tableContent.add(row = new ArrayList<String>());

                row.add(rs.getString("codigo_modelo"));
                row.add(rs.getString("descripcion_modelo"));
                row.add(rs.getString("u/m_modelo"));
                row.add(rs.getString("vol/unidad_modelo"));
                row.add(rs.getString("cantidad_modelo"));
                row.add(rs.getString("programa_modelo"));
                row.add(rs.getString("total_m3_modelo"));
                row.add(rs.getString("precio_cup_modelo"));
                row.add(rs.getString("importe_cup_modelo"));
                row.add(rs.getString("fecha_modelo"));
                row.add(rs.getString("rbk_modelo"));
                i++;
            }
            return tableContent;
        } catch (SQLException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }

        return null;
    }

}
