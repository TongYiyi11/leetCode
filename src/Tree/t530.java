public class t530 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    private int min = Integer.MAX_VALUE;
    private int prev = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root){
        dfs(root);
        return min;
    }
    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        min = Math.min(min, Math.abs(root.val - prev));
        prev = root.val;
        dfs(root.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        t530 test = new t530();
        System.out.println(test.getMinimumDifference(root));
    }
}
