package Day148;
public class HeapSort {
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
    static void heapify(int[] arr,int size,int i){
        int largest = i;
        int left = 2*i;
        int right = 2*i+1;
        if(left <= size && arr[left] > arr[largest]) largest = left;
        if(right <=size && arr[right] > arr[largest]) largest = right;
        if(largest != i){
            swap(arr,i,largest);
            heapify(arr, size, largest);
        }
    }
    static void heapSort(int[] arr,int size){
        for(int i = size/2;i>=1;i--){
            heapify(arr, size, i);
        }
        while(size>1){
            swap(arr,1, size);
            size--;
            heapify(arr, size, 1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {-1,70,60,55,45,50};
        int n = 5;
        heapSort(arr,n);
        for(int i = 1;i<=n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
