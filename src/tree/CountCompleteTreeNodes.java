package tree;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        int height = maxLevel(root);
        int fullNodesCount = (int) Math.pow(2, height) - 1;

        int left = 0;
        int right = fullNodesCount;

        while (left < right) {
            int indexToFind = (int) Math.ceil(((double) (right + left)) / 2);
            if (isNodeExists(root, indexToFind, height)) {
                left = indexToFind;
            } else {
                right = indexToFind - 1;
            }
        }
        return fullNodesCount + left + 1;
    }

    private int maxLevel(TreeNode root) {
        int level = 0;
        while (root.left != null) {
            root = root.left;
            level++;
        }
        return level;
    }

    private boolean isNodeExists(TreeNode node, int indexToFind, int height) {
        int left = 0;
        int right = (int) Math.pow(2, height) - 1;
        int count = 0;

        while (count < height) {
            int middle = (int) Math.ceil(((double) (right + left)) / 2);
            if (indexToFind >= middle) {
                left = middle;
                node = node.right;
            } else {
                right = middle - 1;
                node = node.left;
            }
            count++;
        }

        return node != null;
    }


    public static void main(String[] args) {
        CountCompleteTreeNodes c = new CountCompleteTreeNodes();

        TreeNode six = new TreeNode();
        TreeNode five = new TreeNode();
        TreeNode four = new TreeNode();
        TreeNode three = new TreeNode();
        TreeNode two = new TreeNode();
        TreeNode one = new TreeNode();
//        three.left = six;
//        two.left = four;
//        two.right = five;
        one.left = two;
        one.right = three;

        System.out.println(c.countNodes(one));
    }

}
