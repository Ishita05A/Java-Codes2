package Day223;
import java.util.Arrays;

public class FiboonaciSeries {
    static int fibo_tabular(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2]; 
        }
        return dp[n];
    }
    static int fibo_memo(int n, int[] dp){
        if(n == 1 || n == 0) return n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = fibo(n-1) + fibo(n-2);
    }
    static int fibo(int n){
        if(n == 1 || n == 0) return n;
        return fibo(n-1)+fibo(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibo(3));
        // for(int i = 0;i<=5;i++){
        //     System.out.print(fibo(i)+" ");
        // }
        int[] dp = new int[3+1];
        Arrays.fill(dp, -1);
        System.out.println(fibo_memo(3, dp));
        System.out.println(fibo_tabular(3, dp));
    }
}