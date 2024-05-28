package Sıralama;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class randomSort {

    public static void randomSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        rastgeleSirala(sayilar);

        System.out.println("Rastgele sıralanmış dizi: " + Arrays.toString(sayilar));
    }

    private static void rastgeleSirala(int[] arr) {
        Random rand = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}