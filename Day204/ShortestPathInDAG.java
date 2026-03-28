package Day204;
import java.util.*;
public class ShortestPathInDAG {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first = first;
            this.second = second;
        }
    }
     static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void topoSort(List<List<Pair>> adj,Stack<Integer> st,int[] vis,int node){
        vis[node] = 1;
        for(Pair it:adj.get(node)){
            if(vis[it.first] == 0){
                topoSort(adj, st, vis, it.first);
            }
        }
        st.push(node);
    }
    static int[] shortest(int[][] mat,int n,int m){
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++){
            adj.get(mat[i][0]).add(new Pair(mat[i][1], mat[i][2]));
        }
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[n];
        for(int i = 0;i<n;i++){
            topoSort(adj, st, vis, i);
        }
        int[] dist = new int[n];
        
        for(int i = 0;i<n;i++) dist[i] = (int)1e9;
        dist[0] = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            for(Pair it:adj.get(node)){
                int v = it.first;
                int wt = it.second;
                if(dist[node] +wt <dist[v]){
                    dist[v] = wt+dist[node];
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(dist[i] == 1e9) dist[i] = -1;
        }
        return dist;


    }
    public static void main(String[] args) {
        int[][] mat = {
    {0,1,2},
    {1,2,3},
    {3,4,1}
};
int[] ans = shortest(mat, 5, 3);
display(ans);
    }
    
}
