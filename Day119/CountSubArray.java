package Day119;

import java.util.Scanner;


import java.util.*;

public class CountSubArray {
    static int count_subarray(int[] arr,int target){
        int n = arr.length;
        int count = 0;
        int prefixsum = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i = 0;i<n;i++){
            prefixsum += arr[i];
            if(mp.containsKey(prefixsum-target)){
                count+=mp.get(prefixsum-target);
               
            }
            mp.put(prefixsum, mp.getOrDefault(prefixsum, 0)+1);
        }
        return count;
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
        System.out.println(count_subarray(arr, 6));
        sc.close();
    }
    
}
