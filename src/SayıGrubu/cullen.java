package SayıGrubu;
import java.util.Scanner;

public class cullen {

    private static int n;

    public static void cullen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hesaplamak için bir sayı giriniz: ");
        n = scanner.nextInt();

        if (n < 1) {
            throw new IllegalArgumentException("n değeri 1'den küçük olamaz.");
        }

        long cullenSayisi = 1;
        System.out.println("** Cullen Sayısı Hesaplama**");
        System.out.println("**Başlangıç değeri:** " + n);

        long sayi = (long) Math.pow(2, n);
        System.out.println("- 2 üzeri n: " + sayi);

        cullenSayisi *= sayi * n;
        System.out.println("- 2 üzeri n * n: " + cullenSayisi);

        cullenSayisi += 1;
        System.out.println("- 1 ekleme: " + cullenSayisi);

        System.out.println("\n**Sonuç:**");
        System.out.println("Hesapladığınız Cullen Sayısı: " + cullenSayisi);
    }
}