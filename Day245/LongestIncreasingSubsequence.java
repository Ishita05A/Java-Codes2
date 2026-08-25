package Day245;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static int helper(int[] nums, int idx, int prev_idx,int[][] dp){
        if(idx == nums.length) return 0;
        if(dp[idx][prev_idx+1] != -1) return dp[idx][prev_idx+1];
        int notPick = helper(nums, idx+1,prev_idx, dp);
        int pick = Integer.MIN_VALUE;
        if(prev_idx == -1 || nums[idx] > nums[prev_idx]){
            pick = 1 + helper(nums, idx+1, idx, dp);
        }
        return dp[idx][prev_idx+1] =  Math.max(pick,notPick);
    }
    
    static int longest(int[] nums){
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(nums, 0, -1, dp);
    }
    public static void main(String[] args) {
        int[]  nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(longest(nums));
        
    }
    
}
