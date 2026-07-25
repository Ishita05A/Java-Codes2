package Day235;

import java.util.*;
public class ConnectedComponent {
    static void bfs(List<List<Integer>> adj,boolean[] vis,int e){
        Queue<Integer> q = new LinkedList<>();
        q.add(e);
        while (!q.isEmpty()){
            int node = q.poll();
            for(int it:adj.get(node)){
                if(!vis[it]){
                    q.add(it);
                    vis[it] = true;
                }
            }
        }
    }
    static int findTotalConnected(int V, int[][] edges){
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[V];
        int cnt = 0;
        for(int i = 0;i<V;i++){
            if(!vis[i]){
                vis[i] = true;
                bfs(adj, vis, i);
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        // int[][] edges={{0,1},{1,2}};
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {4, 5}};
        System.out.println(findTotalConnected(7, edges));
    }
    
}
