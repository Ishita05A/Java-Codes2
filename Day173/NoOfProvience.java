package Day173;

import java.util.*;

public class NoOfProvience {
   static void dfs(List<List<Integer>> adj, int[] vis,int node){
        vis[node] = 1;
        for(int it : adj.get(node)){
            if(vis[it] == 0) dfs(adj, vis, it);
        }
    }
    static int count(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                }
            }
        }
        int[] vis = new int[n];
        int count = 0;
        for(int i = 0;i<n;i++){
            if(vis[i] == 0){
                dfs(adj, vis, i);
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of rows");
        int n = sc.nextInt();
        System.out.println("Enter no. of columns");
        int m = sc.nextInt();
        System.out.println("Enter elements ");
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0;j<m;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(count(arr));
        sc.close();
    }
    
}
