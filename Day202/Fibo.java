package Day202;

import java.util.Arrays;

public class Fibo {
    static int fibo_tabularization(int n,int[] dp){
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    static int fibo_dp(int n,int[] dp){
        if(n<=1) return n;
        if(dp[n] != -1) return dp[n];
        dp[n] = fibo_dp(n-1, dp) + fibo_dp(n-2, dp);
        return dp[n];
    }
    static int fibo_rec(int n){
        if(n == 0 || n == 1) return n;
        return fibo_rec(n-1) + fibo_rec(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fibo_rec(5));

        int[] dp = new int[5+1];
        Arrays.fill(dp, -1);
        System.out.println(fibo_dp(5, dp));
        System.out.println(fibo_tabularization(5, dp));
    }
    
}
