package Day147;

import java.util.Scanner;

public class MinimumWindowSubString {
    static String minimum_window_brute(String s,String t){
        int minLen = Integer.MAX_VALUE;
        int s_idx = 0;
        for(int i = 0;i<s.length();i++){
            int count = 0;
            
            int[] hash = new int[256];
            for(int j = 0;j<t.length();j++){
                char ch = t.charAt(j);
                hash[ch-'A']++;
            }
            for(int j = i;j<s.length();j++){
                char ch = s.charAt(j);
                if(hash[ch-'A'] >0) count++;
                hash[ch-'A']--;
                if(count == t.length()){
                     if(j-i+1 < minLen){
                        minLen = j-i+1;
                        s_idx = i;
                     }
                }
            }
        }
        return s.substring(s_idx,s_idx+minLen);
    }
    static String minimum_window_optimized(String s,String t){
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        int s_idx = 0;
        int l =0;
        int[] hash = new int[256];
        for(int i = 0;i<t.length();i++){
            hash[t.charAt(i)-'A']++;
        }
        for(int r = 0;r<s.length();r++){
            char ch = s.charAt(r);
            if(hash[ch-'A']>0) count++;
            hash[ch-'A']--;
            while(count == t.length()){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    s_idx = l;
                }
                hash[s.charAt(l)-'A']++;
                if(hash[s.charAt(l)-'A']>0) count--;
                l++;
            }
        }
        if(minLen == Integer.MAX_VALUE) return "";
        return s.substring(s_idx, s_idx+minLen);
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1");
        String s = sc.nextLine();
        System.out.println("Enter String 2");
        String t = sc.nextLine();
        System.out.println(minimum_window_brute(s, t));
        System.out.println(minimum_window_optimized(s, t)); 
        sc.close();

    }
    
}
