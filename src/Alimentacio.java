import java.time.LocalDate;
import java.util.Date;

class Alimentacio extends Producto {
    protected String DataCaducitat;

    public Alimentacio(String nomProducte, int preu, String codiBarras, String dataCaducitat) {
        super(nomProducte, preu, codiBarras);
        this.DataCaducitat = dataCaducitat;
    }


    public String getDataCaducitat() {
        return DataCaducitat;
    }

    public void setDataCaducitat(String dataCaducitat) {
        this.DataCaducitat = dataCaducitat;
    }

    @Override
    public String toString() {
        return NomProducte;
    }
}
