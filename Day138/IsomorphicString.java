package Day138;

import java.util.HashMap;
import java.util.Scanner;

public class IsomorphicString {
    static boolean isIsomorphicString(String s1,String s2){
        if(s1.length() != s2.length()) return false;
        HashMap<Character,Character> mp1 = new HashMap<>();
        HashMap<Character,Character> mp2 = new HashMap<>();
        for(int i = 0;i<s1.length();i++){
            char original = s1.charAt(i);
            char replacement = s2.charAt(i);
            if(!mp1.containsKey(original)){
                if(!mp2.containsKey(replacement)){
                    mp1.put(original, replacement);
                    mp2.put(replacement, original);
                }
                else return false;
            }
            else{
                if(mp1.get(original) != replacement && mp2.get(replacement) != original) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1");
        String str1 = sc.nextLine();
        System.out.println("Enter String 1");
        String str2 = sc.nextLine();
        System.out.println(isIsomorphicString(str1, str2));
        sc.close();
    }
    
}
