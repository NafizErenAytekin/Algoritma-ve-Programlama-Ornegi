package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class shellSort {

    public static void shellSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = sayilar.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = sayilar[i];
                int j;
                for (j = i; j >= gap && sayilar[j - gap] > temp; j -= gap) {
                    sayilar[j] = sayilar[j - gap];
                }
                sayilar[j] = temp;
            }
        }

        System.out.println("Shell Sort ile sıralanmış dizi: " + Arrays.toString(sayilar));
    }
}