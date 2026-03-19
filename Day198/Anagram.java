package Day198;
public class Anagram {
    static boolean isAnagram(String s, String t){
        int[] freq = new int[26];
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'A']++;
        }
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            freq[ch-'A']--;
        }
        for(int i= 0;i<freq.length;i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isAnagram("CAT", "ACT"));
    }
}
