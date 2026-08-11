import java.util.Scanner;

public class AYouDeleteIDelete {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            String s = sc.next();
            int zero = -1;
            int one = -1;
            boolean found0 = false;
            boolean found1 = false;
            for(int i = 0;i<s.length();i++){
                if(s.charAt(i) == '0' && found0 == false){
                    zero = i;
                    found0 = true;
                }
                if(s.charAt(i) == '1' && found1 == false){
                    one = i;
                    found1 = true;
                }
                if(found0 && found1) break;
            }
            System.out.println(s.substring(0, zero+1)+s.substring(one, t));
        }
    }
}