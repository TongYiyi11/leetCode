package BackTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class t39 {
    List<List<Integer>> res;
    int[] candidates;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        this.candidates = candidates;
        this.target = target;
        res = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(0, 0, list);
        return res;
    }

    private void backtrack(int sum, int start, List<Integer> list){
        if(sum == target){
            List<Integer> listCopy = new ArrayList<>(list);
            res.add(listCopy);
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if((sum + candidates[i]) > target) continue;
            list.add(candidates[i]);
            backtrack(sum + candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        t39 test = new t39();
        int[] candidates = new int[]{2, 3, 6, 7};
        test.combinationSum(candidates, 7);
    }
}
