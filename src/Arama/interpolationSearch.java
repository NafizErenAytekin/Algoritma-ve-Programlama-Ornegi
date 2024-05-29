package Arama;
import java.util.Arrays;
import java.util.Scanner;

public class interpolationSearch {

    public static void interpolationSearch() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen aramak istediğiniz sayıları virgülle ayırarak girin (sıralı olmalı): ");
        int[] dizi = Arrays.stream(klavye.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print("Aranacak sayıyı girin: ");
        int arananSayi = klavye.nextInt();

        int index = interpolationSearch(dizi, arananSayi);

        if (index != -1) {
            System.out.println("Sayı " + index + ". indeksde bulundu.");
        } else {
            System.out.println("Sayı bulunamadı.");
        }
    }

    private static int interpolationSearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target) {
                    return low;
                } else {
                    return -1;
                }
            }

            // Interpolasyon formülü ile tahmini pozisyonu hesapla
            int pos = (int) (low + (((double) (high - low) / (arr[high] - arr[low])) * (target - arr[low])));

            if (arr[pos] == target) {
                return pos; // Sayı bulundu
            } else if (arr[pos] < target) {
                low = pos + 1; // Arama aralığını sağ tarafa daralt
            } else {
                high = pos - 1; // Arama aralığını sol tarafa daralt
            }
        }

        return -1;
    }
}
