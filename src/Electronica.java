public class Electronica extends Producto{
    protected int Garantia;

    public Electronica(String nomProducte, float preu, String codiBarras, int garantia) {
        super(nomProducte, preu, codiBarras);
        Garantia = garantia;
    }

    /**
     * Funcion para obtener el precio en funcion de la garantia del producto
     * @return retorna el precio del producto una vez calculado
     */
    @Override
    public float getPreu() {
       float preu = super.getPreu();
        return  (float) (preu + preu*(Garantia/365)*0.1);
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
        return  NomProducte;
    }
}
