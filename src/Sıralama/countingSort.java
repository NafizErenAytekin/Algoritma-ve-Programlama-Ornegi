package Sıralama;

import java.util.Arrays;
import java.util.Scanner;

public class countingSort {

    public static void countingSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int max = Arrays.stream(sayilar).max().getAsInt();
        int min = Arrays.stream(sayilar).min().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        Arrays.fill(count, 0);

        for (int num : sayilar) {
            count[num - min]++;
        }

        int j = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                sayilar[j++] = i + min;
                count[i]--;
            }
        }

        System.out.println("Counting Sort ile sıralanmış dizi: " + Arrays.toString(sayilar));
    }
}
