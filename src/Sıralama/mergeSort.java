package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class mergeSort {

    public static void mergeSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        mergeSort(sayilar, 0, sayilar.length - 1);

        System.out.println("Sıralanmış dizi: " + Arrays.toString(sayilar));
    }

    private static void mergeSort(int[] arr, int basla, int bitis) {
        if (basla < bitis) {
            int orta = (basla + bitis) / 2;

            // Sol yarıyı sırala
            mergeSort(arr, basla, orta);

            // Sağ yarıyı sırala
            mergeSort(arr, orta + 1, bitis);

            // Sıralı iki yarıyı birleştir
            merge(arr, basla, orta, bitis);
        }
    }

    private static void merge(int[] arr, int basla, int orta, int bitis) {
        int[] sol = Arrays.copyOfRange(arr, basla, orta + 1);
        int[] sag = Arrays.copyOfRange(arr, orta + 1, bitis + 1);

        int i = 0, j = 0, k = basla;
        while (i < sol.length && j < sag.length) {
            if (sol[i] <= sag[j]) {
                arr[k++] = sol[i++];
            } else {
                arr[k++] = sag[j++];
            }
        }

        while (i < sol.length) {
            arr[k++] = sol[i++];
        }

        while (j < sag.length) {
            arr[k++] = sag[j++];
        }
    }
}