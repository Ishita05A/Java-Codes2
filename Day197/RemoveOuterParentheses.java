package Day197;

public class RemoveOuterParentheses {
    static void  remove(String str){
        StringBuilder ans = new StringBuilder();
        int count = 0;
        for(int i = 0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch == '('){
                if(count > 0){
                    ans.append(ch);
                }
                count++;
            }else{
                count--;
                if(count > 0){
                    ans.append(ch);
                }
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) {
        remove("()(()())(())");
    }
    
}
