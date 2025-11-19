package Day118;

import java.util.Scanner;

public class RotateMatrixBY90 {
    
    static void display(int[][] arr){
        for(int i =0;i<arr.length;i++){
            for(int  j = 0;j<arr.length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    static void reverse(int[] arr){
        int i = 0;
        int j = arr.length-1;
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    static void transpose(int[][] arr){
        
        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j<i;j++){
               int temp = arr[i][j];
               arr[i][j] = arr[j][i];
               arr[j][i] = temp;
            }
        }
    }
    static void rotate(int[][] arr){
        transpose(arr);
        for(int i = 0;i<arr.length;i++){
            reverse(arr[i]);
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
        rotate(arr);
        display(arr);
        sc.close();
    }
    
}
