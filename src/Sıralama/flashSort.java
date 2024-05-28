package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class flashSort {

    public static void flashSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = sayilar.length;
        int m = (int) (0.45 * n);
        int[] L = new int[m];

        int min = sayilar[0], max = sayilar[0];
        for (int i = 1; i < n; i++) {
            if (sayilar[i] < min) {
                min = sayilar[i];
            }
            if (sayilar[i] > max) {
                max = sayilar[i];
            }
        }

        double c1 = (double) (m - 1) / (max - min);
        Arrays.fill(L, 0);
        for (int i = 0; i < n; i++) {
            int k = (int) (c1 * (sayilar[i] - min));
            L[k]++;
        }

        for (int i = 1; i < m; i++) {
            L[i] += L[i - 1];
        }

        int j = 0;
        int cycle = 0;
        while (cycle < m - 1) {
            while (j >= L[cycle]) {
                j++;
                cycle++;
            }
            int hold = sayilar[j];
            while (j != cycle) {
                int k = (int) (c1 * (hold - min));
                int temp = sayilar[L[k] - 1];
                sayilar[L[k] - 1] = hold;
                hold = temp;
                L[k]--;
            }
        }

        insertionSort(sayilar); // Kalan küçük parçaları Insertion Sort ile sırala

        System.out.println("Flash Sort ile sıralanmış dizi: " + Arrays.toString(sayilar));
    }

    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // key'den büyük olan elemanları bir pozisyon sağa kaydır
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}