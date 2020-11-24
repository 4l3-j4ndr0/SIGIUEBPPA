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
public final class FakeDataProvider {

    private static conexion cn = new conexion();
    static PreparedStatement ps;

    /**
     * Return the columns name for the table
     */
    public static List<String> getTableHeaders() {
        List<String> tableHeader = new ArrayList<String>();
        tableHeader.add("No. CONTRATO");
        tableHeader.add("NOMBRE CLIENTE");
        tableHeader.add("FECHA INICIO");
        tableHeader.add("FECHA FINAL");
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

            String SQL = "SELECT * FROM contrato";
            Statement st = cn.conect.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            int i = 0;
            List<String> row = null;
            while (rs.next()) {
                tableContent.add(row = new ArrayList<String>());

                row.add(rs.getString("numero_contrato"));
                row.add(rs.getString("nombre_contrato"));
                row.add(rs.getString("fecha_inicio_contrato"));
                row.add(rs.getString("fecha_final_contrato"));
                i++;
            }
            return tableContent;
        } catch (SQLException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }

        return null;
    }

}
