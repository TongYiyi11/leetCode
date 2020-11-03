import java.util.Stack;

public class t20 {
    public boolean isValid(String s){
        if(s.length() == 0) return true;
        Stack<Character> st = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }else{
                if(st.empty() || c != getPair(st.peek())) return false;
                st.pop();
            }
        }
        return st.empty();
    }

    private char getPair(char c){
        switch (c){
            case '(':
                return ')';
            case '{':
                return '}';
            case '[':
                return ']';
            default:
                return '\0';
        }
    }

    public static void main(String[] args){
        t20 test = new t20();
        System.out.println(test.isValid("[({(())}[()])]"));
    }
}
