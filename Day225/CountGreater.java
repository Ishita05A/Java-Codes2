package Day225;

public class CountGreater {
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            
            System.out.print(arr[i]+" ");
        }
    }
    static int  merge(int[] arr,int st,int mid, int end){
        int[] left = new int[mid-st+1];
        int cnt = 0;
        int[] right = new int[end - mid];
        for(int i = 0;i<left.length;i++){
            left[i] = arr[i+st];
        }
        for(int i = 0;i<right.length;i++){
            right[i] = arr[i+mid+1];
        }
        int i = 0;
        int j = 0;
        int k = st;
        while(i<left.length && j<right.length){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }
            else{
                arr[k++] = right[j++];
                cnt+=mid-st+1;
            }
        }
        while(i<left.length){
            arr[k++] = left[i++];
        }
        while(j < right.length){
            arr[k++] = right[j++];
        }
        return cnt;
    }
    static int  mergeSort(int[] arr, int st, int end){
        if(st >= end) return 0;
        int cnt = 0;
        int mid = (st+end)/2;
        cnt+=mergeSort(arr, st, mid);
        cnt+=mergeSort(arr, mid+1, end);
        cnt+=merge(arr, st, mid, end);
        return cnt;


    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        System.out.println(mergeSort(arr, 0,arr.length-1));
        display(arr);
    }
    
}
