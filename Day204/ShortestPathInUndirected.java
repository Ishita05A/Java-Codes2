package Day204;

import java.util.*;

public class ShortestPathInUndirected {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static int[] shortestPath(int[][] arr, int n, int m, int src) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(arr[i][0]).add(arr[i][1]);
        }
        int[] dist = new int[n];
        for (int i = 0; i < n; i++)
            dist[i] = (int) 1e9;
        Queue<Integer> q = new LinkedList<>();
        dist[src] = 0;
        q.add(src);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int it : adj.get(node)) {
                if (dist[node] + 1 < dist[it]) {
                    dist[it] = dist[node] + 1;
                    q.add(it);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 0, 1 },
                { 0, 2 },
                { 1, 3 },
                { 2, 4 }
        };
        int[] ans = shortestPath(arr, 5, 4, 0);
        display(ans);
    }

}
