package Day147;

public class Heap_insertion {
    static class BinaryHeap {
        int size;
        int capacity;
        int[] arr;

        BinaryHeap(int cap) {
            capacity = cap;
            size = 0;
            arr = new int[capacity];
            arr[0] = -1;
        }

        void insert(int x) {
            if (size == capacity-1) {
                System.out.println("Binary Heap OverFlown");
                return;
            }
            size = size + 1;
            int idx = size;
            arr[idx] = x;
            while (idx > 1) {
                int parent = idx / 2;
                if (arr[parent] < arr[idx]) {
                    int temp = arr[parent];
                    arr[parent] = arr[idx];
                    arr[idx] = temp;
                    idx = parent;
                } else
                    break;
            }
        }
        void display(){
            for(int i=1;i<=size;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinaryHeap h = new BinaryHeap(5);
        h.insert(2);
        h.insert(4);
        h.insert(5);
        h.insert(1);
        h.display();
        h.insert(4);
    }

}
