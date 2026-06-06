package Day225;

public class MissingAndRepeating {
    static int[] find(int[] arr){
        int n = arr.length;
        int s = 0;
        int ss = 0;
        int sn = (n*(n+1))/2;
        int ssn = (n*(n+1)*(2*n+1))/6;
        for(int i = 0;i<n;i++){
            s+=arr[i];
            ss+=(arr[i]*arr[i]);
        }
        int val1  = s-sn;
        int val2 = (ss-ssn)/val1;
        int duplicate = (val1+val2)/2;
        int missing = val2-duplicate;
        return new int[] {duplicate,missing}; 
    }
    public static void main(String[] args) {

        int[] arr = {3, 5, 4, 1, 1};
        int[] ans = find(arr);
        System.out.println(ans[0]+" "+ans[1]);

        
    }
    
}
