package Day197;

public class ReverseWord {
    static String reverse(String word) {
        int n = word.length();
        int i = n - 1;
        StringBuilder ans = new StringBuilder();
        while (i >= 0) {
            StringBuilder small = new StringBuilder();
            while (i >= 0 && word.charAt(i) != ' ') {
                small.append(word.charAt(i));
                i--;
            }
            small.append(" ");
            small.reverse();
            ans.append(small);
            i--;
        }
        return ans.substring(1).toString();
    }

    public static void main(String[] args) {
        System.out.println(reverse( "welcome to the jungle"));
    }
}
