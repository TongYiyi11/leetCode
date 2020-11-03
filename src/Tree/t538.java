public class t538 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    private int add = 0;
    public TreeNode convertBST(TreeNode root){
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.right);
        root.val += add;
        add = root.val;
        dfs(root.left);
    }

}
