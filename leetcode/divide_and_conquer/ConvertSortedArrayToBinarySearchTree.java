package divide_and_conquer;

import java.util.Arrays;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        TreeNode treeNode = new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println();
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }
        TreeNode head = new TreeNode(nums[nums.length/2]);
        head.val = nums[nums.length/2];
        int[] leftNums = Arrays.copyOf(nums, nums.length/2);

        head.left = sortedArrayToBST(leftNums);

        int[] rightNums = Arrays.copyOfRange(nums, nums.length/2 + 1, nums.length);
        head.right = sortedArrayToBST(rightNums);

        return head;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
