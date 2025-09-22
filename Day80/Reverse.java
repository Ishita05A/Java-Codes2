package Day80;

import java.util.Scanner;

public class Reverse{
    static String reverse(String s){
        if(s.length() == 0) return "";
        String smallAns = reverse(s.substring(1 ));
        char ch = s.charAt(0);
        return smallAns+ch;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String s = sc.nextLine();
        System.out.println(reverse(s));
        sc.close();
    }
}