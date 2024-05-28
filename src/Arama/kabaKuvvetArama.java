package Arama;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class kabaKuvvetArama {
    public static void kabaKuvvetArama() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Metin: ");
        String metin = klavye.nextLine();
        System.out.print("Desen: ");
        String desen = klavye.nextLine();

        List<Integer> eslesmeler = kabaKuvvetAra(metin, desen);
        System.out.println(eslesmeler.isEmpty() ? "Desen bulunamadı." : "Desen şu indekslerde bulundu: " + eslesmeler);
    }

    private static List<Integer> kabaKuvvetAra(String metin, String desen) {
        List<Integer> eslesmeler = new ArrayList<>();
        int M = metin.length();
        int N = desen.length();

        for (int i = 0; i <= M - N; i++) {
            int j;
            for (j = 0; j < N; j++) {
                if (metin.charAt(i + j) != desen.charAt(j)) {
                    break;
                }
            }
            if (j == N) { // Eşleşme bulundu
                eslesmeler.add(i);
            }
        }
        return eslesmeler;
    }
}
