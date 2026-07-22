package Day234;

import java.util.HashMap;

public class CountNumberOfSubStrings {
    static int atMost(String s, int k){
        if(k == 0) return 0;
        HashMap<Character,Integer> mp = new HashMap<>();
        int ans = 0;
        int left = 0;
        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
            while(mp.size() > k){
                char sh = s.charAt(left);
                mp.put(sh, mp.get(sh)-1);
                if(mp.get(sh) == 0){
                    mp.remove(sh);
                }
                left++;
            }
            ans+=(right-left+1);
        }
        return ans;
    }
    static int countSubStrings(String s, int k){
        return atMost(s, k) - atMost(s, k-1);
    }
    public static void main(String[] args) {
        System.out.println(countSubStrings("pqpqs", 2));
    }
    
}
