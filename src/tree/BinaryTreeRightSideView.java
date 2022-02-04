package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        return calcRightSide(root, new ArrayList<>(), 0);
    }

    private List<Integer> calcRightSide(TreeNode root, List<Integer> result, int level) {
        if (result.size() == level) result.add(root.val);

        if (root.right != null) {
            calcRightSide(root.right, result, level + 1);
        }

        if (root.left != null) {
            calcRightSide(root.right, result, level + 1);
        }

        return result;
    }
}
