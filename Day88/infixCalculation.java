package Day88;

import java.util.Scanner;
import java.util.Stack;

public class infixCalculation {

    static char prevChar(String str, int idx){
        int j = idx-1;
        while(j >= 0 && str.charAt(j) == ' ') j--;
        return (j >= 0) ? str.charAt(j):'\0';
    }

    static int precedence(char ch) {
        if (ch == '-' || ch == '+')
            return 1;
        if (ch == '*' || ch == '/')
            return 2;
        return 0;
    }


    static int applyop(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if(b == 0) throw new UnsupportedOperationException("Cannot divide by 0");
                return a / b;
        }
        return 0;
    }

    static int evaluate(String str) {
        Stack<Character> op = new Stack<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ')
                continue;
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num = num * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                st.push(num);
            } else if (ch == '(')
                op.push(ch);
            else if (ch == ')') {
                while (op.peek() != '(') {
                    int v2 = st.pop();
                    int v1 = st.pop();
                    st.push(applyop(v1, v2, op.pop()));
                }
                op.pop();
            } else {
                char prev = prevChar(str,i);
                if(ch == '-' && (i == 0 || prev == '(' || "+-*/".indexOf(prev)!=-1))
                st.push(0);

                while (!op.isEmpty() && precedence(op.peek()) >= precedence(ch)) {
                    int v2 = st.pop();
                    int v1 = st.pop();
                    st.push(applyop(v1, v2, op.pop()));

                }
                op.push(ch);
            }
        }
        while (!op.isEmpty()) {
            int v2 = st.pop();
            int v1 = st.pop();
            st.push(applyop(v1, v2, op.pop()));

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
