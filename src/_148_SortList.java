import common.ListNode;
import util.ListUtil;

import java.util.Random;

/**
 * Created by feng on 2015/8/24.
 */
public class _148_SortList {
    public static void main(String[] args) {
        ListNode test1 = ListUtil.createRandomList(10);
        ListUtil.printList(test1);
        ListNode result = sortList(test1);
        ListUtil.printList(result);
    }

    public static ListNode sortList(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return head;
        return mergeSortList(head);
    }

    private static ListNode mergeSortList(ListNode head) {
        if (head==null||head.next==null)
            return head;
        ListNode middleNode = getMiddleNode(head);
        return head;
    }

    private static ListNode getMiddleNode(ListNode head) {
        return null;
    }

}
