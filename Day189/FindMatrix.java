package Day189;

import java.util.Scanner;

public class FindMatrix {
    static int upperBound(int[] arr,int target){
        int st = 0;
        int end = arr.length-1;
        int idx = arr.length;
        while(st<=end){
            int mid = (end-st)/2+st;
            if(arr[mid] > target){
                idx = mid;
                end = mid-1;
            }
            else st = mid + 1;
        }
        return idx;
    }
    static int countGreater(int[][] mat,int n,int m,int mid){
        int count = 0;
        for(int i = 0;i<n;i++){
            count += upperBound(mat[i], mid);
        }
        return count;
    }
    static int findMatrix(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int median = (n*m+1)/2;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][m-1]);
        }
        while(low<=high){
            int mid = (high-low)/2+low;
            int count = countGreater(mat, n, m, mid);
            if(count < median) low = mid +1;
            else high = mid - 1; 
        }
        return low;

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
        System.out.println(findMatrix(arr));
        sc.close();
    }
    
}
