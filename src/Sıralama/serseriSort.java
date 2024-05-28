package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class serseriSort {

    public static void serseriSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        stoogeSort(sayilar, 0, sayilar.length - 1);

        System.out.println("Stooge Sort ile sıralanmış dizi: " + Arrays.toString(sayilar));
    }

    private static void stoogeSort(int[] arr, int low, int high) {
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }

        if (high - low + 1 > 2) {
            int t = (high - low + 1) / 3; // Üçte birlik kısmı hesapla

            // İlk 2/3'ünü sırala
            stoogeSort(arr, low, high - t);

            // Son 2/3'ünü sırala
            stoogeSort(arr, low + t, high);

            // Tekrar ilk 2/3'ünü sırala
            stoogeSort(arr, low, high - t);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}