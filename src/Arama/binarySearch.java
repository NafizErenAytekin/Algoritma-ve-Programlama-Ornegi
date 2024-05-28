package Arama;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {

    public static void binarySearch() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen aramak istediğiniz sayıları virgülle ayırarak girin (sıralı olmalı): ");
        int[] dizi = Arrays.stream(klavye.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print("Aranacak sayıyı girin: ");
        int arananSayi = klavye.nextInt();

        int index = binarySearch(dizi, arananSayi);

        if (index != -1) {
            System.out.println("Sayı " + index + ". indeksde bulundu.");
        } else {
            System.out.println("Sayı bulunamadı.");
        }
    }

    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid; // Sayı bulundu
            } else if (arr[mid] < target) {
                low = mid + 1; // Arama aralığını sağ tarafa daralt
            } else {
                high = mid - 1; // Arama aralığını sol tarafa daralt
            }
        }

        return -1;
    }
}
