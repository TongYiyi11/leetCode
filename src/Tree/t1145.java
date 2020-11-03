public class t1145 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    int left = 0, right = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x){
        countTree(root, x);
        if(Math.max(left, right) > n / 2) return true;
        if((left + right + 1) < (n + 1) / 2) return true;
        return false;
    }

    private int countTree(TreeNode root, int x){
        if(root == null) return 0;
        int l = countTree(root.left, x);
        int r = countTree(root.right, x);
        if(root.val == x){
            left = l;
            right = r;
        }
        return 1 + l + r;
    }
}
