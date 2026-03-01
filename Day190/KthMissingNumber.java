package Day190;

import java.util.Scanner;

public class KthMissingNumber {
    static int findMissing_brute(int[] arr,int k){
        for(int i = 0;i<arr.length;i++){
            if(arr[i] <= k) k++;
            else return k;
        }
        return k;
    }
    static int findMissing_Optimized(int[] arr,int k){
        int st = 0;
        int end = arr.length-1;
        while(st<=end){
            int mid = (end-st)/2+st;
            int missing = arr[mid]-(mid+1);
            if(missing < k) st = mid+1;
            else end = mid - 1;
        }
        return k+end+1;
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
        System.out.println(findMissing_brute(arr, 5));
        System.out.println(findMissing_Optimized(arr, 5));
        sc.close();
    }
    
}
