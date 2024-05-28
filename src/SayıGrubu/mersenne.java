package SayıGrubu;
import java.util.Scanner;

public class mersenne {

    public static void mersenne() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen bir üst sınır girin (Mersenne sayılarını bu üsse kadar arayacağız): ");
        int ustSinir = klavye.nextInt();

        System.out.println("Mersenne sayıları (2^p-1 şeklinde, p " + ustSinir + "'e kadar):");
        for (int p = 2; p <= ustSinir; p++) {
            if (mersanneMi(p)) {
                long mersenne = (long) Math.pow(2, p) - 1;
                if (mersanneMi(mersenne)) {
                    System.out.println(mersenne + " (p = " + p + ")");
                }
            }
        }
    }

    private static boolean mersanneMi(long sayi) {
        if (sayi <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(sayi); i++) {
            if (sayi % i == 0) {
                return false;
            }
        }
        return true;
    }
}