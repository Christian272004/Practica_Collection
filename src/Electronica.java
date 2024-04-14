public class Electronica extends Producto{
    protected int Garantia;

    public Electronica(String nomProducte, int preu, String codiBarras, int garantia) {
        super(nomProducte, preu, codiBarras);
        Garantia = garantia;
    }
}
