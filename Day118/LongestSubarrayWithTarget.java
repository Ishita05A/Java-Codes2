package Day118;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarrayWithTarget {
    static int find_longest_subarray(int[] arr,int k){
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0, -1);
        int max = 0;
        int sum = 0;
        for(int i =0;i<arr.length;i++){
            sum+=arr[i];
            if(mp.containsKey(k-sum)) max = Math.max(i-mp.get(k-sum),max);
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
        System.out.println(find_longest_subarray(arr, 10));
        sc.close();
    }
    
}
