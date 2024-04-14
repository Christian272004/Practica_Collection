class Alimentacio extends Producto {
    protected String DataCaducitat;

    public Alimentacio(String nomProducte, int preu, String codiBarras, String dataCaducitat) {
        super(nomProducte, preu, codiBarras);
        DataCaducitat = dataCaducitat;
    }
}
