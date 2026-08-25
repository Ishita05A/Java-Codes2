package Day247;

public class ConvertMinHeapToMaxHeap {
    static void maxHeapify(int[] arr, int i){
        int n = arr.length;
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }
        if (largest != i) {
            int temp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = temp;
            maxHeapify(arr, largest);
        }

    }

    static int[] convert(int[] arr){
        int n = arr.length;
        for(int i = n/2-1;i>=0;i--){
            maxHeapify(arr, i);
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 21, 23};
        int[] arr = convert(nums);
        for(int i = 0;i<nums.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    
}
