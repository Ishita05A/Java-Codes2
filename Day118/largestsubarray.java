package Day118;

import java.util.Scanner;

public class largestsubarray {
    static int find_max_subarray(int[] arr,int k){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        
        for(int end = 0;end<arr.length;end++){
            sum+=arr[end];
            while(sum>k){
                sum = sum-arr[start];
                start++;
            }
            max  = Math.max(max, end-start+1);
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
        System.out.println(find_max_subarray(arr, 1));
        sc.close();
    }
    
}
