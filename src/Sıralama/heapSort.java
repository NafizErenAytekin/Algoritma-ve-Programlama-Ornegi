package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class heapSort {

    public static void heapSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        int[] arr = Arrays.stream(klavye.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = arr.length;

        // Max-heap oluştur (en büyük eleman kökte olacak şekilde)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Heap'i sıralı hale getir
        for (int i = n - 1; i >= 0; i--) {
            // Kökü (en büyük eleman) son elemanla değiştir
            swap(arr, 0, i);

            // Kalan heap'i yeniden düzenle
            heapify(arr, i, 0);
        }

        System.out.println("Sıralanmış dizi: " + Arrays.toString(arr));
    }

    // Bir alt ağacı max-heap özelliğine uygun hale getir
    private static void heapify(int[] arr, int n, int i) {
        int enBuyuk = i; // Şu anki kök (varsayılan olarak en büyük)
        int sol = 2 * i + 1; // Sol çocuk
        int sag = 2 * i + 2; // Sağ çocuk

        // Sol çocuk varsa ve kök'ten büyükse
        if (sol < n && arr[sol] > arr[enBuyuk]) {
            enBuyuk = sol;
        }

        // Sağ çocuk varsa ve kök'ten büyükse
        if (sag < n && arr[sag] > arr[enBuyuk]) {
            enBuyuk = sag;
        }

        // Eğer en büyük eleman kök değilse, yerlerini değiştir ve alt ağacı düzenle
        if (enBuyuk != i) {
            swap(arr, i, enBuyuk);
            heapify(arr, n, enBuyuk);
        }
    }

    // İki elemanın yerini değiştir
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}