package Tree0405;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class PreOrderByLoop {

    public static TreeNode bulid(){
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.left = f;
        return a;
    }
    public static void preOrderByLoop(TreeNode root){
        if(root == null) {
            return;
        }
        //借助栈的方式来模仿递归进行非递归先序遍历
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode top = stack.pop();
            //访问这个节点
            System.out.print(top.val + " ");
            //将右子树与左子树分别入栈
            if(top.right != null) {
                stack.push(top.right);
            }
            if(top.left != null) {
                stack.push(top.left);
            }
        }
    }
    public static void main(String[] args) {
        TreeNode  root =  bulid();
        preOrderByLoop(root);
    }
}


