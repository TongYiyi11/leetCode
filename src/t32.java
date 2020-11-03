public class t32 {
    public int longestValidParentheses(String s){
        if(s.length() == 0 || s.length() == 1) return 0;
        int left = 0, right = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left += 1;
            }else{
                right += 1;
            }
            if(left == right){
                maxLen = Math.max(2 * right, maxLen);
            }else if(right > left){
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for(int j = s.length() - 1; j >= 0; j--){
            if(s.charAt(j) == '('){
                left += 1;
            }else{
                right += 1;
            }
            if(left == right){
                maxLen = Math.max(2 * left, maxLen);
            }else if(left > right){
                left = 0;
                right = 0;
            }
        }

        return maxLen;
    }

    public static void main(String[] args){
        t32 test = new t32();
        System.out.println(test.longestValidParentheses(")()())"));
    }
}
