package list0502;

public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null) {
            return null;
        }
        if (pHead.next == null) {
            return pHead;
        }
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        for (ListNode cur = pHead; cur != null; cur = cur.next ) {
            if (cur.val < x) {
                smallTail.next = new ListNode(cur.val);
                smallTail = smallTail.next;
            }else {
                bigTail.next = new ListNode(cur.val);
                bigTail = bigTail.next;
            }
        }
        //将两个链表首尾相连
        smallTail.next = bigHead.next;
        return smallTail.next;
    }
}
