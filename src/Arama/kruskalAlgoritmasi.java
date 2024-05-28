package Arama;

import java.util.Arrays;
import java.util.Scanner;

public class kruskalAlgoritmasi {

    public static void kruskalAlgoritmasi() {
        Scanner klavye = new Scanner(System.in);
        System.out.print("Düğüm sayısı: ");
        int V = klavye.nextInt();
        System.out.print("Kenar sayısı: ");
        int E = klavye.nextInt();

        Edge[] edges = new Edge[E];
        System.out.println("Kenarları ve ağırlıklarını girin (örnek: 0 1 4):");
        for (int i = 0; i < E; i++) {
            int src = klavye.nextInt();
            int dest = klavye.nextInt();
            int weight = klavye.nextInt();
            edges[i] = new Edge(src, dest, weight);
        }

        kruskalMST(V, edges);
    }

    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge otherEdge) {
            return this.weight - otherEdge.weight;
        }
    }

    private static void kruskalMST(int V, Edge[] edges) {
        Arrays.sort(edges);

        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int e = 0; // Eklenen kenar sayısı
        int i = 0; // edges dizisindeki index
        System.out.println("Minimum Spanning Tree:");
        while (e < V - 1) {
            Edge next_edge = edges[i++];

            int x = find(parent, next_edge.src);
            int y = find(parent, next_edge.dest);

            if (x != y) {
                System.out.println(next_edge.src + " - " + next_edge.dest + " : " + next_edge.weight);
                union(parent, x, y);
                e++;
            }
        }
    }

    private static int find(int[] parent, int i) {
        if (parent[i] == i) {
            return i;
        } else {
            return find(parent, parent[i]);
        }
    }

    private static void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }
}
