import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase menu donde se encuentran los dos menus principales, el menu principal y el menu para esocger que producto introducir
 */
public class Menu {
    static Scanner scan = new Scanner(System.in);

    /**
     * Funcion de menu principal
     */
     public static void MenuPrincipal()  {
         int opcion;

         do {
             System.out.println("BENVINGUT AL SAPAMERCAT");
             LocalDate DataActual = LocalDate.now();
             System.out.println(DataActual);
             System.out.println("------------");
             System.out.println("-- INICI ---");
             System.out.println("------------");
             System.out.println("1) Introduir producte ");
             System.out.println("2) Passar per caixa ");
             System.out.println("3) Mostrar carret de compra ");
             System.out.println("0) Acabar");
             opcion = ComprobarLaOpcion();

             switch (opcion) {
                 case 1:
                     MenuProucte();
                     break;
                 case 2:
                     Carrito.PasarPorCaja();
                     Carrito.conteo.clear();
                     break;
                 case 3:
                     Carrito.MostrarCarritoCompra();
                     break;
                 case 0:
                     System.exit(1);
                 default:
                     System.out.println("ATENCIÓ!!! \nHa de ser un valor entre 0 i 3");
             }
         } while (opcion != 0);
    }

    /**
     * Funcion de menu para introducir un producto en concreto
     */
    public static void MenuProucte(){
        int opcion;
        do {
            System.out.println("---------------");
            System.out.println("-- PRODUCTE ---");
            System.out.println("---------------");
            System.out.println("1) Alimentació");
            System.out.println("2) Tèxtil");
            System.out.println("3) Electrònica");
            System.out.println("0) Tornar");
            opcion = ComprobarLaOpcion();
            switch (opcion){
                case 1:
                    Producto.Alimentacio();
                    break;
                case 2:
                    Producto.Textil();
                    break;
                case 3:
                    Producto.Electronica();
                    break;
                case 0:
                    MenuPrincipal();
                default:
                    System.out.println("ATENCIÓ!!! \nHa de ser un valor entre 0 i 3");
            }
        } while (opcion != 0);
    }

    /**
     * Funcion para comprobar si la opcion de los menus es correcta
     * @return retorna el valor de la opcion introducida
     */
    private static int ComprobarLaOpcion(){
        int opcion = -1;
        do {
            try {
                System.out.print("->");
                opcion = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e){
                System.out.println("¡Por favor introduce un valor entre 0 y 3!");
                SAPAMERCAT.GuardarExepciones(e.toString());
                opcion = -1;
                scan.nextLine();
            }
        } while (opcion == -1);
        return opcion;
    }
}
