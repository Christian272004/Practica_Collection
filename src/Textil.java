
/**
 * Subclase Textil de producto
 */
public class Textil extends Producto {
    protected String Composicio;

    public Textil(String nomProducte, float preu, String codiBarras, String composicio) {
        super(nomProducte, preu, codiBarras);
        Composicio = composicio;
    }

    /**
     * Funcion de la calse Comparable
     * @param o Objecto con el que queremos comparar.
     * @return retorna el codigo de barras
     */
    @Override
    public int compareTo(Producto o) {
        if (o instanceof Textil p) {
            return this.Composicio.compareTo(p.Composicio);
        } else {
            return this.CodiBarras.compareTo(o.CodiBarras);
        }
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
