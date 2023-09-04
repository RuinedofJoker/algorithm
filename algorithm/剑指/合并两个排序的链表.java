package 剑指;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 */
public class 合并两个排序的链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode current = newHead;

        while (l1 != null || l2 != null) {
            ListNode notNullNode = null;
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    current.next = l1;
                    l1 = l1.next;
                }else {
                    current.next = l2;
                    l2 = l2.next;
                }
                current = current.next;
            }else if (l1 == null){
                notNullNode = l2;
            }else {
                notNullNode = l1;
            }
            if (notNullNode != null) {
                while (notNullNode != null) {
                    current.next = notNullNode;
                    notNullNode = notNullNode.next;
                    current = current.next;
                }
                break;
            }
        }

        return newHead.next;
    }
}
