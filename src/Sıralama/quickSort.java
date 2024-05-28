package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class quickSort {

    public static void quickSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        quickSort(sayilar, 0, sayilar.length - 1);

        System.out.println("Sıralanmış dizi: " + Arrays.toString(sayilar));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1); // Pivotun sol tarafını sırala
            quickSort(arr, pivotIndex + 1, high); // Pivotun sağ tarafını sırala
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Pivot olarak son elemanı seç
        int i = (low - 1); // Pivot'tan küçük elemanların son indeksini takip et

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j); // Pivot'tan küçük elemanı sola taşı
            }
        }
        swap(arr, i + 1, high); // Pivot'u doğru yerine koy

        return i + 1; // Pivot'un yeni indeksini döndür
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}