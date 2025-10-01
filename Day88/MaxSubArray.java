package Day88;

import java.util.Scanner;
import java.util.*;

public class MaxSubArray {
    static int maxSubArr(int[] arr, int target){
        int prefixSum = 0;
        int max = 0;
        HashMap<Integer,Integer> mp= new HashMap<>();
        mp.put(0, -1);
        for(int i = 0;i<arr.length;i++){
            prefixSum += arr[i];
            if(!mp.containsKey(prefixSum)) mp.put(prefixSum, i);
            if(mp.containsKey(prefixSum-target)) max = Math.max(max, i-mp.get(prefixSum-target));
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
        System.out.println("Enter Target");
        int x = sc.nextInt();
        System.out.println(maxSubArr(arr,x));
        sc.close();
    }
    
}
