package Day146;

import java.util.HashMap;
import java.util.Scanner;

public class LargestNonReapetingSubString {
    static int longest_brute(String s){
        int maxlen = 0;
        for(int i = 0;i<s.length();i++){
            int[] hash = new int[255];
             for(int j = i;j<s.length();j++){
                
                if(hash[s.charAt(j)] == 1) break;
                hash[s.charAt(j)]++;
                maxlen = Math.max(j-i+1,maxlen);
             }
        }
        return maxlen;
    }
    static int longest_optimized(String s){
        int maxLen = 0;
        int l = 0;
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int r = 0;r<s.length();r++){
            char ch = s.charAt(r);
            if(!mp.containsKey(ch)) mp.put(ch, r);
            else{
                if(mp.get(ch)>=l) l = mp.get(ch)+1;
                mp.put(ch, r);
            }
            maxLen = Math.max(maxLen, r-l+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s = sc.nextLine();
        System.out.println(longest_brute(s));
        System.out.println(longest_optimized(s));
        sc.close();
    }
    
}
