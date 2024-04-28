import java.util.*;

/**
 *
 */
abstract class Producto implements Comparable<Producto> {
    static Scanner scan = new Scanner(System.in);
    protected String NomProducte;
    protected float Preu;
    protected String CodiBarras;
    public static List<Producto> Productos = new ArrayList<>();

    /**
     * Construcutor de la clase Producto
     * @param nomProducte Nombre del producto introducido
     * @param preu Precio del producto introducido
     * @param codiBarras Codigo de barras del producto introducido
     */
    public Producto(String nomProducte, float preu, String codiBarras) {
        this.NomProducte = nomProducte;
        this.Preu = preu;
        this.CodiBarras = codiBarras;
    }

    public String getNomProducte() {
        return NomProducte;
    }

    public float getPreu() {
        return Preu;
    }
    public String getCodiBarras() {
        return CodiBarras;
    }

    public void setPreu(float preu) {
        this.Preu = preu;
    }

    /**
     * Funcion para introducir un producto de la subclase de Alimentacion
     */
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

    /**
     * Funcion para introducir un producto de la subclase de Textil
     */
    public static void Textil(){
        String NomProducte,Composisico,CodiBarras;
        float Preu;
        System.out.println("Afegir tèxtil");
        NomProducte = ComprobarNombre();
        Preu = ComprobarPrecio();
        System.out.print("Composició: ");
        Composisico = scan.next();
        System.out.print("Codi de barres: ");
        CodiBarras = scan.next();
        scan.nextLine();

        Productos.add(new Textil(NomProducte,Preu,"T"+CodiBarras,Composisico));

    }

    /**
     * Funcion para introducir un producto de la subclase de Electronica
     */
    public static void Electronica(){
        String NomProducte,CodiBarras;
        float Preu;
        int Garantia;
        System.out.println("Afegir electrònica");
        NomProducte = ComprobarNombre();
        Preu = ComprobarPrecio();
        Garantia = ComprobarGarantia();
        System.out.print("Codi de barres: ");
        CodiBarras = scan.next();
        scan.nextLine();
        Productos.add(new Electronica(NomProducte,Preu,"E"+CodiBarras,Garantia));
    }

    /**
     * Funcion para obtener el nombre del producto medianete el codigo de barras.
     * @param codigoBarras Codigo de barras del producto
     * @return Retorna el nombre del prodcuto asociado al codigo de barras que le pasamos
     */
    public static String obtenerNombreProducto(String codigoBarras) {
        return Productos.stream()
                .filter(producto -> producto.getCodiBarras().equals(codigoBarras))
                .findFirst()
                .map(Producto::getNomProducte)
                .orElse("Producto no encontrado");
    }

    /**
     * Funcion para comprobar que el nombre del producto no supoere los 15 caracteres
     * @return Retorna el nombre del producto
     */
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

    /**
     * Funcion para validar la fecha de Alimentacion
     * @param fecha Fecha que queremos validad
     * @return Retorna false si la fecha no es validad y true si la fecha es valida
     */
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

    /**
     * Funcion para Comprobar el precio de los productos
     * @return Retorna el precio del producto
     */
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
    private static int ComprobarGarantia(){
        int garantia;
        do {
            try {
                System.out.print("Garantia (dies): ");
                garantia = scan.nextInt();
            } catch (InputMismatchException e){
                System.out.println("¡Por favor introduce una Garantia correcta!");
                garantia = -1;
                scan.nextLine();
            }
        } while (garantia == -1);
        return garantia;
    }
}
