package Day247;

public class isMinHeap {
    static boolean meth2(int[] heap){
        int n = heap.length;
        for(int i = 0;i<=(n/2)-1;i++){
            int left = (2*i+1);
            if(left < n && heap[left] < heap[i]) return false;
            int right = (2*i+2);
            if(right < n && heap[right] < heap[i]) return false;
        }
        return true;
    }
    static boolean helper(int[] heap, int idx, int n){
        if(idx == n) return true;
        int left = 2*idx + 1;
        if(left >= n) return true;
        if(heap[left] < heap[idx]) return false; 
        int right = 2*idx + 2;
        if(right >= n) return true;;
        if(heap[right] < heap[idx]) return false;
        return helper(heap, left, n) && helper(heap, right, n);

    }
    static boolean isMin_Heap(int[] arr){
        return helper(arr, 0, arr.length);
    }
    public static void main(String[] args) {
        int[]  nums = {10, 20, 30,11, 23};
        System.out.println(isMin_Heap(nums));
        System.out.println(meth2(nums));

    }
    
}
