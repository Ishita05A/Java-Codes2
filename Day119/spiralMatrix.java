package Day119;

import java.util.Scanner;

public class spiralMatrix {
    static void printSpiral(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int no_of_elements = 0;
        int tr = 0 , br = n-1, lc=0,rc = m-1;
        while(no_of_elements < n*m){
            for(int i = lc;i<=rc;i++){
                System.out.print(arr[tr][i]+" ");
                no_of_elements++;
            }
            tr++;
            for(int i = tr;i<=br;i++){
                System.out.print(arr[i][rc]+" ");
                no_of_elements++;
            }
            rc--;
            for(int i = rc;i>=lc;i--){
                System.out.print(arr[br][i]+" ");
                no_of_elements++;
            }
            br--;
            for(int i =br;i>=tr;i--){
                System.out.print(arr[i][lc]+" ");
                no_of_elements++;
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
        printSpiral(arr);
        sc.close();
    }
    
}
