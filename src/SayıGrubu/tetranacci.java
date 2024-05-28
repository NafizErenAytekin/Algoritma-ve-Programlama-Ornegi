package SayıGrubu;
import java.util.Scanner;

public class tetranacci {

    public static void tetranacci() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen kaç tane Tetranacci sayısı görmek istediğinizi girin: ");
        int n = klavye.nextInt();

        System.out.print("İlk " + n + " Tetranacci sayısı: ");
        for (int i = 0; i < n; i++) {
            System.out.print(tetranacci(i) + " ");
        }
        System.out.println();
    }

    private static int tetranacci(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        } else if (n == 3) {
            return 1;
        } else {
            return tetranacci(n - 1) + tetranacci(n - 2) + tetranacci(n - 3) + tetranacci(n - 4);
        }
    }
}