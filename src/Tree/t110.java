package Tree;

public class t110 {
    public boolean isBalanced(TreeNode root){
        return getDepth(root) >= 0;
    }
    private int getDepth(TreeNode root){
        if(root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(left >= 0 && right >= 0 && Math.abs(left - right) <= 1){
            return Math.max(left, right) + 1;
        }else{
            return -1;
        }
    }
}
