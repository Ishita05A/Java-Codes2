package Day187;

import java.util.Scanner;

public class FindPeakElement {
    static int findPeak(int[] arr){
        int n = arr.length;
        if(arr.length == 1) return 0;
        if(arr[0] >arr[1]) return 0;
        if(arr[n-1] > arr[n-2]) return n-1;
        int st = 1;
        int end = arr.length-2;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid-1] < arr[mid]  &&  arr[mid] > arr[mid+1]){
                return mid;
            }
            else if(arr[mid] < arr[mid+1]) st = mid-1;
            else end = mid-1;
        }
        return -1;
    }
    static int[] findPeakindex(int[][] mat){
        int[] ans = new int[2];
        int n = mat.length;
        int peak = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            int col = findPeak(mat[i]);
            if(mat[i][col] >peak){
                peak = mat[i][col];
                ans[0] = i;
                ans[1] = col;
            }
        }
        return ans;
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
        int[] ans = findPeakindex(arr);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
        sc.close();
    }
    
}
