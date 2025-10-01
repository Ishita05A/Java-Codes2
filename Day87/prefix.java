package Day87;

import java.util.Scanner;
import java.util.Stack;

public class prefix {
    static String evaluate(String str) {
        Stack<String> st = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (ch >= '0' && ch <= '9') {
                st.push(ch + "");
            } else if (op.size() == 0 || ch == '(' || op.peek() == '(')
                op.push(ch);
            else if (ch == ')') {
                while (op.peek() != '(') {
                    String v2 = st.pop();
                    String v1 = st.pop();
                    char o = op.pop();
                    st.push(v1 + v2 + o);
                }
                op.pop();

            } else {
                if (ch == '+' || ch == '-') {
                    String v2 = st.pop();
                    String v1 = st.pop();
                    char o = op.pop();
                    st.push(v1 + v2 + o);
                    op.push(ch);
                } else if(ch == '*' || ch == '/'){
                    if (op.peek() == '*' || op.peek() == '/') {
                        String v2 = st.pop();
                        String v1 = st.pop();
                        char o = op.pop();
                        st.push(v1 + v2 + o);
                        op.push(ch);
                    } else
                        op.push(ch);
                }
            }

        }
        while (!op.isEmpty()) {
            String v2 = st.pop();
            String v1 = st.pop();
            char o = op.pop();
            st.push(v1 + v2 + o);
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
