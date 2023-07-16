package leetcode;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        ListNode beforeHead = new ListNode();
        ListNode head = new ListNode();
        head.val = 1;
        beforeHead.next = head;
        for (int i = 2; i <= 6; i++){
            ListNode next = new ListNode();
            next.val = i;
            head.next = next;
            head = next;
        }
        ListNode listNode = new RemoveLinkedListElements().removeElements(beforeHead.next, 6);
        System.out.println();
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        if (head.val == val){
            return head.next;
        }else {
            return head;
        }
    }
}


