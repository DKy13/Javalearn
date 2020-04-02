package JavaStudy;

import java.util.LinkedList;
import java.util.Queue;

//层序遍历
public class LevelTree {
    public void levelTree(TreeNode root) {
        //借助队列来完成
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur =  queue.poll();
            System.out.println(cur.val + " ");
            if(cur.left != null) {
                queue.offer(cur.left);
            }
            if(cur.right != null); {
                queue.offer(cur.right);
            }
        }
    }
}
