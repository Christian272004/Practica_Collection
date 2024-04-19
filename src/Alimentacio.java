import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static java.time.temporal.ChronoUnit.DAYS;

class Alimentacio extends Producto {
    protected String DataCaducitat;

    public Alimentacio(String nomProducte, float preu, String codiBarras, String dataCaducitat) {
        super(nomProducte, preu, codiBarras);
        this.DataCaducitat = dataCaducitat;
    }

    @Override
    public float getPreu() {
        float preu = super.getPreu();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(DataCaducitat, formato);// Fecha
        LocalDate DataActual = LocalDate.now();// Fecha actual de la maquina
        long numberOFDays = DAYS.between(fecha, DataActual); // Obtener la diferencia de dias entre la fecha de caducidad y la fecha actual
        return (float) (preu - preu*( 1 /(numberOFDays+1) + (preu * 0.1)));
    }

    public void setDataCaducitat(String dataCaducitat) {
        this.DataCaducitat = dataCaducitat;
    }
    public int countProducts(List<Producto> products, String barcode, double price) {
        int count = 0;
        for (Producto product : products) {
            if (product.getCodiBarras().equals(barcode) && product.getPreu() == price) {
                count++;
            }
        }
        return count;
    }
    @Override
    public String toString() {
        return NomProducte;
    }
}
