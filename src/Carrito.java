import javax.swing.*;
import java.time.LocalDate;

class Carrito {
    public static void MostrarCarritoCompra(){
        System.out.println("Carret");
        System.out.println("-----------------");
        for (Producto n : Producto.productos){
            if (n != null){
                System.out.println(n + "-->" );
            }
        }
        System.out.println("-----------------");
        System.out.println();
    }

    public static void PasarPorCaja(){
        System.out.println("-----------------------------");
        System.out.println("SAPAMERCAT");
        System.out.println("-----------------------------");
        System.out.println("Data: " + LocalDate.now());
        System.out.println("-----------------------------");
        for (Producto m : Producto.productos){
            if (m != null){
                System.out.println(m);
            }
        }

        System.out.println("-----------------------------");
        System.out.println("Total: " );
    }
}
