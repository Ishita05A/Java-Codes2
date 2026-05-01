package Day216;

import java.util.ArrayList;
import java.util.*;
public class PrimsAlgo {
    static class Pair{
        int wt;
        int node;
        Pair(int wt,int node){
            this.wt = wt;
            this.node = node;
        }
    }
    static int findWt(int V,int[][] edges){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(wt, v));
            adj.get(v).add(new Pair(wt, u));
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.wt-b.wt);
        int[] vis = new int[V];
        q.add(new Pair(0, 0));
        int sum = 0;
        while(!q.isEmpty()){
            Pair top = q.poll();
            int wt = top.wt;
            int node = top.node;
            if(vis[node] == 1) continue;
            sum+=wt;
            vis[node] = 1;
            for(Pair it : adj.get(node)){
                int adjWt = it.wt;
                int adjNode = it.node;
                if(vis[adjNode] == 0){
                    q.add(new Pair(adjWt, adjNode));
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        
    }
}
