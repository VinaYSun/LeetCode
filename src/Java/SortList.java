package Java;

/**
 * Created by ysun on 5/18/16.
 */
public class SortList {
    // merge sort
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMedian(head);

        // divide
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        // conquer
        return merge(left, right);
    }

    private ListNode findMedian(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return dummy.next;
    }
    // quick sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMedian(head);
        ListNode leftDummy = new ListNode(0);
        ListNode leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode rightTail = rightDummy;
        ListNode middleDummy = new ListNode(0);
        ListNode midTail = middleDummy;
        while (head != null) {
            if (head.val < mid.val) {
                leftTail.next = head;
                leftTail = head;
            } else if (head.val > mid.val) {
                rightTail.next = head;
                rightTail = head;
            } else {
                midTail.next = head;
                midTail = head;
            }
            head = head.next;
        }
        leftTail.next = null;
        midTail.next = null;
        rightTail.next = null;

        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);

        return concat(left, middleDummy.next, right);

    }

    private ListNode findMedian(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        tail.next = left;
        // to end of left list
        tail = getTail(tail);
        // left.end -> middle
        tail.next = middle;
        // to end of mid list
        tail = getTail(tail);
        // mid.end -> right
        tail.next = right;

        // tail = getTail(tail);

        return dummy.next;
    }

    private ListNode getTail(ListNode node) {
        if (node == null) {
            return null;
        }
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }


}
