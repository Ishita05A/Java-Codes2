package Day186;
import java.util.*;
public class bfs {
    
    static void bfs_traversal(List<List<Integer>> adj,int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        List<Integer> ans = new ArrayList<>();
        int[] vis = new int[v+1];
        vis[1] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for(int it : adj.get(node)){
                if(vis[it] == 0){
                    q.add(it);
                    vis[it] = 1;
                }
            }
        }
        System.out.println(ans);
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
            adj.get(v).add(u);
        }
        bfs_traversal(adj, n);
        sc.close();
    }
    
}
