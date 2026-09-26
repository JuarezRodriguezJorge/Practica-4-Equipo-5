import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AnalizadorPalabras {

    // Atributos: oración original y frecuencia de cada palabra.
    private String oracion;
    private Map<String, Integer> frecuencias;

    // Constructor: recibe la oración y crea el mapa vacío.
    public AnalizadorPalabras(String nuevaOracion) {
        this.oracion = nuevaOracion;
        this.frecuencias = new HashMap<>();
    }

    // Cuenta todas las palabras y guarda sus frecuencias en el mapa.
    public int contarPalabras() {
        // Pasa todo a minúsculas y quita signos de puntuación comunes.
        String limpia = oracion.toLowerCase().replaceAll("[^a-záéíóúñ\\s]", "");
        limpia = limpia.trim();

        if (limpia.isEmpty()) {
            return 0;
        }

        String[] palabras = limpia.split("\\s+");
        for (String palabra : palabras) {
            if (frecuencias.containsKey(palabra)) {
                int contador = frecuencias.get(palabra);
                frecuencias.put(palabra, contador + 1);
            } else {
                frecuencias.put(palabra, 1);
            }
        }

        return palabras.length;
    }

    // Devuelve cuántas palabras diferentes se encontraron.
    public int obtenerNumeroPalabrasDistintas() {
        return frecuencias.size();
    }

    // Cuenta las palabras diferentes cuya frecuencia supera uno.
    public int obtenerNumeroDuplicadas() {
        int duplicadas = 0;
        for (int conteo : frecuencias.values()) {
            if (conteo > 1) {
                duplicadas++;
            }
        }
        return duplicadas;
    }

    // Muestra todas las palabras y su frecuencia.
    public void mostrarResultado() {
        System.out.println("\nFrecuencia de todas las palabras:");
        for (String palabra : frecuencias.keySet()) {
            System.out.println(palabra + ": " + frecuencias.get(palabra));
        }
    }

    // Muestra las palabras duplicadas sin ningún orden particular.
    public void mostrarDuplicadasSinOrdenar() {
        boolean hayDuplicadas = false;
        for (String palabra : frecuencias.keySet()) {
            if (frecuencias.get(palabra) > 1) {
                System.out.println(palabra + ": " + frecuencias.get(palabra));
                hayDuplicadas = true;
            }
        }
        if (!hayDuplicadas) {
            System.out.println("No hay palabras duplicadas.");
        }
    }

    // Muestra las palabras duplicadas en orden alfabético usando TreeSet.
    public void mostrarDuplicadasOrdenadas() {
        TreeSet<String> ordenadas = new TreeSet<>(frecuencias.keySet());

        boolean hayDuplicadas = false;
        for (String palabra : ordenadas) {
            if (frecuencias.get(palabra) > 1) {
                System.out.println(palabra + ": " + frecuencias.get(palabra));
                hayDuplicadas = true;
            }
        }
        if (!hayDuplicadas) {
            System.out.println("No hay palabras duplicadas.");
        }
    }
}
