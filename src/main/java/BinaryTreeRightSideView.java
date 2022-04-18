import java.util.*;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * <p>
 * 示例 3:
 * <p>
 * 输入: []
 * 输出: []
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class BinaryTreeRightSideView {
    /**
     * 官方题解之深度优先搜索
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if (root == null) {
            return view;
        }
        Map<Integer, Integer> levelRightMap = new HashMap<>();
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        Deque<Integer> levelDeque = new LinkedList<>();
        nodeDeque.addFirst(root);
        int dep = 0;
        levelDeque.addFirst(0);
        while (!nodeDeque.isEmpty()) {
            TreeNode node = nodeDeque.poll();
            int level = levelDeque.poll();
            if (node == null) {
                continue;
            }
            dep = Math.max(level, dep);
            levelRightMap.putIfAbsent(level, node.val);
            nodeDeque.addFirst(node.left);
            nodeDeque.addFirst(node.right);
            levelDeque.addFirst(level + 1);
            levelDeque.addFirst(level + 1);
        }
        for (int i = 0; i <= dep; i++) {
            view.add(levelRightMap.get(i));
        }
        return view;
    }
}
