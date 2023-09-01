package 剑指;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class 从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> reverseQuery = new LinkedList();

        while (head != null) {
            reverseQuery.offerFirst(head.val);
            head = head.next;
        }

        return reverseQuery.stream().mapToInt(i -> i).toArray();
    }
}
