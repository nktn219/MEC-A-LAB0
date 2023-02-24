import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CalculosEstadistica {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño del arreglo: ");
        int z = sc.nextInt();
        int[] arr = new int[z];
        Random rand = new Random();
        for (int i = 0; i < z; i++) {
            arr[i] = rand.nextInt(101);
        }
        System.out.println("Arreglo: " + Arrays.toString(arr));
        double media = 0;
        for (int i = 0; i < z; i++) {
            media += arr[i];
        }
        media /= z;
        System.out.println("Media: " + media);
        Arrays.sort(arr);
        double mediana = 0;
        if (z % 2 == 0) {
            mediana = (arr[z/2] + arr[z/2 - 1]) / 2.0;
        } else {
            mediana = arr[z/2];
        }
        System.out.println("Mediana: " + mediana);
        double varianza = 0;
        for (int i = 0; i < z; i++) {
            varianza += Math.pow(arr[i] - media, 2);
        }
        varianza /= z;
        System.out.println("Varianza: " + varianza);
        double desviacion = Math.sqrt(varianza);
        System.out.println("Desviación estándar: " + desviacion);
        int moda = arr[0];
        int maxCount = 1;
        int count = 1;
        for (int i = 1; i < z; i++) {
            if (arr[i] == arr[i-1]) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    moda = arr[i-1];
                }
                count = 1;
            }
        }
        if (count > maxCount) {
            moda = arr[z-1];
        }
        System.out.println("Moda: " + moda);
    }
}