package Arama;

import java.util.*;

public class horspoolArama {
    public static void horspoolArama() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Metin: ");
        String metin = klavye.nextLine();
        System.out.print("Desen: ");
        String desen = klavye.nextLine();

        List<Integer> eslesmeler = horspoolAra(metin, desen);
        System.out.println(eslesmeler.isEmpty() ? "Desen bulunamadı." : "Desen şu indekslerde bulundu: " + eslesmeler);
    }

    private static List<Integer> horspoolAra(String metin, String desen) {
        int[] kaydirmaTablosu = new int[256]; // Varsayılan kaydırma: desen uzunluğu
        for (int i = 0; i < desen.length() - 1; i++) {
            kaydirmaTablosu[desen.charAt(i)] = desen.length() - 1 - i;
        }

        List<Integer> eslesmeler = new ArrayList<>();
        int i = 0;
        while (i <= metin.length() - desen.length()) {
            int j = desen.length() - 1;
            while (j >= 0 && desen.charAt(j) == metin.charAt(i + j)) {
                j--;
            }
            if (j < 0) {
                eslesmeler.add(i);
            }
            i += kaydirmaTablosu[metin.charAt(i + desen.length() - 1)];
        }
        return eslesmeler;
    }
}