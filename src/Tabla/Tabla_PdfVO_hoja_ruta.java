package Tabla;

import DAO.PdfDAO;
import DAO.PdfDAO_hoja_ruta;
import DAO.PdfDAO_prep_tecnica;
import DAO.PdfDAO_proy;
import VO.PdfVO;
import VO.PdfVO_hoja_ruta;
import VO.PdfVO_prep_tecnica;
import VO.PdfVO_proy;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import paneles_de_paneles.de_gestionar_plano_listar;

public class Tabla_PdfVO_hoja_ruta {

    PdfDAO_hoja_ruta dao = null;

    public void visualizar_PdfVO(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("ID");
        dt.addColumn("CHAPA");
        dt.addColumn("TOTAL KM");
        dt.addColumn("CONSUMO");
        dt.addColumn("PDF");

        ImageIcon icono = null;
        if (get_Image("/img_planos/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/img_planos/32pdf.png"));
        }

        dao = new PdfDAO_hoja_ruta();
        PdfVO_hoja_ruta vo = new PdfVO_hoja_ruta();
        ArrayList<PdfVO_hoja_ruta> list = dao.Listar_PdfVO();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[5];
                vo = list.get(i);
                fila[0] = vo.getCodigopdf();
                fila[1] = vo.getChapa();
                fila[2] = vo.getTotal_km();
                fila[3] = vo.getConsumo();
                if (vo.getArchivopdf() != null) {
                    fila[4] = new JButton(icono);
                } else {
                    fila[4] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
          //  tabla.setModel(de_gestionar_plano_listar.tabla_plano.getModel());
            tabla.setRowHeight(32);
        }
    }
   
    
    public void visualizar_PdfVO_despues_de_actualizar(JTable tabla) {
        tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("ID");
        dt.addColumn("CHAPA");
        dt.addColumn("TOTAL KM");
        dt.addColumn("CONSUMO");
        dt.addColumn("PDF");

        ImageIcon icono = null;
        if (get_Image("/img_planos/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/img_planos/32pdf.png"));
        }

        dao = new PdfDAO_hoja_ruta();
        PdfVO_hoja_ruta vo = new PdfVO_hoja_ruta();
        ArrayList<PdfVO_hoja_ruta> list = dao.Listar_PdfVO();

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[5];
                vo = list.get(i);
                fila[0] = vo.getCodigopdf();
                fila[1] = vo.getChapa();
                fila[2] = vo.getTotal_km();
                fila[3] = vo.getConsumo();
                if (vo.getArchivopdf() != null) {
                    fila[4] = new JButton(icono);
                } else {
                    fila[4] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(32);
        }
    }

    public void visualizar_PdfVO_buscar(JTable tabla, String busca) {
      //  tabla.setDefaultRenderer(Object.class, new imgTabla());
        DefaultTableModel dt = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dt.addColumn("ID");
        dt.addColumn("CHAPA");
        dt.addColumn("TOTAL KM");
        dt.addColumn("CONSUMO");
        dt.addColumn("PDF");

        ImageIcon icono = null;
        if (get_Image("/img_planos/32pdf.png") != null) {
            icono = new ImageIcon(get_Image("/img_planos/32pdf.png"));
        }

        dao = new PdfDAO_hoja_ruta();
        PdfVO_hoja_ruta vo = new PdfVO_hoja_ruta();
        ArrayList<PdfVO_hoja_ruta> list = dao.buscar_PdfVO(busca);

        if (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                Object fila[] = new Object[5];
                vo = list.get(i);
                fila[0] = vo.getCodigopdf();
                fila[1] = vo.getChapa();
                fila[2] = vo.getTotal_km();
                fila[3] = vo.getConsumo();
                if (vo.getArchivopdf() != null) {
                    fila[4] = new JButton(icono);
                } else {
                    fila[4] = new JButton("Vacio");
                }

                dt.addRow(fila);
            }
            tabla.setModel(dt);
            tabla.setRowHeight(32);
        }
    }
    
    public Image get_Image(String ruta) {
        try {
            ImageIcon imageIcon = new ImageIcon(getClass().getResource(ruta));
            Image mainIcon = imageIcon.getImage();
            return mainIcon;
        } catch (Exception e) {
        }
        return null;
    }
}
