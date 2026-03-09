package Day193;

import java.util.HashMap;

public class HeightestAndLowestFrequency {

    public static void main(String[] args) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int[] arr = {1,2,2,1,2,4};
        for(int num : arr){
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }
        int max = 0;
        int min = 0;
        int maxCount = 0;
        int minCount = 10;
        for(var e:mp.entrySet()){
            if(e.getValue() > maxCount){
                maxCount = e.getValue();
                max = e.getKey();
            }
             if(e.getValue() < minCount){
                minCount = e.getValue();
                min= e.getKey();
            }
        }
        System.out.println(max);
        System.out.println(min);
    }
    
}
