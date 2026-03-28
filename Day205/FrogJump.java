package Day205;

public class FrogJump {
    static int spaceOpt(int[] height,int idx){
        int prev1 = 0;
        int prev2 = 0;
        for(int i = 2;i<=idx;i++){
            int fs = prev1 + Math.abs(height[i]-height[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1) ss = prev2 + Math.abs(height[i]-height[i-2]);
            int curr = Math.min(fs, ss);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;

    
    }
    static int frog_tabular(int[] height,int idx,int[] dp){
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<idx;i++){
            int left = dp[i-1] +Math.abs(height[i] - height[i-1]); 
            int right = dp[i-2] + Math.abs(height[i] - height[i-2]);
            dp[i] = Math.min(left, right); 
        }
        return dp[idx];
    }
    static int frog_memo(int[] height,int idx,int[] dp){
        if(idx == 0) return 0;
        if(idx == 1 ) return 1;
        if(dp[idx] == -1) return dp[idx];
        int step1 = frog_memo(height, idx-1,dp) + Math.abs(height[idx] - height[idx-1]);
        int step2 = Integer.MAX_VALUE;
        if(idx > 1) step2 = frog_memo(height, idx-2,dp) + Math.abs(height[idx] - height[idx-2]);
        dp[idx] = Math.min(step1, step2);
        return dp[idx];
        
    }
    static int frogJump(int[] height,int idx){
        if(idx == 0) return 0;
        if(idx == 1) return 1;
        int step1 = frogJump(height, idx-1) + Math.abs(height[idx] - height[idx-1]);
        int step2 = Integer.MAX_VALUE;
        if(idx > 1) step2 = frogJump(height, idx-2) + Math.abs(height[idx] - height[idx-2]);
        return Math.min(step1, step2);
    }
    public static void main(String[] args) {
         int[] heights = {2, 1, 3, 5, 4};
         System.out.println(frogJump(heights, 4));
         int[] dp = new int[5];
         System.out.println(frog_memo(heights, 4, dp));
         System.out.println(frog_tabular(heights, 4, dp));
         System.out.println(spaceOpt(heights, 4));
         
    }
    
}
