package Day197;

import java.util.HashMap;

public class LengthOfLongestSubArrayWith0 {
    static int longest(int[] arr){
        int sum = 0;
        int max = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            sum+=arr[i];
            if(sum == 0) max = Math.max(i+1,max); 
            if(mp.containsKey(sum)){
                max = Math.max(max, i-mp.get(sum));
            }
            if(!mp.containsKey(sum)){
                mp.put(sum,i);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr =  {6, -2, 2, -8, 1, 7, 4, -10};
        System.out.println(longest(arr));
    }
    
}
