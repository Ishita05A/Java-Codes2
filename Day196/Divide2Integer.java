package Day196;
public class Divide2Integer {
    static int divide(int n ,int d){
        if(n == d) return 1;
        boolean flag = true;
        if(n<0){
            flag = false;
            n = -n;
        }
        if(d<0){
            flag = false;
            d = -d;
        }
        int ans = 0;
        while(n>=d){
            int count = 0;
            while(n > (d<<count+1)){
                count++;
            }
            ans+=(1<<count);
            n = n - (d<<count);
        }
        if(flag == false) return -ans;
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(divide(7, -3));
    }
}
