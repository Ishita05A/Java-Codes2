package Day84;


import java.util.Scanner;
import java.util.*;

public class longestSubArrayinlcudingNegative {
    static int longestSubArray(int[] arr,int target){
        int prefixSum = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i<arr.length;i++){
            prefixSum += arr[i];
            if(prefixSum == target) maxLen = i+1;
            if(mp.containsKey(prefixSum-target)) maxLen = Math.max(maxLen, i-mp.get(prefixSum-target));
            if(!mp.containsKey(prefixSum-target)) mp.put(prefixSum, i);
        }
        return maxLen;
       
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
        System.out.println("Enter target");
        int x = sc.nextInt();
        System.out.println(longestSubArray(arr, x));
        sc.close();
        
    }
    
}
