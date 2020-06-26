package learn;

import java0426.ListNode;
//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            while (temp.next != null) {
                if (temp.next.val == cur.val) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
