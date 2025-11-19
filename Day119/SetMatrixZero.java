package Day119;

import java.util.Scanner;

public class SetMatrixZero {
    static void display(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void setMatrix2(int[][] arr) {
        int col = 1;
        int n = arr.length;
        int m = arr[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    if (j != 0)
                        arr[0][j] = 0;
                    else
                        col = 0;
                }
            }
        }
        for(int i = 1;i<n;i++){
            for(int j =1;j<m;j++){
                if(arr[0][j]==0 || arr[i][0] == 0) arr[i][j] =0;
            }
        }
        if(arr[0][0] == 0){
            for(int j = 0;j<m;j++) arr[0][j] = 0;
        }
        if(col == 0){
            for(int i = 0;i<n;i++) arr[i][0] = 0;
        }


    }

    static void set_matrix_zero(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (row[i]) {
                for (int j = 0; j < m; j++)
                    arr[i][j] = 0;
            }
        }
        for (int j = 0; j < m; j++) {
            if (col[j]) {
                for (int i = 0; i < n; i++)
                    arr[i][j] = 0;
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
        // set_matrix_zero(arr);
        setMatrix2(arr);
        display(arr);
        sc.close();
    }

}
