package SayıGrubu;

import java.util.*;

public class mukemmel
{
    public static void mukemmel()
    {
        Scanner klavye = new Scanner(System.in);
        System.out.println("İstediğiniz sayıyı giriniz :");

        int x = klavye.nextInt();
        int toplam =0;
        for(int i = 1; i < x; i++)
        {
            if (x % i == 0)
            {
                toplam += i;
            }
        }
        if (toplam==x)
        {
            System.out.println(x +" Sayısı mükemmel sayıdır.");
        }
        else
            System.out.println(x+" Sayısı mükemmel sayı değildir.");
    }
}