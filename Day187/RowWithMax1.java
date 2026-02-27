package Day187;

import java.util.Scanner;

public class RowWithMax1 {
    static int firstOccurance(int[] arr){
        int st = 0;
        int end = arr.length-1;
        int idx = -1;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] == 1){
                idx = mid;
                end = mid-1;
            }
            else st = mid+1;
        }
        return idx;
    }
    static int findRowwithmax1(int[][] mat){
        int max = -1;
        int idx = -1;
        for(int i = 0;i<mat.length;i++){
            int firstOcc = firstOccurance(mat[i]);
            if(firstOcc != -1){
                if(mat.length-firstOcc >max){
                    max = mat.length-firstOcc;
                    idx = i;
                }
            }
        }
        return idx;
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
        System.out.println(findRowwithmax1(arr));
        sc.close();
    }
}
