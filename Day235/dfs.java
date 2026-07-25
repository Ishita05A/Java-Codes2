package Day235;

import java.util.ArrayList;
import java.util.List;

public class dfs {
    static void dfs_(List<Integer> ans, int[][] adj, boolean[] vis,int node){
        vis[node] = true;
        ans.add(node);
        for(int it: adj[node]){
            if(!vis[it]){
                dfs_(ans, adj, vis, it);
            }
        }

    }
    static List<Integer> traversal(int V, int[][] edges){
        // List<List<Integer>> adj = new ArrayList<>();
        // for(int i = 0;i<V;i++){
        //     adj.add(new ArrayList<>());
        // }
        boolean[] vis = new boolean[V+1];
        // for(int i = 0;i<edges.length;i++){
        //     int u = edges[i][0];
        //     int v = edges[i][1];
        //     adj.get(u).add(v);
        //     adj.get(v).add(u);
        // }
        List<Integer> ans = new ArrayList<>();
        
                dfs_(ans, edges, vis, 1);
            
        return ans;
    }
    public static void main(String[] args) {
        int[][]  adj = {{},{2,3}, {1,4,5}, {1}, {2,5}, {4,5}};
        System.out.println(traversal(5, adj));
    }
    
}
