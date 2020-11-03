public class M0405 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
    public boolean isValidBST(TreeNode root){
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean dfs(TreeNode n, long min, long max){
        if(n == null) return true;
        if(n.val >= max || n.val <= min) return false;
        return dfs(n.left, min, n.val) && dfs(n.right, n.val, max);
    }
}
