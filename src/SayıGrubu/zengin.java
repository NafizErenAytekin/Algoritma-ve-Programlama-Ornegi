package SayıGrubu;
import java.util.Scanner;

public class zengin {

    public static void zengin() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen bir sayı girin: ");
        int sayi = klavye.nextInt();

        if (isZenginSayi(sayi)) {
            System.out.println(sayi + " bir zengin sayıdır.");
        } else {
            System.out.println(sayi + " bir zengin sayı değildir.");
        }
    }

    private static boolean isZenginSayi(int sayi) {
        int bolenlerToplami = 0;
        for (int i = 1; i < sayi; i++) {
            if (sayi % i == 0) {
                bolenlerToplami += i;
            }
        }
        return bolenlerToplami > 2 * sayi;
    }
}
