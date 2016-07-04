package Java;

/**
 * Created by ysun on 5/18/16.
 */
public class LinkedListCycle { public boolean hasCycle(ListNode head) {
    // write your code here
    if (head == null || head.next == null) {
        return false;
    }

    ListNode slow = head, fast = head.next;
    while (fast != slow) {
        if (fast == null || fast.next == null) {
            return false;
        }
        slow = head.next;
        fast = head.next.next;
    }
    return true;
}
}
