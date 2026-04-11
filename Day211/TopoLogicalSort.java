package Day211;
import java.util.*;
public class TopoLogicalSort {
    static List<Integer> topoSort(List<List<Integer>> adj, int V){
        List<Integer> ans = new ArrayList<>();
        int[] indegree = new int[V];
        for(int i = 0;i<V;i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        for(int i = 0;i<V;i++){
            if()
        }
    }
    public static void main(String[] args) {
        
    }
    
}
