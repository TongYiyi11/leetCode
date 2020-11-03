public class t1022 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    private int ans = 0;
    public int sumRootToLeaf(TreeNode root){
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode root, int tmp){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans += tmp * 2 + root.val;
            return;
        }
        if(root.left != null) helper(root.left, 2 * tmp + root.val);
        if(root.right != null) helper(root.right, 2 * tmp + root.val);
    }

}
