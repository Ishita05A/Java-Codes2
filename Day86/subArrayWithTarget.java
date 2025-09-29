package Day86;

import java.util.HashMap;
import java.util.Scanner;

public class subArrayWithTarget {
    static int longestSubArray(int[] arr,int target){
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int max = 0;
        int prefixsum = 0;
        
        for(int i = 0;i<arr.length;i++){
            prefixsum+=arr[i];
            if(mp.containsKey(prefixsum-target)) max = Math.max(max, i-mp.get(prefixsum-target)); 
            mp.putIfAbsent(prefixsum, i);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter target");
        int x = sc.nextInt();
        System.out.println(longestSubArray(arr, x));
        sc.close();
    }
    
}
