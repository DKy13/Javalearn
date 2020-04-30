package list0430;

// 反转链表

class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
    }
}
public class ReverseListInterview {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            //链表为空
            return null;
        }
        if (head.next == null) {
            //链表中只有一个元素
            return head;
        }
        ListNode newhead = null;
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null) {
                //当前cur就是原链表的末尾节点
                newhead = cur;//将cur当做逆置后的链表的头结点
            }
            // 逆置的核心操作
            cur.next = prev;
            //更新prev   cur   next  的指向位置
            prev = cur;
            cur = next;
        }
        return newhead;
    }
}
