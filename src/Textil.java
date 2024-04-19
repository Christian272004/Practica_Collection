public class Textil extends Producto {
    protected String Composicio;

    public Textil(String nomProducte, float preu, String codiBarras, String composicio) {
        super(nomProducte, preu, codiBarras);
        Composicio = composicio;
    }

    public String getComposicio() {
        return Composicio;
    }

    public void setComposicio(String composicio) {
        Composicio = composicio;
    }

    @Override
    public String toString() {
        return NomProducte ;
    }
}
