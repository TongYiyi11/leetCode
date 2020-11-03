public class t671 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public int findSecondMinimumValue(TreeNode root){
        return dfs(root, root.val);
    }

    public int dfs(TreeNode root, int min){
        if(root == null) return -1;
        if(root.val > min) return root.val;
        int left = dfs(root.left, min);
        int right = dfs(root.right, min);
        if(left > min && right > min) return Math.min(left, right);
        return Math.max(left, right);
    }
}
