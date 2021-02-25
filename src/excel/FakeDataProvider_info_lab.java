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
public final class FakeDataProvider_info_lab {

    private static conexion cn = new conexion();
    static PreparedStatement ps;

    /**
     * Return the columns name for the table
     */
    public static List<String> getTableHeaders() {
        List<String> tableHeader = new ArrayList<String>();
        tableHeader.add("No. M");
        tableHeader.add("ELEMENTOS");
        tableHeader.add("F. FUND");
        tableHeader.add("RBK kg/cm^2");
        tableHeader.add("TIPO CTO.");
        tableHeader.add("VOL (m^3)");
        tableHeader.add("CEM. kg");
        tableHeader.add("GRAV. kg");
        tableHeader.add("AREN. kg");
        tableHeader.add("ADIT. lts");
        tableHeader.add("AGUA lts");
        tableHeader.add("ASENT. cm");
        tableHeader.add("X1 3 días");
        tableHeader.add("X2 3 días");
        tableHeader.add("X3 3 días");
        tableHeader.add("XM");
        tableHeader.add("X1 28 días");
        tableHeader.add("X2 28 días");
        tableHeader.add("X3 28 días");
        tableHeader.add("XM");
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

            String SQL = "SELECT * FROM info_lab";
            Statement st = cn.conect.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            int i = 0;
            List<String> row = null;
            while (rs.next()) {
                tableContent.add(row = new ArrayList<String>());

                row.add(rs.getString("num_materiales_info_lab"));
                row.add(rs.getString("elementos_info_lab"));
                row.add(rs.getString("fecha_info_lab"));
                row.add(rs.getString("rbk_info_lab"));
                row.add(rs.getString("tipoCto_info_lab"));
                row.add(rs.getString("vol_info_lab"));
                row.add(rs.getString("cem_info_lab"));
                row.add(rs.getString("grav_info_lab"));
                row.add(rs.getString("aren_info_lab"));
                row.add(rs.getString("adit_info_lab"));
                row.add(rs.getString("agua_info_lab"));
                row.add(rs.getString("asent_info_lab"));
                row.add(rs.getString("x1_info_lab"));
                row.add(rs.getString("x2_info_lab"));
                row.add(rs.getString("x3_info_lab"));
                row.add(rs.getString("xm_info_lab"));
                row.add(rs.getString("x1_28dias_info_lab"));
                row.add(rs.getString("x2_28dias_info_lab"));
                row.add(rs.getString("x3_28dias_info_lab"));
                row.add(rs.getString("xm_28dias_info_lab"));
                i++;
            }
            return tableContent;
        } catch (SQLException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }

        return null;
    }

}
