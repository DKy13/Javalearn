package Tree0406;

import java.util.Stack;

 class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class OrderByLoop {

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

    //非递归中序遍历
    public static void inOrderByLoop(TreeNode root){
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            //循环往左遍历,并将找到的元素入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //如果栈为空，那么遍历就结束
            if(stack.isEmpty()) {
                break;
            }
            //取出栈顶元素并访问
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            //从当前节点的右子树出发继续刚才的过程
            cur = top.right;
        }
    }

    //非递归后序遍历
    public static void postOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //prev表示已经遍历完的最后一个元素，也就是即将被访问的元素的前一个元素
        TreeNode prev = null;
        while (true) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty()) {
                break;
            }
            //拿出栈顶元素看是否能访问
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                //此时这个栈顶元素可以进行访问
                System.out.print(top.val + " ");
                stack.pop();
                //时刻保证prev指向已经遍历完的最后一个元素
                prev = top;
            } else {
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root =  bulid();
        System.out.println("非递归先序遍历的结果");
        preOrderByLoop(root);
        System.out.println();
        System.out.println("非递归中序遍历的结果");
        inOrderByLoop(root);
        System.out.println();
        System.out.println("非递归后序遍历的结果");
        postOrderByLoop(root);
    }
}



