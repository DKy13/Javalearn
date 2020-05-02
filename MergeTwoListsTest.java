package list0502;

class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
    }
}

public class MergeTwoListsTest {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode newHead = null;
        ListNode newTail = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {

            if (cur1.val < cur2.val) {
                if (newTail == null) {
                    newHead = cur1;
                    newTail = cur1;
                }else {
                    newTail.next = cur1;
                    newTail = newTail.next;
                }
                cur1 = cur1.next;
            }else {
                if (newTail == null) {
                    newHead = cur2;
                    newTail = cur2;
                }else {
                    newTail.next = cur2;
                    newTail = newTail.next;
                }
                cur2 = cur2.next;
        }
            if (cur1 == null) {
                newTail.next = cur2;
            }else {
                newTail.next = cur1;
            }

            }
        return newHead;
    }
}
