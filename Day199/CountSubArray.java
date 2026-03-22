package Day199;

import java.util.HashMap;
import java.util.HashSet;

public class CountSubArray {
    static int count(String str,int k){
        int count = 0;
        for(int i = 0;i<str.length();i++){
            HashSet<Character> mp = new HashSet<>();
            int c = 0;
            for(int j = i;j<str.length();j++){
                char ch = str.charAt(j);
                if(!mp.contains(ch)){
                    mp.add(ch);
                    c++;
                }
                if(c == k) count++;
                if(c>k) break;
            }
        }
        return count;
    }
    static int count_optimized(String str,int k){
        HashMap<Character,Integer> mp = new HashMap<>();
        int st = 0;
        int count = 0;
        for(int end = 0;end < str.length();end++){
            char ch = str.charAt(end);
            mp.put(ch,mp.getOrDefault(ch, 0)+1);
            while(mp.size()>k){
                char sh = str.charAt(st);
                mp.put(sh,mp.get(sh)-1);
                if(mp.get(sh) == 0){
                    mp.remove(sh);
                }
                st++;
            }
            count= count + (end-st+1);
        }
        return count;
    }
    static int count_opt(String str,int k){
        return count_optimized(str, k) - count_optimized(str, k-1);
    }
    public static void main(String[] args) {
        System.out.println(count("pqpqs", 2));
        System.out.println(count_opt("pqpqs", 2));
    }
    
}
