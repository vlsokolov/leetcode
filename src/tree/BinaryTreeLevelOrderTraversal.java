package tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        return calcLevel(root);
    }

    private List<List<Integer>> calcLevel(TreeNode root) {
        Queue<TreeNode> nodes = new ArrayDeque<>();
        List<List<Integer>> levels = new ArrayList<>();

        nodes.add(root);

        while (!nodes.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int nodeLevelCounter = 0;
            int queueLength = nodes.size();

            while (queueLength > nodeLevelCounter) {
                TreeNode node = nodes.poll();
                level.add(node.val);
                nodeLevelCounter++;

                if(node.left != null) nodes.add(node.left);
                if(node.right != null) nodes.add(node.right);
            }

            levels.add(level);
        }

        return levels;
    }
}
