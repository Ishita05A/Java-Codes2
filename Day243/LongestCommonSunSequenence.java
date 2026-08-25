package Day243;

import java.util.Arrays;

public class LongestCommonSunSequenence {
    static int memorization(String s1, int idx1, String s2, int idx2,int[][] dp){
        if(idx1 < 0 || idx2 < 0){
            return 0;
        }
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        if(s1.charAt(idx1) == s2.charAt(idx2)){
            return dp[idx1][idx2] = 1 + memorization(s1, idx1-1, s2, idx2-1, dp);
        }
        else{
            return dp[idx1][idx2] =  Math.max(memorization(s1, idx1-1, s2, idx2, dp), memorization(s1, idx1, s2, idx2-1, dp));
        }
    }
    static int tabularization(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0;i<=n;i++) dp[i][0] = 0;
        for(int j = 0;j<=m;j++) dp[0][j] = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); 
            }
        }
        return dp[n][m];
    }
    static String printSubsequence(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        StringBuilder ans = new StringBuilder();
        int i = n;
        int j = m;
        while (i>0 && j>0) {
            if(s1.charAt(i-1)== s2.charAt(j-1)){
                ans.append(s2.charAt(j-1));
                i--;
                j--;
            }
            else if(dp[i][j-1] > dp[i-1][j]){
                j--;
            }
            else i--;
        }
        return ans.reverse().toString();

    }
    static int longest(String s1, String s2){
        int idx1 = s1.length();
        int idx2 = s2.length();
        int[][] dp = new int[idx1][idx2];
        for(int i = 0;i<idx1;i++){
            Arrays.fill(dp[i],-1);
        }
        return memorization(s1, idx1-1, s2, idx2-1, dp);

    }
    public static void main(String[] args) {
        System.out.println(longest("bdefg", "bfg"));
        System.out.println(tabularization("bdefg", "bfg"));
        System.out.println(printSubsequence("bdefg", "bfg"));
    }
    
}
