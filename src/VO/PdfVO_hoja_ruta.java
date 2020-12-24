package VO;

public class PdfVO_hoja_ruta {

    /*Todo los atributos*/
    int codigopdf;
    String chapa;
    String total_km;
    String consumo;
    byte[] archivopdf;

    public PdfVO_hoja_ruta() {
    }

    /*Todo los codigos get*/
    public int getCodigopdf() {
        return codigopdf;
    }

    public byte[] getArchivopdf() {
        return archivopdf;
    }
    
    /*Todo los codigos set*/
    public void setCodigopdf(int codigopdf) {
        this.codigopdf = codigopdf;
    }

    public void setArchivopdf(byte[] archivopdf) {
        this.archivopdf = archivopdf;
    }

    public String getTotal_km() {
        return total_km;
    }

    public void setTotal_km(String total_km) {
        this.total_km = total_km;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public String getChapa() {
        return chapa;
    }

    public void setChapa(String chapa) {
        this.chapa = chapa;
    }

}
