package Day108;
import java.util.Scanner;

public class SetMatrixZero {
    static void display(int[][] arr){
        for(int i =0;i<arr.length;i++){
            for(int  j = 0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void zeroMatrix(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];
        
        for(int i =0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for(int i = 0;i<n;i++){
            if(rows[i]){
                for(int j = 0;j<m;j++){
                    arr[i][j] = 0;
                }
            }
        }
        
        for(int j = 0;j<m;j++){
            if(cols[j]){
                for(int i = 0;i<n;i++) arr[i][j] = 0;
            }
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
        zeroMatrix(arr);
        display(arr);
        sc.close();
    }
    
}
