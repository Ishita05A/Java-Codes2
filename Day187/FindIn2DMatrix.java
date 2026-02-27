package Day187;

import java.util.Scanner;

public class FindIn2DMatrix {
    static boolean findElement(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] == target) return true;
            if(arr[mid]<target) st = mid+1;
            else end = mid-1;
        }
        return false;
    }
    static boolean searchElement(int[][] mat,int target){
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0;i<n;i++){
            if(mat[i][m-1] >= target){
                return findElement(mat[i], target);
            }
        }
        return false;
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
        System.out.println(searchElement(arr, 78));
        sc.close();
    }
    
}
