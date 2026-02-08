package Day170;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BipartiteGraph {
    static boolean dfs(List<List<Integer>> adj,int[] vis,int color,int node){
        vis[node] = color;
        for(int it:adj.get(node)){
            if(vis[it] == color) return false;
            else if(vis[it] == -1){
                if(dfs(adj, vis, 1-color, it) == false) return false;
            }
        }
        return true;
    }
    static boolean isBipartite(List<List<Integer>> adj,int v){
        int[] vis = new int[v];
        for(int i = 0;i<v;i++) vis[i] = -1; 
        return dfs(adj, vis, 0, 0);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes");
        int n = sc.nextInt();
        System.out.println("Enter no. of edges");
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(isBipartite(adj, m));
        sc.close();
    }
    
}
