package Day220;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    static void helper(List<String> a, String s,String sub, int idx){
        if(idx == s.length()){
            if(sub.length() >0 )a.add(sub);
            return;
        }
        helper(a, s, sub,idx+1);
        helper(a, s, sub+s.charAt(idx), idx+1);
    }
    static List<String> power(String s){
        List<String> a = new ArrayList<>();
        helper(a, "abc", "", 0);
        return a;
    }
    public static void main(String[] args) {
        System.out.println(power("abc"));
    }
    
}
