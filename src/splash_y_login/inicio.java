/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splash_y_login;

import alertas.ErrorAlert;
import conexion.conexion;
import conexion.pide_server;
import interaccion_bd.opciones_de_gestionar_contrato;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author 4l3
 */
public class inicio {

    private void escribe() throws IOException, SQLException {
         pide_server m = new pide_server(new JFrame(), true);
        if (existe_fichero()) {
            if (dbExists()) {
                new Splash().setVisible(true);
            }else{
                m.setVisible(true);
                escribe();
            }
        } else {
           
            m.setVisible(true);
            //creo un archivo en el directorio raiz de mi proyecto
            File archivo = new File("conexion BD_system.txt");
            //  a.createNewFile();
            BufferedWriter bw;
            bw =new BufferedWriter(new FileWriter(archivo.getAbsolutePath()));
           bw.write(pide_server.dir_server.getText());
            bw.close();
            if (dbExists()) {
                new Splash().setVisible(true);
            }else{
                escribe();
            }
        }
    }
    
    private boolean existe_fichero(){
        boolean existe=false;
        File archivo = new File("conexion BD_system.txt");
        if(archivo.exists()){
            existe=true;
        }
        return existe;
    }
    
    public boolean dbExists() throws IOException, SQLException {
        boolean exist = false;
        try {
            Connection conn = null;
            Statement st = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://"+server()+"/tesis", "tesis", "tesis"); 
            st = conn.createStatement();
            String sql = "SELECT SCHEMA_NAME FROM INFORMATION_SCHEMA.SCHEMATA WHERE SCHEMA_NAME = 'tesis'";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                //JOptionPane.showMessageDialog(main, "La base de datos existe.");
                exist = true;
            }
        } catch (ClassNotFoundException ex) {
            opciones_de_gestionar_contrato.lanza_error(ex);
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(main, "La base de datos no existe.");
            exist = false;
            ErrorAlert error = new ErrorAlert(new JFrame(), true);
            error.msj1.setText("No pudimos conectar con el servidor de bases de datos.");
            error.msj2.setText("Por favor vuelva proporcionarnoslo");
            error.msj3.setText("");
            error.preferredSize();
            error.pack();
            error.setVisible(true);
        }
        return exist;
    }
    
    private String server() throws FileNotFoundException, IOException {
        String servidor = "";
        File archivo = new File("conexion BD_system.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
         servidor = br.readLine();
//         fr.close();
         
        return servidor;
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccesoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccesoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccesoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccesoLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new inicio().escribe();
                } catch (IOException ex) {
                    Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
