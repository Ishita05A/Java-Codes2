package Day140;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SieveOfEratosthenes {
    static List<Integer> printAllPrimeTillN(int n){
        List<Integer> ans = new ArrayList<>();
        int[] prime = new int[n+1];
        for(int i = 2;i<prime.length;i++){
            prime[i] = 1;
        }
        for(int i=2;i*i<n;i++){
            if(prime[i]==1){
                for(int j = i*i;j<=n;j+=i){
                    prime[j] = 0;
                }
            }
        }
        for(int i = 2;i<prime.length;i++){
           if( prime[i] == 1)  ans.add(i);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int n = sc.nextInt();
        System.out.println(printAllPrimeTillN(n));
        sc.close();
    }
    
}
