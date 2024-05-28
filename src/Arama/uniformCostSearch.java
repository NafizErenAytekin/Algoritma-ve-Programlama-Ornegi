package Arama;

import java.util.*;

public class uniformCostSearch {

    public static void uniformCostSearch() {
        Scanner klavye = new Scanner(System.in);

        // Grafı kullanıcıdan al (örnek olarak basit bir graf yapısı)
        int[][] graph = {
                {0, 1, 4, 0, 0, 0}, // A düğümünün komşuları ve maliyetleri
                {1, 0, 2, 5, 0, 0}, // B düğümünün komşuları ve maliyetleri
                {4, 2, 0, 1, 3, 0}, // C düğümünün komşuları ve maliyetleri
                {0, 5, 1, 0, 2, 2}, // D düğümünün komşuları ve maliyetleri
                {0, 0, 3, 2, 0, 1}, // E düğümünün komşuları ve maliyetleri
                {0, 0, 0, 2, 1, 0}  // F düğümünün komşuları ve maliyetleri
        };

        System.out.print("Başlangıç düğümünü girin (A, B, C, D, E, F): ");
        String baslangicDugum = klavye.nextLine().toUpperCase();
        int baslangicIndex = baslangicDugum.charAt(0) - 'A'; // Harfi indekse çevir

        System.out.print("Hedef düğümü girin (A, B, C, D, E, F): ");
        String hedefDugum = klavye.nextLine().toUpperCase();
        int hedefIndex = hedefDugum.charAt(0) - 'A'; // Harfi indekse çevir

        int[] mesafe = ucs(graph, baslangicIndex, hedefIndex);

        if (mesafe[hedefIndex] == Integer.MAX_VALUE) {
            System.out.println("Hedef düğüme ulaşılamadı.");
        } else {
            System.out.println("Başlangıç düğümünden hedef düğüme en kısa mesafe: " + mesafe[hedefIndex]);
            // İsterseniz burada yolu da bulabilirsiniz
        }
    }

    private static int[] ucs(int[][] graph, int start, int goal) {
        int V = graph.length;
        int[] mesafe = new int[V];
        Arrays.fill(mesafe, Integer.MAX_VALUE);
        mesafe[start] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(i -> mesafe[i]));
        queue.add(start);

        while (!queue.isEmpty()) {
            int u = queue.poll();

            if (u == goal) {
                return mesafe;
            }

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && mesafe[u] != Integer.MAX_VALUE && mesafe[u] + graph[u][v] < mesafe[v]) {
                    mesafe[v] = mesafe[u] + graph[u][v];
                    queue.add(v);
                }
            }
        }
        return mesafe;
    }
}
