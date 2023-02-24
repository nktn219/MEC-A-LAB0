import java.util.*;

public class ProcesarTexto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una línea de texto: ");
        String linea = scanner.nextLine();

        char letraMasRepetida = obtenerLetraMasRepetida(linea);
        
        String lineaSustituida = sustituirVocales(linea, letraMasRepetida);
        
        String lineaInvertida = invertirLinea(linea);
        
        System.out.println("Línea original: " + linea);
        System.out.println("Línea sustituida: " + lineaSustituida);
        System.out.println("Línea invertida: " + lineaInvertida);
    }
    private static char obtenerLetraMasRepetida(String linea) {
        Map<Character, Integer> frecuencias = new HashMap<>();
        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);
            if (Character.isLetter(c)) {
                c = Character.toLowerCase(c);
                frecuencias.put(c, frecuencias.getOrDefault(c, 0) + 1);
            }
        }
        char letraMasRepetida = ' ';
        int maxFrecuencia = 0;
        for (Map.Entry<Character, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                letraMasRepetida = entry.getKey();
                maxFrecuencia = entry.getValue();
            }
        }
        return letraMasRepetida;
    }
    private static String sustituirVocales(String linea, char letra) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                sb.append(letra);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    private static String invertirLinea(String linea) {
        StringBuilder sb = new StringBuilder(linea);
        sb.reverse();
        return sb.toString();
    }
}