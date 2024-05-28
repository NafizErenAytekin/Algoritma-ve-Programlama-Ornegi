import SayıGrubu.*;
import Sıralama.*;
import Arama.*;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner klavye = new Scanner(System.in);
        System.out.println("Öğrenci Numarası: 202313172040");
        System.out.println("Adı Soyadı: Nafız Eren AYTEKİN");
        System.out.println("Derse Kayıtlı Olduğu Öğretim Grubu: 2.Öğretim");
        System.out.println("Hangi bölümü seçmek istiyorsunuz?");
        System.out.println("1- Sayı Grubu Algoritmaları");
        System.out.println("2- Sıralama Algoritmaları");
        System.out.println("3- Arama Algoritmaları");

        int a = klavye.nextInt();

        switch (a)
        {
            case 1 ->
            {
                System.out.println("Çalıştırmak istediğiniz sayı grubunun rakamını seçiniz:");
                System.out.println("""
                        1- Mükemmel Sayı
                        2- Fibonacci Sayıları (a) Recursive olarak (b) standart çalıştırma
                        3- Armstrong sayısı
                        4- Tribonacci Sayılar
                        5- Palindrom Sayılar
                        6- Cullen Sayıları
                        7- Lasa Sayısı
                        8- Fermat sayıları
                        9- Dost Sayılar
                        10- Zengin Sayılar
                        11- Lucas Serisi
                        12- Tetranacci Sayılar
                        13- İkiz Sayılar
                        14- Weodal Sayılar
                        15- Mersenne Sayılar
                        16- Harshad Sayılar
                        17- Cyclic (Döngüsel Sayılar)
                        18- Tav Sayılar
                        19- Bağdaşık Sayılar (Amicable)
                        20- 6174 sayısı""");
                int y = klavye.nextInt();
                switch (y)
                {
                    case 1 -> mukemmel.mukemmel();
                    case 2 -> fibonacci.fibonacciHesapla();
                    case 3 -> armstrong.armstrong();
                    case 4 -> tribonacci.tribonacci();
                    case 5 -> palindrom.palindrom();
                    case 6 -> cullen.cullen();
                    case 7 -> lasa.lasa();
                    case 8 -> fermat.fermat();
                    case 9 -> dost.dost();
                    case 10 -> zengin.zengin();
                    case 11 -> lucas.lucas();
                    case 12 -> tetranacci.tetranacci();
                    case 13 -> ikiz.ikiz();
                    case 14 -> weodal.weodal();
                    case 15 -> mersenne.mersenne();
                    case 16 -> harshad.harshad();
                    case 17 -> cyclic.cyclic();
                    case 18 -> tav.tav();
                    case 19 -> bagdasik.bagdasik();
                    case 20 -> sayi6174.sayi6174();
                }
            }
            case 2 ->
            {
                System.out.println("Çalıştırmak istediğiniz sıralama algoritmasının rakamını seçiniz:");
                System.out.println("""
                        1- Insertion Sort (Eklemeli Sıralama )
                        2- Selection Sort (Seçmeli Sıralama)
                        3- Bubble Sort (Kabarcık/Baloncuk sıralama)
                        4- Divide and Conquer Sort (Böl ve Ayıkla Algoritması) (Counting Sort ile)
                        5- Shell Sort
                        6- Merge Sort
                        7- Quick Sort
                        8- Quick Sort 3
                        9- Heap Sort (Yığınlama)
                        10- Radix Sort (Taban Sıralama)
                        11- Shaker Sort (Sallama Sıralama)
                        12- Random Sort(Rastgele Sıralama)
                        13- Lucky Sort (Şanslı Sıralama)
                        14- Serseri Sort (Stooge)
                        15- Flash Sort (Şimşek Sıralama)
                        16- Comb Sort (Tarak sıralama)
                        17- Gnome Sort
                        18- Permütasyon Sort (Perm Sort)
                        19- Strand Sort (Tel Sıralama)
                        20- Kova Sort""");
                int z = klavye.nextInt();
                switch (z)
                {
                    case 1 -> insertionSort.insertionSort();
                    case 2 -> selectionSort.selectionSort();
                    case 3 -> bubbleSort.bubbleSort();
                    case 4 -> countingSort.countingSort();
                    case 5 ->shellSort.shellSort();
                    case 6 ->mergeSort.mergeSort();
                    case 7 ->quickSort.quickSort();
                    case 8 ->quickSort3.quickSort3();
                    case 9 ->heapSort.heapSort();
                    case 10 ->radixSort.radixSort();
                    case 11 ->shakerSort.shakerSort();
                    case 12 ->randomSort.randomSort();
                    case 13 ->luckySort.luckySort();
                    case 14 ->serseriSort.serseriSort();
                    case 15 ->flashSort.flashSort();
                    case 16 ->combSort.combSort();
                    case 17 ->gnomeSort.gnomeSort();
                    case 18 ->permSort.permSort();
                    case 19 ->strandSort.strandSort();
                    case 20 ->kovaSort.kovaSort();
                }
            }
            case 3 ->
            {
                System.out.println("Çalıştırmak istediğiniz arama algoritmasının rakamını seçiniz:");
                System.out.println("""
                       1- Doğrusal Arama (Linear Search)
                       2- İkili arama (binary search)
                       3- Interpolasyon Araması (Ara değer araması, Interpolation Search)
                       4- Şekiller (graflar (Graphs) ) üzerinde çalışan algoritmalar [Breadth-First Search (BFS - Genişlik Öncelikli Arama) ile]
                       5- Sabit Maliyetli Arama (Uniform Cost Search)
                       6- Floyd Warshall algoritması
                       7- Prim’s Algoritması
                       8- Kruskal Algoritması
                       9- Dijkstra Algoritması
                       10- Bellman Ford Algoritması
                       11- İkili arama ağacı (Binary Search Tree)
                       12- Prüfer dizilimi
                       13- Metin arama algoritmaları (bir yazı içerisinde belirli bir dizgiyi (string) arayan algoritmalar)
                       14- Horspool Arama Algoritması
                       15- Kaba Kuvvet Metin Arama Algoritması (Brute Force Text Search, Linear Text Search""");

                int b = klavye.nextInt();

                switch (b)
                {
                    case 1 -> linearSearch.linearSearch();
                    case 2 -> binarySearch.binarySearch();
                    case 3 -> interpolationSearch.interpolationSearch();
                    case 4 -> bfsArama.bfsArama();
                    case 5 -> uniformCostSearch.uniformCostSearch();
                    case 6 -> floydWarshall.floydWarshall();
                    case 7 -> primAlgoritmasi.primAlgoritmasi();
                    case 8 -> kruskalAlgoritmasi.kruskalAlgoritmasi();
                    case 9 -> dijkstraAlgoritmasi.dijkstraAlgoritmasi();
                    case 10 -> bellmanFordAlgoritmasi.bellmanFordAlgoritmasi();
                    case 11 -> binarySearchTree.binarySearchTree();
                    case 12 -> pruferDizilimi.pruferDizilimi();
                    case 13 -> metinAramaKMP.metinAramaKMP();
                    case 14 -> horspoolArama.horspoolArama();
                    case 15 -> kabaKuvvetArama.kabaKuvvetArama();
                }
            }
        }
    }
}
