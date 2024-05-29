package Sıralama;
import java.util.Arrays;
import java.util.Scanner;

public class bubbleSort
{
    public static void bubbleSort()
    {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < sayilar.length - 1; i++)
        {
            for (int j = 0; j < sayilar.length - i - 1; j++)
            {
                if (sayilar[j] > sayilar[j + 1])
                {
                    int temp = sayilar[j];
                    sayilar[j] = sayilar[j + 1];
                    sayilar[j + 1] = temp;
                }
            }
        }
        System.out.println("Sıralanmış dizi: " + Arrays.toString(sayilar));
    }
}