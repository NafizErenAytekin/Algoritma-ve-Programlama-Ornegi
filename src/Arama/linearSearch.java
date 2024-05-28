package Arama;

import java.util.Arrays;
import java.util.Scanner;

public class linearSearch {

    public static void linearSearch() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen aramak istediğiniz sayıları virgülle ayırarak girin: ");
        int[] dizi = Arrays.stream(klavye.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.print("Aranacak sayıyı girin: ");
        int arananSayi = klavye.nextInt();

        int index = linearSearch(dizi, arananSayi);

        if (index != -1) {
            System.out.println("Sayı " + index + ". indeksde bulundu.");
        } else {
            System.out.println("Sayı bulunamadı.");
        }
    }

    private static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}