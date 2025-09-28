package Day85;

import java.util.Stack;

public class ImplementQueueUsingStack {
    public static class Queue{
        Stack<Integer> st = new Stack<>();
        Stack<Integer> gt = new Stack<>();
        int size = 0;
        void add(int val){
            st.push(val);
            size++;
        }
        int remove(){
            if(size==0){
                System.out.println("Queue is Empty");
                return -1;
            }
            for(int i=1;i<size;i++){
                gt.push(st.pop());
            }
            int ans = st.pop();
            while(!gt.isEmpty()) st.push(gt.pop());
            size--;
            return ans;
        }
        int element(){
            if(size == 0){
                System.out.println("Queue is Empty");
                return -1;
            }
            for(int i=1;i<size;i++){
                gt.push(st.pop());
            }
            int ans = st.peek();
            while(!gt.isEmpty()) st.push(gt.pop());
            return ans;
        }
        boolean isEmpty(){
            return size==0;
        }
        void display(){
            while(!st.empty()) gt.push(st.pop());
            while(!gt.isEmpty()){
                System.out.print(gt.peek()+" ");
                st.push(gt.pop());
            }
            System.out.println();
        }
        
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(4);
        q.add(6);
        q.add(7);
        q.add(9);
        q.add(8);
        q.display();
        System.out.println(q.remove());
        System.out.println(q.element());
        System.out.println(q.remove());
        q.add(0);
        q.display();
        System.out.println(q.size);

    }
    
}
