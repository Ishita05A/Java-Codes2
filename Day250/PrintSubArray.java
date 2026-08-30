package Day250;

public class PrintSubArray {
    static void printSubArr(int[] arr){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int st = 0;
        int start = 0;
        int end = 0;
        int n = arr.length;
        for(int i = 0;i<n;i++){
            sum+=arr[i];
            if(sum > max){
                max = sum;
                start = st;
                end = i;
            }
            if(sum < 0){
                st = i+1;
            }
        }
        for(int i = start;i<=end;i++){
            System.out.print(arr[i]+ " ");
        }


    }
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, -2, 7, -4};
        printSubArr(nums);
    }
    
}
