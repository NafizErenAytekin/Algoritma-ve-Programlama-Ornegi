package SayıGrubu;
import java.util.Scanner;

public class armstrong
{
    public static void armstrong() {
        Scanner klavye = new Scanner(System.in);

        System.out.print("Armstrong sayısı olup olmadığını kontrol etmek için bir sayı giriniz: ");
        int sayi = klavye.nextInt();

        if (sayi <= 0) {
            System.out.println("Geçersiz giriş. Lütfen 0'dan büyük bir tam sayı giriniz.");
            return;
        }

        boolean armstrongSayıMı = armstrongSayıMı(sayi);

        if (armstrongSayıMı) {
            System.out.println(sayi + " bir Armstrong sayısıdır.");
        } else {
            System.out.println(sayi + " bir Armstrong sayısı değildir.");
        }
    }

    private static boolean armstrongSayıMı(int sayi) {
        int basamakSayisi = getBasamakSayisi(sayi);
        int toplam = 0;

        while (sayi > 0) {
            int basamak = sayi % 10;
            toplam += Math.pow(basamak, basamakSayisi);
            sayi /= 10;
        }
        return sayi == toplam;
    }

    private static int getBasamakSayisi(int sayi) {
        int count = 0;

        while (sayi > 0) {
            count++;
            sayi /= 10;
        }
        return count;
    }
}

