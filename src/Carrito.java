import javax.swing.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Carrito {
    static List<Producto> Cosas = new ArrayList<>(Producto.Productos);
    static Map<String, Integer> conteo = Cosas.stream()
            .collect(Collectors.groupingBy((producto) -> producto.getPreu()  + "_" + producto.getCodiBarras() ,Collectors.summingInt(e -> 1)));


    public static void MostrarCarritoCompra(){
        System.out.println("Carret");
        System.out.println("-----------------");
        conteo.forEach((key, value) -> {
            String nombreProducto = Producto.obtenerNombreProducto(key.substring(key.indexOf("_")+1));
            System.out.printf("%s->%d\n", nombreProducto, value);
        });
        System.out.println("-----------------");
        System.out.println();
    }

    public static void PasarPorCaja(){
        System.out.println("-----------------------------");
        System.out.println("SAPAMERCAT");
        System.out.println("-----------------------------");
        System.out.println("Data: " + LocalDate.now());
        System.out.println("-----------------------------");
        conteo.forEach((key, value) -> {
            String nombreProducto = Producto.obtenerNombreProducto(key.substring(key.indexOf("_")+1));
            Float precioUnidad = Float.valueOf(key.substring(0,key.indexOf("_")));
            Float precio = precioUnidad * value;
            System.out.printf("%s%15d\t%.2f\t%.2f\n", nombreProducto, value, precioUnidad, precio);
        });
        System.out.println("-----------------------------");
        System.out.println("Total: " );
        Producto.Productos.clear();
    }
}
