import java.util.ArrayList;
import java.util.List;

public class GenerateString {
    static void helper(int n, int idx, String s, List<String> a){
        if(s.length() == n){
            a.add(s);
            return;
        }
        helper(n, idx+1, s+'0', a);
        if((idx == 0) || (idx>0 && s.charAt(idx-1) != '1')) helper(n, idx+1, s+'1', a);
    }
    static List<String> genrate(int n){
        List<String> a = new ArrayList<>();
        helper(n, 0, "", a);
        return a;
    }
    public static void main(String[] args) {
        System.out.println(genrate(3));
    }
    
}
