import org.w3c.dom.Text;

public class Textil extends Producto {
    protected String Composicio;

    public Textil(String nomProducte, float preu, String codiBarras, String composicio) {
        super(nomProducte, preu, codiBarras);
        Composicio = composicio;
    }

    @Override
    public int compareTo(Producto o) {
        if (o instanceof Textil p) {
            return this.Composicio.compareTo(p.Composicio);
        } else {
            return this.CodiBarras.compareTo(o.CodiBarras);
        }
    }

    @Override
    public String toString() {
        return NomProducte ;
    }
}
