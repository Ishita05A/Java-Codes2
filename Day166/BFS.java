package Day166;

import java.util.*;
public class BFS {
    
    static List<Integer> bfs(List<List<Integer>> adj, int v){
        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[v];
        List<Integer> ans = new ArrayList<>();
        q.add(0);
        vis[0] = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(int it: adj.get(node)){
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(it);
                }
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
        for(int i =0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(bfs(adj, n));
        sc.close();

    }
    
}
