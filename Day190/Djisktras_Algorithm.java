package Day190;
import java.util.*;
public class Djisktras_Algorithm {
    static  class Pair{
        int node;
        int dist;
        Pair(int dist,int node){
            this.dist = dist;
            this.node = node;
        }
    }
    static List<Integer> djisktraAlgo(List<List<Integer>> adj,int v,int src){
        int[] dist = new int[v];
        int n = adj.size();
        for(int i = 0;i<v;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        int[] parent = new int[v];
        PriorityQueue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(0, src));
        while (!q.isEmpty()){
            Pair top = q.poll();
            int node = top.node;
            int wt = top.dist;
            for(int i = 0;i<2;i++){
                int edW = adj.get(node).get(i);
                int it = adj.get(node).get(i);
                if(edW+wt < dist[it]){
                    dist[it] = edW+wt;
                    parent[it] = node;
                    q.add(new Pair(edW+wt, it));
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        for(int i = 0;i<v;i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        int node  = n;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(src);
        Collections.reverse(path);
        return path;
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
            adj.get(i).add(u);
            adj.get(i).add(v);
        }
        System.out.println(djisktraAlgo(adj, n, 0));
        sc.close();

    }
    
}
