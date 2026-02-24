package Day184;

public class LongestSubStringWithoutRepetation {
    static int maxLength(String str){
        int[] lastSeen = new int[128];
        int start = 0;
        int max = 0;
        for(int end = 0;end<str.length();end++){
            char ch = str.charAt(end);
            if(lastSeen[ch]>=start){
                start = lastSeen[ch]+1;
            }
            lastSeen[ch] = end;
            max = Math.max(max, end - start +1);
        }
        return max;
    }
    public static void main(String[] args) {
        String str = "abcddabac";
        System.out.println(maxLength(str));
        
    }
    
}
