package Day251;

import java.util.HashMap;

public class CntXorWithSubArrayK {
    static int countSubArray(int[] arr,int k){
        int n = arr.length;
        int xor = 0;
        HashMap<Integer,Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int cnt = 0;
        for(int i = 0;i<n;i++){
            xor^=arr[i];
            int target = xor^k;
            if(mp.containsKey(target)){
                cnt += mp.get(target);
            }
            mp.put(xor, mp.getOrDefault(xor, 0)+1);
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        System.out.println(countSubArray(a, 6));
    }
    
}
