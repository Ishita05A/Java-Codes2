package Day249;

public class ArmStrong {
    static int count(int n){
        int cnt = 0;
        while (n>0) {
            cnt++;
            n/=10;
        }
        return cnt;
    }
    static boolean isArmStrong(int n){
        int c = count(n);
        int num = n;
        int ans = 0;
        while (num>0) {
            ans+=Math.pow(num%10, c);
            num/=10;
        }
        if (ans == n) return true;
        else return false;
    }
    public static void main(String[] args) {
        System.out.println(isArmStrong(153));
        System.out.println(isArmStrong(389));
    }
    
}
