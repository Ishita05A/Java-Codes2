package Day90;

import java.util.Scanner;

public class LargestOddString {
    static String largest_odd(String str){
        int idx = 0;
        
        while(idx<str.length() && str.charAt(idx) == '0') idx++;

        if(idx == str.length()) return "";
        str = str.substring (idx,str.length());

        for(int i = str.length()-1;i>=0;i--){
            if((str.charAt(i)-'0')%2 == 1) return str.substring(0, i+1);
        }
        return "";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression");
        String str = sc.nextLine();
        System.out.println(largest_odd(str));
        sc.close();
    }
    
}
