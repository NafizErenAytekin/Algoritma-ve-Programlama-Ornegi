package SayıGrubu;
import java.util.Scanner;

public class lucas {

    public static void lucas() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen kaç tane Lucas sayısı görmek istediğinizi girin: ");
        int n = klavye.nextInt();

        System.out.print("İlk " + n + " Lucas sayısı: ");
        for (int i = 0; i < n; i++) {
            System.out.print(lucas(i) + " ");
        }
        System.out.println();
    }

    private static int lucas(int n) {
        if (n == 0) {
            return 2;
        } else if (n == 1) {
            return 1;
        } else {
            return lucas(n - 1) + lucas(n - 2);
        }
    }
}