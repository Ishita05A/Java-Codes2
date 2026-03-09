package Day193;

public class ArrayIsSortedOrNot {
    static boolean isSorted(int[] arr){
        int count = 0;
        for(int i = 0;i<arr.length-1;i++){
            if(arr[i] > arr[i+1]) count++;
        }
        if(arr[0] > arr[arr.length-1])count++;
        return count == 0 || count == 2;
    }
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(isSorted(arr));

    }
    
}
