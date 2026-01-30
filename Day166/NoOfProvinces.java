package Day166;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoOfProvinces {
    static void dfs(int node,List<List<Integer>> adj, int[] vis){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it,adj,vis);
            }
        }
    }
    static int no_of_province(List<List<Integer>> ans,int v){
        int[] vis = new int[v];
        int count = 0;
        for(int i = 0;i<v;i++){
            if(vis[i] == 0){
                dfs(i, ans, vis);
                count++;
            }
        }
        return count;
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
        System.out.println(no_of_province(adj, n));
        sc.close();
    }
    
}
