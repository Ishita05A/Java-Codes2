package Day149;

import java.util.Scanner;

public class LongestSubArrayWithSum {
    static int maxSubArray(int[] arr,int k){
        int maxLen = 0;
        int sum = 0;
        int l = 0;
        for(int r = 0;r<arr.length;r++){
            sum+=arr[r];
            while(sum>k){
                sum-=arr[l];
                l++;
            }
            if(sum == k) maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxSubArray(arr, 15));
        sc.close();
    }
    
}
