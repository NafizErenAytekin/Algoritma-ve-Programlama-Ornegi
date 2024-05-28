package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class selectionSort {

    public static void selectionSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < sayilar.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sayilar.length; j++) {
                if (sayilar[j] < sayilar[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = sayilar[minIndex];
            sayilar[minIndex] = sayilar[i];
            sayilar[i] = temp;
        }

        System.out.println("Sıralanmış dizi: " + Arrays.toString(sayilar));
    }
}