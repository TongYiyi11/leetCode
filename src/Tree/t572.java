public class t572 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    public boolean isSubtree(TreeNode s, TreeNode t){
        if(t == null) return true;
        if(s == null) return false;
        return checkEqual(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean checkEqual(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return checkEqual(s.left, t.left) && checkEqual(s.right, t.right);
    }


    public static void main(String[] args){
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        t572 test = new t572();
        System.out.println(test.isSubtree(s, t));
    }
}
