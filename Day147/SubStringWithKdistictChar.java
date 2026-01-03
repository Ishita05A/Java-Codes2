package Day147;

import java.util.HashMap;
import java.util.Scanner;

public class SubStringWithKdistictChar {
    static int longest_subString_brute(String s,int k ){
        int maxLen = 0;
        for(int i = 0;i<s.length();i++){
            HashMap<Character,Integer> mp = new HashMap<>();
            for(int j = i;j<s.length();j++){
                mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0)+1);
                if(mp.size()>k) break;
                if(mp.size()<=k) maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
    static int longest_substring_optimized(String s,int k){
        int l = 0;
        int maxLen = 0;
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int r = 0;r<s.length();r++){
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r),0)+1);
            while(mp.size()>k){
                mp.put(s.charAt(l),mp.getOrDefault(s.charAt(l), 0)-1);
                if(mp.get(s.charAt(l))==0) mp.remove(s.charAt(l));
                l++;
            }
            maxLen =Math.max(maxLen, r-l+1);
        }
        return maxLen;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s = sc.nextLine();
        System.out.println(longest_subString_brute(s, 2));
        System.out.println(longest_substring_optimized(s, 2));
        sc.close();
    }

    
}
