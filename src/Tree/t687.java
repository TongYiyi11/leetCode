public class t687 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    int res = 0;
    public int longestUnivaluePath(TreeNode root){
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftH = 0, rightH = 0;
        if(root.left != null && root.left.val == root.val){
            leftH = left + 1;
        }
        if(root.right != null && root.right.val == root.val){
            rightH = right + 1;
        }
        res = Math.max(res, leftH + rightH);
        return Math.max(leftH, rightH);
    }
}
