package Day204;
import java.util.*;
public class TopoSort {
    static void dfs(List<List<Integer>> adj,int[] vis, Stack<Integer> st,int node){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(adj, vis, st, it);
            }
        }
        st.push(node);
        
    }
    static List<Integer> topoSort(List<List<Integer>> adj,int v){
        int[] vis = new int[v];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<v;i++){
            if(vis[i] == 0){
                dfs(adj, vis, st, i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!st.isEmpty()){
            ans.add(st.pop());
        }
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
        }
        System.out.println(topoSort(adj, n));
        sc.close();
    }
    
}
