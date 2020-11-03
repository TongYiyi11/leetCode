public class t993 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right){
          this.val = val;
          this.left = left;
          this.right = right;
       }
    }

    int xDepth, yDepth, xPar, yPar;
    public boolean isCousins(TreeNode root, int x, int y){
        dfs(root.left, x, y, 1, root.val);
        dfs(root.right, x, y, 1, root.val);
        return (xDepth == yDepth) && (xPar != yPar);
    }

    private void dfs(TreeNode root, int x, int y, int depth, int par){
        if(root == null) return;
        if(x == root.val){
            xPar = par;
            xDepth = depth;
        }
        if(y == root.val){
            yPar = par;
            yDepth = depth;
        }
        dfs(root.left, x, y, depth + 1, root.val);
        dfs(root.right, x, y, depth + 1, root.val);
    }
}
