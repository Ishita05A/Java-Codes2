package Day211;
import java.util.*;
public class DetectACycleInUndirected {
    static boolean dfs(List<List<Integer>> adj, int[] vis, int parent,int node){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] != 1){
                if(dfs(adj, vis, node, it)== true) return true;
                
            }
            else if(it!= parent) return true;
        }
        return false;
    }
    
    static boolean isCyclic(List<List<Integer>> adj, int V){
        int[] vis = new int[V];
        for(int i = 0;i<V;i++){
            if(vis[i] == 0){
                if(dfs(adj, vis, -1, i) == true) return true;
            }
        }
        return false;

    }
    public static void main(String[] args) {
        
    }
    
}
