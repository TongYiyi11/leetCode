public class t9 {
    public boolean isPalindrome(int x){
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int xRev = 0;
        //notice! reverse half of x and overflowing can be avoid
        while(x > xRev){
            xRev = 10 * xRev + x % 10;
            x = x / 10;
        }
        return x == xRev || x == xRev / 10;
        //notice! two conditions of palindrome. 10 can be an exception, consider it first!
    }

    public static void main(String[] args){
        t9 test = new t9();
        System.out.println(test.isPalindrome(10));
    }
}
