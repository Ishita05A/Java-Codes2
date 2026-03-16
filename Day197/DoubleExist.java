package Day197;

public class DoubleExist {
    static boolean isDoubleExist(int[] arr){
        int n = arr.length;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                if(arr[j]*2 == arr[i] || arr[i]*2 == arr[j] ){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {10,2,5,3};
        System.out.println(isDoubleExist(arr));
    }
    
}
