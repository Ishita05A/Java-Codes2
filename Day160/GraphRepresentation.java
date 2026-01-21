package Day160;

import java.util.Scanner;

public class GraphRepresentation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes");
        int n = sc.nextInt();
        System.out.println("Enter no. of edges");
        int m = sc.nextInt();
        int[][] adj = new int[n+1][n+1];
        for(int i = 0;i<m;i++){
            int  u = sc.nextInt();
            int v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }
        sc.close();
    }
    
}
