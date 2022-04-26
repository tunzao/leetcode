/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 示例 1：
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 示例 2：
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 *
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 *
 *     链表中节点的数目在范围 [0, 5 * 104] 内
 *     -105 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author likuan
 */
public class SortList {
    /**
     * 插入排序（超时）
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        ListNode preHead = new ListNode(0, head);
        ListNode sortedPreHead = new ListNode();
        ListNode sortedPoint = sortedPreHead;
        while (preHead.next != null) {
            int min = Integer.MAX_VALUE;
            ListNode preMin = preHead;
            for (ListNode p = preHead; p.next != null; p = p.next) {
                if (p.next.val < min) {
                    min = p.next.val;
                    preMin = p;
                }
            }
            ListNode node = preMin.next;
            preMin.next = preMin.next.next;
            node.next = null;
            sortedPoint.next = node;
            sortedPoint = node;
        }
        return sortedPreHead.next;
    }

    /**
     * 自底向上归并排序（官方题解）
     * @param head
     * @return
     */
    public ListNode sortListOfficial(ListNode head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        ListNode dummyHead = new ListNode(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }

}
