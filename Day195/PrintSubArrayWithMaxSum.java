package Day195;

public class PrintSubArrayWithMaxSum {
    static int[] findSubArray(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0;
        int end = 0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            if(sum > max){
                max = sum;
                end = i;
            }
            if(sum < 0){
                sum = 0;
                start = end;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        
    }
    
}
