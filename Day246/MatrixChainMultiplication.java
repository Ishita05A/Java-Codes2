package Day246;

import java.util.Arrays;

public class MatrixChainMultiplication {
    static int helper(int[] nums, int i, int j,int[][] dp){
        if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = (int)1e9;
        for(int k = i;k<j;k++){
            int step = nums[i-1]*nums[k]*nums[j] + helper(nums, i, k,dp) + helper(nums, k+1, j,dp);
            min = Math.min(min, step);
        }
        return dp[i][j] =  min;
    }
    static int min_Operation(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(nums, 1, nums.length-1,dp);
    }
    public static void main(String[] args) {
        int[] nums = {40, 20, 30, 10, 30};
        System.out.println(min_Operation(nums));
    }
    
}
