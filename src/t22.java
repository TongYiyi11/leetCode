import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class t22 {
    public List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n){
        if(n <= 0) return ans;
        getParenthesis("", n, n);
        return ans;
    }

    private void getParenthesis(String s, int left, int right){
        if(left == 0 && right == 0){
            ans.add(s);
            return;
        }
        if(left > 0){
            getParenthesis(s + "(", left - 1, right);
        }
        if(right > left){
            getParenthesis(s + ")", left, right - 1);
        }
    }

    public static void main(String[] args){
        t22 test = new t22();
        System.out.println(test.generateParenthesis(3));
    }
}
