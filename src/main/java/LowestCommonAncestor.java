import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 * 示例 2：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 示例 3：
 *
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     树中节点数目在范围 [2, 105] 内。
 *     -109 <= Node.val <= 109
 *     所有 Node.val 互不相同 。
 *     p != q
 *     p 和 q 均存在于给定的二叉树中。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author likuan
 */
public class LowestCommonAncestor {
    /**
     * 我们可以用哈希表存储所有节点的父节点，然后我们就可以利用节点的父节点信息从 p 结点开始不断往上跳，
     * 并记录已经访问过的节点，再从 q 节点开始不断往上跳，如果碰到已经访问过的节点，那么这个节点就是我们要找的最近公共祖先。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        Map<Integer, TreeNode> childParentMap = new HashMap<>();
        buildChildParentMap(null, root, childParentMap);
        Set<Integer> visited = new HashSet<>();

        while (p != null) {
            visited.add(p.val);
            p = childParentMap.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            visited.add(q.val);
            q = childParentMap.get(q.val);
        }
        return null;

    }

    private Map<Integer, TreeNode> buildChildParentMap(TreeNode parent, TreeNode child, Map<Integer, TreeNode> map) {
        if (parent != null) {
            map.put(child.val, parent);
        }
        if (child.left != null) {
            buildChildParentMap(child, child.left, map);
        }

        if (child.right != null) {
            buildChildParentMap(child, child.right, map);
        }
        return map;
    }
}
