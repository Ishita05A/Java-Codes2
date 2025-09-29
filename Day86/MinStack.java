package Day86;
import java.util.*;
public class MinStack {
    public static class Min_Stack{
        Stack<Integer> st = new Stack<>();
        int min = Integer.MAX_VALUE;
        void push(int val){
            if(st.isEmpty()){
                st.push(val);
                min = val;
            }
            else if(val<min){
                st.push(2*val - min);
                min = val;
            }
            else{
                st.push(val);
            }
        }
        int pop(){
            if(st.isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            if(st.peek()<min){
                int ans = min;
                min = 2*ans-st.peek();
                st.pop();
                return ans;
            }
            return st.pop();
        }
        int peek(){
            if(st.isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            if(st.peek()<min){
                return min;
            }
            return st.peek();

        }
    }
    public static void main(String[] args) {
        Min_Stack st = new Min_Stack();
        st.push(3);
        st.push(2);
        st.push(5);
        st.push(-1);
        st.push(0);
        st.push(-3);
        System.out.println(st.min);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.min);
        st.pop();
        System.out.println(st.min);
        

    }
}
