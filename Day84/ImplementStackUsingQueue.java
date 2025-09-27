package Day84;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {
    public static class Stack{
        Queue<Integer> q = new LinkedList<>();
        int size = 0;
        void push(int val){
            q.add(val);
            size++;
        }
        int pop(){
            if(size == 0){
                System.out.println("Stack is Empty");
                return -1;
            }
            for(int i = 0;i<size-1;i++){
                q.add(q.remove());
            }
            int ans = q.remove();
            size--;
            return ans;
        }
        int peek(){
            if(size == 0){
                System.out.println("Stack is Empty");
                return -1;
            }
            for(int i = 0;i<size-1;i++){
                q.add(q.remove());
            }
            int ans = q.element();
            q.add(q.remove());
            return ans;
        }
        boolean isEmpty(){
            return size == 0;
        }
        void display(){
            for(int i = 0;i<=size-1;i++){
                System.out.print(q.element()+" ");
                q.add(q.remove());
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(5);
        st.push(7);
        st.push(8);
        st.push(0);
        st.push(1);
        st.display();
        st.push(8);
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.size);
    }
    
}
