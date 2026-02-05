package Day168;

import java.util.Scanner;

public class Adjecentmatrix {
    static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n = sc.nextInt();
        System.out.println("Enter no. of edges");
        int m = sc.nextInt();
        int[][] mat = new int[n+1][n+1];
        for(int i = 0;i<m;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            mat[u][v] = 1;
            mat[v][u] = 1;
        }
        display(mat);
        sc.close();
        


    }
    
}
