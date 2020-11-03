import java.util.ArrayList;
import java.util.List;

public class t1339 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    List<Long> sumList = new ArrayList<>();
    public int maxProduct(TreeNode root){
        long total = dfs(root);
        long res = 0;
        for(long part: sumList){
            res = Math.max(res, part * (total - part));
        }
        return (int) (res % (Math.pow(10, 9) + 7));
    }

    private long dfs(TreeNode root){
        if(root == null) return 0;
        long sum = root.val + dfs(root.left) + dfs(root.right);
        sumList.add(sum);
        return sum;
    }
}
