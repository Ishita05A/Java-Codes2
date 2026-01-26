package Day163;

import java.util.Scanner;

public class PallindromeString {
    static boolean isPallindrome(String str,int l,int r){
        if(l>=r) return true;
        if(str.charAt(l) != str.charAt(r)) return false;
        return isPallindrome(str, l+1, r-1);  
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String str = sc.nextLine();
        System.out.println(isPallindrome(str, 0, str.length()-1));
        sc.close();

    }
    
}
