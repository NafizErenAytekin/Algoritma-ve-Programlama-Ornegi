package SayıGrubu;

import java.util.Scanner;

public class palindrom
{
    public static void palindrom() {
        Scanner klavye = new Scanner(System.in);

        System.out.print("Palindrom olup olmadığını kontrol etmek için bir metin giriniz: ");
        String metin = klavye.nextLine();

        if (metin.isEmpty()) {
            System.out.println("Geçersiz giriş. Lütfen bir metin giriniz.");
            return;
        }

        boolean palindromMu = palindromMu(metin);

        if (palindromMu) {
            System.out.println(metin + " bir palindromdur.");
        } else {
            System.out.println(metin + " bir palindrom değildir.");
        }
    }

    private static boolean palindromMu(String metin) {
        metin = metin.replaceAll("\\s", "");
        metin = metin.toLowerCase();

        int basamakSayisi = metin.length();

        for (int i = 0; i < basamakSayisi / 2; i++) {
            if (metin.charAt(i) != metin.charAt(basamakSayisi - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
