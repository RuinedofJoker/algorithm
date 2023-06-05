package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 206. 反转链表
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 *
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        new ReverseLinkedList().reverseList(head);
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode virtualHead = new ListNode();
        List<ListNode> nodes = new ArrayList<>();

        while (head.next != null) {
            nodes.add(head);
            head = head.next;
        }
        nodes.add(head);
        virtualHead.next = head;

        for (int i = nodes.size() - 2; i >= 0; i--) {
            head.next = nodes.get(i);
            head = head.next;
        }
        head.next = null;

        return virtualHead.next;
    }

}
