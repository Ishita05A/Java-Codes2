package Day202;

import java.util.Arrays;

public class FrogJumpWithKSteps {
    static int findMinEng(int idx,int[] height,int[] dp,int k){
        if(idx == 0) return 0;
       
        if(dp[idx] != -1) return dp[idx];
         int minStep = Integer.MAX_VALUE;
        for(int j = 1;j<=k;j++){
            if(idx - j>=0){
                int jump = findMinEng(idx-j, height, dp, k)+Math.abs(height[idx]-height[idx-j]);
                minStep = Math.min(minStep, jump);
            }
        }
        dp[idx] = minStep;
        return minStep;
    }

    public static void main(String[] args) {
        int[] height = {10, 5, 20, 0, 15};
        int[] dp = new int[5+1];
        Arrays.fill(dp, -1);
        System.out.println(findMinEng(4, height, dp, 2));
    }
    
}
