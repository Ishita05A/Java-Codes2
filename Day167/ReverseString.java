package Day167;

import java.util.Scanner;

public class ReverseString {
    static String reverse(String str){
        StringBuilder s = new StringBuilder();
        for(int i = str.length()-1;i>=0;i--){
            StringBuilder sss = new StringBuilder();
            
            while(i>=0 && str.charAt(i) != ' '){
                sss.append(str.charAt(i));
                i--;
            }
            sss.reverse();
            if(sss.length()>0) s.append(" "+sss);
        }
        return s.substring(1).toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str.length());
        System.out.println(reverse(str));
        System.out.println(reverse(str).length());
        sc.close();
    }
    
}
