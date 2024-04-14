public class Textil extends Producto {
    protected String Composicio;

    public Textil(String nomProducte, int preu, String codiBarras, String composicio) {
        super(nomProducte, preu, codiBarras);
        Composicio = composicio;
    }
}
