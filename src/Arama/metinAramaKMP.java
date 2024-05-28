package Arama;

import java.util.*;

public class metinAramaKMP {

    public static void metinAramaKMP() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Metni girin: ");
        String metin = klavye.nextLine();
        System.out.print("Aranacak deseni girin: ");
        String desen = klavye.nextLine();

        List<Integer> eslesmeler = kmpAra(metin, desen);
        System.out.println(eslesmeler.isEmpty() ? "Desen bulunamadı."
                : "Desen şu indekslerde bulundu: " + eslesmeler);
    }

    private static List<Integer> kmpAra(String metin, String desen) {
        List<Integer> eslesmeler = new ArrayList<>();
        int[] lps = new int[desen.length()];
        for (int i = 1, len = 0; i < desen.length();) {
            if (desen.charAt(i) == desen.charAt(len)) lps[i++] = ++len;
            else len = len != 0 ? lps[len - 1] : 0;
        }

        int i = 0, j = 0;
        while (i < metin.length()) {
            if (desen.charAt(j) == metin.charAt(i)) {
                i++; j++;
                if (j == desen.length()) {
                    eslesmeler.add(i - j);
                    j = lps[j - 1];
                }
            } else if (i < metin.length() && desen.charAt(j) != metin.charAt(i)) {
                j = j != 0 ? lps[j - 1] : 0;
                if (j == 0) i++;
            }
        }
        return eslesmeler;
    }
}
