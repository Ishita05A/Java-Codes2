package Day107;

import java.util.Scanner;

public class LongestSubArray {

    static int longest(int[] arr,int k){
        if(arr == null || arr.length == 0) return 0;
        int sum = arr[0];
        int max = 0;
        int st = 0;
        int end = 0;
        while(end<arr.length){
            while(st<=end && sum >k){
                sum-=arr[st];
                st++;
            }
            if(sum == k) max = Math.max(max, end-st+1);
            end++;
            if(end <arr.length) sum+=arr[end];
        }
        return max;
    }
    static int longestSA(int[] arr,int k){
        int n = arr.length;
        int sum = 0;
        int max = -1;
        for(int i  = 0;i<arr.length;i++){
            int j = i;
            sum = 0;
            int count =0;
            while(j<n){
                sum+=arr[j];
                count++;
                if(sum == k){
                    max = Math.max(count, max);
                    break;
                }
                j++;
            }
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
        System.out.println(longestSA(arr, 10));
        System.out.println(longest(arr,10 ));
        sc.close();
    }
    
}
