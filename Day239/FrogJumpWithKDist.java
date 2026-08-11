package Day239;

import java.util.Arrays;

public class FrogJumpWithKDist {

    static int helper2(int[] height, int idx, int k, int[] dp){
        dp[0] = 0;
        for(int i = 1;i <= idx; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 1;j<=k;j++){
                int jump = Integer.MAX_VALUE;
                if(i-j >= 0) jump = dp[i-j] + Math.abs(height[i-j] - height[i]);
                min = Math.min(min, jump);
            }
            dp[i] = min;
        }
        return dp[idx];
    }

    static int helper1(int[] height, int idx,int k,int[] dp){
        if(idx == 0) return 0;
        if(idx < 0) return Integer.MAX_VALUE;
        if(dp[idx] != -1) return dp[idx];
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<=k;i++){
            int jump = Integer.MAX_VALUE;
            if(idx - i >=0){
                jump = helper(height, idx-i, k) + Math.abs(height[idx] - height[idx-i]);
            }
            min = Math.min(min, jump);
        }
        return dp[idx] = min;
    }
    static int helper(int[] height, int idx,int k){
        if(idx == 0) return 0;
        if(idx < 0) return Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<=k;i++){
            int jump = Integer.MAX_VALUE;
            if(idx - i >=0){
                jump = helper(height, idx-i, k) + Math.abs(height[idx] - height[idx-i]);
            }
            min = Math.min(min, jump);
        }
        return min;
    }
    static int minEnergy(int[] height, int k){
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(helper1(height, n - 1, k, dp));
        System.out.println(helper2(height, n-1, k, dp));
        return helper(height, n-1, k);
    }
    public static void main(String[] args) {
        int[]  heights = {15, 4, 1, 14, 15};
        int k = 3;
        System.out.println(minEnergy(heights, k));
    }
    
}
