package Day87;

import java.util.Scanner;
import java.util.Stack;

public class postFix {
    static String evaluate(String str) {
        Stack<String> st = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57) {
                st.push(ch + "");
            } else if (op.size() == 0 || ch == '(' || op.peek() == '(')
                op.push(ch);
            else if (ch == ')') {
                while (op.peek() != '(') {
                    String v2 = st.pop();
                    String v1 = st.pop();
                    char c = op.pop();
                    st.push(c + v1 + v2);
                }
                op.pop();
            }
            else{
                if(ch == '+' || ch == '-'){
                    String v1 = st.pop();
                    String v2 = st.pop();
                    char c = op.pop();
                    st.push(c + v1 + v2);
                    op.push(ch);
                }
                else{
                    if(op.peek() == '*' || op.peek() == '/'){
                        String v2 = st.pop();
                    String v1 = st.pop();
                    char c = op.pop();
                    st.push(c + v1 + v2);
                    op.push(ch);
                    }
                    else op.push(ch);
                }
            }

        }
        while(!op.isEmpty()){
            String v2 = st.pop(); 
            String v1 = st.pop();
            char c = op.pop();
            st.push(c+v1+v2); 
        }
        return st.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Expression");
        String str = sc.nextLine();
        System.out.println(evaluate(str));
        sc.close();
    }

}
