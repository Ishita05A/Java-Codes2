package Day167;

import java.util.Scanner;

public class SetMatrixZero {
    static void display(int[][] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void setmatrixZero(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int col = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j] == 0){
                    if(j == 0) col = 0;
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                if(arr[i][0] == 0 || arr[0][j] == 0) arr[i][j] = 0;
            }   
        }
        if(arr[0][0] == 0){
            for(int j = 0;j<m;j++) arr[0][j] = 0;
        }
        if(col == 0){
            for(int i = 0;i<n;i++) arr[i][0] = 0;
        }

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
        setmatrixZero(arr);
        display(arr);
        sc.close();
    }
    
}
