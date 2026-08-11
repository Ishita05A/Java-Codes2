package Day240;

import java.util.Arrays;

public class SubsetSumEqualToTarget {

    static boolean tabularization(int[] arr,int k){
        boolean[][] dp = new boolean[arr.length][k+1];
        for(int i = 0;i<arr.length;i++){
            dp[i][0] = true;
        }

        if(arr[0] <= k){
            dp[0][arr[0]] = true;
        }

        for(int i = 1;i<arr.length;i++){
            for(int j = 1;j<=k;j++){
                boolean notPick = dp[i-1][j];
                boolean pick = false;
                if(arr[i] <=j){
                    pick = dp[i-1][j-arr[i]];
                }
                dp[i][j] = pick || notPick;
            }
        }
        return dp[arr.length-1][k];
    }
    static boolean targetSum(int[] arr,int k,int idx,int[][] dp){
        if(idx == 0) return arr[idx] == k;
        if(k == 0) return true;
        if(dp[idx][k] != -1){
            return dp[idx][k] == 1;
        }
        boolean notpick = targetSum(arr, k, idx-1,dp);
        boolean pick = false;
        if(arr[idx] <= k){
            pick = targetSum(arr, k-arr[idx], idx-1,dp);
        }
        dp[idx][k] = pick || notpick ? 1:0;
        return pick || notpick;
    }
    public static void main(String[] args) {
         int[] arr = {4, 3, 5, 2}; 
         int K = 6; 
         int[][] dp = new int[arr.length+1][K+1];
         for(int i = 0;i<arr.length;i++){
            Arrays.fill(dp[i],-1);
         }
         System.out.println(targetSum(arr, K, arr.length-1, dp));
         System.out.println(tabularization(arr, K));
    }
    
}
