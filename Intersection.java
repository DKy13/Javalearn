package learn0510;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
//相交链表
//双指针法
public class Intersection {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode hA = headA;
        ListNode hB = headB;
        while (hA != hB) {
            hA = (hA == null ? headB : hA.next);
            hB = (hB == null ? headA : hB.next);
        }
        return hA;
    }
}
