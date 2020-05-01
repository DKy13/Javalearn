package list0501;

class ListNode {
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
    }
}

public class MiddleNodeTest {
    public ListNode middleNode(ListNode head) {
        int steps = size(head) / 2;
        ListNode cur = head;
        for (int i = 0; i < steps; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public int size (ListNode head) {
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }
}
