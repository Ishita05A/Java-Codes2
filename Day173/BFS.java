package Day173;

import java.util.*;

public class BFS {
    static List<Integer> bfs(List<List<Integer>> adj,int V){
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        int[] vis = new int[V];
        q.add(0);
        
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            vis[node] = 1;
            for(int it : adj.get(node)){
                if(vis[it] == 0) q.add(it);
            }
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
            adj.get(v).add(u);
        }
        System.out.println(bfs(adj, n));
        sc.close();
    }
    
}
