package Day184;

import java.util.Scanner;

public class TargetSubArray {
    static int maxSum(int[] arr,int k){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int st  =0;
        int count = 0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            count++;
            if(count>k){
                sum -= arr[st];
                count--;
                st++;
            }
            if(count == k) max = Math.max(max, sum);
            
        }
        return max;


         
    }
    static int[] targetSubArray(int[] arr,int target){
        int st = 0;
        int sum = 0;
        int[] ans = {-1,-1};
        for(int end = 0;end<arr.length;end++){
            sum+=arr[end];
            while(sum>target){
                sum-=arr[st];
                st++;
            }
            if(sum == target){
                ans[0] = st;
                ans[1] = end;
            }
        }
        return ans;
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
        int[] ans = targetSubArray(arr, 12);
        System.out.println(ans[0]); 
        System.out.println(ans[1]); 
        sc.close();
        System.out.println(maxSum(arr,3));
    }
    
}
