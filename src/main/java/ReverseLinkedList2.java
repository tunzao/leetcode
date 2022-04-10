/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class ReverseLinkedList2 {

    /**
     * 将[left, right]区间内的节点原地翻转
     * 把[1,left)区间的最后一个节点的next指向翻转后的第一个节点
     * 把翻转后最后一个节点的next执行(right, end]区间的第一个节点
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return head;
        }
        ListNode endOfLeft = null, // [1,left)区间的最后一个节点
                startOfRight = null, // （right, end]区间的第一个节点
                point = head, // 指针
                pre = null, // 翻转过程中上一个节点
                start = null, // [left, right]区间翻转后的开始节点
                end = null; // [left, right]区间翻转后的结束节点
        for (int i = 1; i <= right; i++) {
            if (i == left - 1) {
                endOfLeft = point;
            }
            if (i >= left && i <= right) {
                if (i == left) {
                    end = point;
                }
                if (i == right) {
                    startOfRight = point.next;
                    start = point;
                }
                ListNode next = point.next;
                point.next = pre;
                pre = point;
                point = next;

            } else {
                point = point.next;
            }
        }
        if (endOfLeft != null) {
            endOfLeft.next = start;
        }
        if (end != null) {
            end.next = startOfRight;
        }
        return head == end ? start : head;
    }
}
