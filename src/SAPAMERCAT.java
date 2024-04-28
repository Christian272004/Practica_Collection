import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase principal que contiene el main y la funcion de crear los archivos si es que no existen
 */
public class SAPAMERCAT {
    /**
     *Arraylist para guardar las expeciones
     */
    static List<String> Exepciones = new ArrayList<>();

    /**
     *funcnion principal
     * @param args
     */
    public static void main(String[] args)  {
        CreacionFicheros();
        Menu.MenuPrincipal();
    }

    /**
     *Funcion para crear los ficheros updates y logs
     */
    private static void CreacionFicheros()  {
        File CarpetaUpdate = new File(".\\updates");
        File CarpetaLogs = new File(".\\logs");
        File ArchivoUpdate = new File(".\\updates\\UpdateTextilPrices.dat");
        File ArchivoLogs = new File(".\\logs\\Exceptions.dat");
        try {
            if (!(CarpetaUpdate.exists() && CarpetaLogs.exists())){
                CarpetaUpdate.mkdir();
                CarpetaLogs.mkdir();
                if (!(ArchivoUpdate.exists() && ArchivoLogs.exists())){
                    ArchivoUpdate.createNewFile();
                    ArchivoLogs.createNewFile();
                }
            }
        } catch (IOException e) {
            GuardarExepciones(e.getMessage());
        }
    }

    /**
     *Funcion para meter los datos de las exepciones en el fichero logs
     * @throws FileNotFoundException
     */
    protected static void MeterDatos() throws FileNotFoundException {
        File ArchivoLogs = new File(".\\logs\\Exceptions.dat");
        PrintStream writer2 = new PrintStream(ArchivoLogs);

        for (int i = 0; i <Exepciones.size(); i++) {
            writer2.println(Exepciones.get(i));
        }
        writer2.close();
    }

    /**
     *Funcion para guardar las expeciones en una arerayList
     * @param error Paramentro de entrada del error de la expecion
     */
    protected static void GuardarExepciones(String error){
        Exepciones.add(error);
    }
}
