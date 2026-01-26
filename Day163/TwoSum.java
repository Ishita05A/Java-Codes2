package Day163;

import java.util.HashSet;
import java.util.Scanner;

public class TwoSum {
    static boolean find2Sum(int[] arr,int target){
        HashSet<Integer> mp = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            if(mp.contains(target - arr[i])) return true;
            mp.add(arr[i]);
        }
        return false;
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
        System.out.println(find2Sum(arr, 15));
        sc.close();
    }
    
}
