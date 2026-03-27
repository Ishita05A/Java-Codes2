package Day202;
import java.util.*;
public class LongestCommon {
    static void helper(String s,StringBuilder curr,List<String> a,int idx){
        if(idx == s.length()){
            a.add(curr.toString());
            return;
        }
        helper(s, curr, a, idx+1);
        curr.append(s.charAt(idx));
        helper(s, curr, a, idx+1);
        curr.deleteCharAt(curr.length()-1);
    }
    static int lcsGreedyLike(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    int[][] dp = new int[n + 1][m + 1];

    for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
            if (s1.charAt(i) == s2.charAt(j)) {
                dp[i][j] = 1 + dp[i + 1][j + 1];
            } else {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
    }

    int i = 0, j = 0;
    int count = 0;

    while (i < n && j < m) {
        if (s1.charAt(i) == s2.charAt(j)) {
            count++;
            i++;
            j++;
        } else if (dp[i + 1][j] > dp[i][j + 1]) {
            i++;  
        } else {
            j++;  
        }
    }

    return count;
}
    static List<String> longestCommon(String s){
        List<String> ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        helper(s, curr, ans, 0);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(longestCommon("abc"));
    }
    
}
