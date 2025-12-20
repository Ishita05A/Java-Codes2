package Day137;

import java.util.Scanner;

public class removeOuterParenthesis {
    static String removeOuter(String str){
        int count = 0;
        StringBuilder s = new StringBuilder("");
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '('){
                if(count != 0) s.append(ch);
                count++;
            }
            else{
                if(count>1) s.append(ch);
                count--;
            }
        }
        return s.toString();

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter parenthesis");
        String str = sc.nextLine();
        System.out.println(removeOuter(str));
        sc.close();

    }
    
}
