package Day90;

import java.util.Scanner;


public class RemoveOuterParenthesis {
    static String remove_outer(String str){
        StringBuilder s = new StringBuilder();
        
        int count = 0;
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '('){
                count++;
                if(count>1) s.append(ch);
            }
            else{
                if(count != 1) s.append(ch);
                count--;
            }
        }
        
       return s.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression");
        String str = sc.nextLine();
        System.out.println(remove_outer(str));
        sc.close();
    }

}
