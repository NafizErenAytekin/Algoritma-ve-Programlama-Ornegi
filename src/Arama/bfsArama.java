package Arama;

import java.util.*;

public class bfsArama {

    public static void bfsArama() {
        Scanner klavye = new Scanner(System.in);

        // Grafı kullanıcıdan al (örnek olarak basit bir graf yapısı)
        int[][] graph = {
                {0, 1, 1, 0}, // A düğümünün komşuları
                {1, 0, 1, 1}, // B düğümünün komşuları
                {1, 1, 0, 1}, // C düğümünün komşuları
                {0, 1, 1, 0}  // D düğümünün komşuları
        };

        System.out.print("Başlangıç düğümünü girin (A, B, C, D): ");
        String baslangicDugum = klavye.nextLine().toUpperCase();
        int baslangicIndex = baslangicDugum.charAt(0) - 'A'; // Harfi indekse çevir

        System.out.print("Hedef düğümü girin (A, B, C, D): ");
        String hedefDugum = klavye.nextLine().toUpperCase();
        int hedefIndex = hedefDugum.charAt(0) - 'A'; // Harfi indekse çevir

        bfs(graph, baslangicIndex, hedefIndex);
    }

    private static void bfs(int[][] graph, int start, int goal) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Gezinme Sırası: ");

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print((char) (u + 'A') + " "); // Düğümü harf olarak yazdır

            if (u == goal) {
                System.out.println("\nHedef düğüm (" + (char) (goal + 'A') + ") bulundu!");
                return;
            }

            for (int v = 0; v < V; v++) {
                if (graph[u][v] == 1 && !visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

        System.out.println("\nHedef düğüm (" + (char) (goal + 'A') + ") bulunamadı.");
    }
}
