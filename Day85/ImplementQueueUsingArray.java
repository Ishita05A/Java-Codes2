package Day85;

public class ImplementQueueUsingArray {
    public static class Queue {
        int[] arr = new int[5];
        int size = 0;
        int front = -1;
        int rear = -1;

        void add(int val) {
            if (size == arr.length) {
                System.out.println("Queue is Full");
                return;
            }
            if (size == 0) {
                front = 0;
                rear = 0;
                arr[front] = val;
            } else if (rear == arr.length - 1) {
                rear = 0;
                arr[rear] = val;
            } else {
                arr[++rear] = val;
            }
            size++;
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int ans = arr[front];
            if (front == arr.length - 1) {
                front = 0;
            } else
                front++;
            size--;
            if(size == 0) front=rear=-1;
            return ans;
        }

        int element() {
            if (size == 0) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return arr[front];
        }

        boolean isEmpty() {
            return size == 0;
        }
        void display(){
            if(size == 0){
                System.out.println("Queue is Empty");
                return;
            }
            if(rear < front){
                for(int i = front;i<arr.length;i++){
                    System.out.print(arr[i]+" ");
                }
                for(int i = 0;i<=rear;i++){
                    System.out.print(arr[i]+" ");
                }
            }
            else{
                for(int i = front;i<=rear;i++){
                    System.out.print(arr[i]+" ");
                }
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
