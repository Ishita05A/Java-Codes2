package Day193;
import java.util.*;

import Day110.pascalaTriangle;
public class DetectACycleInUndirected {
    static class Pair{
        int node;
        int parent;
        Pair(int node,int parent){
            this.node = node;
            this.parent = parent;
        }
    }
    static boolean bfs(List<List<Integer>> adj,int[] vis, int node){
        Queue<Pair> q = new LinkedList<>();
        vis[node] = 1;
        q.add(new Pair(node, -1));
        while(!q.isEmpty()){
            Pair top = q.poll();
            node = top.node;
            int parent = top.parent;
             for(int it : adj.get(node)){
                if(vis[it] == 0){
                    vis[it] = 1;
                    q.add(new Pair(it, node));
                }
                else if(it != parent) return true;
             }
        }
        return false;
    }
    static boolean isCyclic(List<List<Integer>> adj,int v){
        int[] vis = new int[v];
        for(int i = 0;i<v;i++){
            if(vis[i] == 0){
                if(bfs(adj, vis, i) == true) return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes");
        int n = sc.nextInt();
        System.out.println("Enter no. of edges");
        int m = sc.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(isCyclic(adj, n));
        sc.close();
    }
}
