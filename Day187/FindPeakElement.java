package Day187;

import java.util.Scanner;

public class FindPeakElement {
    static int findPeak(int[][] arr,int n,int m,int col){
        int max = -1;
        int idx = -1;
        for(int i = 0;i<n;i++){
            if(arr[i][col] >max){
                max= arr[i][col];
                idx = i;
            }
        }
        return idx;
    }

    static int[] findPeakindex(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int st = 0;
        int end = m-1;
        while(st<=end){
            int mid = (end-st)/2+st;
            int row_idx = findPeak(mat, n, m, mid);
            int left = mid>0 ? mat[row_idx][mid-1]:-1;
            int right = mid < m-1 ? mat[row_idx][mid+1] : -1;
            if(left < mat[row_idx][mid] && mat[row_idx][mid] > right) {

                return new int[] {row_idx,mid};
            }
            else if(mat[row_idx][mid] < right) st = mid + 1;
            else end = mid - 1;
        }
        return new int[] {-1,-1};
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
