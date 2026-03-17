package Day197;

import java.util.HashMap;

public class Isomorphic {
    static boolean isIsomorphic(String s, String t){
        HashMap<Character,Character> mp = new HashMap<>();
        if(s.length() != t.length()) return false;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            char sh = t.charAt(i);
            if(!mp.containsKey(ch)){
                mp.put(ch,sh);
            }
            else if(mp.containsKey(ch)){
                if(mp.get(ch) != sh ) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isIsomorphic("foo", "bar"));
    }
    
}
