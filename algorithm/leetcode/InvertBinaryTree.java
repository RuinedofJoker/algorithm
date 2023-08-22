package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. 翻转二叉树
 *
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 示例 2：
 * 输入：root = [2,1,3]
 * 输出：[2,3,1]
 *
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 *
 * 提示：
 * 树中节点数目范围在 [0, 100] 内
 * -100 <= Node.val <= 100
 */
public class InvertBinaryTree {

    Queue<TreeNode> queue = new LinkedList<>();

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            queue.offer(root);
            invert();
        }
        return root;
    }

    void invert() {
        if (queue.size() == 0)  return;
        int i = queue.size() - 1;
        while (i >= 0) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            TreeNode left = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = left;

            i--;
        }
        invert();
    }

}
