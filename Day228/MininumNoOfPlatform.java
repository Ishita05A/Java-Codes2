package Day228;

import java.util.Arrays;

public class MininumNoOfPlatform {
    static int minPlatform(int[] arr, int[] dep){
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0;
        int j = 0;
        int cnt = 0;
        int max = 0;
        while(i< arr.length){
            if(arr[i]<dep[j]){
                cnt++;
                i++;
                max = Math.max(max, cnt);
            }
            else{
                cnt--;
                j++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
       int[]  Arrival = {900, 940, 950, 1100, 1500, 1800} ;
       int[]  Departure = {910, 1200, 1120, 1130, 1900, 2000};
       System.out.println(minPlatform(Arrival, Departure));
    }
    
}
