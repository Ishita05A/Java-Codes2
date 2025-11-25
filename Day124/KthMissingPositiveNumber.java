package Day124;

import java.util.Scanner;

public class KthMissingPositiveNumber {
    static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);
        return max;
    }
    
    static int missing_number(int[] arr,int k){
        int end = arr.length-1;
        int st = 1;

        while(st<=end){
            int mid = (end-st)/2+st;
            int missing_numbers = arr[mid]-(mid+1);
            if(missing_numbers<k) st = mid+1;
            else end = mid-1;
        }
        return st+k;

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
        System.out.println("Enter missing position");
        int k = sc.nextInt();
        System.out.println(missing_number(arr, k));

    }
    
}
