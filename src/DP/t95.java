package DP;

import java.util.ArrayList;
import java.util.List;

public class t95 {
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n){
        List<TreeNode> res = new ArrayList<>();
        if(n <= 0) return res;
        TreeNode root = new TreeNode(1);
        res.add(root);
        for(int i = 2; i <= n; i++){
            List<TreeNode> curr = new ArrayList<>();
            for(TreeNode node: res){
                curr.add(new TreeNode(i, node, null));
                TreeNode p = node;
                while(p != null){
                    TreeNode copy = copyTree(node);
                    TreeNode cp = findNode(copy, p.val);
                    cp.right = new TreeNode(i, cp.right, null);
                    curr.add(copy);
                    p = p.right;
                }
            }
            res = curr;
        }
        return res;
    }

    private TreeNode copyTree(TreeNode root){
        TreeNode copy = new TreeNode(root.val);
        if(root.left != null) copy.left = copyTree(root.left);
        if(root.right != null) copy.right = copyTree(root.right);
        return copy;
    }

    private TreeNode findNode(TreeNode root, int val){
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val > val) {
            return findNode(root.left, val);
        }else{
            return findNode(root.right, val);
        }
    }

    public static void main(String[] args){
        t95 test = new t95();
        List<TreeNode> res = test.generateTrees(3);
    }
}
