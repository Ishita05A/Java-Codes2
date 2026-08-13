package Day241;

import java.util.Arrays;

public class CountSubSetWithSumK {
    static int helper(int[] nums, int idx,int k,int[][] dp){
        if(idx == 0){
            if(k == 0 && nums[0] == 0) return 2;
            if(k == 0 || nums[0] == k) return 1;
            return 0;
        }
        if(k == 0) return 1;
        if(dp[idx][k] != -1) return dp[idx][k];
        int notPick = helper(nums, idx-1, k, dp);
        int pick = 0;
        if(nums[idx] <= k){
            pick = helper(nums, idx-1, k-nums[idx], dp);
        }
        return dp[idx][k] = pick + notPick;

    }
    static int countSubSet(int[] nums,int k){
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(nums, n-1, k, dp);

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int  K = 5;
        System.out.println(countSubSet(arr, K));
        
    }
    
}
