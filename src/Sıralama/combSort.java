package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class combSort {

    public static void combSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = sayilar.length;
        int gap = n;
        double daralmaFaktoru = 1.3; // Genellikle 1.3 kullanılır
        boolean takasYapildi = true;

        while (gap > 1 || takasYapildi) {
            // Gap'i güncelle
            gap = (int) (gap / daralmaFaktoru);
            if (gap < 1) {
                gap = 1;
            }

            takasYapildi = false;

            for (int i = 0; i < n - gap; i++) {
                if (sayilar[i] > sayilar[i + gap]) {
                    swap(sayilar, i, i + gap);
                    takasYapildi = true;
                }
            }
        }

        System.out.println("Comb Sort ile sıralanmış dizi: " + Arrays.toString(sayilar));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}