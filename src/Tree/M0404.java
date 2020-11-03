public class M0404 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }

    private boolean flag = true;

    public boolean isBalanced(TreeNode root){
        getHeight(root);
        return flag;
    }

    private int getHeight(TreeNode n){
        int left = 0, right = 0;
        if(n == null) return 0;
        if(n.left != null) left = 1 + getHeight(n.left);
        if(n.right != null) right = 1 + getHeight(n.right);
        if(Math.abs(left - right) > 1){
            flag = false;
        }
        return Math.max(left, right);
    }
//    private boolean checkBalance(TreeNode n){
//        if(n == null) return true;
//        int left = 1 + getHeight(n.left);
//        int right = 1 + getHeight(n.right);
//        if(Math.abs(left - right) > 1){
//            return false;
//        }else{
//            return checkBalance(n.left) && checkBalance(n.right);
//        }
//    }

    public static void main(String[] args){
        TreeNode r = new TreeNode(1);
        r.right = new TreeNode(2);
        r.right.right = new TreeNode(3);
        M0404 test = new M0404();
        System.out.println(test.isBalanced(r));
    }
}
