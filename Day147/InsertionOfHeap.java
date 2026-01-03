package Day147;

public class InsertionOfHeap {
    static class BinaryHeap{
        int size;
        int capacity;
        int arr[];
        BinaryHeap(int cap){
            size = 0;
            capacity = cap;
            arr = new int[cap];
            arr[0] = -1;
        }
        void insert(int val){
            if(size == capacity-1){
                System.out.println("Heap is overFlow");
                return;
            }
            size = size +1;
            int idx = size;
            arr[idx] = val;
            while(idx>1){
                int parent = idx/2;
                if(arr[parent]<arr[idx]){
                    int temp = arr[parent];
                    arr[parent] = arr[idx];
                    arr[idx] = temp;
                }
                idx--;
            }
        }
        void display(){
            for(int i = 1;i<=size;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        BinaryHeap h = new BinaryHeap(5);
        h.insert(3);
        h.insert(5);
        h.insert(6);
        h.insert(7);
        h.insert(8);
        h.display();
    }
    
}
