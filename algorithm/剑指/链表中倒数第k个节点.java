package 剑指;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class 链表中倒数第k个节点 {
    private AtomicInteger layer;
    public ListNode getKthFromEnd(ListNode head, int k) {
        layer = new AtomicInteger();
        return findNode(head, k);
    }

    ListNode findNode(ListNode current, int k) {
        if (current == null) {
            layer.set(0);
            return null;
        }
        ListNode findNode = findNode(current.next, k);
        if (layer.incrementAndGet() == k) {
            return current;
        }else {
            return findNode;
        }
    }
}
