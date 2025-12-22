package Day139;



public class SwapTwoNumber {
    static  void swap(int[] arr){
       arr[0] = arr[0]^arr[1];
       arr[1] = arr[0]^arr[1];
       arr[0] = arr[0]^arr[1];
    }
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.printf("Before swpapping a = %d b = %d\n",arr[0],arr[1]);
        swap(arr);
        System.out.printf("After swpapping a = %d b = %d",arr[0],arr[1]);
        

        
    }
    
}
