package Arama;

import java.util.Arrays;
import java.util.Scanner;

public class bellmanFordAlgoritmasi {
    public static void bellmanFordAlgoritmasi() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Düğüm sayısı: ");
        int V = klavye.nextInt();
        System.out.print("Kenar sayısı: ");
        int E = klavye.nextInt();

        int[][] edges = new int[E][3]; // Kaynak, hedef, ağırlık
        System.out.println("Kenarları ve ağırlıklarını girin (örnek: 0 1 4):");
        for (int i = 0; i < E; i++) {
            edges[i][0] = klavye.nextInt();
            edges[i][1] = klavye.nextInt();
            edges[i][2] = klavye.nextInt();
        }

        System.out.print("Başlangıç düğümünü girin (0'dan " + (V - 1) + " arasında): ");
        int src = klavye.nextInt();

        bellmanFord(V, edges, src);
    }

    private static void bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 1; i < V; ++i) { // V-1 kez gevşetme işlemi
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int weight = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Negatif ağırlıklı döngü kontrolü
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graf negatif ağırlıklı döngü içeriyor.");
                return;
            }
        }

        printSolution(dist);
    }

    private static void printSolution(int[] dist) {
        System.out.println("Düğüm \t Başlangıç Düğümüne Uzaklık");
        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }
}
