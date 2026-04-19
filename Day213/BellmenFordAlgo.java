package Day213;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BellmenFordAlgo {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static int[] shortestPath(int V,int[][] adj,int st){
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[st] = 0;
        for(int i = 0;i<V-1;i++){
                for(int[] it:adj[i]){
                    int u = adj[i][0];
                    int v = adj[i][1];
                    int dis = adj[i][2];
                    if(dist[u] != Integer.MAX_VALUE && dis+dist[u] < dist[v]){
                        dist[v] = dist[u]+dis;
                    }
                }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][] E = {{3, 2, 6}, {5, 3, 1}, {0, 1, 5}, {1, 5, -3}, {1, 2, -2}, {3, 4, -2}, {2, 4, 3}};
        int[] arr = shortestPath(6, E, 0);
        display(arr);
    }
    
}
