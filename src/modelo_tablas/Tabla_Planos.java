/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_tablas;

import interaccion_bd.opciones_de_gestionar_contrato;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author RojeruSan
 */
public class Tabla_Planos extends DefaultTableCellRenderer {

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

        
        
        if (value instanceof JLabel) {
            JLabel lbl = (JLabel) value;
            return lbl;
        }

        if (value instanceof JButton) {
            JButton button = (JButton) value;
            if (selected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(UIManager.getColor("Button.background"));
            }
            return button;
        }
        
        return componenete;
    }
}
