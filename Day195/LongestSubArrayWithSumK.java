package Day195;

public class LongestSubArrayWithSumK {
    // static int longestWithZero(int[] arr,int k){
    //     int max = 0;
    //     int n = arr.length;
    //     int sum = 0;
    //     for(int i = 0;i<n;i++){
    //         sum+=arr[i];
    //         if(sum == 0){

    //         }
    //     }
    // }
    static int find_longest_Subarray(int[] arr,int k){
        int start = 0;
        int max = 0;
        int sum = 0;
        for(int end = 0;end<arr.length;end++){
            sum+=arr[end];
            while(sum>k){
                sum-=arr[start];
                start++;
            }
            if(sum == k){
                max = Math.max(max,end-start+1);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {10,5,2,7,1,9};
        System.out.println(find_longest_Subarray(arr, 15));
    }
    
}
