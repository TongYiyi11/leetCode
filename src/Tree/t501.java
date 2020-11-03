package Tree;

public class t501 {
    int[] res = new int[8];
    int count, maxCount;
    int prev;
    int idx = 0;
    public int[] findMode(TreeNode root){
        prev = root.val;
        count = 0;
        maxCount = 0;
        dfs(root);
        int[] newRes = new int[idx];
        for(int i = 0; i < idx; i++){
            newRes[i] = res[i];
        }
        res = newRes;
        return res;
    }

    private void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(root.val != prev){
            count = 1;
            prev = root.val;
        }else{
            count += 1;
        }
        if(count == maxCount){
            res[idx] = prev;
            idx += 1;
            if(idx >= res.length){
                resize(res.length * 2);
            }
        }
        if(count > maxCount){
            maxCount = count;
            res = new int[8];
            res[0] = prev;
            idx = 1;
        }
        dfs(root.right);
    }

    private void resize(int capacity){
        int[] newRes = new int[capacity];
        for(int i = 0; i < res.length; i++){
            newRes[i] = res[i];
        }
        res = newRes;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        t501 test = new t501();
        int[] result = test.findMode(root);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }

    }
}
