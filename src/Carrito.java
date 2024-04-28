import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Clase Carrito donde se encuentra la funcion de mostrar el carrito y la funcion de pasar por caja
 */
public class Carrito {
    /**
     *HasMap del arraylist de productos
     */
    static Map<String, Integer> conteo = new HashMap<>();

    /**
     *Funcion de Mostrar el carrrito
     */
    public static void MostrarCarritoCompra(){
        IniciarMap();
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

    /**
     *Funcion de pasar por caja
     */
    public static void PasarPorCaja()  {
        IniciarMap();
       ComprobarPrecioTextil();
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
        Producto.Productos.clear();
        Carrito.conteo.clear();

    }
    private static void IniciarMap(){
        conteo = Producto.Productos.stream()
                .collect(Collectors.groupingBy((producto) -> producto.getPreu() + "_" + producto.getCodiBarras(), Collectors.summingInt(e -> 1)));
    }

    public static void ComprobarPrecioTextil(){
        try (BufferedReader br = new BufferedReader(new FileReader(".\\updates\\UpdateTextilPrices.dat"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] parts = linea.split(";");
                if (parts.length == 2) {
                    String CodiBarrasF = parts[0].trim();
                    float Preuf = Float.parseFloat(parts[1].trim());
                    for (Producto producto : Producto.Productos) {
                        if (producto instanceof Textil){
                            if (producto.getCodiBarras().equals(CodiBarrasF)){
                                producto.setPreu(Preuf);
                                IniciarMap();
                            }
                        }


                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            SAPAMERCAT.GuardarExepciones(e.toString());
        }
    }
}


