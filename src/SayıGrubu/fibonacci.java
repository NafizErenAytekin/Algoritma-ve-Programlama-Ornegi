package SayıGrubu;
import java.util.InputMismatchException;
import java.util.Scanner;

public class fibonacci {

    public static void fibonacciHesapla() {
        Scanner klavye = new Scanner(System.in);

        System.out.print("Hangi yöntemle hesaplamak istiyorsunuz? (1-Recursive, 2-Standart): ");
        int secim = klavye.nextInt();

        if (secim == 1) {
            System.out.print("Kaçıncı Fibonacci sayısını hesaplamak istiyorsunuz?: ");
            int n = klavye.nextInt();

            if (n < 0) {
                System.out.println("Geçersiz giriş. Lütfen 0 veya daha büyük bir tam sayı giriniz.");
                return;
            }

            System.out.println(n + ". Fibonacci sayısı: " + fibonacciRecursive(n));
        } else if (secim == 2) {
            System.out.print("Kaç tane Fibonacci sayısı hesaplamak istiyorsunuz?: ");
            int n = klavye.nextInt();

            if (n <= 0) {
                System.out.println("Geçersiz giriş. Lütfen 0'dan büyük bir tam sayı giriniz.");
                return;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(fibonacciStandart(i) + " ");
            }
        } else {
            System.out.println("Geçersiz seçim. Lütfen 1 veya 2 giriniz.");
        }
    }

    private static int fibonacciRecursive(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }
    }

    private static int fibonacciStandart(int n) {
        int[] dizi = new int[n + 1];

        dizi[0] = 0;
        dizi[1] = 1;

        for (int i = 2; i <= n; i++) {
            dizi[i] = dizi[i - 1] + dizi[i - 2];
        }
        return dizi[n];
    }
}