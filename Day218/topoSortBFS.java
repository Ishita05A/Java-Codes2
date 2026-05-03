package Day218;
import java.util.*;
public class topoSortBFS {
    static List<Integer> topoSort(List<List<Integer>> adj,int v){
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[v];
        for(int i = 0;i<adj.size();i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
        for(int i = 0;i<v;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int top = q.poll();
            ans.add(top);
            for(int it:adj.get(top)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
    
}
