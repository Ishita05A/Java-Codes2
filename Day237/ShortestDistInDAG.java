package Day237;

import java.util.*;
public class ShortestDistInDAG {
    static class Pair{
        int node;
        int dis;
        Pair(int node,int dis){
            this.dis = dis;
            this.node = node;
        }
    }
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static int[] shortest(int V,int[][] edges){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int d = edges[i][2];
            adj.get(u).add(new Pair(v, d));
        }
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i<size;i++){
                Pair top = q.poll();
                int node = top.node;
                int dis = top.dis;
                for(Pair it : adj.get(node)){
                    if(dis + it.dis < dist[it.node]){
                        dist[it.node] = dis+it.dis;
                        q.add(new Pair(it.node, dis+it.dis));
                    }
                }
            }
        
        }
        return dist;

    }
    public static void main(String[] args) {
        int[][] edges = {{0,4,2}, {0,5,3}, {5,4,1}, {4,6,3}, {4,2,1}, {6,1,2}, {2,3,3}, {1,3,1}};
        int[] dist = shortest(7, edges);
        display(dist);
        


    }
    
}
