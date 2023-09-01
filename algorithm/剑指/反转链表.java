package 剑指;

/**
 * 剑指 Offer 24. 反转链表
 */
public class 反转链表 {
    private ListNode newHead;
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        reve(head) = null;
        return newHead;
    }

    private ListNode reve(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode nextNode = reve(node.next);
        if (nextNode != null) {
            nextNode.next = node;
        }else {
            newHead = node;
        }
        return node;
    }
}
