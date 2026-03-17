package Day197;

public class LargestOddNumber {
    static String largestOdd(String str){
        int n = str.length();
        int i = n-1;
        while(i<=0){
            int num = (char)str.charAt(i);
            if(num%i == 1) break;
            i--;
        }
        return str.substring(0, i+1).toString();
    }
    public static void main(String[] args) {
        System.out.println(largestOdd("294543"));
    }
    
}
