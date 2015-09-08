import common.ListNode;
import util.ListUtil;

/**
 * Created by feng on 2015/9/7.
 *
 * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

 Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,

 the linked list should become 1 -> 2 -> 4 after calling your function.

 */
public class _237_DeleteNodeInALinkedList {

    public static void main(String[] args) {
        ListNode head = ListUtil.createRandomList(5);
        ListUtil.printList(head);
        deleteNode(head);
        ListUtil.printList(head);
    }

    private static void deleteNode(ListNode node) {
        if (node.next==null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
