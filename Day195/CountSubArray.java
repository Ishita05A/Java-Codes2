package Day195;

import java.util.HashMap;


public class CountSubArray {
    static int countSub(int[] arr,int k){
        HashMap<Integer,Integer> mp = new HashMap<>();
        int count = 0;
        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            if(sum == k){
                count++;
            }
            if(mp.containsKey(sum-k)){
                count+=mp.get(sum-k);
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return count;
        
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1};
        System.out.println(countSub(arr, 3));
    }
    
}
