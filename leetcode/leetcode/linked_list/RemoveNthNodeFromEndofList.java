package leetcode.linked_list;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 提示：
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 * 进阶：你能尝试使用一趟扫描实现吗？
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveNthNodeFromEndofList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i <= 2; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        new RemoveNthNodeFromEndofList().removeNthFromEnd(head, 1);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> nodes = new ArrayList<>();

        while (head != null) {
            nodes.add(head);
            head = head.next;
        }

        if (nodes.size() - n - 1 < 0) {
            nodes.remove(0);
            if (nodes.size() == 0) {
                return null;
            }
        }else if (nodes.size() - n + 1 >= nodes.size()) {
            nodes.get(nodes.size() - 2).next = null;
        }else {
            nodes.get(nodes.size() - n - 1).next = nodes.get(nodes.size() - n + 1);
        }

        return nodes.get(0);
    }
}
