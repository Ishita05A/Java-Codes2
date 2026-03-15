package Day195;

import java.util.HashSet;

public class LargestConsecutive {
    static int largestCons(int[] arr){
        HashSet<Integer> mp = new HashSet<>();
        for(int i = 0;i<arr.length;i++){
            mp.add(arr[i]);
        }
        int max = 0;
        for(int i = 0;i<arr.length;i++){
            if(!mp.contains(arr[i]-1)){
                int count = 0;
                int num = arr[i];
                while(mp.contains(num)){
                    count++;
                    num++;
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr =  {100, 4, 200, 1, 3, 2};
        System.out.println(largestCons(arr));
    }
    
}
