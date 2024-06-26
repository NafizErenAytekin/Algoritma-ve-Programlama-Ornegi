package Arama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class pruferDizilimi {

    public static void pruferDizilimi() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Ağacın kaç düğümü var? (En az 2 olmalı): ");

        // Düğüm sayısı için kontrol
        while (!klavye.hasNextInt()) {
            System.out.println("Geçersiz giriş. Lütfen bir sayı girin.");
            klavye.next(); // Hatalı girişi temizle
        }
        int n = klavye.nextInt();

        if (n < 2) {
            System.out.println("Geçersiz giriş. Düğüm sayısı en az 2 olmalıdır.");
            return;
        }

        System.out.println("Ağacın kenarlarını girin (örnek: 0 1, 0 2, 1 3):");
        List<int[]> kenarlar = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            // Kenar bilgileri için kontrol
            while (!klavye.hasNextInt()) {
                System.out.println("Geçersiz giriş. Lütfen bir sayı girin.");
                klavye.next(); // Hatalı girişi temizle
            }
            int u = klavye.nextInt();
            while (!klavye.hasNextInt()) {
                System.out.println("Geçersiz giriş. Lütfen bir sayı girin.");
                klavye.next(); // Hatalı girişi temizle
            }
            int v = klavye.nextInt();
            // Kenarların düğüm indekslerinin geçerliliğini kontrol et
            if (u < 0 || u >= n || v < 0 || v >= n) {
                System.out.println("Geçersiz kenar. Düğüm indeksleri 0 ile " + (n - 1) + " arasında olmalıdır.");
                i--; // Geçersiz kenarı tekrar girmesi için döngüyü bir adım geri al
                continue;
            }
            kenarlar.add(new int[]{u, v});
        }

        int[] prufer = pruferKoduOlustur(kenarlar, n);
        System.out.println("Prüfer dizilimi: " + Arrays.toString(prufer));
    }

    private static int[] pruferKoduOlustur(List<int[]> kenarlar, int n) {
        int[] derece = new int[n];
        for (int[] kenar : kenarlar) {
            derece[kenar[0]]++;
            derece[kenar[1]]++;
        }

        int[] prufer = new int[n - 2];
        int index = 0;
        for (int i = 0; i < n && index < n - 2; i++) {
            if (derece[i] == 1) {
                for (int j = 0; j < kenarlar.size(); j++) {  // kenarlar.size() ile sınırla
                    int[] kenar = kenarlar.get(j);
                    if (kenar[0] == i || kenar[1] == i) {
                        prufer[index++] = kenar[0] == i ? kenar[1] : kenar[0];
                        derece[kenar[0]]--;
                        derece[kenar[1]]--;
                        kenarlar.remove(j);  // Kullanılan kenarı kaldır
                        break;
                    }
                }
            }
        }
        return prufer;
    }
}
