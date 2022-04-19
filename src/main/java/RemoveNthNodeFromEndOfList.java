/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 *
 * 示例 2：
 *
 * 输入：head = [1], n = 1
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author likuan
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * 使用长度为n+1的滑动窗口，窗口左侧指向被删除节点之前的指针
     * 窗口滑动到末尾，删除左侧指针执行节点即可
     * 如果n等于列表长度，则窗口左侧指针为空，直接删除head节点即可
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, point = head;
        int index = 1;
        while (point.next != null) {
            index++;
            point = point.next;
            if (index == n+1) {
                pre = head;
            } else if (index > n+1) {
                pre = pre.next;
            }
        }
        if (pre == null) {
            head = head.next;
        } else {
            pre.next = pre.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList remove = new RemoveNthNodeFromEndOfList();

    }
}
