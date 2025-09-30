package Day87;

import java.util.Scanner;
import java.util.Stack;

public class infixEvalution {
    static int evaluate(String str) {
        Stack<Character> op = new Stack<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;
            if (ascii >= 48 && ascii <= 57)
                st.push(ascii - 48);
            else if (op.size() == 0 || ch == '(' || op.peek() == '(')
                op.push(ch);
            else if (ch == ')') {
                while (op.peek() != '(') {
                    int v2 = st.pop();
                    int v1 = st.pop();
                    if (op.peek() == '+')
                        st.push(v1 + v2);
                    else if (op.peek() == '-')
                        st.push(v1 - v2);
                    else if (op.peek() == '*')
                        st.push(v1 * v2);
                    else if (op.peek() == '/')
                        st.push(v1 / v2);
                        op.pop();
                }
                op.pop();
            } else {
                if (ch == '+' || ch == '-') {
                    int v2 = st.pop();
                    int v1 = st.pop();
                    if (op.peek() == '+')
                        st.push(v1 + v2);
                    else if (op.peek() == '-')
                        st.push(v1 - v2);
                    else if (op.peek() == '*')
                        st.push(v1 * v2);
                    else if (op.peek() == '/')
                        st.push(v1 / v2);
                    op.pop();
                    op.push(ch);

                } if(ch == '*' || ch == '/') {
                    if (op.peek() == '*' || op.peek() == '/') {
                        int v2 = st.pop();
                        int v1 = st.pop();
                        if (op.peek() == '*')
                            st.push(v1 * v2);
                        if (op.peek() == '/')
                            st.push(v1 / v2);
                        op.pop();
                        op.push(ch);
                    } else
                        op.push(ch);
                }
            }
        }
        while (!op.isEmpty()) {
            int v2 = st.pop();
            int v1 = st.pop();
            if (op.peek() == '+')
                st.push(v1 + v2);
            else if (op.peek() == '-')
                st.push(v1 - v2);
            else if (op.peek() == '*')
                st.push(v1 * v2);
            else if (op.peek() == '/')
                st.push(v1 / v2);
            op.pop();

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
