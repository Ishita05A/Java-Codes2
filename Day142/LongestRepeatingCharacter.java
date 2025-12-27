package Day142;

import java.util.Scanner;

public class LongestRepeatingCharacter {
    static int findLongestRepetingCharacter(String s,int k){
        int maxlen = 0;
        for(int i = 0;i<s.length();i++){
            int[] hash = new int[26];
            int maxf= 0;
            for(int j = i;j<s.length();j++){
                char ch = s.charAt(j);
                hash[ch-'A']++;
                maxf = Math.max(maxf, hash[ch-'A']);
                int changes = j-i+1-maxf;
                if(changes<=k){
                    maxlen = Math.max(maxlen, j-i+1);
                }
                else break;
            }
        }
        return maxlen;
    }
    static int findLongestRepetingCharacter_better(String s,int k){
        int maxLen = 0;
        int l = 0,r = 0;
        int n = s.length();
        int[] hash = new int[26];
        int maxf = 0;
        while(r<n){
            char ch = s.charAt(r);
            hash[ch - 'A']++;
            maxf = Math.max(maxf,hash[ch-'A']);
            while(r-l+1-maxf >k){
                hash[s.charAt(l)-'A']--;
                maxf = 0;
                for(int i = 0;i<26;i++){
                    maxf = Math.max(maxf, hash[i]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
    static int findLongestRepetingCharacter_optimal(String s,int k){
        int maxLen = 0;
        int l = 0,r= 0;
        int maxf = 0;
        int[] hash = new int[26];
        while(r<s.length()){
            char ch = s.charAt(r);
            hash[ch-'A']++;
            maxf = Math.max(maxf, hash[ch-'A']);
            if(r-l+1-maxf > k){
                hash[s.charAt(l)-'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s = sc.nextLine();
        System.out.println(findLongestRepetingCharacter(s, 2));
        System.out.println(findLongestRepetingCharacter_better(s, 2));
        System.out.println(findLongestRepetingCharacter_optimal(s, 2));
        sc.close();
    }
    
}
