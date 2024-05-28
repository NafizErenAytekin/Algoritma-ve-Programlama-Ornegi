package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class permSort {

    public static void permSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        permSort(sayilar);

        System.out.println("Permütasyon Sort ile sıralanmış dizi: " + Arrays.toString(sayilar));
    }

    private static void permSort(int[] arr) {
        permSort(arr, 0);
    }

    private static void permSort(int[] arr, int start) {
        if (start == arr.length - 1) {
            if (isSorted(arr)) {
                return; // Dizi sıralıysa dur
            }
        } else {
            for (int i = start; i < arr.length; i++) {
                swap(arr, start, i);
                permSort(arr, start + 1);
                swap(arr, start, i); // Geri al
            }
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}