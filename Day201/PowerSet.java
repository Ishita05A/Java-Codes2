package Day201;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    static void helper(List<String> ans,String s,String curr,int idx){
        if(idx == s.length()){
            ans.add(curr);
            return;
        }
        helper(ans,s,curr,idx+1);
        helper(ans,s,curr+s.charAt(idx),idx+1);
    }
     static List<String> powerSet(String s){
        List<String> ans = new ArrayList<>();
        helper(ans, s ,"", 0);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(powerSet("abc"));
    }
    
}
