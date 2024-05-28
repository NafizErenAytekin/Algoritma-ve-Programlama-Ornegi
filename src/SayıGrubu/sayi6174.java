package SayıGrubu;
import java.util.Arrays;
import java.util.Scanner;

public class sayi6174 {

    public static void sayi6174() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen dört basamaklı bir sayı girin: ");
        int sayi = klavye.nextInt();

        if (sayi < 1000 || sayi > 9999) {
            System.out.println("Hatalı giriş! Lütfen dört basamaklı bir sayı girin.");
            return;
        }

        int tekrar = 0;
        while (sayi != 6174) {
            sayi = kaprekarIslemi(sayi);
            tekrar++;
        }

        System.out.println(tekrar + " tekrar sonra 6174 sayısına ulaşıldı.");
    }

    private static int kaprekarIslemi(int sayi) {
        char[] rakamlar = String.valueOf(sayi).toCharArray();
        Arrays.sort(rakamlar);
        int kucukSayi = Integer.parseInt(new String(rakamlar));
        int buyukSayi = Integer.parseInt(new StringBuilder(new String(rakamlar)).reverse().toString());
        return buyukSayi - kucukSayi;
    }
}