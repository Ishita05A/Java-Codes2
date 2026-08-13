package Day241;

import java.util.Arrays;

public class CountPartitionWithDiffK {
    static int helper(int[] nums, int idx, int k, int[][] dp){
        if(idx == 0){
            if(k == 0 && nums[0] == 0) return 2;
        if(k == 0 || nums[0] == k) return 1;
        else return 0;
        }
        if(dp[idx][k] != -1) return dp[idx][k];
        int notPick = helper(nums, idx-1, k, dp);
        int pick = 0;
        if(nums[idx] <= k) pick = helper(nums, idx-1, k-nums[idx], dp);
        return dp[idx][k] = pick + notPick;

    }
    static int countDiff(int[] nums, int d){
        int n = nums.length;
        int total = 0;
        for(int i = 0;i<n;i++){
            total+=nums[i];
        }
        if(total - d < 0 || (total-d)% 2 != 0) return 0;

        int k = (total-d)/2;
        int[][] dp = new int[n][k+1];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(nums, n-1, k, dp);    
    }
    public static void main(String[] args) {
       int[] arr = {1, 1, 2, 3};
       int  diff = 1;
       System.out.println(countDiff(arr, diff));
    }
    
}
