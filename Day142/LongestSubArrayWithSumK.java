package Day142;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubArrayWithSumK {
    // for positives
    static int longestSubArray(int[] arr,int k){
        int max = 0;
        int sum = 0;
        int left = 0;
        for(int right = 0;right<arr.length;right++){
            sum+=arr[right];
            if(sum>k){
                sum-=arr[left++];
            }
            if(sum == k) max = Math.max(max, right-left+1);
        }
        return max;
    }
    static int longestSubArray_negative(int[] arr,int k){
        int max = 0;
        int sum = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            sum += arr[i];
            if(sum == k) max = i+1;
            if(mp.containsKey(sum-k)){
                max = Math.max(max, i-mp.get(sum-k));
            }
            mp.putIfAbsent(sum , i);
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
        // System.out.println(longestSubArray(arr, 15));
        System.out.println(longestSubArray_negative(arr,3 ));
        sc.close();
    }
    
}
