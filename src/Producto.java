import java.util.Scanner;

public class Producto {
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

    }

    public static void Textil(){
        String NomProducte,Composisico,CodiBarras;
        int Preu;
        System.out.println("Afegir tèxtil");
        System.out.print("Nom producte: ");
        NomProducte = scan.nextLine();
        System.out.print("Preu: ");
        Preu = scan.nextInt();
        System.out.println("Composició: ");
        Composisico = scan.next();
        System.out.print("Codi de barres: ");
        CodiBarras = scan.next();
        scan.nextLine();
    }
    public static void Electronica(){
        String NomProducte,Garantia,CodiBarras;
        int Preu;
        System.out.println("Afegir electrònica");
        System.out.print("Nom producte: ");
        NomProducte = scan.nextLine();
        System.out.print("Preu: ");
        Preu = scan.nextInt();
        System.out.print("Garantia (dies): ");
        Garantia = scan.next();
        System.out.print("Codi de barres: ");
        CodiBarras = scan.next();
        scan.nextLine();
    }
}
