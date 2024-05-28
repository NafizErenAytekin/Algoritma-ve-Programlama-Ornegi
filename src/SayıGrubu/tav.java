package SayıGrubu;
import java.util.Scanner;

public class tav {

    public static void tav() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen bir üst sınır girin (Tav sayılarını bu sınıra kadar arayacağız): ");
        int ustSinir = klavye.nextInt();

        System.out.println("Tav sayılar (" + ustSinir + "'e kadar):");
        for (int i = 1; i <= ustSinir; i++) {
            if (tavMı(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean tavMı(int sayi) {
        int temp = sayi;
        int rakamlarToplami = 0;

        while (temp > 0) {
            rakamlarToplami += temp % 10;
            temp /= 10;
        }

        return sayi % rakamlarToplami == 0 && rakamlarToplami != 1;
    }
}