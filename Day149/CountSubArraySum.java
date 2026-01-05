package Day149;

import java.util.Scanner;

public class CountSubArraySum {
    static int countSubArray_count_optimized(int[] arr,int k){
        int l = 0;
        int count = 0;
        int sum = 0;
        for(int r = 0;r<arr.length;r++){
            sum+=arr[r];
            while(sum>k){
                sum-=arr[l];
                l++;
            }
            if(sum == k) count++;
        }
        return count;
    }
    static int countSubArray_brute(int[] arr,int k){
        int count = 0;
        int n = arr.length;
        for(int i = 0;i<n;i++){
            int sum = 0;
            for(int j = i;j<n;j++){
                sum+=arr[j];
                if(sum == k) {
                    count++;
                    break;
                }
            }
        }
        return count;
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
        System.out.println(countSubArray_brute(arr, 6));
        System.out.println(countSubArray_count_optimized(arr, 6));
        sc.close();
    }
    
}
