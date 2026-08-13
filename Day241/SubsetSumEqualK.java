package Day241;

import java.util.Arrays;

public class SubsetSumEqualK {
    //  subsetSum using tabularization
    static boolean tabularization(int[] nums, int k) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= k) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                boolean notPick = dp[i - 1][j];
                boolean pick = false;
                if (nums[i] <= j) {
                    pick = dp[i - 1][j - nums[i]];
                }
                dp[i][j] = pick || notPick;
            }
            
        }
        return dp[n - 1][k];
    }
    // helper function of isAvailable
    static boolean helper(int[] nums, int k, int idx, int[][] dp) {
        if (idx == 0)
            return nums[0] == k;
        if (k == 0)
            return true;
        if (dp[idx][k] != -1)
            return dp[idx][k] == 1 ? true : false;
        boolean notPick = helper(nums, k, idx - 1, dp);
        boolean pick = false;
        if (nums[idx] <= k) {
            pick = helper(nums, k - nums[idx], idx - 1, dp);
        }
        dp[idx][k] = (pick || notPick) ? 1 : 0;
        return pick || notPick;
    }
//  quest 1 using memorization (subset sum)
    static boolean isAvailable(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(nums, k, n - 1, dp);

    }
// question 2  partition equal subset...
    static boolean partitionSubSet(int[] nums){
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum+=nums[i];
        }
        if(sum % 2 == 1) return false;
        System.out.println(tabularization(nums, sum/2));
        return isAvailable(nums, sum/2);
    }
    // quest 3  minimum difference the subset could have(it contains only positive value)
    static int minDiff(int[] nums){
        int n = nums.length;
        int total = 0;
        for(int i = 0;i<n;i++){
            total+=nums[i];
        }
        int[][] dp = new int[n][total+1];
         for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        int min = Integer.MAX_VALUE;
        for(int s1 = 0;s1<=total/2;s1++){
            if(helper(nums, s1, n-1, dp)){
                int s2 = total - s1;
                min = Math.min(min,Math.abs(s2- s1));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] ARR = {8, 6, 5};
        int K = 6;
        System.out.println(isAvailable(ARR, K));
        System.out.println(tabularization(ARR, K));

        System.out.println(partitionSubSet(ARR));
        System.out.println(minDiff(ARR));
        
    }

}