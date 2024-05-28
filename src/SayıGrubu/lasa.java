package SayıGrubu;
import java.util.Scanner;


public class lasa {

    public static void lasa() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen bir sayı girin: ");
        int n = klavye.nextInt();

        if (lasaMı(n)) {
            System.out.println(n + " bir LASA sayısıdır.");
        } else {
            System.out.println(n + " bir LASA sayısı değildir.");
        }
    }

    private static boolean lasaMı(int n) {
        int i = 1;
        while (lasaHesap(i) < n) {
            i++;
        }
        return lasaHesap(i) == n;
    }

    private static int lasaHesap(int n) {
        int lasa = 1;
        for (int j = 2; j <= n; j++) {
            lasa += j * (j - 1);
        }
        return lasa;
    }
}
