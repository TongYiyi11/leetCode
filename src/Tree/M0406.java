public class M0406 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        return dfs(root, p, null);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode successor){
        int comp = root.val - p.val;
        if(comp > 0){
            return dfs(root.left, p, root);
        }else if(comp < 0){
            return dfs(root.right, p, successor);
        }else{
            p = p.right;
            if(p == null) return successor;
            while(p.left != null){
                p = p.left;
            }
            return p;
        }
    }
}
