package Day193;

import java.util.*;
public class Bfs {
    static void bfs(List<List<Integer>> adj, List<Integer> ans,int[] vis,int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = 1;
        while(!q.isEmpty()){
            node = q.poll();
            ans.add(node);
            for(int it:adj.get(node)){
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(it);
                }
            }
        }
    }
    static List<Integer> bfs_traversal(List<List<Integer>> adj, int v){
        int[] vis = new int[v];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<v;i++){
            if(vis[i] == 0)
            bfs(adj, ans, vis, i);
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
        System.out.println(bfs_traversal(adj, n));
        sc.close();
    }
    
}
