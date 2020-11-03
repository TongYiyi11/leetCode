public class t543 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root){
        getDepth(root);
        return max;
    }

    private int getDepth(TreeNode root){
        if(root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(left + right > max){
            max = left + right;
        }
        return Math.max(left, right) + 1;
    }
}
