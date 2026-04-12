package Day212;

import java.util.*;
public class ShortestPathInDAG {
    static void topoSort(int[][] edges,int[] vis,int node,Stack<Integer> st){
        vis[node] = 1;
        for(int it[]: edges){
            int u = it[0];
            int v = it[1];
            if(u == node && vis[v] == 0){
                topoSort(edges, vis, v, st);
            }
        }
        st.push(node);
    }
    static int[] shortestDist(int[][] edges , int V){
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<V;i++){
            if(vis[i] == 0){
                topoSort(edges, vis, i, st);
            }
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while (!st.isEmpty()){
            int node = st.pop();
            for(int it[]: edges){
                int u = it[0];
                int v = it[1];
                int d = it[2];
                if(u == node){
                    if(dist[u] != Integer.MAX_VALUE && dist[v] > d+dist[u]){
                        dist[v] = d+dist[u];
                    }
                }
            }
        }
        for(int i = 0;i<V;i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
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
        }
    }
    
}
