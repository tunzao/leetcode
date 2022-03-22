import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 *
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 示例 3：
 *
 * 输入：root = []
 * 输出：[]
 *
 *
 *
 * 提示：
 *
 *     树中节点数目在范围 [0, 2000] 内
 *     -100 <= Node.val <= 100
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author likuan
 */
public class ZigZagLevelOrderTraversal {

    /**
     * 交替从左到右，然后再从右到左遍历
     * 先把根节点加入对双端队列
     * 从左到右遍历双端队列，由于下一层要反向遍历，所以该层先遍历到节点的子节点就需要放到下一层队列的尾端（其实是双端队列的首，因为下层从尾部开始遍历）
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean forward = true;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>(size);
            for (int i=0;i<size;i++) {
                if (forward) {
                    TreeNode node = deque.removeFirst();
                    level.add(node.val);
                    if (node.left != null) deque.addLast(node.left);
                    if (node.right != null) deque.addLast(node.right);
                } else {
                    TreeNode node = deque.removeLast();
                    level.add(node.val);
                    if (node.right != null) deque.addFirst(node.right);
                    if (node.left != null) deque.addFirst(node.left);
                }
            }
            result.add(level);
            forward = !forward;
        }
        return result;

    }
}
