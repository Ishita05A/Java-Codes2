package Day108;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubArray {
    static int longest(int[] arr,int k){
        int n = arr.length;
        int sum = 0;
        
        int max = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i<n;i++){
            sum+=arr[i];
            if(sum == k) max = Math.max(max, i+1);
            if(mp.containsKey(k-sum)) max = Math.max(max, i-mp.get(k-sum)+1); 
            if(!mp.containsKey(sum)) mp.put(arr[i], i);
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
        System.out.println(longest(arr, 1));
        sc.close();
    }
    
}
