package SayıGrubu;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class tribonacci
{
    public static void tribonacci() {
        Scanner klavye = new Scanner(System.in);

        System.out.print("Tribonacci dizisini kaç elemanlı oluşturmak istiyorsunuz? (En az 3): ");
        int elemanSayisi = klavye.nextInt();

        if (elemanSayisi < 3) {
            System.out.println("Geçersiz giriş. Tribonacci dizisi en az 3 elemandan oluşmalıdır.");
            return;
        }

        System.out.print("Tribonacci dizisine kontrol etmek için bir sayı giriniz: ");
        int kontrolSayisi = klavye.nextInt();

        List<Integer> tribonacciDizisi = tribonacciDizisiOlustur(elemanSayisi);

        boolean tribonacciSayıMı = tribonacciDizisiIcindeMi(tribonacciDizisi, kontrolSayisi);

        System.out.println("Tribonacci Dizisi: " + tribonacciDizisi);
        System.out.println(kontrolSayisi + (tribonacciSayıMı ? " bu dizide yer alır." : " bu dizide yer almaz."));
    }

    private static List<Integer> tribonacciDizisiOlustur(int elemanSayisi) {
        List<Integer> tribonacciDizisi = new ArrayList<>();

        tribonacciDizisi.add(0);
        tribonacciDizisi.add(1);
        tribonacciDizisi.add(1);

        for (int i = 3; i < elemanSayisi; i++) {
            int yeniTribonacciSayısı = tribonacciDizisi.get(i - 1) + tribonacciDizisi.get(i - 2) + tribonacciDizisi.get(i - 3);
            tribonacciDizisi.add(yeniTribonacciSayısı);
        }

        return tribonacciDizisi;
    }

    private static boolean tribonacciDizisiIcindeMi(List<Integer> tribonacciDizisi, int kontrolSayisi) {
        return tribonacciDizisi.contains(kontrolSayisi);
    }
}

