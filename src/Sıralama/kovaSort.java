package Sıralama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class kovaSort {

    public static void kovaSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        double[] sayilar = Arrays.stream(girdi.split(","))
                .mapToDouble(Double::parseDouble) // Double değerleri kabul ediyoruz
                .toArray();

        kovaSort(sayilar);

        System.out.println("Kova Sort ile sıralanmış dizi: " + Arrays.toString(sayilar));
    }

    private static void kovaSort(double[] arr) {
        int n = arr.length;
        List<List<Double>> kovalar = new ArrayList<>(n);

        // Kovaları oluştur
        for (int i = 0; i < n; i++) {
            kovalar.add(new LinkedList<>());
        }

        // Elemanları kovalara dağıt
        for (int i = 0; i < n; i++) {
            int kovaIndeksi = (int) (n * arr[i]);
            kovalar.get(kovaIndeksi).add(arr[i]);
        }

        // Her kovayı sırala
        for (List<Double> kova : kovalar) {
            Collections.sort(kova);
        }

        // Kovaları birleştirerek orijinal diziyi oluştur
        int index = 0;
        for (List<Double> kova : kovalar) {
            for (double num : kova) {
                arr[index++] = num;
            }
        }
    }
}