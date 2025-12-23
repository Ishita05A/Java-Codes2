package Day140;
import java.util.*;

public class PrimeFactorizationUsingSieve {
    static  List<Integer> querry(int n){
        List<Integer> a = new ArrayList<>();
        int[] fact = new int[n+1];
        for(int i = 2;i<fact.length;i++){
            fact[i] = i;
        }
        for(int i = 2;i*i<=n;i++){
            if(fact[i] == i){
                a.add(fact[i]);
                for(int j = i*i;j<=n;j+=i){
                    fact[j] = i;
                }
            }
        }
        return a;
    }
    static List<List<Integer>> primeFactorization(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            List<Integer> a = querry(arr[i]);
            ans.add(a);
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of elements");
        int n = sc.nextInt();
        System.out.println("Enter elements");
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(primeFactorization(arr));
        sc.close();
        
    }
    
}
