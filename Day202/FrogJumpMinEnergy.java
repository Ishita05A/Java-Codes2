package Day202;

import java.util.Arrays;

public class FrogJumpMinEnergy {
    static int findMinEnergy(int n,int[] height){
        if(n == 0) return 0;
        int left = findMinEnergy(n-1, height) + Math.abs(height[n]-height[n-1]);
        int right = Integer.MAX_VALUE;
        if(n>1)
            right = findMinEnergy(n-2, height) + Math.abs(height[n] - height[n-2]);
        return Math.min(left, right);
    }
    static int findMinEnergy_Memorization(int n,int[] height,int[] dp){
        if(n == 0) return 0;
        if(dp[n] != -1) return dp[n];
        int left = findMinEnergy_Memorization(n-1, height, dp) + Math.abs(height[n]-height[n-1]);
        int right = Integer.MAX_VALUE;
        if(n>1){
            right = findMinEnergy_Memorization(n-2, height, dp) + Math.abs(height[n] - height[n-2]);
        }
        dp[n] = Math.min(left, right);
        return Math.min(left, right);
        
    }
    static int find_Tabularization(int n,int[] height,int[] dp){
        dp[0] = 0;
        for(int i = 1;i<=n;i++){
            int left = dp[i-1] + Math.abs(height[i]-height[i-1]);
            int right = Integer.MAX_VALUE;
            if(i>1){
                right = dp[i-2] + Math.abs(height[i]-height[i-2]);
            }
            dp[n] = Math.min(left, right);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] height = {2, 1, 3, 5, 4};
        System.out.println(findMinEnergy(4, height));
        int[] dp = new int[5+1];
        Arrays.fill(dp, -1);
        System.out.println(findMinEnergy_Memorization(4, height, dp));
        System.out.println(find_Tabularization(4, height, dp));
    }
    
}
