import java.net.PasswordAuthentication;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    static Scanner scan = new Scanner(System.in);
     public static void MenuPrincipal(){
         int opcion;

         do {
             System.out.println("BENVINGUT AL SAPAMERCAT");
             LocalDate DataActual = LocalDate.now();
             System.out.println(DataActual);
             System.out.println("------------");
             System.out.println("-- INICI ---");
             System.out.println("------------");
             System.out.println("1) Introduir producte ");
             System.out.println("2) Passar per caixa 📦");
             System.out.println("3) Mostrar carret de compra 🛒");
             System.out.println("0) Acabar");
             opcion = scan.nextInt();
             scan.nextLine();
             switch (opcion) {
                 case 1:
                     MenuProucte();
                     break;
                 case 2:
                     Carrito.PasarPorCaja();
                     break;
                 case 3:
                     Carrito.MostrarCarritoCompra();
                     break;
                 case 0:
                     break;
                 default:
                     System.out.println("ATENCIÓ!!! \nHa de ser un valor entre 0 i 3");
             }
         } while (opcion != 0);
    }
    public static void MenuProucte(){
        int opcion = 0;
        do {
            System.out.println("---------------");
            System.out.println("-- PRODUCTE ---");
            System.out.println("---------------");
            System.out.println("1) Alimentació");
            System.out.println("2) Tèxtil");
            System.out.println("3) Electrònica");
            System.out.println("0) Tornar");
            opcion = scan.nextInt();
            scan.nextLine();

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
}
