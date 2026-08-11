import java.util.Scanner;

public class BEvanescent {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int n = sc.nextInt();
            String s = sc.next();
            int cnt = 1;
            for(int i = 1;i<n;i++){
                if(s.charAt(i) != s.charAt(i-1)){
                    cnt++;
                }
            }
            int ans = cnt;
            for(int i = 1;i<n-1;i++){
                char fst = s.charAt(i-1);
                char sec = s.charAt(i);
                char trd = s.charAt(i+1);
                if(fst == trd && fst != sec){
                    ans = Math.min(ans,cnt-2);
                }
                else if(fst != sec && sec != trd){
                    ans = Math.min(ans, cnt-1);
                }
            }
            System.out.println(ans);
        }
    }
}