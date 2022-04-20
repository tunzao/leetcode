/**
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class RemoveDuplicatesFromSortedList2 {
    /**
     * preDup指向重复节点的前驱节点，point指针遍历节点
     * 如果当前point指向节点只跟之前节点值相同，则继续遍历直到找到不同的节点或者链表末尾
     * 如果遍历到不同节点，则将preDup.next设置为当前节点（即删除所有重复节点），然后将pre节点指向point节点，继续遍历
     * <p>
     * 如果point指向节点值跟之前不同，则preDup指向pre，pre指向point，继续遍历
     * <p>
     * 脑回路怎么想的，逻辑有点混乱
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        int preValue = Integer.MIN_VALUE;
        ListNode preHead = new ListNode(), // 虚拟节点
                preDup = null; // 重复节点前驱节点
        preHead.next = head;
        ListNode point = head, // 指针节点
                pre = preHead; // 之前前驱节点
        boolean duplicated = false;
        while (point != null) {
            if (point.val == preValue) {
                duplicated = true;
            } else {
                preValue = point.val;
                if (duplicated) {
                    if (preDup != null)
                        preDup.next = point;
                    duplicated = false;
                } else {
                    preDup = pre;
                }
                pre = point;
            }
            point = point.next;
        }
        if (duplicated && preDup != null) {
            preDup.next = null;
        }
        return preDup == null ? null : preHead.next;
    }

    /**
     * 官方题解，简洁太多了。
     * 但是为什么我没有按到官方题解的思路思考呢?
     * @param head
     * @return
     */
    public ListNode deleteDuplicatesOfficial(ListNode head) {

        ListNode preHead = new ListNode(Integer.MIN_VALUE, head);
        ListNode point = preHead;
        while (point.next != null && point.next.next != null) {
            if (point.next.val == point.next.next.val) {
                int value = point.next.val;
                while (point.next != null && point.next.val == value) {
                    point.next = point.next.next;
                }
            } else {
                point = point.next;
            }
        }
        return preHead.next;
    }
}
