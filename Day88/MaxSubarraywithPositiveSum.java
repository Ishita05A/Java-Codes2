package Day88;

import java.util.Scanner;

public class MaxSubarraywithPositiveSum {
    static int maxSubArr(int[] arr,int target){
        int start = 0;
        int max = -1;
        int sum = 0;
        for(int end = 0;end<arr.length;end++){
            sum+=arr[end];
            while(sum>target){
                sum-=arr[start];
                start++;
            }
            if(sum == target) max = Math.max(max, end-start+1);
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
