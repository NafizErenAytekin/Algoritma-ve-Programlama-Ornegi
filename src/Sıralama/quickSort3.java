package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class quickSort3 {

    public static void quickSort3() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        quickSort3(sayilar, 0, sayilar.length - 1);

        System.out.println("Quick Sort 3 ile sıralanmış dizi: " + Arrays.toString(sayilar));
    }

    private static void quickSort3(int[] arr, int low, int high) {
        if (high <= low) return;

        int lt = low, gt = high;
        int pivot = arr[low];
        int i = low + 1;
        while (i <= gt) {
            if (arr[i] < pivot) {
                swap(arr, lt++, i++);
            } else if (arr[i] > pivot) {
                swap(arr, i, gt--);
            } else {
                i++;
            }
        }

        // 3-way partitioning tamamlandı
        quickSort3(arr, low, lt - 1);
        quickSort3(arr, gt + 1, high);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}