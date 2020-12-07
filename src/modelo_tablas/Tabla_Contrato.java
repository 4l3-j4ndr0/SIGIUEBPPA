/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_tablas;

import interaccion_bd.opciones_de_gestionar_contrato;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import org.joda.time.DateTime;
import paneles_de_paneles.de_gestionar_contrato_editar;

/**
 *
 * @author RojeruSan
 */
public class Tabla_Contrato extends DefaultTableCellRenderer {

    private Component componenete;
    private Color colorBackgound1 = new Color(255, 255, 255);
    private Color colorForeground1 = new Color(0, 0, 0);

    private Color colorBackgound2 = new Color(240, 240, 240);
    private Color colorForeground2 = new Color(0, 0, 0);

    private Color colorSelBackgound = new Color(69, 87, 252);
    private Color colorSelForeground = new Color(255, 255, 255);

    private int grosorBorde = 1;
    private Color colorBorde = new Color(0, 0, 0);

    public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
        componenete = super.getTableCellRendererComponent(table, value, selected, focused, row, column);

        this.setHorizontalAlignment(SwingConstants.CENTER);

        if (row % 2 == 0 ) {
            componenete.setForeground(colorForeground1);
            componenete.setBackground(colorBackgound1);
        } else {
            componenete.setForeground(colorForeground2);
            componenete.setBackground(colorBackgound2);
        }

        int id = Integer.valueOf(table.getValueAt(row, 0).toString());


        
        String fecha_inicio = interaccion_bd.opciones_de_gestionar_contrato.getFechaInicio(id);
        int dia_inicio,mes_inicio,ano_inicio=0;
         String dia_text_inicio=fecha_inicio.substring(0,2);
        String mes_text_inicio=fecha_inicio.substring(3,5);
        String ano_text_inicio=fecha_inicio.substring(6);
        dia_inicio=Integer.parseInt(dia_text_inicio);
        mes_inicio=Integer.parseInt(mes_text_inicio);
        ano_inicio=Integer.parseInt(ano_text_inicio);
        
        String fecha_limite = interaccion_bd.opciones_de_gestionar_contrato.getFechaLimite(id);
         int dia_final,mes_final,ano_final=0;
         String dia_text=fecha_limite.substring(0,2); 
        mes_final=Integer.parseInt(mes_text_inicio);
        ano_final=Integer.parseInt(ano_text_inicio);
        
        String fecha_actual=opciones_de_gestionar_contrato.fechaactual();
        int dia_actual,mes_actual,ano_actual=0;
        String dia_actual_txt=fecha_actual.substring(0, 2);
        String mes_actual_txt=fecha_actual.substring(3,5);
        String ano_actual_txt=fecha_actual.substring(6);
        dia_actual=Integer.parseInt(dia_actual_txt);
        mes_actual=Integer.parseInt(mes_actual_txt);
        ano_actual=Integer.parseInt(ano_actual_txt);
        
        int ano=ano_final-ano_inicio;
        
       Date limite= de_gestionar_contrato_editar.ParseFecha(fecha_limite);
        Date actual= de_gestionar_contrato_editar.ParseFecha(fecha_actual);
        
        
        final SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
       
        try {
            date = df.parse(fecha_limite); // conversion from String
        } catch (ParseException ex) {
            Logger.getLogger(Tabla_Contrato.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final java.util.Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(date);
        cal.add(GregorianCalendar.MONTH, -2); // date manipulation 
        
        if (actual.after(limite)) {
            componenete.setBackground(Color.RED);
            componenete.setForeground(Color.WHITE);
        }
        
        if (actual.after(cal.getTime())&&actual.before(limite)) {
            componenete.setBackground(Color.YELLOW);
            componenete.setForeground(Color.BLACK);
        }
        return componenete;
    }
}
