package Day118;

import java.util.Scanner;

public class KadaneAlgo {
    static int maximum_subarray_sum(int[] arr){
        int sum  = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            if(sum<0) sum = 0;
            max = Math.max(max, sum);
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
        System.out.println(maximum_subarray_sum(arr));
        sc.close();
    }
    
}
