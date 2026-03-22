package Day200.Recursion;

import java.util.Stack;

public class ReverseStack {
    static void reverse(Stack<Integer> st){
        if(st.isEmpty()) return;
        int temp = st.pop();
        reverse(st);
        insert(st, temp);
    }
    static void insert(Stack<Integer> st,int temp){
        if(st.isEmpty()){
            st.push(temp);
            return;
        }
        int val = st.pop();
        insert(st, temp);
        st.push(val);
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        
        reverse(stack);
        System.out.print("Reversed stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
}
