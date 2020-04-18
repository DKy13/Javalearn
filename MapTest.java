package map0418;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
// 1.遍历旧链表，把旧链表的每个节点依次插入到 Map 中，Key表示旧链表节点，Value表示拷贝出来的新链表节点
        Map<Node, Node> map = new HashMap<>();
        for (Node cur = head; cur != null; cur = cur.next) {
            map.put(cur, new Node(cur.val));
        }
//        2.再次遍历链表，修改新链表中节点的next 和 random
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newCur = map.get(cur);
            newCur.next = map.get(cur.next);
            newCur.random = map.get(cur.random);
        }
//        3.需要返回新链表的头结点
        return map.get(head);
    }
}
