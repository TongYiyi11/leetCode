import java.util.ArrayList;
import java.util.List;

public class t971 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    List<Integer> res = new ArrayList<>();
    int index = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage){
        dfs(root, voyage,null);
        return res;
    }

    private void dfs(TreeNode root, int[] voyage, TreeNode prev){
        if(root == null) return;
        if(root.val != voyage[index]){
            res.clear();
            res.add(-1);
            return;
        }
        if(index + 1 < voyage.length && root.left != null && root.left.val != voyage[index + 1]){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            res.add(root.val);
        }
        index += 1;
        dfs(root.left, voyage, root);
        dfs(root.right, voyage, root);
    }
}
