package Day219;
import java.util.*;
public class DAGShortestPath {
    static class Pair{
        int v;
        int dist;
        Pair(int v,int dist){
            this.v = v;
            this.dist = dist;
        }
    }
    static void topoSort(List<List<Pair>> adj, Stack<Integer> st,int[] vis,int node){
        vis[node] = 1;
        for(Pair it: adj.get(node)){
            int v = it.v;
            if(vis[v] == 0){
                topoSort(adj, st, vis, v);
            }
        }
        st.push(node);
    }
    static int[] shortestpath(int V, int[][] edges){
        int[] vis = new int[V];
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int dist = edges[i][2];
            adj.get(u).add(new Pair(v, dist)); 
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<V;i++){
            if(vis[i] == 0){
                topoSort(adj, st, vis, i);
            }
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        while(!st.isEmpty()){
            int top = st.pop();
            for(Pair it : adj.get(top)){
                int v = it.v;
                int dis = it.dist;
                if(dist[top] + dis< dist[v]){
                    dist[v] = dist[top] + dis;
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
        
    }
    
}
