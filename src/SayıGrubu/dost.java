package SayıGrubu;
import java.util.Scanner;

public class dost {

    public static void dost() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen birinci sayıyı girin: ");
        int sayi1 = klavye.nextInt();
        System.out.print("Lütfen ikinci sayıyı girin: ");
        int sayi2 = klavye.nextInt();

        if (isDostSayilar(sayi1, sayi2)) {
            System.out.println(sayi1 + " ve " + sayi2 + " dost sayılardır.");
        } else {
            System.out.println(sayi1 + " ve " + sayi2 + " dost sayılar değildir.");
        }
    }

    private static boolean isDostSayilar(int sayi1, int sayi2) {
        int toplam1 = bolenlerinToplami(sayi1);
        int toplam2 = bolenlerinToplami(sayi2);
        return (toplam1 == sayi2) && (toplam2 == sayi1);
    }

    private static int bolenlerinToplami(int sayi) {
        int toplam = 1; // 1 her zaman bölendir
        for (int i = 2; i <= Math.sqrt(sayi); i++) {
            if (sayi % i == 0) {
                toplam += i;
                if (i != sayi / i) { // Kendisi hariç diğer böleni de ekle
                    toplam += sayi / i;
                }
            }
        }
        return toplam;
    }
}
