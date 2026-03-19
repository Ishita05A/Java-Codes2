package Day198;

import java.util.HashMap;

public class RoationString {
    static boolean isRotationPossible(String s, String t){
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            if(mp.containsKey(ch)){
                mp.put(ch, mp.get(ch)-1);
                if(mp.get(ch) == 0) mp.remove(ch);
            }
            else return false;
        }
        return mp.isEmpty();
    }
    static boolean isRotation_optimized(String s,String t){
        String ds = s+s;
        return ds.contains(t);
    }
    public static void main(String[] args) {
        System.out.println(isRotationPossible("hello", "lohelx"));
    }
}
