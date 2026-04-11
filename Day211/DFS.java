package Day211;
import java.util.*;
public class DFS {
    static void dfs(List<List<Integer>> adj, int[] vis,List<Integer> ans,int node){
        vis[node] = 1;
        ans.add(node);
        for(int it:adj.get(node)){
            if(vis[it] != 1){
                dfs(adj, vis, ans, it);
            }
        }
    }
    static List<Integer> dfs_traversal(List<List<Integer>> adj,int V){
        List<Integer> ans = new ArrayList<>();
        int[] vis = new int[V];
        for(int i = 0;i<V;i++){
            if(vis[i] == 0){
                dfs(adj, vis, ans, i);
            }
        }
        return ans;
    }
    static void bfs(List<List<Integer>> adj, int[] vis,List<Integer> ans,int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = 1;
        while(!q.isEmpty()){
            node  = q.poll();
            ans.add(node);
            for(int it : adj.get(node)){
                if(vis[it] != 1){
                    vis[it] = 1;
                    q.add(it);
                }
            }
        }
    }
    static List<Integer> bfs_trav(List<List<Integer>> adj,int V){
        List<Integer> ans = new ArrayList<>();
        int[] vis = new int[V];
        for(int i = 0;i<V;i++){
            if(vis[i] == 0){
                bfs(adj, vis, ans, i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n = sc.nextInt();
        System.out.println("Enter no. of edges");
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        System.out.println("Enter elements");
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        sc.close();
    }
    
}
