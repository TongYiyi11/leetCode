package Tree;

import java.util.*;

public class t103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int level = 0;
        while(!stack.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> temp = new Stack<>();
            int count = stack.size();
            for(int i = 0; i < count; i++){
                TreeNode node = stack.pop();
                list.add(node.val);
                if(level % 2 == 0){
                    if(node.left != null) temp.push(node.left);
                    if(node.right != null) temp.push(node.right);
                }else{
                    if(node.right != null) temp.push(node.right);
                    if(node.left != null) temp.push(node.left);
                }
            }
            res.add(list);
            stack = temp;
            level += 1;
        }
        return res;
    }
}
