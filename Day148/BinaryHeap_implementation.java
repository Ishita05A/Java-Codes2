package Day148;

public class BinaryHeap_implementation {
    static class BinaryHeap{
        int[] arr;
        int size;
        int capacity;
        BinaryHeap(int cap){
            capacity = cap;
            size = 0;
            arr= new int[capacity];
        }
        void insert(int val){
            if(size == capacity-1){
                System.out.println("Heap is Full!!");
                return;
            }
            size = size+1;
            int idx = size;
            arr[idx] = val;
            while(idx>1){
                int parent = idx/2;
                if(arr[idx]>arr[parent]){
                    int temp = arr[idx];
                    arr[idx] = arr[parent];
                    arr[parent] = temp;
                    idx = parent;
                }
                else return;
            }
        }
        void swap(int[] arr,int i,int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        void delete(){
            arr[1] = arr[size];
            size--;
            int i = 1;
            while(i<size){
                int leftIdx = 2*i;
                int rightIdx = 2*i+1;
                if(leftIdx<size && arr[i]<arr[leftIdx]){
                    swap(arr,leftIdx,i);
                    i = leftIdx;
                }
                else if(rightIdx<size && arr[i]<arr[rightIdx]){
                    swap(arr,rightIdx,i);
                    i = rightIdx;
                }
                else return;
            }
        }
        void display(){
            for(int i=1;i<=size;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
        void heapify(int[] arr,int size,int i){
            int largest = i;
            int left = 2*i;
            int right = 2*i+1;
            if(left<size && arr[i]<arr[left]) largest = left;
            else if(right <size && arr[i]<arr[right]) largest = right;
            if(largest != i){
                swap(arr, largest, i);
                heapify(arr, size, largest);
            }
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
        int arr[] = {-1,54,53,55,52,50};
        int n = 5;
        for(int i = n/2;i>=1;i--){
            h.heapify(arr, n, i);
        }
        for(int i = 1;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
    
}
