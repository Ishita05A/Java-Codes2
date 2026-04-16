package Day212;
import java.util.*;
public class DijkstraAlgo {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    static List<Integer> dijkstra(int n,int m,int[][] edges){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it : edges){
            adj.get(it[0]).add(new Pair(it[2], it[1]));
        }
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for(int i = 0;i<n+1;i++){
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.first-b.first);
        q.add(new Pair(0,1));
        dist[1] = 0;
        while(!q.isEmpty()){
            Pair top = q.poll();
            int dis = top.first;
            int node = top.second;
            if(dis > dist[node]) continue;
            for(Pair it:adj.get(node)){
                int dd = it.first;
                int adjNode = it.second;
                if(dd + dis < dist[adjNode]){
                    dist[adjNode] = dd+dis;
                    parent[adjNode] = node;
                    q.add(new Pair(dd+dis, adjNode));
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        if(dist[n] == Integer.MAX_VALUE){
            ans.add(-1);
            return ans;
        }
        int node = n;
        while(parent[node] != node){
            ans.add(node);
            node = parent[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
