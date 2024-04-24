import javax.swing.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Carrito {
    static List<Producto> Cosas = new ArrayList<>(Producto.Productos);
    static Map<String, Integer> conteo = Cosas.stream().collect(Collectors.groupingBy((str) -> str.toString(), Collectors.summingInt(e -> 1)));
    static Map<String, Integer> conteo2 = Cosas.stream().collect(Collectors.groupingBy((str) -> str.toString(), Collectors.summingInt(e -> 1)));

    public static void MostrarCarritoCompra(){
        System.out.println("Carret");
        System.out.println("-----------------");

        for (String s : conteo.keySet()) {
            System.out.println(s+" -> "+conteo.get(s));
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
        conteo.forEach((key,item) -> System.out.print(key + "\t" + conteo.get(key) + "\t"   ));
        conteo2.forEach((item) -> System.out.println(item.getPreu()));
        /*
        for (String s : conteo.keySet()) {
            System.out.print(s + "\t" + conteo.get(s) + "\t" );
            for (Producto a: Alimentacion) {
                System.out.print(a.getPreu() + " " + a.getPreu()*conteo.get(s)+ "\n" );
            }
        }


         */
        System.out.println("-----------------------------");
        System.out.println("Total: " );
        Producto.Productos.clear();
    }
}
