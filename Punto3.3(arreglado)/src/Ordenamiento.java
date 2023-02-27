import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Ordenamiento {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la longitud del arreglo: ");
        int n = sc.nextInt();
        int[] arreglo = generarArregloAleatorio(n);
        System.out.println("Arreglo aleatorio: " + Arrays.toString(arreglo));
        System.out.println("Seleccione el método de ordenamiento:");
        System.out.println("1. Burbuja");
        System.out.println("2. Inserción");
        System.out.println("3. Selección");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                burbuja(arreglo);
                break;
            case 2:
                insercion(arreglo);
                break;
            case 3:
                seleccion(arreglo);
                break;
            default:
                System.out.println("Opción inválida.");
        }
        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));
    }

    public static int[] generarArregloAleatorio(int n) {
        int[] arreglo = new int[n];
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            arreglo[i] = rnd.nextInt(100);
        }
        return arreglo;
    }

    public static void burbuja(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
    }

    public static void insercion(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            int valor = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j] > valor) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = valor;
        }
    }

    public static void seleccion(int[] arreglo) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[minimo]) {
                    minimo = j;
                }
            }
            int temp = arreglo[i];
            arreglo[i] = arreglo[minimo];
            arreglo[minimo] = temp;
        }
    }
}