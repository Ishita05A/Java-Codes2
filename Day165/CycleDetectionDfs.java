package Day165;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CycleDetectionDfs {
    
    static boolean detect(List<List<Integer>> adj,int[] vis,int node,int parent){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(detect(adj, vis, it, node)) return true;
            }
            else{
                if(parent != it) return true;
            }
        }
        return false;

    }
    static boolean isCyclic(List<List<Integer>> adj,int v){
        int[] vis = new int[v];
        for(int i = 0;i<v;i++){
            if(vis[i] == 0) {
                if(detect(adj, vis, i, -1)) return true;
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
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            ans.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            ans.get(u).add(v);
            ans.get(v).add(u);
        }
        System.out.println(isCyclic(ans, n));
        sc.close();
    }
    
}
