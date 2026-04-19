package Day214;

import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
    static int minSum(int V, List<List<List<Integer>>> adj){
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->a.first-b.first);
        int[] vis = new int[V];
        q.add(new Pair(0, 0));
        int sum = 0;
        while(!q.isEmpty()){
            Pair top = q.poll();
            int wt = top.first;
            int node = top.second;
            
            if(vis[node] == 1){
               continue; 
            }
            vis[node] = 1;
            sum+=wt;
            for(int i = 0;i<adj.get(node).size();i++){
                int dis = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(vis[adjNode] == 0){
                    q.add(new Pair(dis, adjNode));
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        
    }
    
}
