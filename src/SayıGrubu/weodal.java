package SayıGrubu;
import java.util.Scanner;

public class weodal {

    public static void weodal() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen bir üst sınır girin (Weodal sayıları bu sınıra kadar arayacağız): ");
        int ustSinir = klavye.nextInt();

        System.out.println("Weodal sayılar (" + ustSinir + "'e kadar):");
        for (int i = 2; i <= ustSinir; i++) {
            if (weodalMi(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean weodalMi(int n) {
        int sayi = n;
        int toplam = 0;
        int carpim = 1;

        while (sayi > 0) {
            int rakam = sayi % 10;
            toplam += rakam;
            carpim *= rakam;
            sayi /= 10;
        }

        return n % (toplam + carpim) == 0;
    }
}