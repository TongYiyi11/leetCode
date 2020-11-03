import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class t662 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    int res = 1;
    public int widthOfBinaryTree(TreeNode root){
        dfs(root, 0, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth, int index){
        if(root == null) return;
        if(!map.containsKey(depth)){
            map.put(depth, index);
        }else{
            res = Math.max(res, index - map.get(depth) + 1);
        }
        dfs(root.left, depth + 1, 2 * index + 1);
        dfs(root.right, depth + 1, 2 * index + 2);
    }
}
