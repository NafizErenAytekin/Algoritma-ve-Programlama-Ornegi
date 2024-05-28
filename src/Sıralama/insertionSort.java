package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class insertionSort {

    public static void insertionSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 1; i < sayilar.length; i++) {
            int key = sayilar[i];
            int j = i - 1;

            while (j >= 0 && sayilar[j] > key) {
                sayilar[j + 1] = sayilar[j];
                j--;
            }
            sayilar[j + 1] = key;
        }

        System.out.println("Sıralanmış dizi: " + Arrays.toString(sayilar));
    }
}