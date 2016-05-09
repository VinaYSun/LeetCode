package main;

/**
 * Created by ysun on 5/8/16.
 */
public class RemoveDuplicateFromSortedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        // Add a dummy node before the first node
        dummy.next = head;
        // Make head pointer at dummy node
        head = dummy;

        // Until the end (head.next, head.next.next != null) of linked list
        while (head.next != null && head.next.next != null) {
            // if next, next.next value are same
            if (head.next.val == head.next.next.val) {
                // save this value
                int val = head.next.val;
                // iterate when head.next is equals to the same value
                while (head.next != null && head.next.val == val) {
                    // move pointer to the next node
                    head.next = head.next.next;
                }
            } else {
                // keep moving pointer
                head = head.next;
            }
        }
        // return the 'real' head
        return dummy.next;
    }
}
