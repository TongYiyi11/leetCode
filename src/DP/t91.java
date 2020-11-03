package DP;

public class t91 {
    public int numDecodings(String s){
        int n0 = 1;
        int n1 = (s.charAt(0) - '0') == 0 ? 0 : 1;
        if(n1 == 0) return 0;
        for(int i = 1; i < s.length(); i++){
            int ni = s.charAt(i) - '0';
            int nij = Integer.parseInt(s.substring(i - 1, i + 1));
            int temp;
            if(ni == 0){
                if(nij > 20 || nij == 0) return 0;
                temp = n0;
            }else{
                temp = nij > 26 || nij < 10 ? n1 : n1 + n0;
            }
            n0 = n1;
            n1 = temp;
        }
        return n1;
    }
}
