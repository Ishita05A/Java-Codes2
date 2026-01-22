package Day161;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class DFS {
    static void traversal(int node,List<List<Integer>> adj,boolean[] vis,List<Integer> ans){
        vis[node] = true;
        ans.add(node);
        for(int it: adj.get(node)){
            if(vis[it] == false){
                traversal(it, adj, vis, ans);
            }
        }
    }
    static List<Integer> dfs(int V,List<List<Integer>> adj){
        boolean[] vis = new boolean[V];
        List<Integer> ans = new ArrayList<>(); 
        traversal(0, adj, vis, ans);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes");
        int n = sc.nextInt();
        System.out.println("Enter edges");
        int m = sc.nextInt();
        List<List<Integer>> arr = new ArrayList<>();
        for(int i =0;i<n;i++){
            arr.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
        System.out.println(dfs(n, arr));
        sc.close();
        

    }
    
}
