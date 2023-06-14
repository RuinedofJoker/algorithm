package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 968. 监控二叉树
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 *
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 *
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 * 示例 1：
 * 输入：[0,0,null,0,0]
 * 输出：1
 * 解释：如图所示，一台摄像头足以监控所有节点。
 *
 * 示例 2：
 * 输入：[0,0,null,0,null,0,null,null,0]
 * 输出：2
 * 解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 *
 * 提示：
 * 给定树的节点数的范围是 [1, 1000]。
 * 每个节点的值都是 0。
 */
public class BinaryTreeCameras {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        System.out.println(new BinaryTreeCameras().minCameraCover(root));
    }
    public int minCameraCover(TreeNode root) {
        int[] result = new int[1];
        if (dfs(root, result) == 0) {
            result[0]++;
        }
        return result[0];
    }

    /**
     * 0 表示无覆盖
     * 1 表示有摄像头
     * 2 表示有覆盖
     */
    int dfs(TreeNode root, int[] result) {
        if (root == null) {
            return 2;
        }

        int left = dfs(root.left, result);
        int right = dfs(root.right, result);

        if (left == 2 && right == 2) {
            return 0;
        }else if (left == 0 || right == 0) {
            result[0] += 1;
            return 1;
        }else {
            return 2;
        }
    }
}
