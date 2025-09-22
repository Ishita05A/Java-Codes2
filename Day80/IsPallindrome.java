package Day80;

import java.util.Scanner;

public class IsPallindrome {
    static boolean isPallindrome(String s, int l,int r){
        if(l>=r) return true;
        return (s.charAt(l) == s.charAt(r) && isPallindrome(s, l+1, r-1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s = sc.nextLine();
        System.out.println(isPallindrome(s,0,s.length()-1));
        sc.close();
    }
    
}
