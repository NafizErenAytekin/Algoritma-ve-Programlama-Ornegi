package Sıralama;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class luckySort {

    public static void luckySort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        luckySort(sayilar);

        System.out.println("Lucky Sort ile sıralanmış dizi: " + Arrays.toString(sayilar));
    }

    private static void luckySort(int[] arr) {
        if (arr.length <= 1) {
            return; // Base case: Dizi zaten sıralıdır veya boştur
        }

        Random rand = new Random();
        int n = arr.length;

        while (true) {
            int[] secilenler = new int[n / 2];
            List<Integer> kalanlar = new ArrayList<>();

            // Rastgele sayıları seç
            for (int i = 0; i < secilenler.length; i++) {
                secilenler[i] = rand.nextInt(n) + 1; // 0 yerine 1'den başlatarak sıfıra bölme hatasını önle
            }

            // Seçilen sayıların toplamını hesapla
            int toplam = Arrays.stream(secilenler).sum();

            // Eğer toplam 0 ise, tekrar rastgele sayılar seç
            if (toplam == 0) {
                continue;
            }

            // Seçilen sayılara göre diziyi böl
            for (int i = 0; i < n; i++) {
                if (i % toplam == 0) {
                    continue; // Seçilen sayı ise atla
                }
                kalanlar.add(arr[i]);
            }

            // Kalanlar dizisini sırala
            int[] kalanlarArray = kalanlar.stream().mapToInt(i -> i).toArray();
            luckySort(kalanlarArray);

            // Eğer kalanlar dizisi sıralıysa, işlemi bitir
            if (isSorted(kalanlarArray)) {
                break;
            }

            // Kalanlar dizisini orijinal dizinin başına kopyala
            System.arraycopy(kalanlarArray, 0, arr, 0, kalanlarArray.length);

            // Dizinin boyutunu güncelle
            n = kalanlarArray.length;
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
}