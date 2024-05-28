package Sıralama;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class strandSort {

    public static void strandSort() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Lütfen sıralamak istediğiniz sayıları virgülle ayırarak girin: ");
        String girdi = klavye.nextLine();
        int[] sayilar = Arrays.stream(girdi.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> sirali = strandSort(Arrays.stream(sayilar).boxed().toList());

        int[] siraliArray = sirali.stream().mapToInt(i -> i).toArray();
        System.out.println("Strand Sort ile sıralanmış dizi: " + Arrays.toString(siraliArray));
    }

    private static List<Integer> strandSort(List<Integer> list) {
        if (list.isEmpty()) {
            return list;
        }

        List<Integer> result = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        sublist.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > sublist.get(sublist.size() - 1)) {
                sublist.add(list.get(i));
            } else {
                result = merge(result, sublist);
                sublist.clear();
                sublist.add(list.get(i));
            }
        }
        return merge(result, sublist);
    }

    private static List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                result.add(a.get(i++));
            } else {
                result.add(b.get(j++));
            }
        }
        while (i < a.size()) {
            result.add(a.get(i++));
        }
        while (j < b.size()) {
            result.add(b.get(j++));
        }
        return result;
    }
}