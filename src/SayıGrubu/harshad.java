package SayıGrubu;
import java.util.Scanner;

public class harshad {

    public static void harshad() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen bir üst sınır girin (Harshad sayılarını bu sınıra kadar arayacağız): ");
        int ustSinir = klavye.nextInt();

        System.out.println("Harshad sayılar (" + ustSinir + "'e kadar):");
        for (int i = 1; i <= ustSinir; i++) {
            if (harshadMı(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean harshadMı(int sayi) {
        int temp = sayi;
        int rakamlarToplami = 0;

        while (temp > 0) {
            rakamlarToplami += temp % 10;
            temp /= 10;
        }

        return sayi % rakamlarToplami == 0;
    }
}