package Day195;

public class NextPermuatation {
    static void reverse(int[] arr,int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    static void display(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void nextPermutation(int[] arr){
        int n = arr.length;
        int i = n-2;
        while(arr[i] >= arr[i+1]){
            i--;
        }
        int j = n;
        for(j = n-1;j>=0;j--){
            if(arr[j] > arr[i]) break;
        }
        if(i<0) return;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        reverse(arr, i+1, n-1);
    }
    public static void main(String[] args) {
        int[] arr = {2,1,5,4,3,0,0};
        nextPermutation(arr);
        display(arr);
    }
    
}
