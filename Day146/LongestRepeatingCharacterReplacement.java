package Day146;

import java.util.Scanner;

public class LongestRepeatingCharacterReplacement {
    static int longest_brute(String s,int k){
        int maxLen = 0;
        for(int i = 0;i<s.length();i++){
            int[] hash = new int[26];
            int maxFreq = 0;
            for(int j = i;j<s.length();j++){
                char ch=s.charAt(j);
                hash[ch-'A']++;
                maxFreq = Math.max(maxFreq, hash[ch-'A']);
                int changes = j-i+1-maxFreq;
                if(changes>k) break;
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
    static int longest_optimized(String s,int k){
        int l = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int[] hash = new int[26];
        for(int r = 0;r<s.length();r++){
            char ch = s.charAt(r);
            hash[ch-'A']++;
            maxFreq = Math.max(maxFreq,hash[ch-'A']);
            int changes = r-l+1-maxFreq;
            while(r-l+1-maxFreq>k){
                char gh = s.charAt(l);
                hash[gh-'A']--;
                maxFreq = 0;
                for(int num:hash) maxFreq = Math.max(maxFreq, num);
                l++;
            }
            if(changes<=k){
                maxLen = Math.max(maxLen, r-l+1);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s = sc.nextLine();
        System.out.println(longest_brute(s,2));
        System.out.println(longest_optimized(s,2));
        sc.close();
    }
    
}
