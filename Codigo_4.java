import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa una oración para analizar: ");
        String oracion = scanner.nextLine();

        AnalizadorPalabras analizador = new AnalizadorPalabras(oracion);
        int total = analizador.contarPalabras();

        System.out.println("\nTotal de palabras: " + total);
        System.out.println("Palabras distintas: " + analizador.obtenerNumeroPalabrasDistintas());
        System.out.println("Palabras diferentes duplicadas: " + analizador.obtenerNumeroDuplicadas());

        analizador.mostrarResultado();

        System.out.println("\nDuplicadas sin ordenar:");
        analizador.mostrarDuplicadasSinOrdenar();

        System.out.println("\nDuplicadas en orden alfabético:");
        analizador.mostrarDuplicadasOrdenadas();

        scanner.close();
    }
}
