package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
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

     public static TreeNode stringToTree(String test) {
         String[] nodes = test.replace("[", "").replace("]", "").split(",");
         if (nodes[0].equals("null")) {
             return null;
         }
         TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
         makeChildNode(nodes, new ArrayList<>(){{add(root);}}, 1);
         return root;
     }
     private static void makeChildNode(String[] nodes, List<TreeNode> root, int index) {
         List<TreeNode> currentNodes = new ArrayList<>();
         boolean allNull = true;
         int rootIndex = 0;

         while (rootIndex < root.size()) {
             if (root.get(rootIndex) == null) {
                 rootIndex++;
                 continue;
             }
             if (index < nodes.length && !nodes[index].equals("null")) {
                 allNull = false;
                 root.get(rootIndex).left = new TreeNode(Integer.parseInt(nodes[index]));
             }else {
                 root.get(rootIndex).left = null;
             }
             currentNodes.add(root.get(rootIndex).left);
             if (index + 1 < nodes.length && !nodes[index + 1].equals("null")) {
                 allNull = false;
                 root.get(rootIndex).right = new TreeNode(Integer.parseInt(nodes[index + 1]));
             }else {
                 root.get(rootIndex).right = null;
             }
             currentNodes.add(root.get(rootIndex).right);
             index+=2;
             rootIndex++;
         }

         if (allNull) return;
         makeChildNode(nodes, currentNodes, index);
     }
}
