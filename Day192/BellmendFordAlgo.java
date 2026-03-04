package Day192;

import java.util.Arrays;
import java.util.Scanner;

public class BellmendFordAlgo {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    static int[] bellmendFord(int v, int[][] edges, int src) {
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v1 = edges[j][1];
                int wt = edges[j][2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v1]) {
                    dist[v1] = dist[u] + wt;
                }
            }
        }
        for(int j = 0;j<edges.length;j++){
            int u = edges[j][0];
            int v1 = edges[j][1];
            int wt = edges[j][2];
            if(dist[u] != Integer.MAX_VALUE && dist[u]+wt <dist[v1]){
                return new int[] {-1};
            }
        }

        return dist;

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
        int[] ans = bellmendFord(5, arr, 0);
        display(ans);
        sc.close();

    }

}
