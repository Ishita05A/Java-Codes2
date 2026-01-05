package Day149;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubArrayWithNegNo {
    static int findLongestSubArray(int[] arr,int k){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            if(sum == k) maxLen = i+1;
            if(mp.containsKey(sum-k)) maxLen=Math.max(maxLen, i-mp.get(sum-k)+1);
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
        System.out.println(findLongestSubArray(arr, 3));
        sc.close();
    }
    
}
