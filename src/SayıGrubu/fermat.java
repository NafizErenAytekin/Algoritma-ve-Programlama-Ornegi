package SayıGrubu;
import java.util.Scanner;

public class fermat {

    public static void fermat()
    {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen bir sayı girin: ");
        int n = klavye.nextInt();

        if (fermatMı(n)) {
            System.out.println(n + " bir Fermat sayısıdır.");
        } else {
            System.out.println(n + " bir Fermat sayısı değildir.");
        }
    }

    private static boolean fermatMı(int n) {
        return (n > 0) && ((n & (n - 1)) == 0) && (isPowerOfTwo(n + 1));
    }

    private static boolean isPowerOfTwo(int n) {
        return (n != 0) && ((n & (n - 1)) == 0);
    }
}
