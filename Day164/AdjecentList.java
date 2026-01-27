package Day164;
import java.util.Scanner;
public class AdjecentList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of nodes");
        int n = sc.nextInt();
        System.out.println("Enter no. of Edges");
        int m = sc.nextInt();
        int mat[][] = new int[n+1][n+1];
        for(int j = 0;j<m;j++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            mat[u][v] = 1;
            mat[v][u] = 1;

        }
        for(int i =0;i<mat.length;i++){
            for(int j = 0;j<n+1;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        sc.close();
    }
    
}
