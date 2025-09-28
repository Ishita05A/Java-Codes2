package Day85;

import java.util.Stack;

public class ImplementMinStack {
    public static class minStack{
        Stack<Integer> st = new Stack<>();
        int size = 0;
        int min = Integer.MAX_VALUE;
        void push(int val){
            if(st.isEmpty()){
                st.push(val);
                min = val;
                return;
            }
            if(min>val){
                st.push(2*val-min);
                min = val;
            }
            else st.push(val);
        }
        int pop(){
            if(st.isEmpty()){
                System.out.println("Stack is Empty");
                return -1;
            }
            if(st.peek()<=min){
                int ans = min;
                min = min - st.peek();
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
            if(st.peek()<min)
                return min;
            return st.peek();
        } 
    }
    public static void main(String[] args) {
        
    }
    
}
