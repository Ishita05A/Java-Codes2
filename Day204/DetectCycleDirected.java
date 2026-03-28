package Day204;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DetectCycleDirected {
    static boolean dfs(List<List<Integer>> adj, int[] vis,int[] path,int node){
        vis[node] = 1;
        path[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it] == 0){
                if(dfs(adj, vis, path, it) == true) return true;
            }
            else if(path[it] != 0) return true;
        }
        path[node] = 0;
        return false;
    }
    static boolean isCyclic(List<List<Integer>> adj,int v){
        int[] vis = new int[v];
        int[] path = new int[v];
        for(int i = 0;i<v;i++){
            if(vis[i] == 0 ){
                if(dfs(adj, vis, path, i) == true) return true;
            }
        }
        return false;

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
        }
        System.out.println(isCyclic(adj, n));
        sc.close();


    }
    
}
