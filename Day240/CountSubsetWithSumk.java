 package Day240;

import java.util.Arrays;

public class CountSubsetWithSumk {
    static int tabularization(int[] nums, int k){
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        for(int i = 0;i<n;i++){
            dp[i][0] = 1;
        }
        if(nums[0] <= k) dp[0][nums[0]] = 1;

        for(int i = 1;i<n;i++){
            for(int j = 1;j<=k;j++){
                int notPick = dp[i-1][j];
                int pick = 0;
                if(nums[i] <= j){
                    pick = dp[i-1][j-nums[i]];
                }
                dp[i][j] = pick + notPick;
            }
        }
        return dp[n-1][k];
    }
    static int helper(int[] nums, int k, int idx, int[][] dp){
        if(k == 0) return 1;
        if(idx == 0){
            if(nums[0] == k) return 1;
            else return 0;
        } 
        if(dp[idx][k] != -1) return dp[idx][k];
        int notPick = helper(nums, k, idx-1, dp);
        int pick = 0;
        if(nums[idx] <= k){
            pick = helper(nums, k-nums[idx], idx-1, dp);
        }
        return dp[idx][k] =  pick + notPick;
    }
    static int countSubset(int[] nums, int k){
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(nums, k, n-1, dp);
    }

    public static void main(String[] args) {
     
        int[]  arr = {1, 2, 2, 3};
         int K = 3;
         System.out.println(countSubset(arr, K));
         System.out.println(tabularization(arr, K));
    }
}