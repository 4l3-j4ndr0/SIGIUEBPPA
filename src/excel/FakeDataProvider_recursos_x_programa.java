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
public final class FakeDataProvider_recursos_x_programa {

    private static conexion cn = new conexion();
    static PreparedStatement ps;

    /**
     * Return the columns name for the table
     */
    public static List<String> getTableHeaders() {
        List<String> tableHeader = new ArrayList<String>();
        tableHeader.add("CÓDIGO");
        tableHeader.add("DESCRIPCIÓN");
        tableHeader.add("UM");
        tableHeader.add("CANTIDAD");
        tableHeader.add("PROGRAMA");
        tableHeader.add("FACTURA");
        tableHeader.add("CARTA PORTE");
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

            String SQL = "SELECT * FROM recursos_x_programa";
            Statement st = cn.conect.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            int i = 0;
            List<String> row = null;
            while (rs.next()) {
                tableContent.add(row = new ArrayList<String>());

                row.add(rs.getString("codigo_re"));
                row.add(rs.getString("descripcion_re"));
                row.add(rs.getString("um_re"));
                row.add(rs.getString("cant_re"));
                row.add(rs.getString("programa_re"));
                row.add(rs.getString("factura_re"));
                row.add(rs.getString("carta_porte_re"));
                i++;
            }
            return tableContent;
        } catch (SQLException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }

        return null;
    }

}
