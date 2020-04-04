package Tree;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

class TreeNOde{
    public int val;
    public TreeNOde left;
    public TreeNOde right;

    public TreeNOde(int val) {
        this.val = val;
    }
}

public class PracticeTree {
    //result 相当于是一个二维数组，
    //针对当前的ArrayList（包含了所有的层）来说，每个元素又是一个List(每一层里面的所有元素)
    //result 几就对应第几层的所有元素
    static List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return result;
        }
        //helper方法辅助递归，第二个参数表示当前的层数（层数从0开始，和List的下标能够匹配）
        helper(root, 0 );
        return result;
    }

    private void helper(TreeNode root, int level) {
        if(level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root,val);
        if(root.left != null) {
            helper(root.left, level + 1);
        }
        if(root.right != null) {
            helper(root.right,level + 1);
        }
    }
}
