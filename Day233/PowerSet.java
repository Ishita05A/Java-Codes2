import java.util.*;
public class PowerSet {
    static void helper(List<String> a, int idx, String s, String ans){
        if(idx == s.length()){
            if(ans.length() > 0) a.add(ans);
            return;
        }
        helper(a, idx+1, s, ans);
        helper(a, idx+1, s, ans+s.charAt(idx));
    }

    static List<String> powerSet(String s){
        List<String> a = new ArrayList<>();
        helper(a, 0, s, "");
        return a;

    }
    public static void main(String[] args) {
        System.out.println(powerSet("abc"));
    }
    
}
