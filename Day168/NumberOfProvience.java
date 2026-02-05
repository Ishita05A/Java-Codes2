package Day168;

import java.util.*;
public class NumberOfProvience {
    static void dfs(List<List<Integer>> adj, int[] vis,int node){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0) dfs(adj, vis, it);
        }
    }
    static int findCircleNum(int[][] mat){
        int n = mat.length;
        int count = 0;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 1 && i!=j){
                    adj.get(i).add(j);
                }
            }
        }
        int[] vis = new int[n];
        for(int i = 0;i<n;i++){
            if(vis[i] == 0){
                dfs(adj, vis, i);
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n = sc.nextInt();
        System.out.println("Enter no. of edges");
        int m = sc.nextInt();
        int[][] mat = new int[n][n];
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            mat[u][v] = 1;
            mat[v][u] = 1;
        }
        System.out.println(findCircleNum(mat));
        sc.close();
    }
    
}
