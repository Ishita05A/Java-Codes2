package Day162;

import java.util.Scanner;

public class CheckIfStringPallindrome {
    static void isPallindrome(String str,int l,int r){
        if(l>=r){
            System.out.println("Pallindrome");
            return;
        };
        if(str.charAt(l) != str.charAt(r)){
            System.out.println("Not Pallindrome");
            return;
        } 
        isPallindrome(str, l+1, r-1);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String str = sc.nextLine();
        isPallindrome(str, 0, str.length()-1);
        sc.close();

    }
    
}
