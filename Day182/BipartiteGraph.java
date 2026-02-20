package Day182;

import java.util.*;
public class BipartiteGraph {
    static boolean dfs(List<List<Integer>> adj,int[] vis,int node,int color){
        vis[node] = color;
        for(int it : adj.get(color)){
            if(vis[it] == -1){
                if(dfs(adj, vis, it, 1-color) == false) return false;
            }
            else if(vis[it] == color) return false;
        }
        return true;
    }
    static boolean isBipartite(List<List<Integer>> adj,int v){
        int[] vis = new int[v];
        for(int i = 0;i<v;i++){
            vis[i] = -1;
        }
        for(int i = 0;i<v;i++){
            if(vis[i] == -1){
                if(dfs(adj, vis, i, 0) == false) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes");
        int n = sc.nextInt();
        System.out.println("Enter edges");
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter nodes");
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(isBipartite(adj, n));
        sc.close();
    }
    
}
