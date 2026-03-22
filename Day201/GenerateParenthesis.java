package Day201;
import java.util.*;
public class GenerateParenthesis {
    static void helper(List<String> ans,String s,int n,int open,int close){
        if(s.length() == 2*n){
            ans.add(s);
            return;
        }
        if(open < n) helper(ans, s+'(', n, open+1,close);
        if(close<open) helper(ans, s+')', n, open,close+1); 
    }
    static List<String> generate(int n){
        List<String> s = new ArrayList<>();
        helper(s, "", n, 0,0);
        return s;
    }
    public static void main(String[] args) {
        System.out.println(generate(3));
    }
}
