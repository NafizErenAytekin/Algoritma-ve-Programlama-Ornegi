package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class shakerSort {

    public static void shakerSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int baslangic = 0;
        int bitis = sayilar.length - 1;
        boolean takasYapildi;

        do {
            takasYapildi = false;

            // Soldan sağa tarama
            for (int i = baslangic; i < bitis; i++) {
                if (sayilar[i] > sayilar[i + 1]) {
                    swap(sayilar, i, i + 1);
                    takasYapildi = true;
                }
            }

            // Eğer takas yapılmadıysa, dizi zaten sıralıdır
            if (!takasYapildi) {
                break;
            }

            takasYapildi = false;
            bitis--;

            // Sağdan sola tarama
            for (int i = bitis - 1; i >= baslangic; i--) {
                if (sayilar[i] > sayilar[i + 1]) {
                    swap(sayilar, i, i + 1);
                    takasYapildi = true;
                }
            }

            baslangic++;

        } while (takasYapildi);

        System.out.println("Shaker Sort ile sıralanmış dizi: " + Arrays.toString(sayilar));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}