package 剑指;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class 两个链表的第一个公共节点 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet = new HashSet<>();

        while (headA != null || headB != null) {
            if (nodeSet.contains(headA) && headA != null) {
                return headA;
            }else if (nodeSet.contains(headB) && headB != null) {
                return headB;
            }else if (headA == headB){
                return headA;
            }else {
                nodeSet.add(headA);
                nodeSet.add(headB);
            }
            if (headA != null) headA = headA.next;
            if (headB != null) headB = headB.next;
        }
        return null;
    }
}
