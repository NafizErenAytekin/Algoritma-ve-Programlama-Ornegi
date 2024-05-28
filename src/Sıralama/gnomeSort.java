package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class gnomeSort {

    public static void gnomeSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        gnomeSort(sayilar);

        System.out.println("Gnome Sort ile sıralanmış dizi: " + Arrays.toString(sayilar));
    }

    private static void gnomeSort(int[] arr) {
        int index = 0;
        int n = arr.length;

        while (index < n) {
            if (index == 0) {
                index++;
            } else if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                swap(arr, index, index - 1);
                index--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}