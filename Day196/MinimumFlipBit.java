package Day196;

public class MinimumFlipBit {
    static int countFlippedBits(int st, int goal){
        int n = st^goal;
        int count= 0;
        while(n>0){
            if(n%2 == 1){
                count++;
            }
            n/=2;
        }
        return count;


    }
    public static void main(String[] args) {
        System.out.println(countFlippedBits(3, 4));
    }
    
}
