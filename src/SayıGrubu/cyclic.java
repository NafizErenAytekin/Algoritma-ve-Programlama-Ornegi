package SayıGrubu;
import java.util.Scanner;

public class cyclic {

    public static void cyclic() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen bir sayı girin: ");
        int sayi = klavye.nextInt();

        if (cyclicMi(sayi)) {
            System.out.println(sayi + " bir döngüsel sayıdır.");
        } else {
            System.out.println(sayi + " bir döngüsel sayı değildir.");
        }
    }

    private static boolean cyclicMi(int sayi) {
        int n = sayi;
        int basamakSayisi = 0;
        do {
            basamakSayisi++;
            n /= 10;
        } while (n > 0);

        n = sayi;
        do {
            int rakam = n % 10;
            int yeniSayi = (int) (rakam * Math.pow(10, basamakSayisi - 1)) + (n / 10);
            if (yeniSayi != sayi && yeniSayi != 0 && yeniSayi % sayi != 0) {
                return false;
            }
            n = yeniSayi;
        } while (n != sayi);

        return true;
    }
}