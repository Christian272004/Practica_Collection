import java.util.*;


abstract class Producto implements Comparable<Producto> {
    protected String NomProducte;
    protected float Preu;
    protected String CodiBarras;
    public static List<Producto> Productos = new ArrayList<>();

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
        NomProducte = ComprobarNombre();
        Preu = ComprobarPrecio();
        System.out.print("Codi de barres: ");
        CodiBarras = scan.next();
        do {
            System.out.print("Data de caducitat (dd/mm/aaaa): ");
            DataCaducitat = scan.next();
            scan.nextLine();
            if (ValidadFecha(DataCaducitat)){
                Productos.add(new Alimentacio(NomProducte,Preu,"A"+CodiBarras,DataCaducitat));
            }else System.out.println("Introduce una fecha valida");
        } while (!ValidadFecha(DataCaducitat));

    }

    public static void Textil(){
        String NomProducte,Composisico,CodiBarras;
        float Preu;
        System.out.println("Afegir tèxtil");
        NomProducte = ComprobarNombre();
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
        NomProducte = ComprobarNombre();
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
        return Productos.stream()
                .filter(producto -> producto.getCodiBarras().equals(codigoBarras))
                .findFirst()
                .map(Producto::getNomProducte)
                .orElse("Producto no encontrado");
    }

    private static String ComprobarNombre(){
        String NomProducte;
        do {
            System.out.print("Nom producte: ");
            NomProducte = scan.nextLine();
            if (NomProducte.length() > 15) {
                System.out.println("El nom del producte no pot superar el 15 caracter");
            }
        } while (NomProducte.length() > 15);
        return NomProducte;
    }

    public static boolean ValidadFecha(String fecha) {
        if (!fecha.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/((19|20)\\d\\d)$")){
            return false;
        }

        String[] fechaPartes = fecha.split("/");
        int dia = Integer.parseInt(fechaPartes[0]);
        int mes = Integer.parseInt(fechaPartes[1]);
        int any = Integer.parseInt(fechaPartes[2]);

        if (any % 400 == 0 || (any % 4 == 0 && any % 100!= 0)) {
            return mes == 2? dia <= 29 : (mes == 4 || mes == 6 || mes == 9 || mes == 11)? dia <= 30 : dia <= 31;
        } else {
            return mes == 2? dia <= 28 : (mes == 4 || mes == 6 || mes == 9 || mes == 11)? dia <= 30 : dia <= 31;
        }
    }

    private static float ComprobarPrecio(){
        float Preu;
        do {
            try {
                System.out.print("Preu: ");
                Preu = scan.nextFloat();
            } catch (InputMismatchException e){
                System.out.println("¡Por favor introduce un precio correcto!");
                Preu = -1;
                scan.nextLine();
            }
        } while (Preu == -1);
        return Preu;
    }
}
