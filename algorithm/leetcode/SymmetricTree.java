package leetcode;

import java.util.LinkedList;

/**
 * 101. 对称二叉树
 *
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * 提示：
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 *
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 */
public class SymmetricTree {
    public static void main(String[] args) {
        System.out.println(new SymmetricTree().isSymmetric(TreeNode.stringToTree("[1,2,2,null,3,null,3]")));
    }
    LinkedList<TreeNode> leftQueue = new LinkedList<>();
    LinkedList<TreeNode> rightQueue = new LinkedList<>();

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right != null && root.left.val == root.right.val) {
            leftQueue.offer(root.left);
            rightQueue.offerFirst(root.right);
            return symmetricCheck();
        }else {
            return false;
        }
    }
    boolean symmetricCheck() {
        int leftSize = leftQueue.size();
        int rightSize = rightQueue.size();
        if (leftSize != rightSize) return false;
        if (leftSize == 0) return true;

        while (leftSize > 0) {
            leftSize--;
            TreeNode left = leftQueue.poll();
            TreeNode right = rightQueue.pollLast();
            if (left == null && right == null) {
                continue;
            }
            if (left != null && right != null && left.val == right.val) {
                leftQueue.offer(left.left);
                leftQueue.offer(left.right);
                rightQueue.offerFirst(right.right);
                rightQueue.offerFirst(right.left);
            }else {
                return false;
            }
        }

        return symmetricCheck();
    }
}
