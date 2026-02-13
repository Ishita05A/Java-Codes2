package Day173;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DFS {
    static void dfs(List<List<Integer>> adj, int[] vis,List<Integer> ans,int node){
        vis[node] = 1;
        ans.add(node);
        for(int it : adj.get(node)){
            if(vis[it] == 0) dfs(adj, vis, ans, it);
        }
    }
    static List<Integer> dfs_traversal(List<List<Integer>> adj, int v){
        int[] vis = new int[v];
        List<Integer> ans = new ArrayList<>();
        dfs(adj, vis, ans, 0);
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
        System.out.println("Enter nodes");
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(dfs_traversal(adj, n));
        sc.close();
    }
    
}
