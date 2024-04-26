import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


abstract class Producto implements Comparable<Producto> {
    protected String NomProducte;
    protected float Preu;
    protected String CodiBarras;
    protected static ArrayList<Producto> Productos = new ArrayList<Producto>();

    public Producto(String nomProducte, float preu, String codiBarras) {
        this.NomProducte = nomProducte;
        this.Preu = preu;
        this.CodiBarras = codiBarras;
    }



    public String getNomProducte() {
        return NomProducte;
    }

    public void setNomProducte(String nomProducte) {
        NomProducte = nomProducte;
    }

    public float getPreu() {
        return Preu;
    }

    public void setPreu(float preu) {
        this.Preu = preu;
    }

    public String getCodiBarras() {
        return CodiBarras;
    }

    public void setCodiBarras(String codiBarras) {
        CodiBarras = codiBarras;
    }


    static Scanner scan = new Scanner(System.in);
    public static void Alimentacio(){
        String NomProducte,CodiBarras,DataCaducitat;
        float Preu;
        System.out.println("Afegir aliment");
        System.out.print("Nom producte: ");
        do {
            NomProducte = scan.nextLine();
            if (NomProducte.length() > 15) {
                System.out.println("El nom del producte no pot superar el 15 caracter");
            }
        } while (NomProducte.length() > 15);
        System.out.print("Preu: ");
        Preu = scan.nextFloat();
        System.out.print("Codi de barres: ");
        CodiBarras = scan.next();
        System.out.print("Data de caducitat (dd/mm/aaaa): ");
        DataCaducitat = scan.next();
        scan.nextLine();
        Productos.add(new Alimentacio(NomProducte,Preu,"A"+CodiBarras,DataCaducitat));

    }

    public static void Textil(){
        String NomProducte,Composisico,CodiBarras;
        float Preu;
        System.out.println("Afegir tèxtil");
        System.out.print("Nom producte: ");
        do {
            NomProducte = scan.nextLine();
            if (NomProducte.length() > 15) {
                System.out.println("El nom del producte no pot superar el 15 caracter");
            }
        } while (NomProducte.length() > 15);
        System.out.print("Preu: ");
        Preu = scan.nextFloat();
        System.out.print("Composició: ");
        Composisico = scan.next();
        System.out.print("Codi de barres: ");
        CodiBarras = scan.next();
        scan.nextLine();

        Productos.add(new Textil(NomProducte,Preu,"T"+CodiBarras,Composisico));
    }
    public static void Electronica(){
        String NomProducte,CodiBarras;
        float Preu;
        int Garantia;
        System.out.println("Afegir electrònica");
        System.out.print("Nom producte: ");
        do {
            NomProducte = scan.nextLine();
            if (NomProducte.length() > 15) {
                System.out.println("El nom del producte no pot superar el 15 caracter");
            }
        } while (NomProducte.length() > 15);
        System.out.print("Preu: ");
        Preu = scan.nextFloat();
        System.out.print("Garantia (dies): ");
        Garantia = scan.nextInt();
        System.out.print("Codi de barres: ");
        CodiBarras = scan.next();
        scan.nextLine();

        Productos.add(new Electronica(NomProducte,Preu,"E"+CodiBarras,Garantia));
    }
    public static String obtenerNombreProducto(String codigoBarras) {
        return Carrito.Cosas.stream()
                .filter(producto -> producto.getCodiBarras().equals(codigoBarras))
                .findFirst()
                .map(Producto::getNomProducte)
                .orElse("Producto no encontrado");
    }
}
