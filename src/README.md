# Readme
Para tener un orden he separado el codigo en clases (SAPAMERCAT,Producto,Carrito,Alimentacio,Textil,Electronica y Menu).

En la clase SAPAMERCAT este el Main juntamente con las funciones de crear el fichero logs, meter las expeciones a un ArrayList y la insertar este ArrayList dentro del fichero previamente creado.

En la clase Producto se encunetra el ArrayList para guardar los productos y el constructor principal juntamente con sus getter y setters. Tambien en esta clase se encuentra las funciones para introducir los productos selecionados previamente en el Menu. Para verificar los datos he creado unas funciones que verifican si son correcto, de lo contrario vuelve a pedir el valor y lanza la exepcion para posteriormente guardarlo en el fichero de exepciones.
```java
public static List<Producto> Productos = new ArrayList<>();
```

En la clase Carrito se encuentra las funciones de mostrar el carrito y pasar por caja. Ademas se encuentra el HasMap que he utilizado para poder hacer una agrupación mediante una concatenacion del precio del producto juntamente el codigo de barras del producto, por cada concidencia de esta agrupación uso el summingInt para que el array interno del Map pueda contar las conincidencias.
```java
static Map<String, Integer> conteo = new HashMap<>();
conteo = Producto.Productos.stream()
                .collect(Collectors.groupingBy((producto) -> producto.getPreu() + "_" + producto.getCodiBarras(), Collectors.summingInt(e -> 1)));
```

Cada codigo de barras tiene asosiado una inicial depiendiendo del producto que se introduzca, 'A' para los productos de Alimentacion, 'T' para los productos textil y 'E' para los productos Electronica, esto lo hago para posteriormente diferenciar cada codigo de barras de los productos.
```java
Productos.add(new Alimentacio(NomProducte,Preu,"A"+CodiBarras,DataCaducitat));
Productos.add(new Textil(NomProducte,Preu,"T"+CodiBarras,Composisico));
Productos.add(new Electronica(NomProducte,Preu,"E"+CodiBarras,Garantia));
```

En la clase Alimentacion simplemente se encuentra el constructor y la funcion de obtener el precio en funcion de la fecha de caducidad del producto.
```java
@Override
    public float getPreu() {
        float preu = super.Preu;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(DataCaducitat, formato);
        LocalDate DataActual = LocalDate.now();// Fecha actual de la maquina
        long numberOFDays = DAYS.between(fecha, DataActual); // Obtener la diferencia de dias entre la fecha de caducidad y la fecha actual
        return  (preu - (float) (preu*( 1 /(numberOFDays+1)) + (preu * 0.1)));
    }
```

En la clase Textil mas de los mismo, se encuentra el constructor y la funcion de CompareTo para hacer una ordenacion mediante la composicion, pero si esta no es posible la hace mediante el codigo de barras.
```java
@Override
    public int compareTo(Producto o) {
        if (o instanceof Textil p) {
            return this.Composicio.compareTo(p.Composicio);
        } else {
            return this.CodiBarras.compareTo(o.CodiBarras);
        }
    }
```
En la clase Elctronica se puede encontrar el constructor y además su funcion para obtener el precio mediante los dias de garantia.
```java
@Override
    public float getPreu() {
       float preu = super.getPreu();
        return  (float) (preu + preu*(Garantia/365)*0.1);
    }
```
En la clase Menu se encuentra el menu principal y el menu de introducir productos.
```java

```