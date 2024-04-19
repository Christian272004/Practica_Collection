import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

public class Carrito {
    public static void MostrarCarritoCompra(){
        System.out.println("Carret");
        System.out.println("-----------------");
        /*
        for (Producto n : Producto.productos){
            if (n != null){
                System.out.println(n + "-->" );
            }
        }

         */
        System.out.println("-----------------");
        System.out.println();
    }



    public static void PasarPorCaja(){
        Set<Producto> elec_uniq = new HashSet<Producto>(Producto.ProdAlimentacio);

        System.out.println("-----------------------------");
        System.out.println("SAPAMERCAT");
        System.out.println("-----------------------------");
        System.out.println("Data: " + LocalDate.now());
        System.out.println("-----------------------------");
        /*
        for (Alimentacio m : Producto){
            if (m != null){
                System.out.printf("%s\t%.2f\n",m,m.getPreu());
            }
        }

         */


        for (Producto a: elec_uniq) {
            System.out.println(a.getNomProducte() + "\t" + "\t\t" + " " + a.getPreu() + "\t");
        }
        System.out.println("-----------------------------");
        System.out.println("Total: " );
    }
}
