package 剑指;

/**
 * 剑指 Offer 18. 删除链表的节点
 */
public class 删除链表的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        if (head.val == val) return head.next;

        ListNode next = head;
        while (next.next != null) {
            if (next.next.val == val) {
                next.next = next.next.next;
                break;
            }
            next = next.next;
        }

        return head;
    }
}
