package SayıGrubu;
import java.util.Scanner;

public class ikiz {

    public static void ikiz() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen bir üst sınır girin (ikiz sayıları bu sınıra kadar arayacağız): ");
        int ustSinir = klavye.nextInt();

        System.out.println("İkiz sayılar (" + ustSinir + "'e kadar):");
        for (int i = 2; i <= ustSinir - 2; i++) {
            if (ikizMi(i) && ikizMi(i + 2)) {
                System.out.println("(" + i + ", " + (i + 2) + ")");
            }
        }
    }

    private static boolean ikizMi(int sayi) {
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