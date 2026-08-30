package Day248;

import java.util.HashMap;

public class LargestSubStringWithAtMost2DistinctChar {
    static int largestSubString(String s){
        int n = s.length();
        int left = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int right = 0;right<n;right++){
            char ch = s.charAt(right);
            mp.put(ch, mp.getOrDefault(ch,0)+1);
            while (mp.size() > 2) {
                char sh = s.charAt(left);
                mp.put(sh, mp.get(sh)-1);
                if(mp.get(sh) == 0) mp.remove(sh);
                left++;
            }
            max = Math.max(max,right-left+1);
        }
        return max;

    }
    public static void main(String[] args) {
        System.out.println(largestSubString("ccaabbb"));
    }
}
