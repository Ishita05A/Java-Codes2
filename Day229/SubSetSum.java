package Day229;

import java.util.Arrays;

public class SubSetSum {
    // static boolean helper(int[][] arr,int target){
    //     int n = arr.length;
    //     int[][] dp = new int[n][target+1];
    //     for(int i = 0 ;i<n;i++){
    //         dp[i][target] = 1;
    //     }
        
    // }
    
    static boolean subSet_Sum(int[] arr,int idx,int target, int[][] dp){
        if(arr[idx] == target) return true;
        if(idx == 0) return arr[idx] == target;
        if(idx < 0) return false;
        if(dp[idx][target] != -1) return dp[idx][target] == 1;
        boolean notPick = subSet_Sum(arr, idx-1, target, dp);
        boolean pick = false;
        if(arr[idx] <= target) pick = subSet_Sum(arr, idx-1, target-arr[idx], dp);
        if(pick || notPick) dp[idx][target] = 1;
        else dp[idx][target] = 0;
        return  pick || notPick;
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2};
        int n = arr.length;
        int k = 6;
        int[][] dp = new int[n][k+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(subSet_Sum(arr, n-1, k, dp));
        

    }
    
}
