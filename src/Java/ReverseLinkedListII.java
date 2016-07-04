package Java;

/**
 *
 * Reverse a linked list from position m to n.
 * Do it in-place and in one-pass.
 *
 * 1- 2- 3- 4- 5
 * m = 2, n = 4
 *
 * 1- 4- 3- 2- 5
 *
 */
public class ReverseLinkedListII {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        // move head pointer from 1 to m
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postnNode = mNode.next;

        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;

        return dummy.next;
    }
}
