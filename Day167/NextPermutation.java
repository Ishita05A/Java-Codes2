package Day167;
import java.util.*;
public class NextPermutation {
    static void disaply(int[] arr){
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static void reverse(int[] arr,int i,int j){
        while(i<j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    static void next_permutation(int[] arr){
        int i = arr.length-1;
        while(i>0 && arr[i]<=arr[i-1]){
            i--;
        }
        int element = arr[i-1];
        int idx  = 0;
        for(int j = arr.length-1;j>=i;j--){
            if(arr[j] > element){
                idx = j;
                break;
            }
        }
        if(i==0){
            reverse(arr,0,arr.length-1);
            return;
        }
        int temp = arr[i-1];
        arr[i-1] = arr[idx];
        arr[idx] = temp;
        reverse(arr, i, arr.length-1);
        

    }
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements for value");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        next_permutation(arr);
        disaply(arr);
        sc.close();
    }
    
}
