/**
 * Created by likuan on 1/2/16.
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        ListNode node = this;
        while (node != null) {
            sb.append(node.val);
            if (node.next != null) {
                sb.append(",");
            }
            node = node.next;
        }
        sb.append("}");
        return sb.toString();
    }

}
