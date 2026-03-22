package Day200.Recursion;
import java.util.*;
public class PowerSet {
    static void helper(String s,int idx,StringBuilder curr,List<String> ans){
        if(idx == s.length()){
            if(curr.length()>0)
                ans.add(curr.toString());
            return;
        }
        helper(s, idx+1, curr, ans);
        curr.append(s.charAt(idx));
        helper(s, idx+1, curr, ans);
        curr.deleteCharAt(curr.length()-1);
        
    } 
    static List<String> powerSet(String s){
        List<String> ans = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        helper(s, 0, curr, ans);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(powerSet("abc"));
    }
    
}
