package Day203;

import java.util.Arrays;

public class FrogKSteps {
    // Memorization
    static int frog(int idx,int[] height,int[] dp,int k){
        if(idx == 0) return 0;
        if(dp[idx] != -1) return dp[idx];
        int min_step = Integer.MAX_VALUE;
        for(int j = 1;j<=k;j++){
            if(idx-j >= 0) {
                int jump = frog(idx-j, height, dp,k) + Math.abs(height[idx]-height[idx-j]);
                min_step = Math.min(min_step, jump);
            }
        }
        dp[idx] = min_step;
        return dp[idx];
    }
    // Tabulation 
    static int frog_tabulation(int idx,int[] height,int[] dp,int k){
        dp[0] = 0;
        for(int i= 1;i<=idx;i++){
            int minStep = Integer.MAX_VALUE;
            for(int j = 1;j<=k;j++){
               if(i-j>=0) {
                int jump = dp[i-j]+Math.abs(height[i]-height[i-j]);
                minStep = Math.min(minStep, jump);
               }
            }
            dp[i] = minStep;
        }
        return dp[idx];
    }

    public static void main(String[] args) {
        int[] height = {10, 5, 20, 0, 15};
        int[] dp = new int[5];
        Arrays.fill(dp, -1);
        System.out.println(frog(4, height, dp, 2));
        System.out.println(frog_tabulation(4, height, dp, 2));
    }
    
}
