package Day170;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TopologicalSort {
    static void dfs(List<List<Integer>> adj,int[] vis,Stack<Integer> st,int node){
        vis[node] = 1;
        for(int it:adj.get(node)){
            if(vis[it] == 0){
                dfs(adj, vis, st, it);
            }
        }
        st.push(node);
    } 
    static List<Integer> topoAlgo(List<List<Integer>> adj,int v){
        List<Integer> ans = new ArrayList<>();
        int[] vis = new int[v];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<v;i++){
            if(vis[i] == 0) dfs(adj, vis, st, i);
        }
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
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
            
        }
        System.out.println(topoAlgo(adj, n));
        sc.close();
    }
    
}
