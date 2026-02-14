package Day174;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class isCyclic_dfs {
    static boolean dfs(int[] vis,List<List<Integer>> adj,int node,int parent){
        vis[node] = 1;
        for(int it:adj.get(node)){
            if(vis[it] == 0){
                if(dfs(vis, adj, it, node)) return true;
            }
            else if(it != parent) return true; 
        }
        return false;
    }
    static boolean isCyclic(int v,List<List<Integer>> adj){
        int[] vis = new int[v];
        return dfs(vis, adj, 0, -1);

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
        System.out.println(isCyclic(n, adj));
        sc.close();
    }
    
}
