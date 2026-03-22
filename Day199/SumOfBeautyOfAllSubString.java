package Day199;

import java.util.HashMap;

public class SumOfBeautyOfAllSubString {
    static int find_max(HashMap<Character,Integer> mp){
        int max = 0;
        for(var e:mp.entrySet()){
            max = Math.max(max, e.getValue());
        }
        return max;
    }
    static int find_min(HashMap<Character,Integer> mp){
        int min = Integer.MAX_VALUE;
        for(var e:mp.entrySet()){
            min = Math.min(min, e.getValue());
        }
        return min;
    }
    static int findSum(String s){
        int count = 0;
        for(int i = 0;i<s.length();i++){
            HashMap<Character,Integer> mp = new HashMap<>();
            for(int j = i;j<s.length();j++){
                char ch = s.charAt(j);
                mp.put(ch,mp.getOrDefault(ch,0)+1);
                if(mp.size()>2){
                    int max = find_max(mp);
                    int min = find_min(mp);
                    count+=(max-min);
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(findSum("xyx"));
    }
    
}
