package list0502;

public class DeleteDuplicationTest {
    public ListNode deleteDuplication (ListNode pHead) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                //再走一步,刚好跳过重复元素的最后一个元素
                cur = cur.next;
            }else {
                //说明这个元素不是重复元素,将其插入到新的链表中
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }//外层while
        return newHead.next;
    }
}
