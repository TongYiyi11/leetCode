public class RecentCounter {
    int[] calls;
    int indx;
    public RecentCounter() {
        calls = new int[10000];
        indx = 0;
    }

    public int ping(int t) {
        calls[indx] = t;
        int res = 0;
        for(int i = indx; i >= 0; i--){
            if(calls[i] < t - 3000) break;
            else res++;
        }
        indx++;
        return res;
    }
}
