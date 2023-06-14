package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 广度优先按层数奇偶遍历节点
 */
public class BFS {
    public int parityTraverse(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        List<TreeNode> layerOrderListOne = new ArrayList<>();
        List<TreeNode> layerOrderListTwo = new ArrayList<>();
        layerOrderListOne.add(root);

        Map<String, Integer> nodeNums = new HashMap<>(2);
        nodeNums.put("odd", 0);
        nodeNums.put("even", 0);
        bfs(layerOrderListOne, layerOrderListTwo, false, nodeNums);

        return nodeNums.get("odd") >= nodeNums.get("even") ? nodeNums.get("even") : nodeNums.get("odd");
    }
    void bfs(List<TreeNode> layerOrderListOne, List<TreeNode> layerOrderListTwo, boolean isEven, Map<String, Integer> nodeNums) {
        if (!isEven) {
            if (layerOrderListOne.size() == 0) {
                return;
            }
            for (TreeNode currentNode : layerOrderListOne) {
                //
                nodeNums.put("odd", nodeNums.get("odd") + 1);
                if (currentNode.left != null) {
                    layerOrderListTwo.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    layerOrderListTwo.add(currentNode.right);
                }
            }
            layerOrderListOne.clear();
        }else {
            if (layerOrderListTwo.size() == 0) {
                return;
            }
            for (TreeNode currentNode : layerOrderListTwo) {
                //
                nodeNums.put("even", nodeNums.get("even") + 1);
                if (currentNode.left != null) {
                    layerOrderListOne.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    layerOrderListOne.add(currentNode.right);
                }
            }
            layerOrderListTwo.clear();
        }
        bfs(layerOrderListOne, layerOrderListTwo, !isEven, nodeNums);
    }
}
