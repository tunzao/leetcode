/**
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0 → L1 → … → Ln - 1 → Ln
 *
 * 请将其重新排列后变为：
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 *
 * 示例 2：
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 *
 * 提示：
 *
 *     链表的长度范围为 [1, 5 * 104]
 *     1 <= node.val <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author likuan
 */
public class ReorderList {
    /**
     * 找到中点
     * reverse后半部分
     * 合并前半部分和后半部分
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode right = mid.next;
        mid.next = null;
        right = reverse(right);
        merge(head, right);
    }

    private void merge(ListNode left, ListNode right) {
        while (right != null && left != null) {
            ListNode tmpLeft = left.next;
            ListNode tempRight = right.next;

            left.next = right;
            right.next = tmpLeft;
            left = tmpLeft;
            right = tempRight;
        }

    }

    private ListNode reverse(ListNode right) {
        ListNode pre = null, point = right;
        while (point != null) {
            ListNode next = point.next;
            point.next = pre;
            pre = point;
            point = next;
        }
        return pre;
    }

    private ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
