package Day140;
import java.util.*;
import java.util.Scanner;

public class AllDivisorOfNumber {
    static List<Integer> all_divisor(int n){
        List<Integer> ans = new ArrayList<>();
        for(int i = 1;i*i<=n;i++){
            if(n%i == 0){
                ans.add(i);
                if(n/i != i) ans.add(n/i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println(all_divisor(n));
        sc.close();
    }
    
}
