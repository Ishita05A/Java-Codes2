package Day145;

import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithKdistictChar {
    static int longestSubString(String s,int k){
        int max = 0;
        int l = 0;
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int r = 0;r<s.length();r++){
            char ch = s.charAt(r);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
            while(l<s.length() && mp.size() > k){
                char gh = s.charAt(l);
                mp.put(gh, mp.getOrDefault(gh, 0)+1);
                if(mp.get(gh)==0) mp.remove(gh);
                l++;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s = sc.nextLine();
        System.out.println(longestSubString(s, 2));
        sc.close();
    }
    
}
