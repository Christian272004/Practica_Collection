import java.util.Scanner;

class Producto {
    protected String NomProducte;
    protected int Preu;
    protected String CodiBarras;
    protected static Producto[] productos = new Producto[100];
    static int Contador = 0;

    public Producto(String nomProducte, int preu, String codiBarras) {
        NomProducte = nomProducte;
        Preu = preu;
        CodiBarras = codiBarras;
    }


    static Scanner scan = new Scanner(System.in);
    public static void Alimentacio(){
        String NomProducte,CodiBarras,DataCaducitat;
        int Preu;
        System.out.println("Afegir aliment");
        System.out.print("Nom producte: ");
        NomProducte = scan.nextLine();
        System.out.print("Preu: ");
        Preu = scan.nextInt();
        System.out.print("Codi de barres: ");
        CodiBarras = scan.next();
        System.out.print("Data de caducitat (dd/mm/aaaa): ");
        DataCaducitat = scan.next();
        scan.nextLine();


        if (Contador != 0){
            try {
                productos[Contador] = new Alimentacio(NomProducte,Preu,CodiBarras,DataCaducitat);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Contador++;
        } else {
            try {
                productos[0] = new Alimentacio(NomProducte,Preu,CodiBarras,DataCaducitat);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Contador++;
        }
    }

    public static void Textil(){
        String NomProducte,Composisico,CodiBarras;
        int Preu;
        System.out.println("Afegir tèxtil");
        System.out.print("Nom producte: ");
        NomProducte = scan.nextLine();
        System.out.print("Preu: ");
        Preu = scan.nextInt();
        System.out.print("Composició: ");
        Composisico = scan.next();
        System.out.print("Codi de barres: ");
        CodiBarras = scan.next();
        scan.nextLine();

        if (Contador != 0){
            try {
                productos[Contador] = new Textil(NomProducte,Preu,CodiBarras,Composisico);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Contador++;
        } else {
            try {
                productos[0] = new Textil(NomProducte,Preu,CodiBarras,Composisico);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Contador++;
        }
    }
    public static void Electronica(){
        String NomProducte,CodiBarras;
        int Preu,Garantia;
        System.out.println("Afegir electrònica");
        System.out.print("Nom producte: ");
        NomProducte = scan.nextLine();
        System.out.print("Preu: ");
        Preu = scan.nextInt();
        System.out.print("Garantia (dies): ");
        Garantia = scan.nextInt();
        System.out.print("Codi de barres: ");
        CodiBarras = scan.next();
        scan.nextLine();

        if (Contador != 0){
            try {
                productos[Contador] = new Electronica(NomProducte,Preu,CodiBarras,Garantia);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Contador++;
        } else {
            try {
                productos[0] = new Electronica(NomProducte,Preu,CodiBarras,Garantia);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            Contador++;
        }
    }


}
