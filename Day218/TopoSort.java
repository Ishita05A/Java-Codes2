package Day218;
import java.util.*;
public class TopoSort {
    static void dfs(List<List<Integer>> adj, int[] vis,int node,Stack<Integer> st){
        vis[node] = 1;
        for(int it: adj.get(node)){
            if(vis[it] == 0){
                dfs(adj, vis, it,st);
            }
        }
        st.push(node);
    }
    static List<Integer> topo_sort(List<List<Integer>> adj,int v){
        int[] vis = new int[v];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<v;i++){
            if(vis[i] == 0){
                dfs(adj, vis, i, st);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
