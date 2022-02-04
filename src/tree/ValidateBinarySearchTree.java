package tree;

import java.math.BigInteger;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        return isValidNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidNode(TreeNode node, long leftBound, long rightBound) {
        if (node == null) return true;

        if (node.val > leftBound && node.val < rightBound) {
            return isValidNode(node.left, leftBound, node.val) &&
                    isValidNode(node.right, node.val, rightBound);
        }

        return false;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree service = new ValidateBinarySearchTree();

        TreeNode root = new TreeNode(5);
        TreeNode child1 = new TreeNode(4);
        TreeNode child2 = new TreeNode(6);
        TreeNode child4 = new TreeNode(3);
        TreeNode child5 = new TreeNode(7);

        root.left = child1;
        root.right = child2;
        child2.left = child4;
        child2.right = child5;

        System.out.println(service.isValidBST(root));
    }
}
