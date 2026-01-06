package Day150;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZeroMatrix {
    static void display(int[][] arr){
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void makeZeroMatrix_brute(int[][] arr){
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<arr[0].length;j++){
                if(arr[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int i = 0;i<rows.size();i++){
            for(int j = 0;j<arr[0].length;j++){
                arr[rows.get(i)][j] = 0;
            }
        }
        for(int i = 0;i<cols.size();i++){
            for(int j = 0;j<arr.length;j++){
                arr[j][cols.get(i)] = 0;
            }
        }
    }static void makeZeroMatrix_optimized(int[][] arr){
        int col0 = 1;
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<m;j++){
                if(arr[i][j] == 0){
                    arr[i][0] = 0;
                    if(j!=0) arr[0][j] = 0;
                    else col0 = 0;
                }
            }
        }
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                if(arr[0][j] == 0 || arr[i][0] == 0){
                    arr[i][j] = 0;
                }
            }
        }
        if(arr[0][0] == 0){
            for(int j = 0;j<m;j++) arr[0][j] = 0;
        }
        if(col0 == 0){
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
        // makeZeroMatrix_brute(arr);
        makeZeroMatrix_optimized(arr);
        display(arr);
        sc.close();
    }
    
}
