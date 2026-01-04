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
                    idx = parent;
                }
                else return;
            }
        }
        void delete(){
            if(size == 0){
                System.out.println("Heap is Empty");
                return;
            }
            arr[1] = arr[size];
            size--;
            int i = 1;
            while(i<size){
                int leftIdx = 2*i;
                int rightIdx = 2*i+1;
                if(leftIdx<size && arr[leftIdx]>arr[i]){
                    int temp = arr[leftIdx];
                    arr[leftIdx] = arr[i];
                    arr[i] = temp;
                    i = leftIdx;
                }
                else if(rightIdx<size && arr[rightIdx]<arr[i]){
                    int temp = arr[rightIdx];
                    arr[rightIdx] = arr[i];
                    arr[i] = temp;
                    i = rightIdx;
                }
                else return;
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
        h.insert(9);
        h.insert(12);
        h.insert(8);
        h.insert(2);
        h.insert(8);

        h.display();
        h.delete();
        // h.delete();
        h.display();
    }
    
}
