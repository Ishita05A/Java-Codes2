package Day189;
import java.util.*;
public class DetectACycle {
    static boolean dfs(List<List<Integer>> adj,int[] vis,int[] pathPath,int node){
        vis[node] = 1;
        pathPath[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfs(adj, vis, pathPath, it) == true) return true;
            }
            else if(pathPath[it] == 1) return true;
        }
        return false;
    }
    static boolean isCyclic_dfs(int v,List<List<Integer>> adj){
        int[] vis = new int[v+1];
        int[] pathVis = new int[v+1];
        for(int i = 0;i<v;i++){
            if(vis[i] == 0){
                if(dfs(adj, vis, pathVis, i) == true) return true;
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
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
        }
        System.out.println(isCyclic_dfs(n, adj));
        sc.close();
    }
    
}
