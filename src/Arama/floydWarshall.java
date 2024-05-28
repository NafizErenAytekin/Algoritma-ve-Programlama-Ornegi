package Arama;

import java.util.Arrays;
import java.util.Scanner;

public class floydWarshall {

    static final int INF = 99999; // Sonsuzluğu temsil eden büyük bir değer

    public static void floydWarshall() {
        Scanner klavye = new Scanner(System.in);

        System.out.print("Grafın kaç düğümü var? ");
        int V = klavye.nextInt();

        int[][] graph = new int[V][V];
        System.out.println("Grafın ağırlık matrisini girin (komşu olmayan düğümler için " + INF + " girin):");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = klavye.nextInt();
            }
        }

        floydWarshall(graph);

        System.out.println("Tüm düğüm çiftleri arasındaki en kısa mesafeler:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(graph[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    private static void floydWarshall(int[][] dist) {
        int V = dist.length;
        int[][] distance = new int[V][V];
        for (int i = 0; i < V; i++) {
            System.arraycopy(dist[i], 0, distance[i], 0, V);
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        // dist matrisini güncelle
        for (int i = 0; i < V; i++) {
            System.arraycopy(distance[i], 0, dist[i], 0, V);
        }
    }
}
