package Day190;

import java.util.*;

public class ShortestPathInDAG {
    static class  Pair {
       
        int node;
        int wt;
        Pair(int node ,int wt){
            this.node = node;
            this.wt = wt;
        }
    } 
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void dfs(List<List<Pair>> adj,Stack<Integer> st,int[] vis,int node){
        vis[node] = 1;
        for(Pair it: adj.get(node)){
            if(vis[it.node] == 0){
                dfs(adj, st, vis, it.node);
            }
        }
        st.add(node);

    }
   static int[] findShorestDist(int[][] mat,int src,int v){
        List<List<Pair>> adj = new ArrayList<>();
        int n = mat.length;
        for(int i = 0;i<v;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            int idx = mat[i][0];
            int node = mat[i][1];
            int wt = mat[i][2];
            adj.get(idx).add(new Pair(node ,wt));

        }
        int[] vis = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<v;i++){
            if(vis[i] == 0){
                dfs(adj, st, vis, i);
            }
        }
        int[] dist = new int[v];
        for(int i = 0;i<v;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[st.peek()] = 0;
        while(!st.isEmpty()){
            int top = st.pop();
            for(Pair it:adj.get(top)){
                int wt = it.wt;
                int node = it.node;
                if(wt + dist[top] < dist[node]){
                    dist[node] = wt + dist[top];
                }
            }
        }
        for(int i = 0;i<v;i++){
            if(dist[i] == Integer.MAX_VALUE){
                dist[i] = -1;
            }
        }
        return dist;
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows");
        int n = sc.nextInt();
        System.out.println("Enter elements ");
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            for(int j = 0;j<3;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[] dist = findShorestDist(arr, 0, 7);
        display(dist);
        sc.close();
    }
    
}
