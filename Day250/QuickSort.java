package Day250;
public class QuickSort {
    static int  partion(int[] arr, int st, int end){
        int pivot = arr[end];
        int i = st-1;
        for(int j = st;j<end;j++){
            if(arr[j] <= pivot){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;
        return i+1;

    }
    static void quickSort(int[] arr, int st,int end){
        if(st >= end) return;
        int pivotIdx = partion(arr,st,end);
        quickSort(arr, st, pivotIdx-1);
        quickSort(arr, pivotIdx+1, end);
    }
    public static void main(String[] args) {
        int[] arr = {4,9,2,1};
        quickSort(arr, 0, arr.length-1);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
