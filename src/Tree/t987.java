import java.util.*;

public class t987 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    TreeMap<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, 0);
        for(int x: map.keySet()){  //note: treemap's key set follows ascending order
            List<Integer> list = new ArrayList<>();
            for(int y: map.get(x).keySet()){
                Collections.sort(map.get(x).get(y));
                list.addAll(map.get(x).get(y));
            }
            res.add(list);
        }
        return res;
    }

    private void dfs(TreeNode root, int x, int y){
        if(root == null) return;
        if(map.containsKey(x)){
            if(map.get(x).containsKey(y)){
                map.get(x).get(y).add(root.val);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                map.get(x).put(y, list);
            }
        }else{
            Map<Integer, List<Integer>> treemap = new TreeMap<>();
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            treemap.put(y, list);
            map.put(x, treemap);
        }
        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }
}
