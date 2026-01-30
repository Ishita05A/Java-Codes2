package Day166;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DetectCycleUsingDFS {
    static class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    static boolean dfs(int node,int parent,List<List<Integer>> adj,int[] vis){
        vis[node] =1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(it, node, adj, vis)) return true;
            } 
            else if(it !=  parent) return true;
        }
        return false;
    }
    static boolean detectCycle(List<List<Integer>> adj,int v){
        int[] vis = new int[v];

        for(int i = 0;i<v;i++){
            if(vis[i] == 0){
                if(dfs(i,-1,adj,vis)) return true;
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
        for(int i =0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(detectCycle(adj, n));
        sc.close();
    }  
}
