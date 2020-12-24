package conexion;

import interaccion_bd.opciones_de_gestionar_contrato;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import splash_y_login.inicio;
import static splash_y_login.inicio.usuario;

/** 
 *
 * @author 4L3
 */

public class conexion {

   public static Connection conect = null;
    
    public Connection conexion() {
        try {
 // pa conectar teniendo instalado el xammp
           Class.forName("com.mysql.jdbc.Driver");
             conect = DriverManager.getConnection("jdbc:mysql://"+server()+"/tesis", "tesis", "tesis"); 
           
        } catch (Exception e) {
            opciones_de_gestionar_contrato.lanza_error(e);
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
    
    private String server() throws FileNotFoundException, IOException {
        String servidor = "";
        File archivo = new File("C:\\Users\\"+inicio.usuario()+"\\Documents\\SIGIUEBPPA BD_system.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
         servidor = br.readLine();
         fr.close();
         
        return servidor;
    }
    
}
