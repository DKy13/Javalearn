package java0423;

import java.util.ArrayList;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    class Solution {
        public ArrayList<Integer> list = new ArrayList<>();
        boolean result = true;
        public boolean isValidBST(TreeNode root) {
            //二叉搜索树的中序遍历
            inOrder(root);
            return result;
        }
        public void inOrder(TreeNode root){
            if(root == null){
                return ;
            }
            inOrder(root.left);
            if(list.size() > 0){
                //判断序列是否是递增的（这里数据结构同样可以使用栈）
                if(list.get(list.size()-1) >= root.val){
                    result = false;
                }
            }
            list.add(root.val);
            inOrder(root.right);
        }
    }
}

