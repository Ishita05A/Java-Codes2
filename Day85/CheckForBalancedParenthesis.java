package Day85;

import java.util.Scanner;
import java.util.Stack;

public class CheckForBalancedParenthesis {
    static boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch=='{' ) st.push(ch);
            else if(st.size() == 0 && (ch == ')' || ch == ']' || ch=='}')) return false;
            else{
                if(st.peek()== '(' && ch == ')')st.pop(); 
                else if(st.peek()== '[' && ch == ']')st.pop(); 
                else if(st.peek()== '{' && ch == '}')st.pop(); 
                else return false;
            }

        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Parenthesis");
        String str = sc.nextLine();
        System.out.println(isValid(str));
        sc.close();
        
    }
    
}
