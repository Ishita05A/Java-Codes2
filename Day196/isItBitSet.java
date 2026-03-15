package Day196;

public class isItBitSet {
    static boolean isSet(int n,int i){
        if((n &(1<<i) )!= 0) return true;
        else return false;
    }
    static void swap(int a,int b){
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a);
        System.out.println(b);
    }
    static boolean isPowerOf2(int n){
        return (n & n-1) == 0;
    }
    static int countNoOfSetBit(int n){
        int count = 0;
        while(n>0){
            count+=(n&1);
            n = n>>1;
        }
        return count;
    }
    static int countNoOfSetBit_optimized(int n){
        int count = 0;
        while (n>0){
            n = (n&n-1);
            count++;
        }
        return count;
    }
    static int setRightMost(int n){
        if((n&(n+1)) == 0) return n;
        return n | n+1;
    }
    public static void main(String[] args) {
        System.out.println(isSet(5, 0));
        swap(2, 3);
        System.out.println(countNoOfSetBit(29));
        System.out.println(countNoOfSetBit_optimized(29));
        System.out.println(setRightMost(7));
    }
    
}
