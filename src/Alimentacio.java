import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

class Alimentacio extends Producto {
    protected String DataCaducitat;

    public Alimentacio(String nomProducte, float preu, String codiBarras, String dataCaducitat) {
        super(nomProducte, preu, codiBarras);
        this.DataCaducitat = dataCaducitat;
    }
    @Override
    public float getPreu() {
        float preu = super.Preu;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(DataCaducitat, formato);
        LocalDate DataActual = LocalDate.now();// Fecha actual de la maquina
        long numberOFDays = DAYS.between(fecha, DataActual); // Obtener la diferencia de dias entre la fecha de caducidad y la fecha actual
        return  (preu - (float) (preu*( 1 /(numberOFDays+1)) + (preu * 0.1)));
    }

    @Override
    public int compareTo(Producto o) {
        return this.CodiBarras.compareTo(o.CodiBarras);
    }

    @Override
    public String toString() {
        return NomProducte ;
    }


}
