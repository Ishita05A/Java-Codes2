package Day84;



public class ImplementStackusingArray {
    public static class Stack{
        int[] arr = new int[5];
        int size = 0;
        void push(int val){
            if(size == arr.length){
                System.out.println("Stack is Full!!");
                return;
            }
            arr[size] = val;
            size++;
        }
        int pop(){
            if(size == 0){
                System.out.println("Stack is Empty");
                return -1;
            }
            size--;
            return arr[size];
        }
        int peek(){
            if(size == 0){
                System.out.println("Stack is Empty");
                return -1;
            }
            return arr[size-1];
        }
        boolean isEmpty(){
            return size==0;
        }
        void display(){
            for(int i = 0; i<size;i++){
                System.out.print(arr[i]+" ");
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
