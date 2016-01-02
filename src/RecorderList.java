/**
 * Created by likuan on 1/2/16.
 */
public class RecorderList {

    /**
     * <a href="https://leetcode.com/problems/reorder-list/">Reorder List</a>
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        int total = 0;
        ListNode node = head;

        // 遍历list算出总节点数
        while (node != null) {
            total++;
            node = node.next;
        }
        // 然后再计算出中间位置
        int middle = (total)/2;

        ListNode firstHalf1 = head;
        ListNode firstHalf2;
        ListNode preSecondHalf = null;
        ListNode secondHalf = head;
        ListNode secondHalf2 = null;

        // 找出临界点的位置，secondHalf指向后半段, preSecondHalf指向前半段的最后一个Node
        for (int i=0; i<= middle; i++) {
            preSecondHalf = secondHalf;
            secondHalf = secondHalf.next;
        }

        if (preSecondHalf != null) {
            preSecondHalf.next = null;
        }

        // 倒置后半段
        if (secondHalf != null) {
            while (secondHalf.next != null) {
                ListNode next = secondHalf.next;
                secondHalf.next = secondHalf2;
                secondHalf2 = secondHalf;
                secondHalf = next;
            }
            secondHalf.next = secondHalf2;
        }

        // 合并前后两个部分
        while (firstHalf1 != null && secondHalf != null) {
            secondHalf2 = secondHalf.next;
            firstHalf2 = firstHalf1.next;
            firstHalf1.next = secondHalf;
            secondHalf.next = firstHalf2;
            firstHalf1 = firstHalf2;
            secondHalf = secondHalf2;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        RecorderList r = new RecorderList();
        r.reorderList(node);
        System.out.println(node);
    }
}
