package Arama;

import java.util.*;

public class dijkstraAlgoritmasi {

    public static void dijkstraAlgoritmasi() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Düğüm sayısı: ");
        int V = klavye.nextInt();

        int[][] graph = new int[V][V]; // Ağırlık matrisi
        System.out.println("Ağırlık matrisini girin (komşu olmayanlar için 0 girin):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = klavye.nextInt();
            }
        }

        System.out.print("Başlangıç düğümünü girin (0'dan " + (V - 1) + " arasında): ");
        int baslangicDugum = klavye.nextInt();

        dijkstra(graph, baslangicDugum);
    }

    private static void dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] distance = new int[V];
        boolean[] sptSet = new boolean[V];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(distance, sptSet);
            sptSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (!sptSet[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE &&
                        distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        printSolution(distance);
    }

    private static int minDistance(int[] dist, boolean[] sptSet) {
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < dist.length; v++) {
            if (!sptSet[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }

    private static void printSolution(int[] dist) {
        System.out.println("Düğüm \t Başlangıç Düğümüne Uzaklık");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}
