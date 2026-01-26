package Day163;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubArray_Negative {
    static int longestSubArray(int[] arr,int target){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int sum = 0;
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            if(sum == target) max = i+1;
            if(mp.containsKey(sum-target)) max = Math.max(i-mp.get(sum-target), max);
            mp.put(sum, i);
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
        System.out.println(longestSubArray(arr, -1));
        sc.close();
    }
    
}
