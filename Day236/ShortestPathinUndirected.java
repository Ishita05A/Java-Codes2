package Day236;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathinUndirected {
    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static int[] shortestPath(int V, int[][] edges, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        dist[src] = 0;
        while (!q.isEmpty()) {
            Pair top = q.poll();
            int node = top.node;
            int dis = top.dist;
            for (int it : adj.get(node)) {
                if (dis + 1 < dist[it]) {
                    dist[it] = dis + 1;
                    q.add(new Pair(it, dis + 1));
                }
            }
        }
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return new int[] { -1 };
        }
        return dist;

    }

    public static void main(String[] args) {
        int V = 9;

        int[][] edges = {
                { 0, 1 },
                { 0, 3 },
                { 1, 2 },
                { 2, 6 },
                { 3, 4 },
                { 4, 5 },
                { 5, 6 },
                { 6, 7 },
                { 7, 8 }
        };

        int src = 0;

        int[] ans = shortestPath(V, edges, src);

        System.out.println("Shortest Distance from Source " + src + ":");
        for (int i = 0; i < ans.length; i++) {
            System.out.println("Node " + i + " -> " + ans[i]);
        }
    }

}
