package Day163;

import java.util.Scanner;

public class LongestSubArray {
    static int longest_SubArray(int[] arr,int targetSum){
        int max = 0;
        int sum = 0;
        int st = 0;
        for(int end = 0;end<arr.length;end++){
            sum+=arr[end];
            while(sum>targetSum) sum-=arr[st++];
            if(sum == targetSum) max = Math.max(max, end-st+1);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements for value");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(longest_SubArray(arr, 15));
        sc.close();
    }
    
}
