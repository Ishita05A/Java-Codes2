import java.util.Scanner;
public class AIskanderAndDrawings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int n = sc.nextInt();
            String s = sc.next();
            
            int max = 0;
            int cnt = 0;
            for(int i = 0;i<n;i++){
                if(s.charAt(i) == '#'){
                    cnt++;
                }
                else cnt = 0;
                max = Math.max(max, cnt);
            }
            System.out.println((max+1)/2);
        }
    }
}
