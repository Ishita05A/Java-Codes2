package Day249;

public class Recursion {
    static int fact(int n){
        if(n == 0 || n == 1) return 1;
        return n * fact(n-1);
    }
    static int sumOfN(int n){
        if(n == 1) return n;
        return n + sumOfN(n-1);
    }
    static void reverse(int[] a, int i,int j){
        if(i == j || i>j) return;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        reverse(a, i+1, j-1);
    }
    static boolean isPallindrome(String s, int i,int j){
        if(i == j || i>j) return true;
        if(s.charAt(i) != s.charAt(j)) return false;
        return isPallindrome(s, i+1, j-1);
    }
    static int printFibinoci(int n){
        if(n <= 1) return n;
        int x = printFibinoci(n-1) + printFibinoci(n-2);
        return x;
       
    }
    public static void main(String[] args) {
        System.out.println(sumOfN(5));
        System.out.println(fact(5));
        int[] arr = {1,2,3,4};
        reverse(arr, 0, arr.length-1);
        for (int x : arr) {
            System.out.print(x + " ");
        } 
        System.out.println();
        String Str =  "ABCDCBA";
        System.out.println(isPallindrome(Str, 0,Str.length()-1 ));
        int a = 0;
        int b = 1;
        for(int i = 0;i<=5;i++){
            int c = a + b;
            System.out.print(a+" ");
            a = b;
            b = c;
        }
        System.out.println();
        System.out.println(printFibinoci(4));
    }
    
}
