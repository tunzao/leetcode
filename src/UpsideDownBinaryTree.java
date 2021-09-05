import java.util.HashMap;
import java.util.Map;

/**
 * @author likuan
 */
public class UpsideDownBinaryTree {
    /**
     * https://leetcode-cn.com/problems/binary-tree-upside-down
     *
     * 1. 遍历找到最左叶子结点
     * 2. 把父节点作为自己的右子节点，右兄弟节点作为自己的左子节点
     * 3. 依次往上遍历直到root节点
     *
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode parent = root;
        TreeNode point = root;
        TreeNode newRoot = null;

        Map<Integer, TreeNode> parentNodeMap = new HashMap<>();

        while (point.left != null) {
            parent = point;
            point = point.left;
            if (point != null) {
                parentNodeMap.put(point.val, parent);
            }
        }

        point.left = parent.right;
        point.right = parent;
        newRoot = point;
        point = parent;
        parent = parentNodeMap.get(point.val);

        while (parent != null) {
            point.left = parent.right;
            point.right = parent;
            point = parent;
            parent = parentNodeMap.get(point.val);
        }
        point.left = null;
        point.right = null;

        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        UpsideDownBinaryTree tree = new UpsideDownBinaryTree();
        root = tree.upsideDownBinaryTree(root);
        System.out.println(root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        // todo 实现层级遍历
        StringBuilder sb = new StringBuilder("[");
        sb.append(val);
        sb.append("]");
        return sb.toString();
    }
}