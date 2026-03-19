package Day197;

import java.util.HashMap;

public class Isomorphic {
    static boolean isIsomorphic(String s, String t){
        HashMap<Character,Character> mp = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(int i=0;i<s.length();i++){
            char original = s.charAt(i);
            char replacement = t.charAt(i);
            if(mp.containsKey(original)){
                if(mp.get(original) != replacement) return false;
            }
            else{
                mp.put(original, replacement);
            }
    
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
    }
    
}
