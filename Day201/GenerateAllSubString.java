package Day201;
import java.util.*;
public class GenerateAllSubString {
    static void helper(List<String> ans,int n,String curr){
        if(curr.length() == n){
            ans.add(curr);
            return;
        }
        helper(ans, n, curr+'0');
        if(curr.length() == 0 || curr.charAt(curr.length()-1) != '1'){
            helper(ans, n, curr+'1');
        }
    }
    static List<String> generate(int n){
        List<String> ans = new ArrayList<>();
    
       helper(ans,n,"");
       return ans;
    }
    public static void main(String[] args) {
        System.out.println(generate(3));
    }
    
}
