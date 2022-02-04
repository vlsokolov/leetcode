package tree;

public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return calcDepth(root, 1);
    }

    private int calcDepth(TreeNode root, int maxDepth) {
        int leftDepth = root.left != null ? calcDepth(root.left, maxDepth + 1) : maxDepth;
        int rightDepth = root.right != null ? calcDepth(root.right, maxDepth + 1) : maxDepth;
        return Math.max(leftDepth, rightDepth);
    }

}
