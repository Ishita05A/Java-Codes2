package Day200.Recursion;
import java.util.*;
public class SortStack {
    static void sortStack(Stack<Integer> st){
        if(!st.isEmpty()){
            int temp = st.pop();
            sortStack(st);
            insert(st, temp);
        }

    }
    static void insert(Stack<Integer> st,int temp){
        if(st.isEmpty() || st.peek()<=temp){
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
        
        sortStack(stack);
        System.out.println();
        System.out.print("Sorted stack (descending order): ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
}
