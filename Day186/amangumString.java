package Day186;

public class amangumString {
    static boolean isAnagram(String s,String t){
        if(s.length() != t.length()) return false;
        int[] arr = new int[128];
        int j = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            char sh = s.charAt(j);
            arr[ch-'a']++;
            arr[sh-'a']--;
            j++;
        }
        for(int count : arr){
            if(count != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
    
}
