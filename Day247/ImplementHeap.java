package Day247;

public class ImplementHeap {
    static class BinaryHeap {
        int capacity;
        int size;
        int[] heap;

        BinaryHeap(int capacity) {
            if (capacity <= 0) {
                throw new IllegalArgumentException("Heap Capacity must be greater then 0");
            }
            this.capacity = capacity;
            this.size = 0;
            this.heap = new int[capacity];
        }

        // Returns the parent index of ith node
        int parent(int i) {
            return (i - 1) / 2;
        }

        // Returns the left index
        int left(int i) {
            return 2 * i + 1;
        }

        // Returns the right index
        int right(int i) {
            return 2 * i + 2;
        }

        void insert(int val) {
            if (size == capacity) {
                throw new IllegalStateException("Heap is Full");
            }
            int k = size;
            heap[k] = val;
            size++;
            while (k != 0 && heap[parent(k)] > heap[k]) {
                swap(heap, k, parent(k));
                k = parent(k);
            }
        }

        void swap(int[] heap, int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        void print() {
            if (size == 0) {
                System.out.println("Heap is Empty");
                return;
            }
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
            }
            System.out.println();
        }
        // heapify
        void heapify(int idx) {
            if (idx < 0 || idx >= size) {
                throw new IndexOutOfBoundsException(
                        "Invalid heap index: " + idx);
            }
            int smallest = idx;
            int left = left(idx);
            int right = right(idx);
            if(left < size && heap[left] < heap[idx]){
                smallest = left; 
            }
            else if(right < size && heap[right] < heap[idx]){
                smallest = right;
            }
            if(smallest != idx){
                swap(heap, idx, smallest);
                idx = smallest;
                heapify(idx);
            }

        }
        int getMin(){
            if(size == 0){
                throw new IllegalStateException("Heap is Empty");
            }
            return heap[0];
        }

        // Extract minimum
        int extractMin() {
            if (size == 0) {
                throw new IllegalStateException(
                        "Cannot extract from an empty heap");
            }

            if (size == 1) {
                size--;
                return heap[size];
            }
            int min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapify(0);
            return min;

        }

        void decreaseKey(int idx, int val) {
            if (idx < 0 || idx >= size) {
                throw new IndexOutOfBoundsException("Invalid Index" + idx);
            }
            if (val > heap[idx]) {
                throw new IllegalArgumentException("New value should be smaller than current value");
            }

            heap[idx] = val;
            while (idx != 0 && heap[parent(idx)] > heap[idx]) {
                swap(heap, idx, parent(idx));
                idx = parent(idx);
            }
        }

        void delete(int idx) {
            if (idx < 0 || idx >= size) {
                throw new IndexOutOfBoundsException(
                        "Invalid heap index: " + idx);
            }
            decreaseKey(idx, Integer.MIN_VALUE);
            extractMin();
            heapify(0);

        }

    }

    public static void main(String[] args) {

        try {
            BinaryHeap heap = new BinaryHeap(5);
            heap.insert(4);
            heap.insert(1);
            heap.insert(2);
            heap.insert(6);
            heap.insert(7);
            // heap.insert(3);
            heap.print();
            heap.delete(3);
            heap.print();
            System.out.println(heap.getMin());
            heap.decreaseKey(3, 0);
            heap.print();
            System.out.println(heap.extractMin());
        } catch (IllegalStateException e) {
            System.out.println("Heap Error : " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Input : " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index Error" + e.getMessage());
        }
    }
}
