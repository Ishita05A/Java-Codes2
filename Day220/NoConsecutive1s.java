package Day220;
import java.util.*;
public class NoConsecutive1s {
    static void helper(int n, List<String> ans ,String st){
        if(st.length() == n){
            ans.add(st);
            return;
        }
        helper(n, ans, st+'0');
        if(st.length() == 0  || st.charAt(st.length()-1) != '1'){
            helper(n, ans, st+'1');
        } 

    }
    static List<String> findString(int n){
        List<String> mp = new ArrayList<>();
        helper(n, mp, "");
        Collections.sort(mp);
        return mp;
    } 

    public static void main(String[] args) {
        System.out.println(findString(3));
    }
    
}
