
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Carrito {

    static Map<String, Integer> conteo = Producto.Productos.stream()
            .collect(Collectors.groupingBy((producto) -> producto.getPreu() + "_" + producto.getCodiBarras(), Collectors.summingInt(e -> 1)));

    public static void MostrarCarritoCompra(){
        Collections.sort(Producto.Productos);
        System.out.println("Carret");
        System.out.println("-----------------");
        conteo.forEach((key, value) -> {
            String nombreProducto = Producto.obtenerNombreProducto(key.substring(key.indexOf("_")+1));
            System.out.printf("%s->%d\n", nombreProducto, value);
        });
        System.out.println("-----------------");
        System.out.println();
    }

    public static void PasarPorCaja()  {
        float precioTotal = 0;
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
        for (String key : conteo.keySet()) {
            precioTotal += Float.valueOf(key.substring(0,key.indexOf("_"))) * conteo.get(key);
        }
        System.out.println("Total: " + precioTotal);
        try {
            SAPAMERCAT.MeterDatos();
        } catch (IOException e){
            System.out.println("Error al escirbir en el archivo de Logs");
        }

    }

}
