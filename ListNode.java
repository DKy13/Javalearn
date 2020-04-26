package java0426;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode (int x) {
        val = x;
    }
}
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        //当链表为空:
        if (head == null) {
            return null;
        }
        //当链表的头结点就是要删除的元素时,删除头结点后,直接返回头结点的下一个结点
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        while (cur.next != null && cur.next.val != val) {
            cur = cur.next;
        }
        if (cur.next != null) {
            cur.next = cur.next.next;
        }
        return head;
    }
}