package Day166;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    static void dfs(int node,List<List<Integer>> adj,int[] vis,List<Integer> ans){
        vis[node] = 1;
        ans.add(node);
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it, adj, vis, ans);
            }
        }
    }
    static List<Integer> traversal(int v,List<List<Integer>> adj){
        List<Integer> ans = new ArrayList<>();
        int[] vis = new int[v];
        dfs(0, adj, vis, ans);
        return ans;
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
        System.out.println(traversal(n, adj));
        sc.close();
    }
    
}
