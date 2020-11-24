package conexion;

import interaccion_bd.opciones_de_gestionar_contrato;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/** 
 *
 * @author 4L3
 */

public class conexion {

   public static Connection conect = null;
    

    public Connection conexion() {
        try {
            // pa conectar sin tener instalado el xammp
//            Class.forName("org.h2.Driver");
//             conect = DriverManager.getConnection("jdbc:h2:./BD/uruguay","uruguay","uruguay");
 // pa conectar teniendo instalado el xammp
           Class.forName("com.mysql.jdbc.Driver");
             conect = DriverManager.getConnection("jdbc:mysql://localhost/tesis", "tesis", "tesis"); 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la conexión" + e);
        }
        return conect;
    }
    
    public void desconectar() {
        try {
            conexion().close();
        } catch (Exception ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        }
    }
    
}
