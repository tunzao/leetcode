/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author likuan
 */
public class ReverseLinkedNode {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        while (p != null) {
            head = p;
            p = p.next;
            head.next = pre;
            pre = head;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
