public class t563 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    private int tilt;
    public int findTilt(TreeNode root){
        getSum(root);
        return tilt;
    }

    private int getSum(TreeNode root){
        if(root == null) return 0;
        int left = getSum(root.left);
        int right = getSum(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
}
