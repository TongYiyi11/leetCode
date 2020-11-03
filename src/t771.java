public class t771 {
    public int numJewelsInStones(String J, String S) {
        if(J.length() == 0 || S.length() == 0) return 0;
        int[] table = new int[123];
        for(int i = 0; i < S.length(); i++){
            table[S.charAt(i)]++;
        }
        int res = 0;
        for(int j = 0; j < J.length(); j++){
            res += table[J.charAt(j)];
        }
        return res;
    }
}
