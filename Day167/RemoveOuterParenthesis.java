package Day167;

import java.util.Scanner;

public class RemoveOuterParenthesis {
    static String remove(String str){
        StringBuilder s = new StringBuilder();
        int count = 0;
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '('){
                if(count>0) s.append(ch);
                count++;
            }
            else {
                count--;
                if(count >0) s.append(ch);
            }
        }
        return s.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(remove(str));
        sc.close();
        
    }
    
}
