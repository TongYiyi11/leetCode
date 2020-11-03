public class t5 {
    public String longestPalindrome(String s){
        if(s.length() == 0){
            return "";
        }
        int start = 0, end = 0;
        int len1 = 0, len2 = 0, len = 0;
        for(int i = 0; i < s.length(); i++){
            len1 = expandAroundCenter(s, i, i);
            len2 = expandAroundCenter(s, i, i + 1);  //notice! there are two initial conditions
            len = Math.max(len1, len2);
            if(len > (end - start + 1)){
                start = i + 1 - (int)Math.ceil(len / 2.0);
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int i, int j){
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i -= 1;
            j += 1;
        }
        return (j - i - 1);
    }

    public static void main(String[] args){
        String s = "babad";
        t5 test = new t5();
        System.out.println(test.longestPalindrome(s));
    }
}
