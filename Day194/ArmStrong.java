package Day194;
public class ArmStrong {
    static int count(int num){
        int count = 0;
        while(num>0){
            count++;
            num/=10;
        }
        return count;
    }
    static boolean isArmStrong(int n){
        int num = n;
        int digit = count(num);
        int ans = 0;
        while(num>0){
            int rem = num%10;
            ans += (int)Math.pow(rem, digit);
            num/=10;
        }
        return ans == n;
        
    }
    public static void main(String[] args) {
    
        System.out.println(isArmStrong(153));
    }
    
}
