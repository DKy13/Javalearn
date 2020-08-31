package sort;

//判断给定的链表中是否有环
class ListNode{
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
        next = null;
    }
}
//利用快慢指针,快指针每次走两步,慢指针每次走一步,如果链表有环,那么快慢指针肯定会相遇;反之,慢指针永远不会与快指针相遇
public class HascycleTest {
    public boolean hasCycle(ListNode head) {
        //如果头结点为空,表示链表为空,或者链表中只有一个节点,直接返回false
        if (head == null || head.next == null) {
            return false;
        }
        //让快慢指针都从头结点开始
        ListNode fast = head;
        ListNode slow = head;
        //快指针每次走两步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            //慢指针每次走一步
            slow = slow.next;
            //如果两者相等,表示有环
            if (fast == slow) {
                return true;
            }
            //反之,表示没有环
        }
        return false;
    }
}
