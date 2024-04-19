public class Electronica extends Producto{
    protected int Garantia;

    public Electronica(String nomProducte, float preu, String codiBarras, int garantia) {
        super(nomProducte, preu, codiBarras);
        Garantia = garantia;
    }

    public int getGarantia() {
        return Garantia;
    }

    public void setGarantia(int garantia) {
        Garantia = garantia;
    }

    @Override
    public float getPreu() {
       float preu = super.getPreu();
        return  (float) (preu + preu*(Garantia/365)*0.1);
    }

    @Override
    public String toString() {
        return  NomProducte;
    }
}
