package Day242;

import java.util.Arrays;

public class RodCuttingProblem {
    static int helper2(int[] price,int idx, int N,int[][] dp){
        for(int i = 0;i<=N;i++){
            dp[0][i] = i*price[0];
        }
        for(int i = 1;i<price.length;i++){
            for(int j = 2;j<=N;j++){
                int notPick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(i+1 <=j) pick = dp[i][j-i-1] + price[i];
                dp[i][j] = Math.max(notPick, pick);
            }
        }
        return dp[price.length-1][N];
    }

    static int helper(int[] price, int idx, int N, int[][] dp){
        if(idx == 0) return N * price[idx];
        if(dp[idx][N] != -1) return dp[idx][N];
        int notPick = helper(price, idx-1, N, dp);
        int pick = Integer.MIN_VALUE;
        if(idx +1 <= N) pick = price[idx] + helper(price, idx, N-idx-1, dp);
        return dp[idx][N] = Math.max(notPick, pick);

    }
    static int maxPrice(int[] price){
        int n = price.length;
        int[][] dp = new int[n][n+1];
         System.out.println(helper2(price, n-1, n, dp));
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
       
        return helper(price, n-1, n, dp);
    }
    public static void main(String[] args) {
        int[]  price = {1, 6, 8, 9, 10, 19, 7, 20};
        System.out.println(maxPrice(price));
    }
    
}
