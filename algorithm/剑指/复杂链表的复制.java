package 剑指;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 */
public class 复杂链表的复制 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> linkMap = new HashMap<>();
        Node newHead = new Node(0);
        Node next = newHead;
        Node oldHead = head;

        while (head != null) {
            Node newNext = new Node(head.val);
            next.next = newNext;

            linkMap.put(head, newNext);

            head = head.next;
            next = next.next;
        }

        next = newHead.next;
        while (oldHead != null) {
            if (oldHead.random != null) {
                next.random = linkMap.get(oldHead.random);
            }else {
                next.random = null;
            }

            next = next.next;
            oldHead = oldHead.next;
        }

        return newHead.next;
    }
}
