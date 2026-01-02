package Day146;

import java.util.Scanner;

public class MaximumPoint {
    static int max_point_optimized(int[] arr,int k){
        int rsum = 0;
        int lsum = 0;
        int max = 0;
        for(int i = 0;i<k;i++){
            lsum+=arr[i];
        }
        max = lsum;
        int ridx = arr.length-1;
        for(int i = k-1;i>=0;i--){
            lsum-=arr[i];
            rsum+=arr[ridx--];
            max = Math.max(max, lsum+rsum);
        }
        return max;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(max_point_optimized(arr, 3));
        sc.close();

    }
    
}
