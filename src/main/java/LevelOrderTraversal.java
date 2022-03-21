import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author likuan
 */
public class LevelOrderTraversal {

    /**
     * 利用队列
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        traverse(queue, result);
        return result;
    }

    private void traverse(Queue<TreeNode> queue, List<List<Integer>> result) {
        List<Integer> vals = new ArrayList<>(queue.size());
        for (int i = queue.size(); i > 0; i--) {
            TreeNode node = queue.poll();
            vals.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        result.add(vals);
        if (!queue.isEmpty()) {
            traverse(queue, result);
        }
    }
}
