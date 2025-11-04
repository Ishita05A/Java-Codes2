package Day105;

import java.util.Scanner;

public class PallindromString {
    static boolean isPallindrome(String s){
        
        StringBuilder str = new StringBuilder("");
        for(int i = 0;i<s.length();i++){
           if(Character.isLetterOrDigit(s.charAt(i)))  str.append(Character.toLowerCase(s.charAt(i)));
           else continue;
        }
        int i = 0;
        int j = str.length();
        while(i<j){
            if(str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String str = sc.nextLine();
        System.out.println(isPallindrome(str));
        sc.close();
        
    }
    
}
