package Day250;

public class Sort {
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void bubbleSort(int[] nums){
        int n = nums.length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n-i-1;j++){
                if(nums[j] > nums[j+1]){
                    swap(nums, j+1, j);
                }
                
            }
        }
    }
    static void selectionSort(int[] nums){
        int n = nums.length;
        for(int i = 0;i<n-1;i++){
            int idx = i;
            int j = i+1;
            while (j<n) {
                if(nums[j] < nums[idx]){
                    idx = j;
                }
                j++;
            }
            swap(nums, idx, i);
        }
    }
    static void insertionSort(int[] nums){
        int n= nums.length;
        for(int i = 1;i<n;i++){
            for(int j = i;j>0;j--){
                if(nums[j] < nums[j-1]){
                    swap(nums, j-1, j);
                }
                else break;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,9,1,2};
        // bubbleSort(arr);
        // selectionSort(arr);
        insertionSort(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }
        
    }
    
}
