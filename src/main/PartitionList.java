package main;

/**
 * Created by ysun on 5/8/16.
 */
public class PartitionList {

    /**
     * Nodes that are smaller than X come before nodes greater than X, nodes doesn't change their order
     *
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        // two list
        // a list smaller than x
        // dummy small list head node with its pointer
        ListNode small = new ListNode(0);
        ListNode smallhead = small;
        // a list larger than x
        // dummy big list head node with its pointer
        ListNode big = new ListNode(0);
        ListNode bighead = big;

        // traverse linked list
        while (head != null) {
            // when small, save the node as the "small-list-pointer.next"
            // move 'small-list-pointer'
            if (head.val < x) {
                small.next = head;
                small = head;
            } else {
                // when big, attach to the "big list"
                // move 'big-list-pointer'
                big.next = head;
                big = head;
            }
            // move the head pointer in the linked list to next
            head = head.next;
        }
        // append null to the end of big list
        big.next = null;
        // link small list and big list together
        small.next = bighead.next;

        return smallhead.next;
    }
}
