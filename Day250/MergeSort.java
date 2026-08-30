package Day250;

public class MergeSort {
    static void mergesort(int[] arr,int st,int mid,int end){
        int[] left = new int[mid-st+1];
        int[] right = new int[end-mid];
        for(int i = 0;i<left.length;i++){
            left[i] = arr[i+st];
        }
        for(int i = 0;i<right.length;i++){
            right[i] = arr[i+mid+1];
        }
        int i = 0;
        int j = 0;
        int k = st;
        while (i<left.length && j < right.length) {
            if(left[i]<=right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
            }
        }
        while (i<left.length) {
            arr[k++] = left[i++];
        }
        while (j<right.length) {
            arr[k++] = right[j++];
        }
    }
    static void merge(int[] arr,int st,int end){
        if(st>=end) return;
        int mid = (st+end)/2;
        merge(arr, st, mid);
        merge(arr, mid+1, end);
        mergesort(arr, st, mid, end);
    }
    public static void main(String[] args) {
        int[] arr = {4,9,2,1};
        merge(arr, 0, arr.length-1);
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
    
}
