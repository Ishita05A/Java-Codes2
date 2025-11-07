package Day108;

import java.util.Scanner;

public class Spiralmatrix {
    static void spiral(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int tr = 0,br = n-1,lc = 0,rc = m-1;
        int total = 0;
        while(total< n*m){
            for(int i = lc;i<=rc;i++){
                System.out.print(arr[tr][i]+" ");
                total++;
            }
            tr++;
            for(int i = tr;i<=br;i++){
                System.out.print(arr[i][rc]+" ");
                total++;
            }
            rc--;
            for(int i = rc;i>=lc;i--){
                System.out.print(arr[br][i]+" ");
                total++;
            }
            br--;
            for(int i =br;i>=tr;i--){
                System.out.print(arr[i][lc]+" ");
                total++;
            }
            lc++;
        }

    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter rows");
        int n = sc.nextInt();
        System.out.println("Enter columns");

        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        spiral(arr);
        sc.close();
    }
    
}
