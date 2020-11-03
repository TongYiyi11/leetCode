package Tree;

public class t450 {
    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return null;
        int comp = root.val - key;
        if(comp > 0){
            root.left = deleteNode(root.left, key);
        }else if(comp < 0){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left != null && root.right != null){
                TreeNode p = root.left;
                while(p.right != null) p = p.right;
                root.val = p.val;
                root.left = deleteNode(root.left, p.val);
            }else if(root.right == null) root = root.left;
            else if(root.left == null) root = root.right;
            else root = null;
        }
        return root;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        t450 test = new t450();
        test.deleteNode(root, 3);
    }
}
