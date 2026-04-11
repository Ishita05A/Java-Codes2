package Day212;
import java.util.*;
public class TopoSort {
    static  void dfs(List<List<Integer>> adj,int[] vis, int node,Stack<Integer> st){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0){
                dfs(adj, vis, it, st);
            }
        }
        st.push(node);
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
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0;i<n;i++){
            dfs(adj, vis, i, st);
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop()+" ");
        }
        sc.close();
        
    }
    
}
