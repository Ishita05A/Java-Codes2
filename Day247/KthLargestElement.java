package Day247;

import java.util.Random;

public class KthLargestElement {
    static private Random rand = new Random();

    static private int randomIndex(int left,int right){
        int len = right - left +1;
        return rand.nextInt(len) + left;
    }
    static int partitionAndReturnIndex(int[] nums,int pivotIdx, int left, int right){
        int pivot = nums[pivotIdx];
        int temp = nums[left];
        nums[left] = nums[pivotIdx];
        nums[pivotIdx] = temp;

        int idx = left +1;
        for(int i = left+1;i<=right;i++){
            if(nums[i] > pivot){
                temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                idx++;
            }
        }
        temp = nums[left];
        nums[left] = nums[idx-1];
        nums[idx-1] = temp;
        return idx-1;
    }
    static int kthLargest(int[] arr,int k){
        int n = arr.length;
        if(k>n) return -1;
        int left = 0;
        int right = n-1;
        while (true) {
            int pivotIdx = randomIndex(left,right);
            pivotIdx = partitionAndReturnIndex(arr, pivotIdx, left, right);
            if(pivotIdx == k-1) return arr[pivotIdx];
            else if(pivotIdx > k-1) right = pivotIdx-1;
            else left = pivotIdx+1;
        }
    }   
    public static void main(String[] args) {
        int[] nums = {-5, 4, 1, 2, -3};
        int k = 5;
        System.out.println(kthLargest(nums, k));
    }
    
}
