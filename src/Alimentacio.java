import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Subclase Alimentacion de Productos
 */
class Alimentacio extends Producto {
    protected String DataCaducitat;

    public Alimentacio(String nomProducte, float preu, String codiBarras, String dataCaducitat) {
        super(nomProducte, preu, codiBarras);
        this.DataCaducitat = dataCaducitat;
    }

    /**
     * Funcion para obtener el precio en funcion de la fecha de caducidad
     * @return retorna el precio calculado en funcion de la formula
     */
    @Override
    public float getPreu() {
        float preu = super.Preu;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(DataCaducitat, formato);
        LocalDate DataActual = LocalDate.now();// Fecha actual de la maquina
        long numberOFDays = DAYS.between(fecha, DataActual); // Obtener la diferencia de dias entre la fecha de caducidad y la fecha actual
        return  (preu - (float) (preu*( 1 /(numberOFDays+1)) + (preu * 0.1)));
    }

    /**
     * Funcion de la calse Comparable
     * @param o Objecto con el que queremos comparar.
     * @return retorna el codigo de barras
     */
    @Override
    public int compareTo(Producto o) {
        return this.CodiBarras.compareTo(o.CodiBarras);
    }

    /**
     * Funcion tostring
     * @return retorna el nombre del producto
     */
    @Override
    public String toString() {
        return NomProducte ;
    }


}
