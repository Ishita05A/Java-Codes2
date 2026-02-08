package Day170;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DetectCycleInDirected {
    static boolean dfs(List<List<Integer>> adj,int[] vis,int[] pathVis,int node){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(adj, vis, pathVis, it)) return true;
            }
            else if(pathVis[it] == 1) return true;
        }
        vis[node] = 0;
        return false; 

    }
    static boolean isCyclic(List<List<Integer>> ans,int v){
        int[] vis = new int[v];
        int[] pathVis = new int[v];
        for(int i = 0;i<v;i++){
            if(vis[i] == 0 && pathVis[i] == 0){
                if(dfs(ans, vis, pathVis, i)) return true;
            }
        }
        return false;
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
        System.out.println(isCyclic(adj, n));
        sc.close();
    }
    
}
