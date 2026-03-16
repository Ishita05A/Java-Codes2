package Day197;

public class SubArray {
    static void largestSubArray(int[] arr){
        int st = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int newSt = 0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            if(sum >= max){
                end = i;
                st = newSt;
                max = sum;
            
            }
            if(sum < 0){
                sum = 0;
                newSt = 0;
            }
        }
        for(int i = st;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,3,5,-2,7,-4};
        largestSubArray(arr);
    }
    
}
