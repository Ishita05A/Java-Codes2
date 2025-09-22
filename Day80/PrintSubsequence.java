package Day80;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintSubsequence {
    static ArrayList<String> subSequence(String s){
        ArrayList<String> ans = new ArrayList<>();
        if(s.length() == 0) {
            ans.add("");
            return ans;
        }
        char ch = s.charAt(0);
        ArrayList<String> smallAns = subSequence(s.substring(1));
        
        for(String ss:smallAns){
            ans.add(ss);
            ans.add(ch + ss);
        } 
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s = sc.nextLine();
        System.out.println(subSequence(s));
        sc.close();
    }
}
