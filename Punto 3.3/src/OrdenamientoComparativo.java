import java.util.*;

public class OrdenamientoComparativo {

    public static void main(String[] args) {
        int[] tamaños = { 100, 500, 1000, 5000, 10000 };
        for (int tamaño : tamaños) {
            double[] numeros = generarNumerosAleatorios(tamaño);
            long tiempoBurbuja = medirTiempo(() -> ordenarBurbuja(numeros));
            long tiempoInsercion = medirTiempo(() -> ordenarInsercion(numeros));
            long tiempoSeleccion = medirTiempo(() -> ordenarSeleccion(numeros));
            long tiempoMergesort = medirTiempo(() -> ordenarMergesort(numeros));
            System.out.printf("Tamaño: %d, Burbuja: %d ms, Inserción: %d ms, Selección: %d ms, Mergesort: %d ms\n",
                    tamaño, tiempoBurbuja, tiempoInsercion, tiempoSeleccion, tiempoMergesort);
        }
    }

    private static double[] generarNumerosAleatorios(int tamaño) {
        Random random = new Random();
        double[] numeros = new double[tamaño];
        for (int i = 0; i < tamaño; i++) {
            numeros[i] = random.nextDouble();
        }
        return numeros;
    }

    private static long medirTiempo(Runnable tarea) {
        long inicio = System.currentTimeMillis();
        tarea.run();
        long fin = System.currentTimeMillis();
        return fin - inicio;
    }

    private static void ordenarBurbuja(double[] numeros) {
        int n = numeros.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    double temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }
    }

    private static void ordenarInsercion(double[] numeros) {
        int n = numeros.length;
        for (int i = 1; i < n; i++) {
            double key = numeros[i];
            int j = i - 1;
            while (j >= 0 && numeros[j] > key) {
                numeros[j + 1] = numeros[j];
                j--;
            }
            numeros[j + 1] = key;
        }
    }

    private static void ordenarSeleccion(double[] numeros) {
        int n = numeros.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (numeros[j] < numeros[minIdx]) {
                    minIdx = j;
                }
            }
            double temp = numeros[minIdx];
            numeros[minIdx] = numeros[i];
            numeros[i] = temp;
        }
    }

    private static void ordenarMergesort(double[] numeros) {
        int n = numeros.length;
        if (n > 1) {
            int mid = n / 2;
            double[] left = Arrays.copyOfRange(numeros, 0, mid)