package Arama;

import java.util.Arrays;
import java.util.Scanner;

public class primAlgoritmasi {

    public static void primAlgoritmasi() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Düğüm sayısı: ");
        int V = klavye.nextInt();

        int[][] graph = new int[V][V]; // Ağırlık matrisi
        System.out.println("Ağırlık matrisini girin (komşu olmayanlar için 0):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = klavye.nextInt();
            }
        }

        primMST(graph);
    }

    private static void primMST(int[][] graph) {
        int V = graph.length;
        int[] parent = new int[V]; // Her düğümün ebeveyni
        int[] key = new int[V]; // Düğümlerin MST'ye maliyeti
        boolean[] mstSet = new boolean[V]; // Düğümün MST'de olup olmadığı

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);

            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        // MST'yi yazdır (daha anlaşılır formatta)
        System.out.println("Minimum Spanning Tree:");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + " : " + graph[i][parent[i]]);
        }
    }

    private static int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < key.length; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
}
